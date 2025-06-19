package org.cssic.mmdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/check-auth")  // 改为POST请求
    public ResponseEntity<Map<String, Object>> checkAuth(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Object user = session.getAttribute("user");

        if (user != null) {
            response.put("success", true);
            response.put("user", user);
            return ResponseEntity.ok(response);
        }

        response.put("success", false);
        return ResponseEntity.status(401).body(response);
    }
}