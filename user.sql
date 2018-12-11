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

 Date: 11/12/2018 21:59:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_at` bigint(255) NOT NULL,
  `update_at` bigint(255) NULL DEFAULT NULL,
  `editor_id` bigint(255) NOT NULL,
  `privileges` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '盐22注解', 'syan1234', 'dadwad', 1543323049837, 1543840287645, 1, '2');
INSERT INTO `user` VALUES (2, '南宫红鸡', 'syan1234', 'wdad', 1543323191414, 1543503104572, 2, '23');
INSERT INTO `user` VALUES (3, 'zhang', '1313', '213', 1543497947262, 1543497947262, 1, '13');
INSERT INTO `user` VALUES (4, '12', '12', '12', 1543498241765, 1543498241765, 12, '12');
INSERT INTO `user` VALUES (5, '13', '12', '12', 1543498396781, 1543498396781, 12, '12');
INSERT INTO `user` VALUES (6, '12', '23', '23', 1543498958074, 1543498958074, 23, '23');
INSERT INTO `user` VALUES (7, '131', '123', '13', 1543500427369, 1543500427369, 2, '24');
INSERT INTO `user` VALUES (8, '45', '45', '45', 1543500433638, 1543500433638, 45, '45');
INSERT INTO `user` VALUES (9, '56', '56', '56', 1543500439064, 1543500439064, 56, '56');
INSERT INTO `user` VALUES (10, '5667', '6767', '87', 1543500448991, 1543500448991, 87, '87');
INSERT INTO `user` VALUES (11, '878', '89', '98', 1543500455139, 1543500455139, 98, '98');
INSERT INTO `user` VALUES (12, '盐23注解', 'syan1234', NULL, 1543927171347, NULL, 2, NULL);
INSERT INTO `user` VALUES (13, '12', '12123', NULL, 1543928631235, 1543928631235, 1, NULL);
INSERT INTO `user` VALUES (14, '14', 'syn12345', NULL, 1543928734039, 1543928734039, 2, NULL);
INSERT INTO `user` VALUES (15, '14', 'syn12345', NULL, 1543930408046, 1543930408046, 2, NULL);
INSERT INTO `user` VALUES (16, '张三', 'zhangsan123', '', 1543931168033, 1544018712655, 2, '');
INSERT INTO `user` VALUES (17, '盐23注解', 'syan1234', NULL, 1544500808186, NULL, 2, NULL);
INSERT INTO `user` VALUES (18, '盐23注解', 'syan1234', NULL, 1544530209779, NULL, 2, NULL);
INSERT INTO `user` VALUES (19, '盐23注解', 'syan1234', NULL, 1544532237218, NULL, 2, NULL);
INSERT INTO `user` VALUES (20, '盐23注解', 'syan1234', NULL, 1544532891816, NULL, 2, NULL);
INSERT INTO `user` VALUES (21, '盐23注解', 'syan1234', NULL, 1544534396975, NULL, 2, NULL);

SET FOREIGN_KEY_CHECKS = 1;
