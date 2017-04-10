/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : localtest

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2016-03-17 22:20:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permissionid` varchar(255) NOT NULL DEFAULT '',
  `permissionname` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permissionid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO permission VALUES ('P1', 'p1:*', 'P1');
INSERT INTO permission VALUES ('p2', 'user:*', 'p2');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` varchar(255) NOT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('r1', 'r1', 'r1');
INSERT INTO role VALUES ('r2', 'r2', 'r2');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `roleid` varchar(255) NOT NULL DEFAULT '',
  `permissionid` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`roleid`,`permissionid`),
  KEY `FK_PERMISSION` (`permissionid`),
  CONSTRAINT `FK_PERMISSION` FOREIGN KEY (`permissionid`) REFERENCES `permission` (`permissionid`),
  CONSTRAINT `FK_ROLEID1` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO role_permission VALUES ('r1', 'P1');
INSERT INTO role_permission VALUES ('r1', 'p2');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userid` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES ('xiaoming', 'xiaoming', '123');
INSERT INTO t_user VALUES ('zhangsan', 'zhangsan', '123');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userid` varchar(255) NOT NULL DEFAULT '',
  `roleid` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`userid`,`roleid`),
  KEY `FK_ROLEID` (`roleid`),
  CONSTRAINT `FK_ROLEID` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`),
  CONSTRAINT `FK_USERID` FOREIGN KEY (`userid`) REFERENCES `t_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO user_role VALUES ('xiaoming', 'r1');
INSERT INTO user_role VALUES ('zhangsan', 'r2');
