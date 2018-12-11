/*
 Navicat Premium Data Transfer

 Source Server         : my_test
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : task3

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/12/2018 21:59:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for artist
-- ----------------------------
DROP TABLE IF EXISTS `artist`;
CREATE TABLE `artist`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `create_at` bigint(255) NOT NULL,
  `update_at` bigint(255) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `career` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of artist
-- ----------------------------
INSERT INTO `artist` VALUES (1, 123456, 1231, '294157557@qq.com', '张大炮', '17664236789', '朝阳区238号', '牙医', 'https://blog.csdn.net/Tomwildboar/article/details/82560264?utm_source=blogxgwz2');
INSERT INTO `artist` VALUES (2, 1543308379068, NULL, '5728273@qq.com', '李健', NULL, '沈阳市张概念区', NULL, NULL);
INSERT INTO `artist` VALUES (3, 1543308493454, NULL, '5728273@qq.com', '李健', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (4, 1543308533747, NULL, '5728273@qq.com', '李健', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (5, 1543308602047, NULL, '5728273@qq.com', '李健', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (6, 1543308685630, NULL, '5728273@qq.com', '李健', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (7, 1543322142827, NULL, '5728273@qq.com', '李健', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (8, 1543322479723, NULL, '5728273@qq.com', '李健', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (9, 1543458436744, NULL, '5728273@qq.com', '李健2', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (10, 131232313, NULL, NULL, '李四', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (11, 131232313, NULL, NULL, '李四', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (12, 131232313, NULL, NULL, '李四', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (13, 131232313, NULL, NULL, '李四', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (14, 131312313, NULL, NULL, 'adhwadw', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (15, 1544500806351, NULL, '5728273@qq.com', '李健2', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (16, 1544530207646, NULL, '5728273@qq.com', '李健2', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (17, 1544532235305, NULL, '5728273@qq.com', '李健2', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (18, 1544532889420, NULL, '5728273@qq.com', '李健2', NULL, NULL, NULL, NULL);
INSERT INTO `artist` VALUES (19, 1544534395170, NULL, '5728273@qq.com', '李健2', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
