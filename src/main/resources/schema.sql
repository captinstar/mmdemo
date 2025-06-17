-- 创建用户表
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` varchar(20) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 创建数据实体表
CREATE TABLE IF NOT EXISTS `data_entities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `value` text,
  `category` varchar(50) DEFAULT NULL,
  `created_by` bigint NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_created_by` (`created_by`),
  CONSTRAINT `FK_created_by` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 插入初始管理员用户 (密码: admin123)
INSERT INTO `users` (`username`, `password`, `email`, `role`, `active`) VALUES
('admin', 'admin123', 'admin@example.com', 'ADMIN', 1);

-- 插入初始普通用户 (密码: user123)
INSERT INTO `users` (`username`, `password`, `email`, `role`, `active`) VALUES
('user', 'user123', 'user@example.com', 'USER', 1);

-- 插入初始数据
INSERT INTO `data_entities` (`name`, `description`, `value`, `category`, `created_by`, `created_date`) VALUES
('示例数据1', '这是一个示例数据项', '{"key": "value", "number": 42}', '测试', 1, NOW()),
('示例数据2', '用户创建的数据', '{"name": "测试数据", "active": true}', '用户数据', 2, NOW());
