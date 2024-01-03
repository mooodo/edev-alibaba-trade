SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `authenticated` char(1) DEFAULT 'T',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES ('50001', 'registerUser', 'T');
INSERT INTO `t_authority` VALUES ('50002', 'modifyUser', 'T');
INSERT INTO `t_authority` VALUES ('50003', 'removeUser', 'T');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('20001', 'admin', null);

-- ----------------------------
-- Table structure for t_role_granted_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_role_granted_authority`;
CREATE TABLE `t_role_granted_authority` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `available` char(1) DEFAULT 'T',
  `role_id` int(20) NOT NULL,
  `authority_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_granted_authority
-- ----------------------------
INSERT INTO `t_role_granted_authority` VALUES ('1', 'T', '20001', '50001');
INSERT INTO `t_role_granted_authority` VALUES ('2', 'T', '20001', '50002');
INSERT INTO `t_role_granted_authority` VALUES ('3', 'T', '20001', '50003');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `account_expired` int(1) DEFAULT NULL,
  `account_locked` int(1) DEFAULT NULL,
  `credentials_expired` int(1) DEFAULT NULL,
  `disabled` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('10001', 'admin', '{bcrypt}$2a$10$aJV1lCTlK2xK.OQYwyIyGer7sQ.cjyVWDs6Lz/vV8OAYe2TSE9ILS', '0', '0', '0', '0');
INSERT INTO `t_user` VALUES ('10002', 'guest', '{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for t_user_granted_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_user_granted_authority`;
CREATE TABLE `t_user_granted_authority` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `available` char(1) DEFAULT 'T',
  `user_id` int(20) NOT NULL,
  `authority_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_granted_authority` (`user_id`,`authority_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_granted_authority
-- ----------------------------
INSERT INTO `t_user_granted_authority` VALUES ('7', 'T', '10001', '50001');
INSERT INTO `t_user_granted_authority` VALUES ('8', 'T', '10001', '50002');
INSERT INTO `t_user_granted_authority` VALUES ('9', 'T', '10002', '50001');

-- ----------------------------
-- Table structure for t_user_granted_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_granted_role`;
CREATE TABLE `t_user_granted_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `available` char(1) DEFAULT 'T',
  `user_id` int(20) NOT NULL,
  `role_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_user_granted_role
-- ----------------------------
INSERT INTO `t_user_granted_role` VALUES ('3', 'T', '10001', '20001');
