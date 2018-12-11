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

 Date: 11/12/2018 21:59:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `create_at` bigint(255) NOT NULL,
  `update_at` bigint(255) NULL DEFAULT NULL,
  `artist_id` bigint(255) NOT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(4) NOT NULL,
  `editor_id` bigint(255) NOT NULL,
  `thumbnail_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `banner` int(4) NULL DEFAULT NULL,
  `collection_id` bigint(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `work_collection`(`collection_id`) USING BTREE,
  INDEX `work_artist`(`artist_id`) USING BTREE,
  CONSTRAINT `work_artist` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `work_collection` FOREIGN KEY (`collection_id`) REFERENCES `collec` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES (1, 123456, 1313, 1, '随手画的一幅画', 1, 1, 'http://www.jnshu.com/task/5/6/daily?page=2', 'http://www.jnshu.com/task/5/6/daily?page=2', 'http://www.jnshu.com/task/5/6/daily?page=2', '真好看', 1, 1);
INSERT INTO `work` VALUES (2, 1543412026067, NULL, 2, NULL, 0, 1, NULL, NULL, NULL, '我曹真牛逼', 0, 1);
INSERT INTO `work` VALUES (3, 1544500808276, NULL, 2, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `work` VALUES (4, 1544530209871, NULL, 2, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `work` VALUES (5, 1544532237309, NULL, 2, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `work` VALUES (6, 1544532891942, NULL, 2, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `work` VALUES (7, 1544534397047, NULL, 2, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
