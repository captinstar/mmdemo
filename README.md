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

应用运行后，可通过浏览器访问: http://localhost:8080

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
