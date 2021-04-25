/*
 数据库建表语句和简单的测试数据初始化

 Navicat MySQL Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 127.0.0.1
 Source Database       : db_springbootandcloud

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 04/25/2021 15:58:13 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hibernate_sequence`
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES ('26');
COMMIT;

-- ----------------------------
--  Table structure for `t_account`
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `balance` float NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_account`
-- ----------------------------
BEGIN;
INSERT INTO `t_account` VALUES ('1', '700', 'linzla'), ('2', '2200', 'linzlb');
COMMIT;

-- ----------------------------
--  Table structure for `t_book`
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL,
  `book_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_book`
-- ----------------------------
BEGIN;
INSERT INTO `t_book` VALUES ('1', 'java'), ('3', 'c++'), ('4', 'php'), ('22', '数据结构'), ('21', '算法小抄'), ('23', '设计模式'), ('24', 'MySql'), ('25', 'Redis');
COMMIT;

-- ----------------------------
--  Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_student`
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES ('6', '20', 'linzlb'), ('7', '22', 'linlin'), ('14', '28', 'xiecuiwen'), ('15', '8', 'xiecuiwen'), ('16', '8', 'xiecuiwen'), ('17', '8', 'xiecuiwen'), ('18', '8', 'xiecuiwen'), ('19', '8', 'xiecuiwen');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
