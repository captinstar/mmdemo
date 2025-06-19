package org.cssic.mmdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.cssic.mmdemo.model.User;
import org.cssic.mmdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class LoginController {
    
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final UserService userService;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginRequest,
                                                     HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            String username = loginRequest.get("username");
            String password = loginRequest.get("password");

            // 添加参数验证
            if (username == null || username.trim().isEmpty() ||
                    password == null || password.trim().isEmpty()) {
                response.put("success", false);
                response.put("message", "用户名和密码不能为空");
                return ResponseEntity.badRequest().body(response);
            }

            // 添加详细日志
            logger.debug("尝试登录用户: {}", username);
            
            if (userService.authenticate(username, password)) {
                User user = userService.findByUsername(username);
                session.setAttribute("user", user);

                logger.info("用户 {} 登录成功", username);
                response.put("success", true);
                response.put("user", user);
                return ResponseEntity.ok(response);
            } else {
                logger.debug("用户 {} 验证失败", username);
                response.put("success", false);
                response.put("message", "用户名或密码错误");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            logger.error("登录过程发生错误: {}", e.getMessage(), e);
            response.put("success", false);
            response.put("message", "系统错误，请稍后重试");
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpSession session) {
        session.invalidate();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 基本验证
            if (user.getUsername() == null || user.getUsername().trim().isEmpty() ||
                    user.getPassword() == null || user.getPassword().trim().isEmpty()) {
                response.put("success", false);
                response.put("message", "用户名和密码不能为空");
                return ResponseEntity.badRequest().body(response);
            }

            // 验证用户名是否已存在
            if (userService.findByUsername(user.getUsername()) != null) {
                response.put("success", false);
                response.put("message", "用户名已存在");
                return ResponseEntity.badRequest().body(response);
            }

            // 验证密码强度
            if (!isValidPassword(user.getPassword())) {
                response.put("success", false);
                response.put("message", "密码不符合要求");
                return ResponseEntity.badRequest().body(response);
            }

            user.setRole("USER");
            user.setActive(true);
            User savedUser = userService.save(user);

            response.put("success", true);
            response.put("user", savedUser);
            response.put("message", "注册成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("注册用户时发生错误", e);
            response.put("success", false);
            response.put("message", "注册失败，请稍后重试");
            return ResponseEntity.internalServerError().body(response);
        }
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}