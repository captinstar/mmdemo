package org.cssic.mmdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.cssic.mmdemo.model.DataEntity;
import org.cssic.mmdemo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class DataController {
    
    @Autowired
    private DataService dataService;

    @PostMapping("/list")  // 改为POST请求，并修改路径
    public ResponseEntity<Map<String, Object>> getAllData() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<DataEntity> dataList = dataService.findAll();
            response.put("success", true);
            response.put("data", dataList);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "获取数据失败：" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/detail")  // 改为POST请求，接收id作为请求体参数
    public ResponseEntity<Map<String, Object>> getData(@RequestBody Map<String, Long> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            Long id = request.get("id");
            if (id == null) {
                response.put("success", false);
                response.put("message", "ID不能为空");
                return ResponseEntity.badRequest().body(response);
            }

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

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createData(
            @RequestBody DataEntity data,
            HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 设置创建时间 - 修改方法名为正确的setCreatedDate
            data.setCreatedDate(new Date());

            // 保存数据
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

    @PostMapping("/update")  // 改为POST请求，接收id作为请求体参数
    public ResponseEntity<Map<String, Object>> updateData(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            Long id = ((Number) request.get("id")).longValue();
            DataEntity data = new DataEntity(); // 假设有合适的方法来从Map构造DataEntity
            // 从request中设置data的属性
            
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

    @PostMapping("/delete")  // 改为POST请求，接收id作为请求体参数
    public ResponseEntity<Map<String, Object>> deleteData(@RequestBody Map<String, Long> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            Long id = request.get("id");
            if (id == null) {
                response.put("success", false);
                response.put("message", "ID不能为空");
                return ResponseEntity.badRequest().body(response);
            }

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