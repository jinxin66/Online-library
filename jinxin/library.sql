/*
Navicat MySQL Data Transfer

Source Server         : jinxin
Source Server Version : 50723
Source Host           : 47.107.93.138:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-25 22:58:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `all_authority`
-- ----------------------------
DROP TABLE IF EXISTS `all_authority`;
CREATE TABLE `all_authority` (
  `id` char(32) CHARACTER SET utf8 NOT NULL COMMENT 'authority_id',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限名称',
  `code` char(32) CHARACTER SET utf8 NOT NULL COMMENT '编码',
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of all_authority
-- ----------------------------
INSERT INTO `all_authority` VALUES ('1', '删除图书', 'delete_book', '删除图书的权限');
INSERT INTO `all_authority` VALUES ('2', '发言', 'push_pub', '发言的权限');

-- ----------------------------
-- Table structure for `all_book`
-- ----------------------------
DROP TABLE IF EXISTS `all_book`;
CREATE TABLE `all_book` (
  `id` char(32) NOT NULL,
  `book_code` char(32) NOT NULL COMMENT '图书编号',
  `book_isbn` char(32) NOT NULL COMMENT '图书ISBN编号',
  `book_name` char(32) NOT NULL COMMENT '书名',
  `book_writer` char(32) DEFAULT NULL COMMENT '作者',
  `book_publish` char(32) DEFAULT NULL COMMENT '出版社',
  `book_version` char(11) DEFAULT NULL COMMENT '版次',
  `book_price` double(8,2) DEFAULT '0.00' COMMENT '价格',
  `book_description` char(128) DEFAULT NULL COMMENT '书本描述',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态0-在库 1-借出 2-已预约 3-丢失 4-损坏',
  `last_borrowed_time` timestamp NULL DEFAULT NULL COMMENT '最后一次借阅日期',
  `last_borrower_id` char(32) DEFAULT NULL COMMENT '最后一个借阅人ID',
  `location_id` char(32) NOT NULL COMMENT '图书存放位置id',
  `rate` double(16,2) NOT NULL DEFAULT '1.00' COMMENT '图书价值比率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_book
-- ----------------------------
INSERT INTO `all_book` VALUES ('1', '978754545115', '978754515425', '图书1', '作者1', '出版社1', '第二版', '49.81', '简介1', '0', '2018-10-24 22:45:39', null, '2', '0.90');
INSERT INTO `all_book` VALUES ('2', '978754123654', '978754123654', '图书2', '作者2', '出版社2', '第一版', '52.31', '简介2', '1', '2018-10-24 22:46:28', '1', '1', '0.80');
INSERT INTO `all_book` VALUES ('3', '978676126125', '978712121212', '图书3', '作者3', '出版社2', '最新', '15.23', '简介3', '2', null, null, '2', '1.00');

-- ----------------------------
-- Table structure for `all_book_category`
-- ----------------------------
DROP TABLE IF EXISTS `all_book_category`;
CREATE TABLE `all_book_category` (
  `id` char(32) NOT NULL,
  `category_name` char(32) NOT NULL COMMENT '类别名',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态0-启用，1-禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_book_category
-- ----------------------------
INSERT INTO `all_book_category` VALUES ('1', '种类1', '0');
INSERT INTO `all_book_category` VALUES ('2', '种类2', '1');
INSERT INTO `all_book_category` VALUES ('3', '种类3', '0');
INSERT INTO `all_book_category` VALUES ('4', '种类4', '0');
INSERT INTO `all_book_category` VALUES ('5', '种类5', '0');

-- ----------------------------
-- Table structure for `all_bookshelf_level`
-- ----------------------------
DROP TABLE IF EXISTS `all_bookshelf_level`;
CREATE TABLE `all_bookshelf_level` (
  `id` char(32) NOT NULL,
  `floor_id` int(2) NOT NULL COMMENT '楼层',
  `room_id` char(32) DEFAULT NULL COMMENT '图书室',
  `area_id` char(8) DEFAULT NULL COMMENT '区',
  `bookshelf_id` char(8) NOT NULL COMMENT '书架编号',
  `bookshelf_level_id` int(2) NOT NULL COMMENT '书架层数',
  `describption` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-启用1-禁用 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_bookshelf_level
-- ----------------------------
INSERT INTO `all_bookshelf_level` VALUES ('1', '1', '1', '1', '1', '1', '备注1', '0');
INSERT INTO `all_bookshelf_level` VALUES ('2', '1', '1', '1', '1', '2', '备注2', '1');

-- ----------------------------
-- Table structure for `all_borrow_record`
-- ----------------------------
DROP TABLE IF EXISTS `all_borrow_record`;
CREATE TABLE `all_borrow_record` (
  `id` char(32) NOT NULL,
  `borrower_id` char(32) NOT NULL COMMENT '借阅者ID',
  `book_id` char(32) NOT NULL COMMENT '书ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '借阅日期',
  `arrenge_return_time` timestamp NULL DEFAULT NULL COMMENT '约定归还日期',
  `return_time` timestamp NULL DEFAULT NULL COMMENT '真实归还时间',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-未归还 1-已归还 2-逾期',
  `description` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_borrow_record
-- ----------------------------
INSERT INTO `all_borrow_record` VALUES ('1', '1', '2', '2018-10-24 23:25:34', '2018-10-31 23:25:43', null, '0', '备注1');

-- ----------------------------
-- Table structure for `all_collection`
-- ----------------------------
DROP TABLE IF EXISTS `all_collection`;
CREATE TABLE `all_collection` (
  `id` char(32) NOT NULL,
  `user_id` char(32) NOT NULL COMMENT 'user_id',
  `category` int(1) NOT NULL DEFAULT '0' COMMENT '收藏类型0-书1-资讯',
  `book_id` char(32) DEFAULT NULL COMMENT 'book_id',
  `pub_id` char(32) DEFAULT NULL COMMENT 'pub_id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态0-启用 1-删除',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_collection
-- ----------------------------

-- ----------------------------
-- Table structure for `all_comment`
-- ----------------------------
DROP TABLE IF EXISTS `all_comment`;
CREATE TABLE `all_comment` (
  `id` char(32) NOT NULL,
  `category` int(1) NOT NULL DEFAULT '0' COMMENT '类别 0-书评 1-回复书评3-回复书评的回复4-评论资讯 5-回复资讯的评论',
  `from_id` char(32) NOT NULL COMMENT '评论者ID',
  `to_id` char(32) NOT NULL COMMENT '对象ID',
  `comment_word` varchar(512) NOT NULL COMMENT '评论内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建评论时间',
  `support_num` int(8) DEFAULT '0' COMMENT '获得点赞数',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态 0-启用 1-禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `all_pub`
-- ----------------------------
DROP TABLE IF EXISTS `all_pub`;
CREATE TABLE `all_pub` (
  `id` char(32) NOT NULL,
  `from_id` char(32) NOT NULL COMMENT '发布者id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `word` varchar(255) DEFAULT NULL COMMENT '内容',
  `support_num` int(8) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态 0-启用 1-禁用',
  `weight` int(8) NOT NULL DEFAULT '1' COMMENT '权重0-置顶1-正常(时间排序）',
  `description` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `user_delete` (`from_id`),
  CONSTRAINT `user_delete` FOREIGN KEY (`from_id`) REFERENCES `all_user` (`wechat_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_pub
-- ----------------------------
INSERT INTO `all_pub` VALUES ('1', '1', '2018-10-24 23:32:29', '资讯1', '资讯内容1', '0', '0', '1', '备注1');
INSERT INTO `all_pub` VALUES ('2', '1', '2018-10-24 23:33:28', '资讯2', '资讯内容2置顶', '0', '0', '0', '备注2置顶');

-- ----------------------------
-- Table structure for `all_role`
-- ----------------------------
DROP TABLE IF EXISTS `all_role`;
CREATE TABLE `all_role` (
  `id` char(32) CHARACTER SET utf8 NOT NULL COMMENT 'role_id',
  `name` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色名',
  `code` char(32) CHARACTER SET utf8 NOT NULL COMMENT '编码',
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `is_locked` int(1) NOT NULL DEFAULT '0' COMMENT '是否启用[1:启用；0:禁用]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of all_role
-- ----------------------------
INSERT INTO `all_role` VALUES ('-1', 'super', 'super', 'super', '1');
INSERT INTO `all_role` VALUES ('1', '管理员', 'manager', '管理员角色', '0');
INSERT INTO `all_role` VALUES ('2', '图书管理员', 'library_manager', '图书管理员角色', '0');
INSERT INTO `all_role` VALUES ('3', '学生', 'student', '学生', '0');
INSERT INTO `all_role` VALUES ('4', '教师', 'teacher', '教师', '0');
INSERT INTO `all_role` VALUES ('5', '游客', 'member', '未绑定的普通用户', '0');

-- ----------------------------
-- Table structure for `all_ticket`
-- ----------------------------
DROP TABLE IF EXISTS `all_ticket`;
CREATE TABLE `all_ticket` (
  `id` char(32) NOT NULL,
  `user_id` char(32) NOT NULL COMMENT '用户id',
  `borrow_record_id` char(21) DEFAULT NULL COMMENT '借阅记录id',
  `book_id` char(32) DEFAULT NULL COMMENT 'book_id',
  `ticket_fee` double(16,2) NOT NULL COMMENT '罚单费用',
  `over_time` timestamp NULL DEFAULT NULL COMMENT '超出时间(归还时间戳-约定归还时间戳)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pay_time` timestamp NULL DEFAULT NULL COMMENT '支付时间',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态0-未结算，1-结清',
  `description` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_ticket
-- ----------------------------

-- ----------------------------
-- Table structure for `all_user`
-- ----------------------------
DROP TABLE IF EXISTS `all_user`;
CREATE TABLE `all_user` (
  `id` char(32) NOT NULL,
  `wechat_id` char(32) NOT NULL COMMENT '微信号openid',
  `student_id` char(10) DEFAULT NULL COMMENT '学号',
  `role_id` char(32) NOT NULL DEFAULT '5' COMMENT '角色id',
  `nickname` char(16) DEFAULT NULL COMMENT '昵称',
  `username` char(16) DEFAULT NULL COMMENT '用户名',
  `head_url` char(255) DEFAULT NULL COMMENT '头像',
  `last_login_time` timestamp NULL DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` char(16) DEFAULT NULL COMMENT '最后登录ip',
  `credit` int(3) DEFAULT '0' COMMENT '扣除的信用分',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态0-启用 1-禁用',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`wechat_id`),
  KEY `wechat_id` (`wechat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_user
-- ----------------------------
INSERT INTO `all_user` VALUES ('1', '1', '1', '-1', '网名1', '用户名1', '头像1', '2018-10-23 22:20:46', '127.0.0.1', null, '0', '2018-10-23 22:21:04');

-- ----------------------------
-- Table structure for `live_book_category`
-- ----------------------------
DROP TABLE IF EXISTS `live_book_category`;
CREATE TABLE `live_book_category` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `book_id` char(32) NOT NULL COMMENT 'book_id',
  `category_id` char(32) NOT NULL COMMENT 'category_id',
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  KEY `category_delete` (`category_id`),
  CONSTRAINT `book_delete` FOREIGN KEY (`book_id`) REFERENCES `all_book` (`id`) ON DELETE CASCADE,
  CONSTRAINT `category_delete` FOREIGN KEY (`category_id`) REFERENCES `all_book_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of live_book_category
-- ----------------------------
INSERT INTO `live_book_category` VALUES ('1', '1', '1');
INSERT INTO `live_book_category` VALUES ('2', '2', '1');
INSERT INTO `live_book_category` VALUES ('3', '2', '2');
INSERT INTO `live_book_category` VALUES ('4', '2', '3');

-- ----------------------------
-- Table structure for `live_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `live_role_authority`;
CREATE TABLE `live_role_authority` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'role_authority关联表',
  `role_id` char(32) CHARACTER SET utf8 NOT NULL COMMENT 'role_id',
  `authority_id` char(32) CHARACTER SET utf8 NOT NULL COMMENT 'authority_id',
  PRIMARY KEY (`id`),
  KEY `authority_delete` (`authority_id`),
  KEY `role_delete` (`role_id`),
  CONSTRAINT `authority_delete` FOREIGN KEY (`authority_id`) REFERENCES `all_authority` (`id`),
  CONSTRAINT `role_delete` FOREIGN KEY (`role_id`) REFERENCES `all_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of live_role_authority
-- ----------------------------
INSERT INTO `live_role_authority` VALUES ('1', '-1', '1');
INSERT INTO `live_role_authority` VALUES ('2', '-1', '2');
INSERT INTO `live_role_authority` VALUES ('3', '1', '2');
INSERT INTO `live_role_authority` VALUES ('4', '2', '2');
INSERT INTO `live_role_authority` VALUES ('5', '3', '2');
INSERT INTO `live_role_authority` VALUES ('6', '4', '2');
INSERT INTO `live_role_authority` VALUES ('7', '5', '2');
