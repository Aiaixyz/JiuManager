/*
 Navicat Premium Data Transfer

 Source Server         : MyMariaDB
 Source Server Type    : MariaDB
 Source Server Version : 100427 (10.4.27-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : qf22208a_230310

 Target Server Type    : MariaDB
 Target Server Version : 100427 (10.4.27-MariaDB)
 File Encoding         : 65001

 Date: 15/03/2023 21:46:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for d_depet
-- ----------------------------
DROP TABLE IF EXISTS `d_depet`;
CREATE TABLE `d_depet`  (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `is_delete` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`d_id`) USING BTREE,
  INDEX `d_name`(`d_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of d_depet
-- ----------------------------
INSERT INTO `d_depet` VALUES (1, '广州白云仓', '广东省广州市白云区永泰学山酒管家1号仓', 1);
INSERT INTO `d_depet` VALUES (2, '深圳宝安仓', '广东省深圳市宝安区翻身路酒管家2号仓', 1);

-- ----------------------------
-- Table structure for r_report
-- ----------------------------
DROP TABLE IF EXISTS `r_report`;
CREATE TABLE `r_report`  (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP,
  `r_operation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `r_note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_id` int(11) NOT NULL,
  `s_sku` int(255) NOT NULL,
  `is_delete` int(1) NULL DEFAULT 1,
  PRIMARY KEY (`r_id`) USING BTREE,
  INDEX `操作人`(`u_id`) USING BTREE,
  INDEX `商品SKU`(`s_sku`) USING BTREE,
  CONSTRAINT `商品SKU` FOREIGN KEY (`s_sku`) REFERENCES `s_sku` (`s_sku`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `操作人` FOREIGN KEY (`u_id`) REFERENCES `u_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of r_report
-- ----------------------------
INSERT INTO `r_report` VALUES (1, '2023-03-11 10:14:10', 'out', NULL, 1, 1, 1);
INSERT INTO `r_report` VALUES (2, '2023-03-11 10:32:54', 'in', NULL, 1, 1, 1);
INSERT INTO `r_report` VALUES (3, '2023-03-15 14:26:46', 'in', 'test', 1, 2, 0);
INSERT INTO `r_report` VALUES (4, '2023-03-15 14:31:45', 'out', 'ttes', 2, 1, 1);

-- ----------------------------
-- Table structure for s_sku
-- ----------------------------
DROP TABLE IF EXISTS `s_sku`;
CREATE TABLE `s_sku`  (
  `s_sku` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_quantity` int(255) NULL DEFAULT 0,
  `d_id` int(255) NULL DEFAULT NULL,
  `v_id` int(255) NULL DEFAULT NULL,
  `is_delete` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`s_sku`) USING BTREE,
  INDEX `仓库编号外键`(`d_id`) USING BTREE,
  INDEX `s_sku`(`s_sku`) USING BTREE,
  CONSTRAINT `仓库编号外键` FOREIGN KEY (`d_id`) REFERENCES `d_depet` (`d_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_sku
-- ----------------------------
INSERT INTO `s_sku` VALUES (1, '威士忌', 120, 1, 1, 0);
INSERT INTO `s_sku` VALUES (2, '威士忌', 2, 1, 1, 1);
INSERT INTO `s_sku` VALUES (3, '伏特加', 10, 1, 1, 0);
INSERT INTO `s_sku` VALUES (4, '伏特加', 10, 1, 1, 1);

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user`  (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_username` varchar(64) CHARACTER SET ujis COLLATE ujis_japanese_ci NOT NULL COMMENT 'UNIQUE',
  `u_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_realname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_permit` int(11) NOT NULL DEFAULT 1 COMMENT 'nub 0 = admin;\r\nnub 1 = user;',
  `is_delete` int(11) NOT NULL DEFAULT 1 COMMENT '1 = alive;\r\n0 = delete;',
  PRIMARY KEY (`u_id`) USING BTREE,
  UNIQUE INDEX `用户名唯一`(`u_username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES (1, 'admin', 'admin', 'Admin', 0, 1);
INSERT INTO `u_user` VALUES (2, 'user', 'user', 'User', 1, 1);
INSERT INTO `u_user` VALUES (3, 'zs', '123', '张三', 1, 1);
INSERT INTO `u_user` VALUES (5, 'ww', 'ww123456', '王五', 1, 1);
INSERT INTO `u_user` VALUES (6, 'ls', '123456', '李四', 1, 1);

-- ----------------------------
-- Table structure for v_vendors
-- ----------------------------
DROP TABLE IF EXISTS `v_vendors`;
CREATE TABLE `v_vendors`  (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `v_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `v_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` int(1) NULL DEFAULT 1,
  PRIMARY KEY (`v_id`) USING BTREE,
  CONSTRAINT `商品供应商` FOREIGN KEY (`v_id`) REFERENCES `s_sku` (`s_sku`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of v_vendors
-- ----------------------------
INSERT INTO `v_vendors` VALUES (1, '广州白云山酒业无限公司', '1888888888', '广东省广州市白云山上天上人间1号', 1);
INSERT INTO `v_vendors` VALUES (3, '广州白云山酒业', '1242323432', '广州市白云区白云山酒业', 0);
INSERT INTO `v_vendors` VALUES (4, '广州白云山酒业', '1232', '广州市白云区白云山酒业', 1);

SET FOREIGN_KEY_CHECKS = 1;
