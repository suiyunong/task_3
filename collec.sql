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

 Date: 11/12/2018 21:59:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collec
-- ----------------------------
DROP TABLE IF EXISTS `collec`;
CREATE TABLE `collec`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_at` bigint(255) NOT NULL,
  `update_at` bigint(255) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(4) NOT NULL,
  `editor_id` bigint(255) NOT NULL,
  `artist_id` bigint(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `collection_artist`(`artist_id`) USING BTREE,
  CONSTRAINT `collection_artist` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collec
-- ----------------------------
INSERT INTO `collec` VALUES (1, '风景', 132131, NULL, '遇见草原', 1, 1, 1);
INSERT INTO `collec` VALUES (2, '人物', 1543410382917, NULL, '咱当兵的人', 0, 1, 1);
INSERT INTO `collec` VALUES (3, '人物', 1544500806641, NULL, '我的第一幅作品', 0, 1, 1);
INSERT INTO `collec` VALUES (4, '人物', 1544530207929, NULL, '我的第一幅作品', 0, 1, 1);
INSERT INTO `collec` VALUES (5, '人物', 1544532235526, NULL, '我的第一幅作品', 0, 1, 1);
INSERT INTO `collec` VALUES (6, '人物', 1544532889727, NULL, '我的第一幅作品', 0, 1, 1);
INSERT INTO `collec` VALUES (7, '人物', 1544534395441, NULL, '我的第一幅作品', 0, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
