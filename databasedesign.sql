/*
 Navicat Premium Data Transfer

 Source Server         : software
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : databasedesign

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 28/11/2018 17:38:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authorinfo
-- ----------------------------
DROP TABLE IF EXISTS `authorinfo`;
CREATE TABLE `authorinfo`  (
  `AUTHOR` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ABIRTH` date NOT NULL,
  PRIMARY KEY (`AUTHOR`) USING BTREE,
  CONSTRAINT `authorinfo_ibfk_1` FOREIGN KEY (`AUTHOR`) REFERENCES `basebookinfo` (`AUTHOR`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basebookinfo
-- ----------------------------
DROP TABLE IF EXISTS `basebookinfo`;
CREATE TABLE `basebookinfo`  (
  `BID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `AUTHOR` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PUBLICATION` date NOT NULL,
  `PRICE` double(10, 0) DEFAULT NULL,
  `PUBLISHINGCOMPANY` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`BID`) USING BTREE,
  INDEX `AUTHOR`(`AUTHOR`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basebookinfo
-- ----------------------------
INSERT INTO `basebookinfo` VALUES ('1000', '春天', 'gk', '2018-11-05', 11, 'sdust');
INSERT INTO `basebookinfo` VALUES ('1001', '春天的秘密', 'gk', '2018-11-04', 11, 'sdtst');

-- ----------------------------
-- Table structure for borrower
-- ----------------------------
DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower`  (
  `BSID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BDATE` datetime(0) DEFAULT NULL,
  `BORROWCARD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `STATUS` int(2) DEFAULT 1,
  PRIMARY KEY (`BSID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for borrowingsituation
-- ----------------------------
DROP TABLE IF EXISTS `borrowingsituation`;
CREATE TABLE `borrowingsituation`  (
  `BID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SITUATION` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BSID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`BID`) USING BTREE,
  INDEX `fk_BORERID_BSSID`(`BSID`) USING BTREE,
  CONSTRAINT `borrowingsituation_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `basebookinfo` (`BID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `borrowingsituation_ibfk_2` FOREIGN KEY (`BSID`) REFERENCES `borrower` (`BSID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `BID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INVENTORY` int(11) NOT NULL,
  `PURCHASE` int(10) DEFAULT NULL,
  `DAMAGED` int(10) DEFAULT NULL,
  PRIMARY KEY (`BID`) USING BTREE,
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `basebookinfo` (`BID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'a', 'a', 'm', '789456@qq.com');
INSERT INTO `user` VALUES (2, 'b', 'c', 'f', '655487@qq.com');
INSERT INTO `user` VALUES (3, 'zhangsan', '123456', 'm', '111111@qq.com');
INSERT INTO `user` VALUES (4, 'lisi', '654321', 'f', '123456@qq.com');
INSERT INTO `user` VALUES (5, 'asd', '123456', 'm', '11111111@qq.com');
INSERT INTO `user` VALUES (6, 'gk', '123456', 'm', '666666666@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
