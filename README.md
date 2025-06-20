# MM演示系统

这是一个包含用户管理和数据管理功能的简单Web应用程序。

## 技术栈

- Java 17
- Spring Boot 3.5.0
- MySQL 数据库
- Thymeleaf 模板引擎
- Bootstrap 5 UI框架

## 功能特点

- 用户登录认证
- 基于角色的访问控制
- 数据的增删改查
- 响应式UI设计

## 系统结构

- 模型层(Model): 包含User和DataEntity实体类
- 数据访问层(DAO): 使用JdbcTemplate进行数据库操作
- 服务层(Service): 提供业务逻辑处理
- 控制器层(Controller): 处理HTTP请求和响应
- 视图层(View): 使用Thymeleaf模板引擎渲染页面

## 运行说明

### 前提条件

- JDK 17或更高版本
- MySQL 8.0或更高版本
- Maven 3.6或更高版本

### 数据库设置

1. 创建MySQL数据库:

```sql
CREATE DATABASE mmdemo CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
```

2. 配置数据库连接:

编辑`src/main/resources/application.properties`文件中的数据库连接信息。

### 运行应用

```bash
# 使用Maven包装器运行
./mvnw spring-boot:run
```

或者

```bash
# 构建应用
./mvnw clean package

# 运行JAR文件
java -jar target/mmdemo-0.0.1-SNAPSHOT.jar
```

### 访问应用

应用运行后，可通过浏览器访问: http://localhost:8081

### 默认账户

- 管理员账户: admin / admin123
- 普通用户账户: user / user123

## 项目结构

```
src/main/java/org/cssic/mmdemo/
├── MmdemoApplication.java        # 应用入口
├── config/                        # 配置类
├── controller/                    # 控制器
├── dao/                           # 数据访问对象
├── interceptor/                   # 拦截器
├── model/                         # 实体类
└── service/                       # 服务类

src/main/resources/
├── application.properties        # 应用配置
├── schema.sql                    # 数据库初始化脚本
└── templates/                    # Thymeleaf模板
```

# MmDemo 项目文档

## 目录

1. [项目概述](#1-%E9%A1%B9%E7%9B%AE%E6%A6%82%E8%BF%B0)
2. [技术选型](#2-%E6%8A%80%E6%9C%AF%E9%80%89%E5%9E%8B)
3. [系统架构](#3-%E7%B3%BB%E7%BB%9F%E6%9E%B6%E6%9E%84)
4. [功能模块](#4-%E5%8A%9F%E8%83%BD%E6%A8%A1%E5%9D%97)
5. [API文档](#5-api%E6%96%87%E6%A1%A3)
6. [部署指南](#6-%E9%83%A8%E7%BD%B2%E6%8C%87%E5%8D%97)
7. [开发规范](#7-%E5%BC%80%E5%8F%91%E8%A7%84%E8%8C%83)
8. [测试策略](#8-%E6%B5%8B%E8%AF%95%E7%AD%96%E7%95%A5)

## 1. 项目概述

### 1.1 项目简介

MmDemo是一个基于Spring MVC框架开发的Web应用系统，提供REST风格的API接口。

### 1.2 项目目标

- 实现系统健康监控
- 提供可扩展的服务架构
- 确保系统稳定性和可用性

## 2. 技术选型

### 2.1 开发环境

- JDK版本：Java SDK 20
- 开发工具：IntelliJ IDEA

### 2.2 技术栈

- 后端框架：Spring MVC
- API规范：RESTful
- 企业级规范：Jakarta EE

### 2.3 技术选型理由

1. **Spring MVC**
    - 成熟稳定的框架
    - 完善的生态系统
    - 强大的社区支持

2. **RESTful API**
    - 接口规范标准
    - 易于理解和使用
    - 支持跨平台调用

## 3. 系统架构

### 3.1 架构图

``` 
+------------------+
|    客户端层      |
+------------------+
         ↓
+------------------+
|    控制器层      |
|  (Controller)    |
+------------------+
         ↓
+------------------+
|    服务层        |
|  (Service)       |
+------------------+
```

### 3.2 核心组件

- 健康检查控制器（HealthCheckController）
- REST API接口层

## 4. 功能模块

### 4.1 健康检查模块

#### 4.1.1 功能描述

提供系统健康状态监控接口，用于检查系统运行状态。

#### 4.1.2 实现代码

``` java
@RestController
public class HealthCheckController {
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
```

## 5. API文档

### 5.1 健康检查接口

#### 基本信息

- **接口URL**: `/health`
- **请求方式**: GET
- **接口描述**: 获取系统健康状态

#### 请求参数

无

#### 响应参数

| 参数名 | 类型     | 描述     | 示例   |
|-----|--------|--------|------|
| -   | String | 系统健康状态 | "OK" |

#### 响应示例

``` json
"OK"
```

## 6. 部署指南

### 6.1 环境要求

- JDK 20或以上
- Spring框架支持
- Web服务器（如Tomcat）

### 6.2 部署步骤

1. 编译项目代码
2. 配置应用服务器
3. 部署应用程序
4. 验证健康检查接口

## 7. 开发规范

### 7.1 代码规范

- 遵循Java代码规范
- 使用标准的Spring注解
- RESTful API设计规范

### 7.2 命名规范

- 包名：使用组织反向域名（如：org.cssic.mmdemo）
- 类名：驼峰命名，首字母大写
- 方法名：驼峰命名，首字母小写

### 7.3 注释规范

- 类级别注释：说明类的用途
- 方法级别注释：说明方法的功能、参数和返回值
- 关键代码注释：说明复杂逻辑

## 8. 测试策略

### 8.1 测试类型

1. 单元测试
    - 测试控制器方法
    - 测试服务层逻辑

2. 集成测试
    - 测试API接口
    - 测试系统集成

3. 性能测试
    - 测试接口响应时间
    - 测试系统负载能力

### 8.2 测试用例示例

``` java
// 健康检查接口测试
@Test
public void testHealthCheck() {
    String response = healthCheckController.healthCheck();
    assertEquals("OK", response);
}
```

## 未来展望

### 建议优化方向

1. 功能扩展
    - 添加详细的健康状态信息
    - 实现系统监控指标
    - 增加安全认证机制

2. 技术改进
    - 添加日志系统
    - 实现缓存机制
    - 优化性能监控

3. 文档完善
    - 集成Swagger文档
    - 完善接口说明
    - 添加示例代码

**版本信息**

- 文档版本：1.0
- 更新日期：2025-06-20

此文档将随项目发展持续更新，建议定期查看最新版本以获取最新信息。
