/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50635
Source Host           : kubernetes:32306
Source Database       : edevInventory

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2023-06-23 21:17:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_inventory
-- ----------------------------
DROP TABLE IF EXISTS `t_inventory`;
CREATE TABLE `t_inventory` (
  `id` int(20) NOT NULL,
  `quantity` int(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_inventory
-- ----------------------------
INSERT INTO `t_inventory` VALUES ('30001', '9997', '2023-02-03 22:33:38');
INSERT INTO `t_inventory` VALUES ('30002', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30003', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30004', '9998', '2023-02-03 22:33:38');
INSERT INTO `t_inventory` VALUES ('30005', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30006', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30007', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30008', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30009', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30010', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30011', '10000', '2022-03-31 02:40:46');

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
