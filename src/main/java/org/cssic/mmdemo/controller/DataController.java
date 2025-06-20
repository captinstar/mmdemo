package org.cssic.mmdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.cssic.mmdemo.model.DataEntity;
import org.cssic.mmdemo.model.User;
import org.cssic.mmdemo.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/data")
public class DataController {
    
    private final Logger logger = LoggerFactory.getLogger(DataController.class);
    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("")
    public String list(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        List<DataEntity> dataList = dataService.findAll();
        model.addAttribute("dataList", dataList);
        return "data-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("data", new DataEntity());
        model.addAttribute("user", user);  // 添加这行
        return "data-form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute DataEntity data, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        try {
            data.setCreatedBy(user.getId());
            data.setCreatedDate(new Date());
            dataService.save(data);
            return "redirect:/data?success=true";
        } catch (Exception e) {
            logger.error("添加数据时发生错误", e);
            return "redirect:/data/add?error=true";
        }
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        DataEntity data = dataService.findById(id);
        if (data == null) {
            return "redirect:/data?error=not_found";
        }
        
        model.addAttribute("data", data);
        model.addAttribute("canModify", 
    Objects.equals(data.getCreatedBy(), user.getId()) || "ADMIN".equals(user.getRole()));
        return "data-view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        DataEntity data = dataService.findById(id);
        if (data == null) {
            return "redirect:/data?error=not_found";
        }
        
        if (!data.getCreatedBy().equals(user.getId()) && !"ADMIN".equals(user.getRole())) {
            return "redirect:/data?error=access_denied";
        }
        
        model.addAttribute("data", data);
        return "data-form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute DataEntity data, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        DataEntity existingData = dataService.findById(id);
        if (existingData == null) {
            return "redirect:/data?error=not_found";
        }
        
        if (!existingData.getCreatedBy().equals(user.getId()) && !"ADMIN".equals(user.getRole())) {
            return "redirect:/data?error=access_denied";
        }
        
        try {
            data.setId(id);
            data.setCreatedBy(existingData.getCreatedBy());
            data.setCreatedDate(new Date());
            dataService.update(data);
            return "redirect:/data?success=true";
        } catch (Exception e) {
            logger.error("更新数据时发生错误", e);
            return "redirect:/data/edit/" + id + "?error=true";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        DataEntity data = dataService.findById(id);
        if (data == null) {
            return "redirect:/data?error=not_found";
        }
        
        if (!data.getCreatedBy().equals(user.getId()) && !"ADMIN".equals(user.getRole())) {
            return "redirect:/data?error=access_denied";
        }
        
        try {
            dataService.delete(id);
            return "redirect:/data?success=true";
        } catch (Exception e) {
            logger.error("删除数据时发生错误, id: {}", id, e);
            return "redirect:/data?error=true";
        }
    }
}