package org.cssic.mmdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.cssic.mmdemo.model.User;
import org.cssic.mmdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class LoginController {
    
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username,
                       @RequestParam String password,
                       Model model,
                       HttpSession session) {
        try {
            if (userService.authenticate(username, password)) {
                User user = userService.findByUsername(username);
                session.setAttribute("user", user);
                return "redirect:/dashboard";
            } else {
                model.addAttribute("error", "用户名或密码错误");
                return "login";
            }
        } catch (Exception e) {
            logger.error("登录过程发生错误", e);
            model.addAttribute("error", "系统错误，请稍后重试");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}