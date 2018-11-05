/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50713
Source Host           : 127.0.0.1:3306
Source Database       : springcloud_mybatis

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-11-05 16:29:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jpa_user
-- ----------------------------
DROP TABLE IF EXISTS `jpa_user`;
CREATE TABLE `jpa_user` (
  `user_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jpa_user2
-- ----------------------------
DROP TABLE IF EXISTS `jpa_user2`;
CREATE TABLE `jpa_user2` (
  `user_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `Area_Id` int(8) NOT NULL AUTO_INCREMENT COMMENT '地区ID',
  `Area_Name` varchar(120) NOT NULL COMMENT '地区名称',
  `Parent_Id` int(8) DEFAULT NULL COMMENT '父级地区ID',
  `Area_Status` int(1) NOT NULL COMMENT '地区状态 0 有效  1 无效',
  `Modifier` varchar(80) DEFAULT NULL COMMENT '修改者',
  `Update_Time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`Area_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=990101 DEFAULT CHARSET=utf8 COMMENT='地区信息表';

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_source` varchar(255) DEFAULT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  `dept_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_notes
-- ----------------------------
DROP TABLE IF EXISTS `sys_notes`;
CREATE TABLE `sys_notes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titile` varchar(500) NOT NULL,
  `url` varchar(1000) NOT NULL,
  `content` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=271 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `User_Id` int(9) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `Company_Id` int(8) DEFAULT NULL COMMENT '所属公司',
  `User_Name` varchar(80) NOT NULL COMMENT '用户姓名',
  `Login_Name` varchar(80) NOT NULL COMMENT '登录帐号',
  `Login_Password` varchar(80) DEFAULT NULL COMMENT '登录密码',
  `Mobile` varchar(15) DEFAULT NULL COMMENT '联系手机',
  `Email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `Home_Address` varchar(500) DEFAULT NULL COMMENT '联系地址',
  `PostCode` varchar(6) DEFAULT NULL COMMENT '邮政编码',
  `Sex` char(10) DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `Create_Time` datetime DEFAULT NULL COMMENT '创建时间',
  `Last_IP` varchar(60) DEFAULT NULL COMMENT '最后登录IP',
  `Last_Time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `Photo_URL` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `Status` int(1) DEFAULT '0' COMMENT '用户状态 0有效 1无效',
  `warning_state` varchar(1) DEFAULT NULL COMMENT '预警接收状态（0：不接收，1接收）',
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
