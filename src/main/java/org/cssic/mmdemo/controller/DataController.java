package org.cssic.mmdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.cssic.mmdemo.model.DataEntity;
import org.cssic.mmdemo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class DataController {
    
    @Autowired
    private DataService dataService;

    // 获取数据列表
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllData() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<DataEntity> dataList = dataService.findAll();
            // 打印返回的数据，用于调试
            System.out.println("Returning data list: " + dataList);
            response.put("success", true);
            response.put("data", dataList);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace(); // 打印完整的错误栈，便于调试
            response.put("success", false);
            response.put("message", "获取数据失败：" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 获取单个数据项
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getData(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            DataEntity data = dataService.findById(id);
            if (data != null) {
                response.put("success", true);
                response.put("data", data);
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "数据不存在");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "获取数据失败：" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 创建新数据
    @PostMapping
    public ResponseEntity<Map<String, Object>> createData(
            @RequestBody DataEntity data,
            HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 设置创建者和创建时间
            Object userId = session.getAttribute("userId");
            data.setCreatedBy(userId != null ? (Long) userId : 1L);
            data.setCreatedDate(new Date());

            DataEntity savedData = dataService.save(data);
            response.put("success", true);
            response.put("data", savedData);
            response.put("message", "数据创建成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "创建数据失败：" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 更新数据
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateData(
            @PathVariable Long id,
            @RequestBody DataEntity data) {
        Map<String, Object> response = new HashMap<>();
        try {
            data.setId(id);
            DataEntity updatedData = dataService.update(data);
            if (updatedData != null) {
                response.put("success", true);
                response.put("data", updatedData);
                response.put("message", "数据更新成功");
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "数据不存在");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "更新数据失败：" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 删除数据
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteData(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            dataService.delete(id);
            response.put("success", true);
            response.put("message", "数据删除成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "删除数据失败：" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}