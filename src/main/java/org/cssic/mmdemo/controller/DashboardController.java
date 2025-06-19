package org.cssic.mmdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // 注意这里使用@Controller而不是@RestController
public class DashboardController {
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";  // 返回视图名称
    }
}