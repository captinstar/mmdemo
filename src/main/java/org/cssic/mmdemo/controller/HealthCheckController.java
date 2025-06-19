package org.cssic.mmdemo.controller;

import org.cssic.mmdemo.service.DeepSeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    // 添加缺失的 Map 对象用于缓存
    private final Map<String, String> errorAnalysisCache = new HashMap<>();
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private DeepSeekService deepSeekService;

    @PostMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", new Date());

        // 获取控制器参数信息
        Map<String, Object> controllerParams = getControllerParameters();
        response.put("controllerParameters", controllerParams);

        // 发送日志到DeepSeek
        sendLogsToDeepSeek(controllerParams);
        
        return ResponseEntity.ok(response);
    }

    // 添加缺失的 getControllerParameters 方法
    private Map<String, Object> getControllerParameters() {
        Map<String, Object> parameters = new HashMap<>();
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
            RequestMappingInfo mappingInfo = entry.getKey();
            HandlerMethod handlerMethod = entry.getValue();

            Map<String, Object> methodInfo = new HashMap<>();
            methodInfo.put("controllerName", handlerMethod.getBeanType().getSimpleName());
            methodInfo.put("methodName", handlerMethod.getMethod().getName());
            methodInfo.put("returnType", handlerMethod.getReturnType().getParameterType().getSimpleName());

            if (mappingInfo.getPatternsCondition() != null) {
                methodInfo.put("patterns", mappingInfo.getPatternsCondition().getPatterns());
            }

            parameters.put(handlerMethod.getBeanType().getSimpleName() + "." + handlerMethod.getMethod().getName(),
                    methodInfo);
        }

        return parameters;
    }

    private void sendLogsToDeepSeek(Map<String, Object> controllerParams) {
        Map<String, Object> logData = new HashMap<>();
        logData.put("timestamp", new Date());
        logData.put("type", "CONTROLLER_PARAMETERS");
        logData.put("data", controllerParams);
        logData.put("requestType", "ERROR_ANALYSIS");
        logData.put("errorDetails", collectErrorDetails());

        deepSeekService.sendLogs(logData);
//        String analysisResult = deepSeekService.sendLogs(logData);
//        errorAnalysisCache.put(logData.get("timestamp").toString(), analysisResult);
    }

    private Map<String, Object> collectErrorDetails() {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("stackTrace", Thread.currentThread().getStackTrace());
        errorDetails.put("systemInfo", System.getProperties());
        return errorDetails;
    }
}