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

 Date: 11/12/2018 21:59:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `create_at` bigint(255) NOT NULL,
  `update_at` bigint(255) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` int(4) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `editor_id` bigint(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES (1, 1543414653268, NULL, '一级标题2', 1, 'http://www.jnshu.com/school/28087/daily', 1);
INSERT INTO `title` VALUES (2, 131312313, 1313131, '二级标题', 2, 'https://blog.csdn.net/shouldnotappearcalm/article/details/54381408', 2);
INSERT INTO `title` VALUES (3, 1544500806731, NULL, '一级标题2', 1, 'http://www.jnshu.com/school/28087/daily', 1);
INSERT INTO `title` VALUES (4, 1544530208172, NULL, '一级标题2', 1, 'http://www.jnshu.com/school/28087/daily', 1);
INSERT INTO `title` VALUES (5, 1544532235741, NULL, '一级标题2', 1, 'http://www.jnshu.com/school/28087/daily', 1);
INSERT INTO `title` VALUES (6, 1544532890003, NULL, '一级标题2', 1, 'http://www.jnshu.com/school/28087/daily', 1);
INSERT INTO `title` VALUES (7, 1544534395608, NULL, '一级标题2', 1, 'http://www.jnshu.com/school/28087/daily', 1);

SET FOREIGN_KEY_CHECKS = 1;
