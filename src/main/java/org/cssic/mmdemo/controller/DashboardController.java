package org.cssic.mmdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/mmdemo")
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @GetMapping("/data-statistics-card")
    public String dataStatisticsCard(Model model) {
        return "data-statistics-card";
    }
}