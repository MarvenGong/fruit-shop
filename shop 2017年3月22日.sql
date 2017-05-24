/*
Navicat MySQL Data Transfer

Source Server         : LocalHost
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2017-03-18 20:05:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'user', 'user', '1');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `hot` tinyint(1) DEFAULT '0',
  `aid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK302BCFE5B84BD34` (`aid`),
  CONSTRAINT `FK302BCFE5B84BD34` FOREIGN KEY (`aid`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '热门单品', '1', '1');
INSERT INTO `category` VALUES ('2', '女装', '1', null);
INSERT INTO `category` VALUES ('3', '衬衣', '1', null);

-- ----------------------------
-- Table structure for forder
-- ----------------------------
DROP TABLE IF EXISTS `forder`;
CREATE TABLE `forder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(2) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `remak` varchar(30) DEFAULT NULL,
  `price` float(6,2) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `post` varchar(6) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `user` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forder
-- ----------------------------
INSERT INTO `forder` VALUES ('1', '1', 'user', '1234567890', '输入留言信息', '79.00', null, '', 'test', '');
INSERT INTO `forder` VALUES ('4', '1', 'user', '15555555555', '尽快发乎', '76.00', null, '266666', 'test', 'buyer');
INSERT INTO `forder` VALUES ('5', '1', 'user', '', '输入留言信息', '79.00', null, '', 'test', 'buyer');
INSERT INTO `forder` VALUES ('6', '1', 'user', 'ss', '输入留言信息', '99.00', null, '222222', 'test', 'buyer');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pic` varchar(200) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `xremark` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `commend` bit(1) DEFAULT NULL,
  `open` bit(1) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED8DCCEF974BBD51` (`cid`),
  CONSTRAINT `FKED8DCCEF974BBD51` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '夏季新品长裙', '76', 'pr_l_1.jpg', '印花 纯棉', '1', '2017-02-18 08:07:51', '', '', '1');
INSERT INTO `product` VALUES ('2', '夏季新品长裙', '99', 'pr_l_2.jpg', '印花 纯棉', '1', '2017-02-18 08:07:51', '', '', '1');
INSERT INTO `product` VALUES ('3', '夏季新品长裙', '79', 'pr_l_3.jpg', '印花 纯棉', '1', '2017-02-18 08:07:51', '', '', '1');

-- ----------------------------
-- Table structure for sorder
-- ----------------------------
DROP TABLE IF EXISTS `sorder`;
CREATE TABLE `sorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `price` float(6,2) NOT NULL,
  `number` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `index` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCA8ED6BB8F3F3845` (`pid`),
  CONSTRAINT `FKCA8ED6BB8F3F3845` FOREIGN KEY (`pid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sorder
-- ----------------------------
INSERT INTO `sorder` VALUES ('1', '1', '夏季新品长裙', '79.00', '1', '3', null);
INSERT INTO `sorder` VALUES ('2', '2', '夏季新品长裙', '79.00', '1', '3', null);
INSERT INTO `sorder` VALUES ('3', '2', '夏季新品长裙', '99.00', '1', '2', null);
INSERT INTO `sorder` VALUES ('4', '2', '夏季新品长裙', '99.00', '1', '2', null);
INSERT INTO `sorder` VALUES ('5', '2', '夏季新品长裙', '99.00', '1', '2', null);
INSERT INTO `sorder` VALUES ('6', '2', '夏季新品长裙', '79.00', '1', '3', null);
INSERT INTO `sorder` VALUES ('7', '2', '夏季新品长裙', '99.00', '1', '2', null);
INSERT INTO `sorder` VALUES ('8', '2', '夏季新品长裙', '99.00', '1', '2', null);
INSERT INTO `sorder` VALUES ('9', '3', '夏季新品长裙', '76.00', '1', '1', null);
INSERT INTO `sorder` VALUES ('10', '3', '夏季新品长裙', '99.00', '1', '2', null);
INSERT INTO `sorder` VALUES ('11', '2', '夏季新品长裙', '76.00', '1', '1', null);
INSERT INTO `sorder` VALUES ('12', '3', '夏季新品长裙', '79.00', '1', '3', null);
INSERT INTO `sorder` VALUES ('13', '4', '夏季新品长裙', '99.00', '1', '2', null);
INSERT INTO `sorder` VALUES ('14', '4', '夏季新品长裙', '99.00', '1', '2', null);

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Ioc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'admin', '1', '11', '1', '1');
INSERT INTO `user` VALUES ('2', 'user', 'user', 'user', '2', '22', '2', '2');
INSERT INTO `user` VALUES ('3', 'buyer', 'buyer', 'buyer', '2', '22', '2', '2');
