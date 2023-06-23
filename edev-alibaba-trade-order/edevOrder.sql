/*
Navicat MySQL Data Transfer

Source Server         : tidb
Source Server Version : 50725
Source Host           : master:4000
Source Database       : edevOrder

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2023-06-23 21:10:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(20) NOT NULL,
  `customer_id` int(20) DEFAULT NULL,
  `address_id` int(20) DEFAULT NULL,
  `amount` decimal(20,2) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `flag` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('10001', '10001', '1000100', '8958.00', '2020-12-28 17:07:19', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10002', '10002', '1000200', '829.00', '2021-01-01 12:00:00', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10003', '10003', '1000300', '165.80', '2021-02-20 13:01:00', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10004', '10004', '1000400', '4999.00', '2008-05-01 00:00:00', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10005', '10005', '1000500', '4325.00', '2010-04-01 12:00:00', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10006', '10006', '1000600', '11598.00', '2010-10-12 13:20:17', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10007', '10007', '1000700', '14688.00', '2012-04-22 00:00:00', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10008', '10008', '1000800', '12286.00', '2012-05-10 00:00:00', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10009', '10009', '1000900', '7799.00', '2012-06-01 00:00:00', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10010', '10001', '1000100', '5000.00', '2019-12-29 00:00:00', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10011', '10001', '1000100', '16600.00', '2019-12-29 00:00:00', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10012', '10010', '1001000', '4790.00', '2012-07-12 00:00:00', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10013', '10011', '1001100', '3999.00', '2012-08-08 09:30:00', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10014', '10012', '1001200', '8288.00', '2012-09-13 10:00:10', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10015', '10011', '1001101', '5598.00', '2012-10-01 13:23:00', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10016', '10001', '1000101', '10688.00', '2012-11-21 18:34:01', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10017', '10013', '1001300', '2599.00', '2012-12-31 00:00:00', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10018', '10014', '1001400', '2599.00', '2013-01-13 00:00:00', null, 'PAYMENT');
INSERT INTO `t_order` VALUES ('10019', '10015', '1001500', '4999.00', '2013-02-28 23:59:59', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10020', '10012', '1001201', '2380.00', '2014-06-30 20:00:00', null, 'CREATE');
INSERT INTO `t_order` VALUES ('10021', '10012', '1001201', '28.90', '2014-06-30 21:00:00', null, 'CREATE');

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int(20) NOT NULL,
  `order_id` int(20) DEFAULT NULL,
  `product_id` int(20) DEFAULT NULL,
  `quantity` int(20) DEFAULT NULL,
  `price` decimal(20,2) DEFAULT NULL,
  `amount` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_order_item_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES ('100010', '10001', '30003', '2', '4000.00', '8000.00');
INSERT INTO `t_order_item` VALUES ('100011', '10001', '30004', '1', '958.00', '958.00');
INSERT INTO `t_order_item` VALUES ('100020', '10002', '30010', '10', '82.90', '829.00');
INSERT INTO `t_order_item` VALUES ('100030', '10003', '30010', '1', '82.90', '82.90');
INSERT INTO `t_order_item` VALUES ('100031', '10003', '30011', '1', '82.90', '82.90');
INSERT INTO `t_order_item` VALUES ('100040', '10004', '30009', '1', '4999.00', '4999.00');
INSERT INTO `t_order_item` VALUES ('100050', '10005', '30013', '1', '2599.00', '2599.00');
INSERT INTO `t_order_item` VALUES ('100051', '10005', '30008', '1', '1488.00', '1488.00');
INSERT INTO `t_order_item` VALUES ('100052', '10005', '30015', '1', '238.00', '238.00');
INSERT INTO `t_order_item` VALUES ('100060', '10006', '30007', '2', '5799.00', '11598.00');
INSERT INTO `t_order_item` VALUES ('100070', '10007', '30001', '1', '4000.00', '4000.00');
INSERT INTO `t_order_item` VALUES ('100071', '10007', '30003', '1', '10688.00', '10688.00');
INSERT INTO `t_order_item` VALUES ('100080', '10008', '30007', '1', '5799.00', '5799.00');
INSERT INTO `t_order_item` VALUES ('100081', '10008', '30008', '1', '1488.00', '1488.00');
INSERT INTO `t_order_item` VALUES ('100082', '10008', '30009', '1', '4999.00', '4999.00');
INSERT INTO `t_order_item` VALUES ('100090', '10009', '30012', '1', '7799.00', '7799.00');
INSERT INTO `t_order_item` VALUES ('100110', '10011', '30001', '1', '4000.00', '4000.00');
INSERT INTO `t_order_item` VALUES ('100111', '10011', '30002', '1', '12600.00', '12600.00');
INSERT INTO `t_order_item` VALUES ('100120', '10012', '30004', '5', '958.00', '4790.00');
INSERT INTO `t_order_item` VALUES ('100130', '10013', '30014', '1', '3999.00', '3999.00');
INSERT INTO `t_order_item` VALUES ('100140', '10014', '30005', '1', '8288.00', '8288.00');
INSERT INTO `t_order_item` VALUES ('100150', '10015', '30006', '2', '2799.00', '5598.00');
INSERT INTO `t_order_item` VALUES ('100160', '10016', '30003', '1', '10688.00', '10688.00');
INSERT INTO `t_order_item` VALUES ('100170', '10017', '30013', '1', '2599.00', '2599.00');
INSERT INTO `t_order_item` VALUES ('100180', '10018', '30013', '1', '2599.00', '2599.00');
INSERT INTO `t_order_item` VALUES ('100190', '10019', '30009', '1', '4999.00', '4999.00');
INSERT INTO `t_order_item` VALUES ('100200', '10020', '30015', '10', '238.00', '2380.00');
INSERT INTO `t_order_item` VALUES ('100210', '10021', '30011', '1', '28.90', '28.90');

-- ----------------------------
-- Table structure for t_payment
-- ----------------------------
DROP TABLE IF EXISTS `t_payment`;
CREATE TABLE `t_payment` (
  `id` int(20) NOT NULL,
  `account_id` int(20) NOT NULL,
  `amount` decimal(20,2) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_payment
-- ----------------------------
INSERT INTO `t_payment` VALUES ('10001', '10102', '8958.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10002', '10103', '829.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10003', '10104', '165.80', 'payoff');
INSERT INTO `t_payment` VALUES ('10004', '10105', '4999.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10005', '10106', '4325.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10006', '10107', '11598.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10007', '10108', '14688.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10008', '10109', '12286.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10009', '10110', '7799.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10010', '10102', '5000.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10011', '10102', '16600.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10012', '10111', '4790.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10013', '10112', '3999.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10014', '10113', '8288.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10015', '10112', '5598.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10016', '10102', '10688.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10017', '10114', '2599.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10018', '10115', '2599.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10019', '10116', '4999.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10020', '10113', '2380.00', 'payoff');
INSERT INTO `t_payment` VALUES ('10021', '10113', '28.90', 'payoff');

-- ----------------------------
-- Table structure for t_product_discount
-- ----------------------------
DROP TABLE IF EXISTS `t_product_discount`;
CREATE TABLE `t_product_discount` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `discount` decimal(5,4) DEFAULT NULL,
  `discount_type` varchar(20) DEFAULT NULL,
  `product_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_product_discount
-- ----------------------------
INSERT INTO `t_product_discount` VALUES ('30001', '微软平板电脑笔记本打折', '2020-01-01 00:00:00', null, '0.8000', 'productDiscount', '30005');
INSERT INTO `t_product_discount` VALUES ('30002', '华为Mate 30E打折', '2020-01-01 00:00:00', null, '0.8800', 'productDiscount', '30007');

-- ----------------------------
-- Table structure for t_vip_discount
-- ----------------------------
DROP TABLE IF EXISTS `t_vip_discount`;
CREATE TABLE `t_vip_discount` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `discount` decimal(5,4) DEFAULT NULL,
  `discount_type` varchar(20) DEFAULT NULL,
  `vip_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_vip_discount
-- ----------------------------
INSERT INTO `t_vip_discount` VALUES ('1001', '金卡会员打折', '2020-01-01 00:00:00', null, '0.7500', 'vipDiscount', 'golden');
INSERT INTO `t_vip_discount` VALUES ('1002', '银卡会员打折', '2020-01-01 00:00:00', null, '0.9000', 'vipDiscount', 'silver');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
