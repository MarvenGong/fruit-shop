/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-05-25 23:12:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
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
-- Table structure for `category`
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '热卖1', '1', '1');
INSERT INTO `category` VALUES ('4', '进口水果', '1', '1');
INSERT INTO `category` VALUES ('5', '瓜类', '1', '1');
INSERT INTO `category` VALUES ('6', '夏季水果', '1', '1');

-- ----------------------------
-- Table structure for `forder`
-- ----------------------------
DROP TABLE IF EXISTS `forder`;
CREATE TABLE `forder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(2) DEFAULT '1',
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `remak` varchar(30) DEFAULT NULL,
  `price` float(6,2) DEFAULT NULL,
  `createdate` varchar(50) DEFAULT '',
  `post` varchar(6) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `user` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forder
-- ----------------------------
INSERT INTO `forder` VALUES ('18', '1', '龚明华', '15696544221', '输入留言信息', '32.00', '1495687565227', '400251', '重庆市渝中区大坪街道', 'xiaoming');
INSERT INTO `forder` VALUES ('19', '1', '何玲', '15696544221', '输入留言信息', '8.60', '1495687718998', '400251', '重庆市渝中区大坪街道', 'xiaoming');
INSERT INTO `forder` VALUES ('20', '1', '龚明华', '15696544221', '输入留言信息', '35.60', '1495713942616', '400251', '重庆市渝中区大坪街道', 'xiaoming');
INSERT INTO `forder` VALUES ('21', '1', '龚明华', '15696544221', '输入留言信息', '8.60', '1495713962746', '400251', '重庆市渝中区大坪街道', 'xiaoming');
INSERT INTO `forder` VALUES ('22', '1', '龚明华', '15696544221', '输入留言信息', '12.00', '1495713974728', '400251', '重庆市渝中区大坪街道', 'xiaoming');
INSERT INTO `forder` VALUES ('23', '1', '龚明华', '15696544221', '输入留言信息', '32.00', '1495713994049', '400251', '重庆市渝中区大坪街道', 'xiaoming');

-- ----------------------------
-- Table structure for `product`
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('7', '木瓜', '9.9', '7149e394-507b-4879-a975-5c6d5da62b0a.jpg', '有益身体健康', '好吃！！！', '2017-05-25 14:50:00', '', '', '5');
INSERT INTO `product` VALUES ('8', '草莓', '20', '650280bf-b008-4716-b783-250ffccca2b9.jpg', '美颜', '好吃', '2017-05-25 14:50:04', '', '', '1');
INSERT INTO `product` VALUES ('9', '菠萝', '12', '7c59ac25-690d-45a9-bd82-6a8279743f9c.jpg', '季节宠儿', '酸甜好吃。', '2017-05-25 14:50:07', '', '', '1');
INSERT INTO `product` VALUES ('10', '龙眼', '66', '327684aa-b6ba-4b6d-b2c1-92a076a87401.jpg', '进口的哦', '有益于身体健康', '2017-05-25 14:50:11', '', '', '4');
INSERT INTO `product` VALUES ('11', '山竹', '69', '985cdc82-7ec1-4828-a7d0-30ef9bafc7bf.jpg', '好吃', '清脆可口', '2017-05-25 14:50:14', '', '', '4');
INSERT INTO `product` VALUES ('12', '橙子', '8.6', 'cd6567c1-eaeb-426f-b779-2877b558a6b2.jpg', '补充维C', '酸甜，季节水果', '2017-05-25 14:50:17', '', '', '1');
INSERT INTO `product` VALUES ('13', '柠檬', '15', 'fe21b897-3286-483d-a72f-0cca04653025.jpg', '补充维C', '女孩子的最爱', '2017-05-25 14:50:20', '', '', '1');
INSERT INTO `product` VALUES ('14', '香梨', '12', 'bf2cd7fa-4153-4099-bb28-867cdd963a00.jpg', '清脆', '解渴', '2017-05-25 14:50:23', '', '', '6');
INSERT INTO `product` VALUES ('17', 'test', '23', 'f9fbdaa9-3329-4392-840b-13dcab7e39b6.jpg', 'eweqwe wqeqw ', 'ewqeqw ewq dsada ', null, '', '', '5');

-- ----------------------------
-- Table structure for `sorder`
-- ----------------------------
DROP TABLE IF EXISTS `sorder`;
CREATE TABLE `sorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `price` float(6,2) DEFAULT NULL,
  `number` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCA8ED6BB8F3F3845` (`pid`),
  CONSTRAINT `FKCA8ED6BB8F3F3845` FOREIGN KEY (`pid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sorder
-- ----------------------------
INSERT INTO `sorder` VALUES ('60', '5', '菠萝', '12.00', '1', '9', '4');

-- ----------------------------
-- Table structure for `status`
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
-- Table structure for `user`
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'admin', '1', '11', '1', '1');
INSERT INTO `user` VALUES ('2', 'user', 'user', 'user', '2', '22', '2', '2');
INSERT INTO `user` VALUES ('3', 'buyer', 'buyer', 'buyer', '2', '22', '2', '2');
INSERT INTO `user` VALUES ('4', 'marven', 'xiaoming', '123456', '2', '15696544221, ', '1637077309@qq.com', '2');
