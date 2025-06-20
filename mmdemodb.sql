/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80042 (8.0.42)
 Source Host           : localhost:3306
 Source Schema         : mmdemodb

 Target Server Type    : MySQL
 Target Server Version : 80042 (8.0.42)
 File Encoding         : 65001

 Date: 20/06/2025 14:14:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for data_entities
-- ----------------------------
DROP TABLE IF EXISTS `data_entities`;
CREATE TABLE `data_entities`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `category` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_by` bigint NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_created_by`(`created_by` ASC) USING BTREE,
  CONSTRAINT `FK_created_by` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 138 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of data_entities
-- ----------------------------
INSERT INTO `data_entities` VALUES (3, '麻婆豆腐', '发源于四川的一种豆腐美食制作方法，以香、麻、辣出名，深受人们的喜爱，是餐桌上必不可少的一道美食！', '1', '川菜', 1, '2025-06-19 10:02:43');
INSERT INTO `data_entities` VALUES (4, '宫保鸡丁', '经典鲁菜演变而来，以鸡丁、花生、辣椒等炒制，咸鲜香辣，口感丰富', '1', '鲁菜', 1, '2025-06-19 10:10:00');
INSERT INTO `data_entities` VALUES (5, '鱼香肉丝', '源于四川，模仿鱼香风味，用肉丝、木耳、泡椒等炒制，酸甜开胃', '1', '川菜', 1, '2025-06-19 10:11:00');
INSERT INTO `data_entities` VALUES (6, '回锅肉', '四川传统名菜，五花肉切片回炒，搭配蒜苗，肥而不腻，香气四溢', '1', '川菜', 1, '2025-06-19 10:12:00');
INSERT INTO `data_entities` VALUES (7, '夫妻肺片', '成都特色凉菜，精选牛头皮、牛心等卤制凉拌，麻辣鲜香，质感丰富', '1', '川菜', 1, '2025-06-19 10:13:00');
INSERT INTO `data_entities` VALUES (8, '东坡肉', '浙江名菜，相传为苏轼所创，五花肉焖煮至酥烂，肥而不腻，酒香四溢', '1', '浙菜', 1, '2025-06-19 10:14:00');
INSERT INTO `data_entities` VALUES (9, '西湖醋鱼', '杭州经典菜，活鱼现杀清蒸，浇淋酸甜酱汁，鱼肉鲜嫩，酸甜适口', '1', '浙菜', 1, '2025-06-19 10:15:00');
INSERT INTO `data_entities` VALUES (10, '龙井虾仁', '杭州特色，以龙井茶鲜叶和新鲜虾仁炒制，清淡鲜美，茶香四溢', '1', '浙菜', 1, '2025-06-19 10:16:00');
INSERT INTO `data_entities` VALUES (11, '叫化鸡', '江苏名菜，用泥土包裹鸡烤制，鸡肉酥烂，香气透骨，风味独特', '1', '苏菜', 1, '2025-06-19 10:17:00');
INSERT INTO `data_entities` VALUES (12, '狮子头', '淮扬名菜，肥瘦相间猪肉制成大肉丸，可清炖等，口感松软，味道醇厚', '1', '苏菜', 1, '2025-06-19 10:18:00');
INSERT INTO `data_entities` VALUES (13, '松鼠鳜鱼', '苏州经典菜，鳜鱼改刀炸制形似松鼠，浇淋卤汁，外脆里嫩，酸甜可口', '1', '苏菜', 1, '2025-06-19 10:19:00');
INSERT INTO `data_entities` VALUES (14, '北京烤鸭', '北京标志性美食，选用优质鸭，果木炭火烤制，皮脆肉嫩，搭配面皮葱酱', '1', '京菜', 1, '2025-06-19 10:20:00');
INSERT INTO `data_entities` VALUES (15, '炸酱面', '老北京特色，炸酱搭配面条、菜码，酱香浓郁，面条筋道，家常美味', '1', '京菜', 1, '2025-06-19 10:21:00');
INSERT INTO `data_entities` VALUES (16, '涮羊肉', '北方传统火锅吃法，鲜嫩羊肉片在沸汤中涮煮，蘸麻酱等调料，暖身美味', '1', '京菜', 1, '2025-06-19 10:22:00');
INSERT INTO `data_entities` VALUES (17, '德州扒鸡', '山东名吃，德州产鸡经多种香料焖煮，肉烂骨酥，香味醇厚，便于携带', '1', '鲁菜', 1, '2025-06-19 10:23:00');
INSERT INTO `data_entities` VALUES (18, '葱烧海参', '鲁菜经典，海参搭配大葱烧制，海参软糯，葱香浓郁，营养丰富', '1', '鲁菜', 1, '2025-06-19 10:24:00');
INSERT INTO `data_entities` VALUES (19, '九转大肠', '鲁菜传统菜，大肠经多道工序烹制，色泽红润，口味酸甜香辣，质地软糯', '1', '鲁菜', 1, '2025-06-19 10:25:00');
INSERT INTO `data_entities` VALUES (20, '红烧狮子头', '上海本帮菜常见菜，肉丸饱满，红烧入味，咸鲜微甜，肉质松软', '1', '本帮菜', 1, '2025-06-19 10:26:00');
INSERT INTO `data_entities` VALUES (21, '生煎包', '上海特色小吃，底部煎至金黄酥脆，上部松软，肉馅多汁，香气诱人', '1', '本帮菜', 1, '2025-06-19 10:27:00');
INSERT INTO `data_entities` VALUES (22, '蟹壳黄', '上海、江苏等地小吃，烧饼形似蟹壳，酥层清晰，有葱油、鲜肉等多种口味', '1', '本帮菜', 1, '2025-06-19 10:28:00');
INSERT INTO `data_entities` VALUES (23, '锅包肉', '东北经典菜，猪里脊肉切片炸制，浇淋酸甜汁，外酥里嫩，酸甜适口', '1', '东北菜', 1, '2025-06-19 10:29:00');
INSERT INTO `data_entities` VALUES (24, '地三鲜', '东北家常菜，茄子、土豆、青椒炒制，酱香浓郁，食材软烂，下饭美味', '1', '东北菜', 1, '2025-06-19 10:30:00');
INSERT INTO `data_entities` VALUES (25, '溜肉段', '东北菜代表，猪肉段炸后溜炒，外焦里嫩，咸香下饭，深受喜爱', '1', '东北菜', 1, '2025-06-19 10:31:00');
INSERT INTO `data_entities` VALUES (26, '麻辣火锅', '重庆特色，以牛油等为锅底，搭配多样食材，麻辣过瘾，热闹开胃', '1', '川菜', 1, '2025-06-19 10:32:00');
INSERT INTO `data_entities` VALUES (27, '毛血旺', '重庆名菜，鸭血、毛肚等食材烩制，麻辣鲜香，汤汁红亮，极具风味', '1', '川菜', 1, '2025-06-19 10:33:00');
INSERT INTO `data_entities` VALUES (28, '辣子鸡', '重庆特色，鸡肉切块炸制后与大量辣椒炒制，麻辣酥脆，下酒下饭', '1', '川菜', 1, '2025-06-19 10:34:00');
INSERT INTO `data_entities` VALUES (29, '桂林米粉', '广西桂林特色，米粉搭配卤水、配菜，汤鲜粉爽，酸辣可口，风味独特', '1', '桂菜', 1, '2025-06-19 10:35:00');
INSERT INTO `data_entities` VALUES (30, '柳州螺蛳粉', '广西柳州名吃，酸辣鲜爽烫臭，米粉搭配螺蛳汤、酸笋等，极具特色', '1', '桂菜', 1, '2025-06-19 10:36:00');
INSERT INTO `data_entities` VALUES (31, '老友粉', '广西南宁特色，酸笋、豆豉等炒制汤底，米粉爽滑，酸辣开胃，香气扑鼻', '1', '桂菜', 1, '2025-06-19 10:37:00');
INSERT INTO `data_entities` VALUES (32, '过桥米线', '云南特色，滚烫汤头浇淋生食材，米线爽滑，搭配多样，营养美味', '1', '滇菜', 1, '2025-06-19 10:38:00');
INSERT INTO `data_entities` VALUES (33, '汽锅鸡', '云南名菜，用汽锅蒸制，鸡肉鲜嫩，汤汁清澈鲜美，营养保留好', '1', '滇菜', 1, '2025-06-19 10:39:00');
INSERT INTO `data_entities` VALUES (34, '鲜花饼', '云南特色糕点，以鲜花入馅，外皮酥脆，内馅香甜，花香四溢', '1', '滇菜', 1, '2025-06-19 10:40:00');
INSERT INTO `data_entities` VALUES (35, '羊肉泡馍', '陕西西安名吃，掰碎馍块与羊肉汤煮制，馍筋肉烂，汤浓味醇', '1', '陕菜', 1, '2025-06-19 10:41:00');
INSERT INTO `data_entities` VALUES (36, '肉夹馍', '陕西特色，腊汁肉剁碎夹入馍中，馍脆肉香，肥而不腻，百吃不厌', '1', '陕菜', 1, '2025-06-19 10:42:00');
INSERT INTO `data_entities` VALUES (37, '凉皮', '陕西经典小吃，凉皮搭配面筋、调料，酸辣凉爽，夏季消暑佳品', '1', '陕菜', 1, '2025-06-19 10:43:00');
INSERT INTO `data_entities` VALUES (38, '兰州拉面', '甘肃兰州特色，一清二白三红四绿五黄，拉面劲道，汤鲜味美', '1', '陇菜', 1, '2025-06-19 10:44:00');
INSERT INTO `data_entities` VALUES (39, '手抓羊肉', '西北多地特色，羊肉清水煮制，蘸盐食用，肉质鲜嫩，原汁原味', '1', '陇菜', 1, '2025-06-19 10:45:00');
INSERT INTO `data_entities` VALUES (40, '甜醅子', '甘肃特色小吃，青稞或燕麦发酵制成，酸甜可口，有酒香气，清凉解暑', '1', '陇菜', 1, '2025-06-19 10:46:00');
INSERT INTO `data_entities` VALUES (41, '新疆大盘鸡', '新疆名菜，鸡块与土豆、辣椒炒制，搭配皮带面，香辣过瘾，分量十足', '1', '新疆菜', 1, '2025-06-19 10:47:00');
INSERT INTO `data_entities` VALUES (42, '烤羊肉串', '新疆特色，鲜羊肉切小块串起烤制，撒上调料，外焦里嫩，香气诱人', '1', '新疆菜', 1, '2025-06-19 10:48:00');
INSERT INTO `data_entities` VALUES (43, '手抓饭', '新疆传统美食，羊肉、胡萝卜、米饭焖煮，色泽诱人，味道香浓，营养丰富', '1', '新疆菜', 1, '2025-06-19 10:49:00');
INSERT INTO `data_entities` VALUES (44, '客家酿豆腐', '广东客家菜，豆腐挖空填入肉馅，煎焖后，豆腐嫩滑，肉馅鲜香', '1', '粤菜', 1, '2025-06-19 10:50:00');
INSERT INTO `data_entities` VALUES (45, '白切鸡', '广东经典菜，鸡清水煮熟，蘸姜蒜汁，皮黄肉白，原汁原味，肉质鲜嫩', '1', '粤菜', 1, '2025-06-19 10:51:00');
INSERT INTO `data_entities` VALUES (46, '肠粉', '广东特色早餐，米浆蒸制而成，薄如纸，搭配豉油等，口感爽滑', '1', '粤菜', 1, '2025-06-19 10:52:00');
INSERT INTO `data_entities` VALUES (47, '佛跳墙', '福建名菜，多种山珍海味煨制，汤汁浓郁，食材软烂，营养丰富，味极鲜美', '1', '闽菜', 1, '2025-06-19 10:53:00');
INSERT INTO `data_entities` VALUES (48, '荔枝肉', '福建传统菜，猪肉切成荔枝状，炸后炒制，酸甜可口，形似荔枝', '1', '闽菜', 1, '2025-06-19 10:54:00');
INSERT INTO `data_entities` VALUES (49, '沙茶面', '福建厦门特色，浓郁沙茶汤底，搭配多种食材，鲜香浓郁，口感丰富', '1', '闽菜', 1, '2025-06-19 10:55:00');
INSERT INTO `data_entities` VALUES (50, '台湾卤肉饭', '台湾经典美食，卤肉肥瘦相间，浇淋米饭，搭配卤蛋等，香浓下饭', '1', '台湾菜', 1, '2025-06-19 10:56:00');
INSERT INTO `data_entities` VALUES (51, '蚵仔煎', '台湾特色小吃，蚵仔（海蛎）与鸡蛋、淀粉煎制，搭配酱料，口感丰富', '1', '台湾菜', 1, '2025-06-19 10:57:00');
INSERT INTO `data_entities` VALUES (52, '凤梨酥', '台湾传统糕点，凤梨做馅，外皮酥松，甜而不腻，带有凤梨清香', '1', '台湾菜', 1, '2025-06-19 10:58:00');
INSERT INTO `data_entities` VALUES (53, '朝鲜冷面', '朝鲜族特色，凉汤搭配冷面、泡菜、牛肉等，酸甜凉爽，夏季佳品', '1', '朝鲜族菜', 1, '2025-06-19 10:59:00');
INSERT INTO `data_entities` VALUES (54, '石锅拌饭', '韩国料理代表，米饭、蔬菜、肉类等在石锅焖制，底部有香脆锅巴，搭配辣酱', '1', '韩国料理', 1, '2025-06-19 11:00:00');
INSERT INTO `data_entities` VALUES (55, '部队火锅', '韩国特色，多种食材如火腿、泡菜、方便面等煮于一锅，汤汁浓郁，热闹美味', '1', '韩国料理', 1, '2025-06-19 11:01:00');
INSERT INTO `data_entities` VALUES (56, '寿司', '日本传统美食，米饭搭配生鱼片、蔬菜等，捏制而成，造型多样，口味清淡', '1', '日本料理', 1, '2025-06-19 11:02:00');
INSERT INTO `data_entities` VALUES (57, '天妇罗', '日本料理，食材裹面糊炸制，色泽金黄，外皮酥脆，内馅鲜嫩，搭配酱汁', '1', '日本料理', 1, '2025-06-19 11:03:00');
INSERT INTO `data_entities` VALUES (58, '拉面', '日本常见面食，豚骨、酱油等汤底，搭配面条、叉烧等，汤浓面劲道', '1', '日本料理', 1, '2025-06-19 11:04:00');
INSERT INTO `data_entities` VALUES (59, '意大利面', '意大利经典美食，多种形状面条搭配肉酱、奶油等酱汁，口味丰富，变化多样', '1', '意大利菜', 1, '2025-06-19 11:05:00');
INSERT INTO `data_entities` VALUES (60, '披萨', '意大利特色，面饼涂抹酱料，铺芝士、食材烤制，芝士拉丝，香气扑鼻', '1', '意大利菜', 1, '2025-06-19 11:06:00');
INSERT INTO `data_entities` VALUES (61, '提拉米苏', '意大利甜点，咖啡、手指饼干、马斯卡彭芝士等制成，口感细腻，甜而不腻', '1', '意大利菜', 1, '2025-06-19 11:07:00');
INSERT INTO `data_entities` VALUES (62, '法国牛排', '法国经典菜品，牛排经精细烹制，搭配酱汁、蔬菜等，肉质鲜嫩，仪式感强', '1', '法国菜', 1, '2025-06-19 11:08:00');
INSERT INTO `data_entities` VALUES (63, '法式焗蜗牛', '法国特色，蜗牛经处理，用芝士等焗制，口感独特，浓郁芝士香', '1', '法国菜', 1, '2025-06-19 11:09:00');
INSERT INTO `data_entities` VALUES (64, '马卡龙', '法国甜点，外皮酥脆，内馅柔软，色彩缤纷，甜香迷人，精致小巧', '1', '法国菜', 1, '2025-06-19 11:10:00');
INSERT INTO `data_entities` VALUES (65, '德国猪脚', '德国传统美食，猪脚烤制或卤制，外皮酥脆，肉质紧实，搭配酸菜等', '1', '德国菜', 1, '2025-06-19 11:11:00');
INSERT INTO `data_entities` VALUES (66, '香肠拼盘', '德国特色，多种风味香肠组合，搭配酸菜、面包，品尝不同香肠风味', '1', '德国菜', 1, '2025-06-19 11:12:00');
INSERT INTO `data_entities` VALUES (67, '黑森林蛋糕', '德国甜点，巧克力蛋糕层、樱桃馅、奶油等制成，口感丰富，樱桃酒香浓郁', '1', '德国菜', 1, '2025-06-19 11:13:00');
INSERT INTO `data_entities` VALUES (68, '俄式红菜汤', '俄罗斯经典汤品，红菜头、牛肉等熬制，酸甜开胃，搭配面包，暖身美味', '1', '俄罗斯菜', 1, '2025-06-19 11:14:00');
INSERT INTO `data_entities` VALUES (69, '俄式大列巴', '俄罗斯传统面包，体积大，口感硬实有嚼劲，麦香浓郁，可储存久', '1', '俄罗斯菜', 1, '2025-06-19 11:15:00');
INSERT INTO `data_entities` VALUES (70, '俄式烤肉串', '俄罗斯特色，大块肉串烤制，搭配洋葱等，肉质鲜嫩，分量实在，满足味蕾', '1', '俄罗斯菜', 1, '2025-06-19 11:16:00');
INSERT INTO `data_entities` VALUES (71, '宫保鸡丁', '经典鲁菜演变而来，以鸡丁、花生、辣椒等炒制，咸鲜香辣，口感丰富', '1', '鲁菜', 1, '2025-06-19 10:10:00');
INSERT INTO `data_entities` VALUES (72, '鱼香肉丝', '源于四川，模仿鱼香风味，用肉丝、木耳、泡椒等炒制，酸甜开胃', '1', '川菜', 1, '2025-06-19 10:11:00');
INSERT INTO `data_entities` VALUES (73, '回锅肉', '四川传统名菜，五花肉切片回炒，搭配蒜苗，肥而不腻，香气四溢', '1', '川菜', 1, '2025-06-19 10:12:00');
INSERT INTO `data_entities` VALUES (74, '夫妻肺片', '成都特色凉菜，精选牛头皮、牛心等卤制凉拌，麻辣鲜香，质感丰富', '1', '川菜', 1, '2025-06-19 10:13:00');
INSERT INTO `data_entities` VALUES (75, '东坡肉', '浙江名菜，相传为苏轼所创，五花肉焖煮至酥烂，肥而不腻，酒香四溢', '1', '浙菜', 1, '2025-06-19 10:14:00');
INSERT INTO `data_entities` VALUES (76, '西湖醋鱼', '杭州经典菜，活鱼现杀清蒸，浇淋酸甜酱汁，鱼肉鲜嫩，酸甜适口', '1', '浙菜', 1, '2025-06-19 10:15:00');
INSERT INTO `data_entities` VALUES (77, '龙井虾仁', '杭州特色，以龙井茶鲜叶和新鲜虾仁炒制，清淡鲜美，茶香四溢', '1', '浙菜', 1, '2025-06-19 10:16:00');
INSERT INTO `data_entities` VALUES (78, '叫化鸡', '江苏名菜，用泥土包裹鸡烤制，鸡肉酥烂，香气透骨，风味独特', '1', '苏菜', 1, '2025-06-19 10:17:00');
INSERT INTO `data_entities` VALUES (79, '狮子头', '淮扬名菜，肥瘦相间猪肉制成大肉丸，可清炖等，口感松软，味道醇厚', '1', '苏菜', 1, '2025-06-19 10:18:00');
INSERT INTO `data_entities` VALUES (80, '松鼠鳜鱼', '苏州经典菜，鳜鱼改刀炸制形似松鼠，浇淋卤汁，外脆里嫩，酸甜可口', '1', '苏菜', 1, '2025-06-19 10:19:00');
INSERT INTO `data_entities` VALUES (81, '北京烤鸭', '北京标志性美食，选用优质鸭，果木炭火烤制，皮脆肉嫩，搭配面皮葱酱', '1', '京菜', 1, '2025-06-19 10:20:00');
INSERT INTO `data_entities` VALUES (82, '炸酱面', '老北京特色，炸酱搭配面条、菜码，酱香浓郁，面条筋道，家常美味', '1', '京菜', 1, '2025-06-19 10:21:00');
INSERT INTO `data_entities` VALUES (83, '涮羊肉', '北方传统火锅吃法，鲜嫩羊肉片在沸汤中涮煮，蘸麻酱等调料，暖身美味', '1', '京菜', 1, '2025-06-19 10:22:00');
INSERT INTO `data_entities` VALUES (84, '德州扒鸡', '山东名吃，德州产鸡经多种香料焖煮，肉烂骨酥，香味醇厚，便于携带', '1', '鲁菜', 1, '2025-06-19 10:23:00');
INSERT INTO `data_entities` VALUES (85, '葱烧海参', '鲁菜经典，海参搭配大葱烧制，海参软糯，葱香浓郁，营养丰富', '1', '鲁菜', 1, '2025-06-19 10:24:00');
INSERT INTO `data_entities` VALUES (86, '九转大肠', '鲁菜传统菜，大肠经多道工序烹制，色泽红润，口味酸甜香辣，质地软糯', '1', '鲁菜', 1, '2025-06-19 10:25:00');
INSERT INTO `data_entities` VALUES (87, '红烧狮子头', '上海本帮菜常见菜，肉丸饱满，红烧入味，咸鲜微甜，肉质松软', '1', '本帮菜', 1, '2025-06-19 10:26:00');
INSERT INTO `data_entities` VALUES (88, '生煎包', '上海特色小吃，底部煎至金黄酥脆，上部松软，肉馅多汁，香气诱人', '1', '本帮菜', 1, '2025-06-19 10:27:00');
INSERT INTO `data_entities` VALUES (89, '蟹壳黄', '上海、江苏等地小吃，烧饼形似蟹壳，酥层清晰，有葱油、鲜肉等多种口味', '1', '本帮菜', 1, '2025-06-19 10:28:00');
INSERT INTO `data_entities` VALUES (90, '锅包肉', '东北经典菜，猪里脊肉切片炸制，浇淋酸甜汁，外酥里嫩，酸甜适口', '1', '东北菜', 1, '2025-06-19 10:29:00');
INSERT INTO `data_entities` VALUES (91, '地三鲜', '东北家常菜，茄子、土豆、青椒炒制，酱香浓郁，食材软烂，下饭美味', '1', '东北菜', 1, '2025-06-19 10:30:00');
INSERT INTO `data_entities` VALUES (92, '溜肉段', '东北菜代表，猪肉段炸后溜炒，外焦里嫩，咸香下饭，深受喜爱', '1', '东北菜', 1, '2025-06-19 10:31:00');
INSERT INTO `data_entities` VALUES (93, '麻辣火锅', '重庆特色，以牛油等为锅底，搭配多样食材，麻辣过瘾，热闹开胃', '1', '川菜', 1, '2025-06-19 10:32:00');
INSERT INTO `data_entities` VALUES (94, '毛血旺', '重庆名菜，鸭血、毛肚等食材烩制，麻辣鲜香，汤汁红亮，极具风味', '1', '川菜', 1, '2025-06-19 10:33:00');
INSERT INTO `data_entities` VALUES (95, '辣子鸡', '重庆特色，鸡肉切块炸制后与大量辣椒炒制，麻辣酥脆，下酒下饭', '1', '川菜', 1, '2025-06-19 10:34:00');
INSERT INTO `data_entities` VALUES (96, '桂林米粉', '广西桂林特色，米粉搭配卤水、配菜，汤鲜粉爽，酸辣可口，风味独特', '1', '桂菜', 1, '2025-06-19 10:35:00');
INSERT INTO `data_entities` VALUES (97, '柳州螺蛳粉', '广西柳州名吃，酸辣鲜爽烫臭，米粉搭配螺蛳汤、酸笋等，极具特色', '1', '桂菜', 1, '2025-06-19 10:36:00');
INSERT INTO `data_entities` VALUES (98, '老友粉', '广西南宁特色，酸笋、豆豉等炒制汤底，米粉爽滑，酸辣开胃，香气扑鼻', '1', '桂菜', 1, '2025-06-19 10:37:00');
INSERT INTO `data_entities` VALUES (99, '过桥米线', '云南特色，滚烫汤头浇淋生食材，米线爽滑，搭配多样，营养美味', '1', '滇菜', 1, '2025-06-19 10:38:00');
INSERT INTO `data_entities` VALUES (100, '汽锅鸡', '云南名菜，用汽锅蒸制，鸡肉鲜嫩，汤汁清澈鲜美，营养保留好', '1', '滇菜', 1, '2025-06-19 10:39:00');
INSERT INTO `data_entities` VALUES (101, '鲜花饼', '云南特色糕点，以鲜花入馅，外皮酥脆，内馅香甜，花香四溢', '1', '滇菜', 1, '2025-06-19 10:40:00');
INSERT INTO `data_entities` VALUES (102, '羊肉泡馍', '陕西西安名吃，掰碎馍块与羊肉汤煮制，馍筋肉烂，汤浓味醇', '1', '陕菜', 1, '2025-06-19 10:41:00');
INSERT INTO `data_entities` VALUES (103, '肉夹馍', '陕西特色，腊汁肉剁碎夹入馍中，馍脆肉香，肥而不腻，百吃不厌', '1', '陕菜', 1, '2025-06-19 10:42:00');
INSERT INTO `data_entities` VALUES (104, '凉皮', '陕西经典小吃，凉皮搭配面筋、调料，酸辣凉爽，夏季消暑佳品', '1', '陕菜', 1, '2025-06-19 10:43:00');
INSERT INTO `data_entities` VALUES (105, '兰州拉面', '甘肃兰州特色，一清二白三红四绿五黄，拉面劲道，汤鲜味美', '1', '陇菜', 1, '2025-06-19 10:44:00');
INSERT INTO `data_entities` VALUES (106, '手抓羊肉', '西北多地特色，羊肉清水煮制，蘸盐食用，肉质鲜嫩，原汁原味', '1', '陇菜', 1, '2025-06-19 10:45:00');
INSERT INTO `data_entities` VALUES (107, '甜醅子', '甘肃特色小吃，青稞或燕麦发酵制成，酸甜可口，有酒香气，清凉解暑', '1', '陇菜', 1, '2025-06-19 10:46:00');
INSERT INTO `data_entities` VALUES (108, '新疆大盘鸡', '新疆名菜，鸡块与土豆、辣椒炒制，搭配皮带面，香辣过瘾，分量十足', '1', '新疆菜', 1, '2025-06-19 10:47:00');
INSERT INTO `data_entities` VALUES (109, '烤羊肉串', '新疆特色，鲜羊肉切小块串起烤制，撒上调料，外焦里嫩，香气诱人', '1', '新疆菜', 1, '2025-06-19 10:48:00');
INSERT INTO `data_entities` VALUES (110, '手抓饭', '新疆传统美食，羊肉、胡萝卜、米饭焖煮，色泽诱人，味道香浓，营养丰富', '1', '新疆菜', 1, '2025-06-19 10:49:00');
INSERT INTO `data_entities` VALUES (111, '客家酿豆腐', '广东客家菜，豆腐挖空填入肉馅，煎焖后，豆腐嫩滑，肉馅鲜香', '1', '粤菜', 1, '2025-06-19 10:50:00');
INSERT INTO `data_entities` VALUES (112, '白切鸡', '广东经典菜，鸡清水煮熟，蘸姜蒜汁，皮黄肉白，原汁原味，肉质鲜嫩', '1', '粤菜', 1, '2025-06-19 10:51:00');
INSERT INTO `data_entities` VALUES (113, '肠粉', '广东特色早餐，米浆蒸制而成，薄如纸，搭配豉油等，口感爽滑', '1', '粤菜', 1, '2025-06-19 10:52:00');
INSERT INTO `data_entities` VALUES (114, '佛跳墙', '福建名菜，多种山珍海味煨制，汤汁浓郁，食材软烂，营养丰富，味极鲜美', '1', '闽菜', 1, '2025-06-19 10:53:00');
INSERT INTO `data_entities` VALUES (115, '荔枝肉', '福建传统菜，猪肉切成荔枝状，炸后炒制，酸甜可口，形似荔枝', '1', '闽菜', 1, '2025-06-19 10:54:00');
INSERT INTO `data_entities` VALUES (116, '沙茶面', '福建厦门特色，浓郁沙茶汤底，搭配多种食材，鲜香浓郁，口感丰富', '1', '闽菜', 1, '2025-06-19 10:55:00');
INSERT INTO `data_entities` VALUES (117, '台湾卤肉饭', '台湾经典美食，卤肉肥瘦相间，浇淋米饭，搭配卤蛋等，香浓下饭', '1', '台湾菜', 1, '2025-06-19 10:56:00');
INSERT INTO `data_entities` VALUES (118, '蚵仔煎', '台湾特色小吃，蚵仔（海蛎）与鸡蛋、淀粉煎制，搭配酱料，口感丰富', '1', '台湾菜', 1, '2025-06-19 10:57:00');
INSERT INTO `data_entities` VALUES (119, '凤梨酥', '台湾传统糕点，凤梨做馅，外皮酥松，甜而不腻，带有凤梨清香', '1', '台湾菜', 1, '2025-06-19 10:58:00');
INSERT INTO `data_entities` VALUES (120, '朝鲜冷面', '朝鲜族特色，凉汤搭配冷面、泡菜、牛肉等，酸甜凉爽，夏季佳品', '1', '朝鲜族菜', 1, '2025-06-19 10:59:00');
INSERT INTO `data_entities` VALUES (121, '石锅拌饭', '韩国料理代表，米饭、蔬菜、肉类等在石锅焖制，底部有香脆锅巴，搭配辣酱', '1', '韩国料理', 1, '2025-06-19 11:00:00');
INSERT INTO `data_entities` VALUES (122, '部队火锅', '韩国特色，多种食材如火腿、泡菜、方便面等煮于一锅，汤汁浓郁，热闹美味', '1', '韩国料理', 1, '2025-06-19 11:01:00');
INSERT INTO `data_entities` VALUES (123, '寿司', '日本传统美食，米饭搭配生鱼片、蔬菜等，捏制而成，造型多样，口味清淡', '1', '日本料理', 1, '2025-06-19 11:02:00');
INSERT INTO `data_entities` VALUES (124, '天妇罗', '日本料理，食材裹面糊炸制，色泽金黄，外皮酥脆，内馅鲜嫩，搭配酱汁', '1', '日本料理', 1, '2025-06-19 11:03:00');
INSERT INTO `data_entities` VALUES (125, '拉面', '日本常见面食，豚骨、酱油等汤底，搭配面条、叉烧等，汤浓面劲道', '1', '日本料理', 1, '2025-06-19 11:04:00');
INSERT INTO `data_entities` VALUES (126, '意大利面', '意大利经典美食，多种形状面条搭配肉酱、奶油等酱汁，口味丰富，变化多样', '1', '意大利菜', 1, '2025-06-19 11:05:00');
INSERT INTO `data_entities` VALUES (127, '披萨', '意大利特色，面饼涂抹酱料，铺芝士、食材烤制，芝士拉丝，香气扑鼻', '1', '意大利菜', 1, '2025-06-19 11:06:00');
INSERT INTO `data_entities` VALUES (128, '提拉米苏', '意大利甜点，咖啡、手指饼干、马斯卡彭芝士等制成，口感细腻，甜而不腻', '1', '意大利菜', 1, '2025-06-19 11:07:00');
INSERT INTO `data_entities` VALUES (129, '法国牛排', '法国经典菜品，牛排经精细烹制，搭配酱汁、蔬菜等，肉质鲜嫩，仪式感强', '1', '法国菜', 1, '2025-06-19 11:08:00');
INSERT INTO `data_entities` VALUES (130, '法式焗蜗牛', '法国特色，蜗牛经处理，用芝士等焗制，口感独特，浓郁芝士香', '1', '法国菜', 1, '2025-06-19 11:09:00');
INSERT INTO `data_entities` VALUES (131, '马卡龙', '法国甜点，外皮酥脆，内馅柔软，色彩缤纷，甜香迷人，精致小巧', '1', '法国菜', 1, '2025-06-19 11:10:00');
INSERT INTO `data_entities` VALUES (132, '德国猪脚', '德国传统美食，猪脚烤制或卤制，外皮酥脆，肉质紧实，搭配酸菜等', '1', '德国菜', 1, '2025-06-19 11:11:00');
INSERT INTO `data_entities` VALUES (133, '香肠拼盘', '德国特色，多种风味香肠组合，搭配酸菜、面包，品尝不同香肠风味', '1', '德国菜', 1, '2025-06-19 11:12:00');
INSERT INTO `data_entities` VALUES (134, '黑森林蛋糕', '德国甜点，巧克力蛋糕层、樱桃馅、奶油等制成，口感丰富，樱桃酒香浓郁', '1', '德国菜', 1, '2025-06-19 11:13:00');
INSERT INTO `data_entities` VALUES (135, '俄式红菜汤', '俄罗斯经典汤品，红菜头、牛肉等熬制，酸甜开胃，搭配面包，暖身美味', '1', '俄罗斯菜', 1, '2025-06-19 11:14:00');
INSERT INTO `data_entities` VALUES (136, '俄式大列巴', '俄罗斯传统面包，体积大，口感硬实有嚼劲，麦香浓郁，可储存久', '1', '俄罗斯菜', 1, '2025-06-19 11:15:00');
INSERT INTO `data_entities` VALUES (137, '俄式烤肉串', '俄罗斯特色，大块肉串烤制，搭配洋葱等，肉质鲜嫩，分量实在，满足味蕾', '1', '俄罗斯菜', 1, '2025-06-19 11:16:00');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 106 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'admin123', 'admin@example.com', 'ADMIN', 1);
INSERT INTO `users` VALUES (2, 'user', 'user123', 'user@example.com', 'USER', 1);
INSERT INTO `users` VALUES (4, '王城城', '123456', '2421623641@qq.com', 'USER', 1);
INSERT INTO `users` VALUES (5, 'Lei Jiehong', '0sP2O6INw7', 'jiehong908@mail.com', 'DqSPN0I3wu', 124);
INSERT INTO `users` VALUES (6, 'Suzuki Riku', 'N9CTYzXlKp', 'suzuki10@hotmail.com', 'aR5dtSnE4p', 19);
INSERT INTO `users` VALUES (7, 'Matsui Eita', 'EG34kI50Fh', 'maei@yahoo.com', 'TK6XPSty7r', 103);
INSERT INTO `users` VALUES (8, 'Victoria Parker', 'WZv23f55xc', 'parkervictoria@hotmail.com', 'UupRRZGSWU', 82);
INSERT INTO `users` VALUES (9, 'Inoue Itsuki', '7DRjLZTNhY', 'itsukiinoue129@mail.com', 'Di8vukHyXM', 14);
INSERT INTO `users` VALUES (10, 'Cheng Wai Lam', 'yzbQVhquqk', 'wacheng1027@gmail.com', 'GkHdzGW90J', 71);
INSERT INTO `users` VALUES (11, 'Yuen Sai Wing', 'ITwfwROAWh', 'saiwing99@hotmail.com', 'l8uhud9Q8B', 83);
INSERT INTO `users` VALUES (12, 'Angela Jordan', 'S6brJva2PD', 'angeljo7@gmail.com', 'wgpdaig1Ly', 6);
INSERT INTO `users` VALUES (13, 'Man Kwok Yin', 'VJ5EnSnQGC', 'kwokyma@icloud.com', 'nycCvi7CFJ', 64);
INSERT INTO `users` VALUES (14, 'Koyama Shino', 'Xq8tkSayQk', 'koyashino@outlook.com', '7h2lYzLXAR', 19);
INSERT INTO `users` VALUES (15, 'Shi Yunxi', 'W9MSnfQGvY', 'shiy@yahoo.com', 'OcstYguKaw', 41);
INSERT INTO `users` VALUES (16, 'Shi Ziyi', 'PmOgPGXeXR', 'shi8@icloud.com', '8TFJRnIg7R', 31);
INSERT INTO `users` VALUES (17, 'Nakagawa Hazuki', 'ghaQQbmj4b', 'hazunakagawa@mail.com', '5nysJy21dY', 71);
INSERT INTO `users` VALUES (18, 'Elaine Coleman', 'cwjPEDV3j3', 'elaine64@gmail.com', 'rOnmVnTbUI', 107);
INSERT INTO `users` VALUES (19, 'Billy Miller', '1f4WLD3XjK', 'mibi@outlook.com', 'Ys6V3Q3qt8', 115);
INSERT INTO `users` VALUES (20, 'Brian Cooper', '3D9ocEPO5Q', 'brianc@gmail.com', 'tfddRcyGLV', 95);
INSERT INTO `users` VALUES (21, 'Xiao Lu', 'Kgp9XVI8Ba', 'lux@gmail.com', 'bCRxHGXe48', 35);
INSERT INTO `users` VALUES (22, 'Leung Chi Ming', '9Ysvbe0nNM', 'leuchiming5@icloud.com', 'm5EAuwxFoQ', 74);
INSERT INTO `users` VALUES (23, 'Vincent Ortiz', 'OQSyUGHe9Y', 'ortizv@icloud.com', 'Q29xsmyr7g', 39);
INSERT INTO `users` VALUES (24, 'Fu Wai Man', 'eVGMX6qL6v', 'fuwm2@gmail.com', 'MCRT5XUdUo', 118);
INSERT INTO `users` VALUES (25, 'Long Jiehong', 'lfDF1Bw0FR', 'lojiehong@hotmail.com', 'hqeMPJUYyd', 46);
INSERT INTO `users` VALUES (26, 'Jason Murphy', 'u52xKCGHhY', 'jamu3@yahoo.com', '31JIHrt220', 39);
INSERT INTO `users` VALUES (27, 'Timothy Allen', 'QZlYOJiSLC', 'allt@outlook.com', 'C1w1S15Den', 17);
INSERT INTO `users` VALUES (28, 'Qian Jialun', 'mMLiuc9vQW', 'qji2000@gmail.com', '3y9dd9cLqM', 30);
INSERT INTO `users` VALUES (29, 'Wada Daisuke', '6UpwukkzHY', 'wadaisuke1989@icloud.com', 'OJ5XyCxsuT', 116);
INSERT INTO `users` VALUES (30, 'Han Jiehong', 'triy1wIkUU', 'hanjieho310@outlook.com', 'ETTYrcnLDK', 95);
INSERT INTO `users` VALUES (31, 'Jia Zhennan', 'HghpL4LWom', 'zhennanjia@yahoo.com', 'WfzaxcBAhb', 16);
INSERT INTO `users` VALUES (32, 'Su Rui', 'zRlNGjCVND', 'suru@hotmail.com', 'sPnB4akmvi', 48);
INSERT INTO `users` VALUES (33, 'Leung Ka Fai', 'TiaEEbBL81', 'kafai55@gmail.com', 'x5vJVBH0q3', 33);
INSERT INTO `users` VALUES (34, 'Howard Alexander', '8IWYAq09g6', 'alexander719@yahoo.com', 'U55EgenYFq', 87);
INSERT INTO `users` VALUES (35, 'Kong Rui', '64JVwBxgzC', 'kor@outlook.com', 'px52txUhJ0', 71);
INSERT INTO `users` VALUES (36, 'Brandon Mendoza', '3IvS02glb2', 'brandon15@gmail.com', 'v1bs2qyxHv', 69);
INSERT INTO `users` VALUES (37, 'Peter Mendez', 'eQCTsMuBcm', 'mendezpet@outlook.com', 'FtM768Rho2', 6);
INSERT INTO `users` VALUES (38, 'Hayashi Hikari', 'nxR0fjMlCK', 'hayashihikari@hotmail.com', 'F7a6XwJZON', 75);
INSERT INTO `users` VALUES (39, 'Zhao Rui', 'gP4O0f6mAV', 'zhaorui1209@gmail.com', 'ZMfAcyE4eB', 26);
INSERT INTO `users` VALUES (40, 'Man Kwok Ming', 'ooy3j4Wqt9', 'mankm@outlook.com', 'VbsS39oPfr', 53);
INSERT INTO `users` VALUES (41, 'Lu Jiehong', 'aQCmvS1xn0', 'ljiehong331@hotmail.com', 'quUNE4d51q', 111);
INSERT INTO `users` VALUES (42, 'Yamaguchi Hazuki', 'TuttY9MMwq', 'yahazuki1206@outlook.com', 'NNK1tRYuJA', 14);
INSERT INTO `users` VALUES (43, 'Ethel White', '6udkNCwRLx', 'ew10@icloud.com', 'Y7vgwZe9Wj', 119);
INSERT INTO `users` VALUES (44, 'Lo Wai Man', 'Tagb1ijWqs', 'wmlo48@hotmail.com', 'Htpq01qKK0', 77);
INSERT INTO `users` VALUES (45, 'Chan Suk Yee', 'plpEv1TiQv', 'sychan@icloud.com', 'oq8rPw5zhi', 13);
INSERT INTO `users` VALUES (46, 'Chiang Wing Fat', 'fXlLCKjbbl', 'chiangwf531@gmail.com', 'dcRPKUKepk', 69);
INSERT INTO `users` VALUES (47, 'Ogawa Seiko', '6J7srr49DG', 'so1998@outlook.com', 'R5JQB2TCRu', 52);
INSERT INTO `users` VALUES (48, 'Kong Jiehong', 'XkCK2YvbUS', 'jkong@hotmail.com', 'BsGd0ZfBxE', 105);
INSERT INTO `users` VALUES (49, 'Kojima Yuna', 'StLxENd913', 'yuna71@gmail.com', 'erNBhbYkZp', 93);
INSERT INTO `users` VALUES (50, 'Jiang Zhiyuan', 'xXrHD8bZzJ', 'zhiyuan1114@gmail.com', 'J0iizxm9LZ', 20);
INSERT INTO `users` VALUES (51, 'Imai Itsuki', 'gfg1lAZtGD', 'imitsu@yahoo.com', 'T8k0iRFc8v', 72);
INSERT INTO `users` VALUES (52, 'Kondo Shino', 'Xn1m7ygLUk', 'kondosh@outlook.com', 'tBdzYzCqny', 52);
INSERT INTO `users` VALUES (53, 'Hasegawa Ikki', 'hsTgvjE6O5', 'ikhas9@gmail.com', 'j7E6QWH8SU', 87);
INSERT INTO `users` VALUES (54, 'Lu Yuning', 'sRRXWly7ZG', 'yuninglu@outlook.com', '9CX7GUoMEt', 71);
INSERT INTO `users` VALUES (55, 'Ethel Aguilar', 'VmnhAvrCr6', 'aguiethel@gmail.com', 'jb2uFo5Bwi', 86);
INSERT INTO `users` VALUES (56, 'Ying Wai San', 'exs8Xna3FA', 'waisay18@gmail.com', 'zd998SPcb1', 108);
INSERT INTO `users` VALUES (57, 'Yan Ziyi', '3iaNHd7z8Z', 'yanziyi328@outlook.com', '2hLEzkTtZK', 117);
INSERT INTO `users` VALUES (58, 'Sugawara Nanami', '27B223VMMK', 'nanamisugawara@icloud.com', 'oY6JT5QsQS', 118);
INSERT INTO `users` VALUES (59, 'Helen Ellis', 'PaU93th5Dg', 'ehelen313@outlook.com', '4m7qzWdwmW', 90);
INSERT INTO `users` VALUES (60, 'Lai Sau Man', 'wjvW23QkZP', 'sml73@yahoo.com', 'Rj0Ek8M4jh', 92);
INSERT INTO `users` VALUES (61, 'Choi Tin Lok', 'Wsfu5qglJW', 'chotl@icloud.com', 'mE6ZFkIQLK', 41);
INSERT INTO `users` VALUES (62, 'Saito Hikaru', 'lvmlQjZvPZ', 'sahikaru1976@hotmail.com', 'uDwSI1i0uH', 71);
INSERT INTO `users` VALUES (63, 'Fang Yunxi', 'OyxnZwNVQt', 'yunxfang115@hotmail.com', 'QRJRH5inCm', 35);
INSERT INTO `users` VALUES (64, 'Shen Xiuying', 'nXoaTNxx0b', 'xiuyishen622@outlook.com', 'xAIbDwX3Kw', 114);
INSERT INTO `users` VALUES (65, 'Ye Anqi', 'cQNgQAuVHc', 'ye05@mail.com', 'AgJOnBKa0U', 73);
INSERT INTO `users` VALUES (66, 'Yuen Wai Lam', '1yTMQwrDGI', 'yuewa@outlook.com', 'AsFEZ5BGrY', 123);
INSERT INTO `users` VALUES (67, 'Abe Shino', 'JtrAdNn3Va', 'shinoabe@mail.com', 'BhxvPbdJHT', 23);
INSERT INTO `users` VALUES (68, 'Marvin Dunn', 'u9JwCv6rCz', 'dunmarvin818@gmail.com', 'n4fIDvj8d9', 19);
INSERT INTO `users` VALUES (69, 'Wu Chun Yu', 'T5N6RxWLF4', 'wu8@mail.com', 'FvDloBkaLG', 73);
INSERT INTO `users` VALUES (70, 'Wei Anqi', 'Q2fUH4QkRO', 'weanqi330@gmail.com', 'S3q90XKxvy', 36);
INSERT INTO `users` VALUES (71, 'Gerald Young', 'U64MF3y45U', 'young3@outlook.com', 'w64BwZrkZJ', 72);
INSERT INTO `users` VALUES (72, 'Sugawara Yuito', 'uVHe4giTUQ', 'ys4@icloud.com', '9nAsbAar5P', 83);
INSERT INTO `users` VALUES (73, 'Nakayama Sakura', '4yFspuzlFD', 'nakayama9@icloud.com', 'sKGQXcbx9h', 66);
INSERT INTO `users` VALUES (74, 'Glenn Marshall', 'Z8IuPiR9fH', 'glenn224@gmail.com', 'GnvBmR4u1A', 87);
INSERT INTO `users` VALUES (75, 'Lok Ka Ling', 'gvlgViVQnW', 'kaling423@yahoo.com', 'nDhC9imVuC', 94);
INSERT INTO `users` VALUES (76, 'Meng Ka Ming', 'K92ABPuJri', 'kamingmeng3@outlook.com', 'NpIpHoRH9G', 90);
INSERT INTO `users` VALUES (77, 'Connie Meyer', 'MqqihG6z3f', 'connimey@icloud.com', '7tmIsbcGlv', 21);
INSERT INTO `users` VALUES (78, 'Ren Rui', 'W5NmMo1WwD', 'rren@hotmail.com', 'rf5P8DWmAM', 4);
INSERT INTO `users` VALUES (79, 'Liao Chiu Wai', 'I1CvBLYn5s', 'chiuwai7@gmail.com', 'J637AptyQU', 30);
INSERT INTO `users` VALUES (80, 'Shao Jiehong', 'XceTuwor43', 'shao926@hotmail.com', 'd7TmbfPra0', 5);
INSERT INTO `users` VALUES (81, 'Tong Wai San', '1f7ItopqHo', 'waisan3@icloud.com', 'uEHMY84aso', 12);
INSERT INTO `users` VALUES (82, 'Takagi Yota', 'oUFX1Ix29e', 'takagi85@mail.com', 'a719bGY1YJ', 76);
INSERT INTO `users` VALUES (83, 'Lok Tin Wing', 'vP91PHapRH', 'tinwlo68@icloud.com', 'I2n0eXRnuD', 15);
INSERT INTO `users` VALUES (84, 'Endo Airi', 'h8jIp1Gisj', 'airi4@gmail.com', 'XseFqsyZqm', 80);
INSERT INTO `users` VALUES (85, 'Nancy Young', 'vPTwapGxpR', 'youngnanc5@yahoo.com', '7XC4vQgax0', 70);
INSERT INTO `users` VALUES (86, 'Siu Tsz Ching', '8SYmf9YbYD', 'sitc8@mail.com', 'xbUHupQec5', 37);
INSERT INTO `users` VALUES (87, 'Yuan Yunxi', 'gkGdqUpBN9', 'yuan91@mail.com', 'BxQZLcDMqp', 77);
INSERT INTO `users` VALUES (88, 'Meng Anqi', 'a3j5CT4vjf', 'anqimeng@gmail.com', 'OkN2xV6nm9', 3);
INSERT INTO `users` VALUES (89, 'Kikuchi Aoi', 'ahTSnu0Goj', 'kikuchi1217@gmail.com', 'KE79lBTA4t', 1);
INSERT INTO `users` VALUES (90, 'He Zitao', 'ENDu6yuvf7', 'zitaohe45@mail.com', 'hSkGaa7En3', 56);
INSERT INTO `users` VALUES (91, 'Loui Chiu Wai', 'Xk2nceqdG6', 'cwlou503@icloud.com', '23TPj1KIYO', 53);
INSERT INTO `users` VALUES (92, 'Charles Adams', 'Uj8LlAY96S', 'charles3@yahoo.com', 't8Vlat1SOj', 14);
INSERT INTO `users` VALUES (93, 'Larry Ryan', 'xh5XUpLGjS', 'lry@icloud.com', 'nIgKtsAHZb', 17);
INSERT INTO `users` VALUES (94, 'Kathleen Aguilar', 'dPmnrCHAI9', 'aguilar312@yahoo.com', 'V4mag8JHiD', 18);
INSERT INTO `users` VALUES (95, 'Kwong Chi Ming', 'aFN2JS616S', 'kwong831@outlook.com', 'tA7Iizhg14', 124);
INSERT INTO `users` VALUES (96, 'Wanda Marshall', 'cAEmQl7gHN', 'marshall10@icloud.com', 'rIer2K8Qnk', 93);
INSERT INTO `users` VALUES (97, 'Miyazaki Yamato', 'qicPQ47OoY', 'miyayamato@outlook.com', 'OCZsuXTmu7', 69);
INSERT INTO `users` VALUES (98, 'Xu Xiuying', 'I9XnW5OeTe', 'xuxiuying6@outlook.com', 'pMQobrD3eY', 103);
INSERT INTO `users` VALUES (99, 'Li Jiehong', 'gcfsskmz4x', 'jiehong1@hotmail.com', 'uo1sNCfpLo', 42);
INSERT INTO `users` VALUES (100, 'Kevin Turner', 'j9PbrweRDg', 'kevinturner9@hotmail.com', '6uoAJPXjTV', 95);
INSERT INTO `users` VALUES (101, 'Ray Adams', 'im4EW8g0bo', 'radams@gmail.com', 'sF8PGWNqJu', 72);
INSERT INTO `users` VALUES (102, 'Chan Tsz Ching', 'gHRT4eek1w', 'tszcch1@gmail.com', 'skfQsp1Myo', 82);
INSERT INTO `users` VALUES (103, 'Iwasaki Ryota', 'A8KSHjX27b', 'ryotai@gmail.com', 'uliadKcEkM', 86);
INSERT INTO `users` VALUES (104, 'Kyle Chavez', 'yyFb7ssJRX', 'chavez5@outlook.com', 'rNCFLCPl1j', 111);
INSERT INTO `users` VALUES (105, '123', '123', '123@qq.com', 'USER', 1);

SET FOREIGN_KEY_CHECKS = 1;
