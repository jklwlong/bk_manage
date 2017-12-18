/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : bootdo

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-12-18 15:09:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `permission_uuid` varchar(64) NOT NULL COMMENT '权限uuid',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `perms` varchar(500) DEFAULT NULL COMMENT '权限',
  `create_user_uuid` varchar(64) DEFAULT NULL COMMENT '创建用户uuid',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_user_uuid` varchar(64) DEFAULT NULL COMMENT '修改用户uuid',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(5) NOT NULL COMMENT '删除标记0：有效数据，1：无效数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '99822b1c5cc4469e93f94bab5eae5f95', '新增', 'add', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-08-14 10:51:35', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:17:01', '0');
INSERT INTO `permission` VALUES ('2', '458c002d60034bdcb5bb5f118414fecc', '编辑', 'edit', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-08-14 10:52:06', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:17:06', '0');
INSERT INTO `permission` VALUES ('3', 'dc667af9b31243ce82835d3ae865febc', '删除', 'remove', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-08-14 10:52:24', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:17:11', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_uuid` varchar(64) NOT NULL COMMENT '角色uuid',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(100) DEFAULT NULL COMMENT '角色编码',
  `create_user_uuid` varchar(64) DEFAULT NULL COMMENT '创建用户uuid',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_user_uuid` varchar(64) DEFAULT NULL COMMENT '修改用户uuid',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` varchar(5) DEFAULT NULL COMMENT '删除标记0：有效数据，1：无效数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '5b6b3a3cae674f9292b7bb3f0ae766e8', '超级管理员', 'SUPER', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:23:32', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:23:35', '0');
INSERT INTO `role` VALUES ('2', '5b6b3a3cae674f9292b7bb3fds65f4dsf', '普通管理员', 'NORMAL', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:23:32', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:23:35', '0');

-- ----------------------------
-- Table structure for role_permission_rel
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_rel`;
CREATE TABLE `role_permission_rel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_permission_rel_uuid` varchar(64) NOT NULL COMMENT '角色权限关系uuid',
  `role_uuid` varchar(64) DEFAULT NULL COMMENT '角色uuid',
  `permission_uuid` varchar(64) DEFAULT NULL COMMENT '权限uuid',
  `create_user_uuid` varchar(64) DEFAULT NULL COMMENT '创建用户uuid',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_user_uuid` varchar(64) DEFAULT NULL COMMENT '修改用户uuid',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1460 DEFAULT CHARSET=utf8 COMMENT='角色权限关系';

-- ----------------------------
-- Records of role_permission_rel
-- ----------------------------
INSERT INTO `role_permission_rel` VALUES ('1', 'c0204d0255d54668b1805c24335b9c93', '5b6b3a3cae674f9292b7bb3f0ae766e8', '99822b1c5cc4469e93f94bab5eae5f95', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:30', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:33', '0');
INSERT INTO `role_permission_rel` VALUES ('2', 'bba911ccbdf54134bfc6fca1baf5cc6f', '5b6b3a3cae674f9292b7bb3f0ae766e8', '458c002d60034bdcb5bb5f118414fecc', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:30', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:33', '0');
INSERT INTO `role_permission_rel` VALUES ('3', '5e494f454b6d40d9966c386e706dbc5e', '5b6b3a3cae674f9292b7bb3f0ae766e8', 'dc667af9b31243ce82835d3ae865febc', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:30', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:33', '0');
INSERT INTO `role_permission_rel` VALUES ('4', '5e494ffsdl6d40d9966c386e706ffss4', '5b6b3a3cae674f9292b7bb3fds65f4dsf', '458c002d60034bdcb5bb5f118414fecc', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:30', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:33', '0');
INSERT INTO `role_permission_rel` VALUES ('5', '5e494ffsdl6d40d9966c386e706ssddp', '5b6b3a3cae674f9292b7bb3fds65f4dsf', '99822b1c5cc4469e93f94bab5eae5f95', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:30', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-07 11:22:33', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_uuid` varchar(64) NOT NULL COMMENT '用户uuid',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `create_user_uuid` varchar(64) DEFAULT NULL COMMENT '创建用户uuid',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_user_uuid` varchar(64) DEFAULT NULL COMMENT '修改用户uuid',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(5) NOT NULL COMMENT '删除标记0：有效数据，1：无效数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'bb5e0928a9f142a2b5790c10c82ed23f', 'admin', '733d7be2196ff70efaf6913fc8bdcabf', null, 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-06 17:47:22', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-06 17:47:27', '0');
INSERT INTO `user` VALUES ('2', 'bb5e0928a9f142a2b5790c109f87s8df', 'sbli', '733d7be2196ff70efaf6913fc8bdcabf', '', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-06 17:47:22', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-06 17:47:27', '0');

-- ----------------------------
-- Table structure for user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `user_role_rel`;
CREATE TABLE `user_role_rel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_role_rel_uuid` varchar(64) NOT NULL COMMENT '用户角色关系uuid',
  `user_uuid` varchar(64) DEFAULT NULL COMMENT '用户uuid',
  `role_uuid` varchar(64) DEFAULT NULL COMMENT '角色uuid',
  `create_user_uuid` varchar(64) DEFAULT NULL COMMENT '创建用户uuid',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_user_uuid` varchar(64) DEFAULT NULL COMMENT '修改用户uuid',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(5) NOT NULL COMMENT '删除标记0：有效数据，1：无效数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of user_role_rel
-- ----------------------------
INSERT INTO `user_role_rel` VALUES ('1', 'f8cf78a2ab2046d6af7daf0ef6246b4f', 'bb5e0928a9f142a2b5790c10c82ed23f', '5b6b3a3cae674f9292b7bb3f0ae766e8', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-12 15:16:36', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-12 15:16:29', '0');
INSERT INTO `user_role_rel` VALUES ('2', 'f8cf78a2ab2046d6af7daf0ef6adffs4s', 'bb5e0928a9f142a2b5790c109f87s8df', '5b6b3a3cae674f9292b7bb3fds65f4dsf', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-12 15:16:36', 'bb5e0928a9f142a2b5790c10c82ed23f', '2017-12-12 15:16:29', '0');
