package org.cssic.mmdemo.controller;

import org.cssic.mmdemo.model.User;
import org.cssic.mmdemo.service.UserService;
import org.cssic.mmdemo.service.AccessControlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final AccessControlService accessControlService;

    @Autowired
    public UserController(UserService userService, AccessControlService accessControlService) {
        this.userService = userService;
        this.accessControlService = accessControlService;
    }

    @GetMapping("")
    public String list(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        if (accessControlService.isAdmin(currentUser)) {
            List<User> users = userService.findAll();
            model.addAttribute("users", users);
        } else {
            model.addAttribute("users", List.of(currentUser));
        }

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("isAdmin", accessControlService.isAdmin(currentUser));
        return "user/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        if (!accessControlService.isAdmin(currentUser) && !currentUser.getId().equals(id)) {
            return "redirect:/users?error=access_denied";
        }

        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/users?error=not_found";
        }

        model.addAttribute("user", user);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("isAdmin", accessControlService.isAdmin(currentUser));
        return "user/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        if (!accessControlService.isAdmin(currentUser) && !currentUser.getId().equals(id)) {
            return "redirect:/users?error=access_denied";
        }

        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/users?error=not_found";
        }

        model.addAttribute("user", user);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("isAdmin", accessControlService.isAdmin(currentUser));
        return "user/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute User user, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        if (!accessControlService.isAdmin(currentUser) && !currentUser.getId().equals(id)) {
            return "redirect:/users?error=access_denied";
        }

        try {
            User existingUser = userService.findById(id);
            if (existingUser == null) {
                return "redirect:/users?error=not_found";
            }

            // 只有管理员可以修改角色
            if (!accessControlService.isAdmin(currentUser)) {
                user.setRole(existingUser.getRole());
            }

            user.setId(id);
            userService.update(user);
            return "redirect:/users?success=true";
        } catch (Exception e) {
            logger.error("更新用户时发生错误", e);
            return "redirect:/users/edit/" + id + "?error=true";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        try {
            // 设置默认值
            user.setRole("USER");
            user.setActive(true);
            userService.save(user);
            return "redirect:/login?registered=true";
        } catch (Exception e) {
            logger.error("注册用户时发生错误", e);
            return "redirect:/users/register?error=true";
        }
    }
}