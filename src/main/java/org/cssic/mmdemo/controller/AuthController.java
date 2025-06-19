package org.cssic.mmdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @GetMapping("/check-auth")
    public ResponseEntity<Map<String, Object>> checkAuth(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Object user = session.getAttribute("user");

        if (user != null) {
            response.put("success", true);
            response.put("user", user); // 添加用户信息到响应中
            return ResponseEntity.ok(response);
        }

        response.put("success", false);
        return ResponseEntity.status(401).body(response);
    }
}