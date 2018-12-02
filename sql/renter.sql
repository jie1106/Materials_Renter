/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : rm

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-12-02 10:58:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for renter
-- ----------------------------
DROP TABLE IF EXISTS `renter`;
CREATE TABLE `renter` (
  `renterId` varchar(50) NOT NULL,
  `renterName` varchar(50) DEFAULT NULL,
  `renterCompany` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`renterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of renter
-- ----------------------------
INSERT INTO `renter` VALUES ('0005', 'zs', 'dfgdfg');
INSERT INTO `renter` VALUES ('003', '小李', '京东');
INSERT INTO `renter` VALUES ('006', 'zs', '清华');
INSERT INTO `renter` VALUES ('007', '张三', '清华');
INSERT INTO `renter` VALUES ('008', 'yaojie', '清华');
INSERT INTO `renter` VALUES ('0124544', 'yaojie', '清华');
INSERT INTO `renter` VALUES ('1461', 'yaojie', '清华');
INSERT INTO `renter` VALUES ('245', 'yaojie', '清华');
INSERT INTO `renter` VALUES ('9527', 'yaojie', '清华');
