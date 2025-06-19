package org.cssic.mmdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    @GetMapping("/login")
    public ResponseEntity<Map<String, Object>> getLoginPage() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("template", "login");
        response.put("data", new HashMap<String, Object>() {{
            put("title", "用户登录");
            put("formAction", "/api/auth/login");
        }});
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login-data")
    public ResponseEntity<Map<String, Object>> getLoginPageData() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("pageData", new HashMap<String, Object>() {{
            put("title", "登录");
            put("formFields", new String[]{"username", "password"});
        }});
        return ResponseEntity.ok(response);
    }
}