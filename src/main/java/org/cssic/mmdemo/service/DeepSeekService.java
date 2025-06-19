package org.cssic.mmdemo.service;

import org.cssic.mmdemo.config.DeepSeekConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class DeepSeekService {

    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private DeepSeekConfig deepSeekConfig;

    public void sendLogs(Map<String, Object> logs) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + deepSeekConfig.getApiKey());

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(logs, headers);

        try {
            restTemplate.postForEntity(
                    deepSeekConfig.getApiEndpoint() + "/logs",
                    request,
                    String.class
            );
        } catch (Exception e) {
            // 记录错误但不中断应用
            System.err.println("发送日志到DeepSeek失败: " + e.getMessage());
        }
    }
}