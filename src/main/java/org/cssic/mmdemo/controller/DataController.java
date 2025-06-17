package org.cssic.mmdemo.controller;

import org.cssic.mmdemo.model.DataEntity;
import org.cssic.mmdemo.model.User;
import org.cssic.mmdemo.service.AccessControlService;
import org.cssic.mmdemo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {

    private final DataService dataService;
    private final AccessControlService accessControlService;

    @Autowired
    public DataController(DataService dataService, AccessControlService accessControlService) {
        this.dataService = dataService;
        this.accessControlService = accessControlService;
    }

    @GetMapping
    public String dataListPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        List<DataEntity> dataList;
        if (accessControlService.isAdmin(user)) {
            dataList = dataService.findAll();
        } else {
            dataList = dataService.findByCreatedBy(user.getId());
        }

        model.addAttribute("dataList", dataList);
        model.addAttribute("user", user);
        model.addAttribute("isAdmin", accessControlService.isAdmin(user));
        return "data-list";
    }

    @GetMapping("/view/{id}")
    public String viewData(@PathVariable Long id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        DataEntity data = dataService.findById(id);
        if (data == null) {
            return "redirect:/data";
        }

        if (!accessControlService.canAccessData(user, data.getCreatedBy())) {
            return "redirect:/data?error=access_denied";
        }

        model.addAttribute("data", data);
        model.addAttribute("user", user);
        model.addAttribute("canModify", accessControlService.canModifyData(user, data.getCreatedBy()));
        return "data-view";
    }

    @GetMapping("/add")
    public String addDataForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        if (!accessControlService.isUser(user)) {
            return "redirect:/data?error=access_denied";
        }

        model.addAttribute("data", new DataEntity());
        model.addAttribute("user", user);
        return "data-form";
    }

    @PostMapping("/add")
    public String addData(@ModelAttribute DataEntity data, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        if (!accessControlService.isUser(user)) {
            return "redirect:/data?error=access_denied";
        }

        data.setCreatedBy(user.getId());
        data.setCreatedDate(new Date());
        dataService.save(data);
        return "redirect:/data";
    }

    @GetMapping("/edit/{id}")
    public String editDataForm(@PathVariable Long id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        DataEntity data = dataService.findById(id);
        if (data == null) {
            return "redirect:/data";
        }

        if (!accessControlService.canModifyData(user, data.getCreatedBy())) {
            return "redirect:/data?error=access_denied";
        }

        model.addAttribute("data", data);
        model.addAttribute("user", user);
        return "data-form";
    }

    @PostMapping("/edit/{id}")
    public String editData(@PathVariable Long id, @ModelAttribute DataEntity data, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        DataEntity existingData = dataService.findById(id);
        if (existingData == null) {
            return "redirect:/data";
        }

        if (!accessControlService.canModifyData(user, existingData.getCreatedBy())) {
            return "redirect:/data?error=access_denied";
        }

        data.setId(id);
        data.setCreatedBy(existingData.getCreatedBy());
        data.setCreatedDate(existingData.getCreatedDate());
        dataService.update(data);
        return "redirect:/data";
    }

    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        DataEntity data = dataService.findById(id);
        if (data == null) {
            return "redirect:/data";
        }

        if (!accessControlService.canModifyData(user, data.getCreatedBy())) {
            return "redirect:/data?error=access_denied";
        }

        dataService.delete(id);
        return "redirect:/data";
    }
}
