package org.cssic.mmdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.cssic.mmdemo.model.User;
import org.cssic.mmdemo.service.AccessControlService;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final AccessControlService accessControlService;

    @Autowired
    public UserController(UserService userService, AccessControlService accessControlService) {
        this.userService = userService;
        this.accessControlService = accessControlService;
    }

    @PostMapping("/list")  // 改为POST请求，并修改路径
    public ResponseEntity<Map<String, Object>> list(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        User currentUser = (User) session.getAttribute("user");

        if (currentUser == null) {
            response.put("success", false);
            response.put("message", "未登录");
            return ResponseEntity.status(401).body(response);
        }

        List<User> users = accessControlService.isAdmin(currentUser)
                ? userService.findAll()
                : List.of(currentUser);

        response.put("success", true);
        response.put("users", users);
        response.put("currentUser", currentUser);
        response.put("isAdmin", accessControlService.isAdmin(currentUser));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/detail")  // 改为POST请求，接收id作为请求体参数
    public ResponseEntity<Map<String, Object>> view(@RequestBody Map<String, Long> request,
                                                    HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        User currentUser = (User) session.getAttribute("user");

        if (currentUser == null) {
            response.put("success", false);
            response.put("message", "未登录");
            return ResponseEntity.status(401).body(response);
        }

        Long id = request.get("id");
        if (id == null) {
            response.put("success", false);
            response.put("message", "ID不能为空");
            return ResponseEntity.badRequest().body(response);
        }

        if (!accessControlService.isAdmin(currentUser) && !currentUser.getId().equals(id)) {
            response.put("success", false);
            response.put("message", "访问被拒绝");
            return ResponseEntity.status(403).body(response);
        }

        User user = userService.findById(id);
        if (user == null) {
            response.put("success", false);
            response.put("message", "用户不存在");
            return ResponseEntity.status(404).body(response);
        }

        response.put("success", true);
        response.put("user", user);
        response.put("currentUser", currentUser);
        response.put("isAdmin", accessControlService.isAdmin(currentUser));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")  // 保持POST请求，更改路径更明确
    public ResponseEntity<Map<String, Object>> update(@RequestBody Map<String, Object> request,
                                                      HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        User currentUser = (User) session.getAttribute("user");

        if (currentUser == null) {
            response.put("success", false);
            response.put("message", "未登录");
            return ResponseEntity.status(401).body(response);
        }

        try {
            Long id = ((Number) request.get("id")).longValue();
            User user = (User) request.get("user");

            User existingUser = userService.findById(id);
            if (existingUser == null) {
                response.put("success", false);
                response.put("message", "用户不存在");
                return ResponseEntity.status(404).body(response);
            }

            if (!accessControlService.isAdmin(currentUser) && !currentUser.getId().equals(id)) {
                response.put("success", false);
                response.put("message", "访问被拒绝");
                return ResponseEntity.status(403).body(response);
            }

            // 只有管理员可以修改角色
            if (!accessControlService.isAdmin(currentUser)) {
                user.setRole(existingUser.getRole());
            }

            user.setId(id);
            User updatedUser = userService.update(user);

            response.put("success", true);
            response.put("user", updatedUser);
            response.put("message", "用户更新成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("更新用户时发生错误", e);
            response.put("success", false);
            response.put("message", "更新失败：" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/register")  // 保持POST请求不变
    public ResponseEntity<Map<String, Object>> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
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
            response.put("message", "注册失败：" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}