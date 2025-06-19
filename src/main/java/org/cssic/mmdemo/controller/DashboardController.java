package org.cssic.mmdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @PostMapping  // 改为POST请求
    public ResponseEntity<Map<String, Object>> getDashboard() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("dashboardData", new HashMap<String, Object>() {{
            put("title", "仪表盘");
        }});
        return ResponseEntity.ok(response);
    }
}