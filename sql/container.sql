/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : rm

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-12-02 10:58:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for container
-- ----------------------------
DROP TABLE IF EXISTS `container`;
CREATE TABLE `container` (
  `listId` varchar(50) NOT NULL,
  `maker` varchar(50) DEFAULT NULL,
  `buyTime` date DEFAULT NULL,
  `buyPrice` double DEFAULT NULL,
  `length` double(16,2) DEFAULT NULL,
  `width` double(16,2) DEFAULT NULL,
  `height` double(16,2) DEFAULT NULL,
  `mstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`listId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of container
-- ----------------------------
INSERT INTO `container` VALUES ('001', '安琥', '2015-01-01', '200', '300.00', '300.00', '400.00', '1');
INSERT INTO `container` VALUES ('001245', '清华', '2015-01-01', '200', '200.00', '200.00', '400.00', '1');
INSERT INTO `container` VALUES ('003', '对方', '2015-01-01', '200', '300.00', '300.00', '200.00', '0');
INSERT INTO `container` VALUES ('4451554', '垃圾', '2017-01-02', '5545', '515.00', '10.00', '104.00', '0');
INSERT INTO `container` VALUES ('9527', '实施无油腻', '2015-01-01', '564', '21.00', '1545.00', '2121.00', '0');
