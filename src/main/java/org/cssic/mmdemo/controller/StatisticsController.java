package org.cssic.mmdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @PostMapping  // 改为POST请求
    public ResponseEntity<Map<String, Object>> getStatistics() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("html", "<div class='container'><h2>数据统计</h2><p>这里是统计数据界面</p></div>");
        return ResponseEntity.ok(response);
    }
}