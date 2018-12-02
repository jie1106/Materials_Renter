/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : rm

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-12-02 10:58:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mr
-- ----------------------------
DROP TABLE IF EXISTS `mr`;
CREATE TABLE `mr` (
  `mrId` varchar(50) NOT NULL,
  `renterId` varchar(50) DEFAULT NULL,
  `listId` varchar(50) DEFAULT NULL,
  `renterDeposit` double(16,2) DEFAULT NULL,
  `renterBeginTime` date DEFAULT NULL,
  `renterEndTime` date DEFAULT NULL,
  PRIMARY KEY (`mrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mr
-- ----------------------------
INSERT INTO `mr` VALUES ('3294016a-106d-4911-af30-b4d867d79020', '006', '001', '200.00', '2015-01-01', '2015-02-02');
INSERT INTO `mr` VALUES ('3a0c5fe7-6c8a-4df8-8034-4dccc6591ec8', '245', '003', '200.00', '2015-01-02', '2015-02-02');
INSERT INTO `mr` VALUES ('7195a8eb-a3e4-4a37-9efd-5021f875edf5', '0124544', '001245', '200.00', '2015-01-02', '2015-02-02');
