/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : lovesnack

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 06/05/2021 15:11:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `money` double(8, 0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '闫昆鹏', 20000);
INSERT INTO `account` VALUES (4, '张三', 10000);
INSERT INTO `account` VALUES (5, 'user', 232323);
INSERT INTO `account` VALUES (6, 'me', 232323);
INSERT INTO `account` VALUES (7, '激光笔', 232323);
INSERT INTO `account` VALUES (8, '萨达', 22222);
INSERT INTO `account` VALUES (9, '玩完', 232323);
INSERT INTO `account` VALUES (10, '李四', 10000);
INSERT INTO `account` VALUES (11, '马腾飞', 60000);
INSERT INTO `account` VALUES (13, '11', 100000);
INSERT INTO `account` VALUES (14, '王晓宇', 60000);
INSERT INTO `account` VALUES (15, '', 23232);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'ykp', '111111', '男', '19913328359');
INSERT INTO `admin` VALUES ('2', 'mtf', '111111', '男', '15617526358');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(10, 1) DEFAULT NULL,
  `weight` int(10) DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  INDEX `c_fk_goodsName`(`goodsName`) USING BTREE,
  INDEX `c_fk_openid`(`openid`) USING BTREE,
  CONSTRAINT `c_fk_goodsName` FOREIGN KEY (`goodsName`) REFERENCES `goods` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `c_fk_openid` FOREIGN KEY (`openid`) REFERENCES `user` (`openid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '创味工坊炭烧腰果咸蛋黄味100g', 2.0, 1, 'https://www.hualigs.cn/image/60891173b6e39.jpg');
INSERT INTO `cart` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '手撕牛排', 1.5, 1, 'https://www.hualigs.cn/image/60890ed46e4ef.jpg');
INSERT INTO `cart` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '百草味吊瓜子奶油味100g', 2.0, 1, 'https://www.hualigs.cn/image/608911351baf4.jpg');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(10, 1) DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `information` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `discount` decimal(2, 1) DEFAULT NULL,
  INDEX `co_fk_goodsName`(`goodsName`) USING BTREE,
  INDEX `co_fk_openid`(`openid`) USING BTREE,
  CONSTRAINT `co_fk_goodsName` FOREIGN KEY (`goodsName`) REFERENCES `goods` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `co_fk_openid` FOREIGN KEY (`openid`) REFERENCES `user` (`openid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', '创味工坊炭烧腰果咸蛋黄味100g', 2.0, '无辣不欢', 'https://www.hualigs.cn/image/60891173b6e39.jpg', '创味工坊炭烧腰果咸蛋黄味100g', 1.0);

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation`  (
  `orderId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`orderId`) USING BTREE,
  INDEX `e_fk_goodsName`(`goodsName`) USING BTREE,
  INDEX `e_fk_openId`(`openid`) USING BTREE,
  CONSTRAINT `e_fk_goodsName` FOREIGN KEY (`goodsName`) REFERENCES `goods` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e_fk_openId` FOREIGN KEY (`openid`) REFERENCES `user` (`openid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e_fk_orderid` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES ('1619018389905li610c22q3i', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', '不怕辣豆角干', '2021-04-28-15:58:40', '很不错');
INSERT INTO `evaluation` VALUES ('1619018424976sirlbckn9bk', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', '百草味大面筋', '2021-05-04-10:20:10', '很好吃');
INSERT INTO `evaluation` VALUES ('16191461715771nkn7n117gk', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', '佳龙', '2021-04-28-16:3:11', '不错啊');
INSERT INTO `evaluation` VALUES ('1619149491360jzhqok4ivgd', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', '维达卷纸无芯卫生纸780克10卷', '2021-04-28-15:59:58', '订单的');
INSERT INTO `evaluation` VALUES ('16200061558523mom0wlfc5u', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', '佳龙', '2021-05-03-9:43:42', '百吃不厌啊，太爱了');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  INDEX `fe_fk_openid`(`openid`) USING BTREE,
  CONSTRAINT `fe_fk_openid` FOREIGN KEY (`openid`) REFERENCES `user` (`openid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '功能意见', '希望能够加一个自己的浏览记录功能', '2021-04-26-14:31:54');
INSERT INTO `feedback` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '页面显示问题', '页面图片加载有点慢', '2021-04-26-14:36:10');
INSERT INTO `feedback` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '页面显示问题', '大萨达', '2021-04-28-12:57:17');
INSERT INTO `feedback` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '其他', '24242', '2021-04-28-12:57:32');
INSERT INTO `feedback` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '页面显示问题', 'sss', '2021-04-28-12:58:59');
INSERT INTO `feedback` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '性能问题', 'dsadasd', '2021-04-28-13:37:48');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(10, 1) NOT NULL DEFAULT 0.0,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `surplus` int(10) NOT NULL DEFAULT 0,
  `discount` decimal(2, 1) NOT NULL DEFAULT 1.0,
  `sales` int(11) UNSIGNED ZEROFILL DEFAULT 00000000000,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `information` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('不怕辣豆角干', 1.0, '无辣不欢', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890e821ac5b.jpg', '不怕辣豆角干');
INSERT INTO `goods` VALUES ('乐事薯片', 2.0, '休闲零食', 149, 1.0, 00000000001, 'https://www.hualigs.cn/image/608910c6c154e.jpg', '乐事薯片');
INSERT INTO `goods` VALUES ('佳龙', 2.0, '无辣不欢', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890eab4475d.jpg', '佳龙');
INSERT INTO `goods` VALUES ('农夫山泉', 2.0, '饮料牛奶', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/608f9579b78b8.jpg', '农夫山泉');
INSERT INTO `goods` VALUES ('创味工坊炭烧腰果咸蛋黄味100g', 2.0, '无辣不欢', 95, 1.0, 00000000005, 'https://www.hualigs.cn/image/60891173b6e39.jpg', '创味工坊炭烧腰果咸蛋黄味100g');
INSERT INTO `goods` VALUES ('可口可乐', 3.0, '饮料牛奶', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890fdda837d.jpg', '可口可乐');
INSERT INTO `goods` VALUES ('呀士豆', 1.0, '无辣不欢', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/608fa472bef72.jpg', '呀士豆');
INSERT INTO `goods` VALUES ('哇哈哈AD钙奶', 2.5, '饮料牛奶', 120, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890ff3d33fc.jpg', '哇哈哈AD钙奶');
INSERT INTO `goods` VALUES ('大豫竹方便面', 1.0, '方便面', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890f50682be.jpg', '大豫竹方便面');
INSERT INTO `goods` VALUES ('女生红糖', 3.0, '仙女专用', 30, 1.0, 00000000000, 'https://www.hualigs.cn/image/6089107261e4c.jpg', '女生红糖');
INSERT INTO `goods` VALUES ('康师傅冰红茶', 3.0, '饮料牛奶', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890f89e3f67.jpg', '康师傅冰红茶');
INSERT INTO `goods` VALUES ('康师傅绿茶', 3.0, '饮料牛奶', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890fc6c04d7.jpg', '康师傅绿茶');
INSERT INTO `goods` VALUES ('手撕牛排', 1.5, '无辣不欢', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890ed46e4ef.jpg', '手撕牛排');
INSERT INTO `goods` VALUES ('沙琪玛', 1.5, '休闲零食', 140, 1.0, 00000000000, 'https://www.hualigs.cn/image/608910db54458.jpg', '来自云南的沙琪玛');
INSERT INTO `goods` VALUES ('洽洽葵大大焦糖味葵花籽218g', 3.0, '瓜子坚果', 120, 1.0, 00000000000, 'https://www.hualigs.cn/image/6089118d626a3.jpg', '洽洽葵大大焦糖味葵花籽218g');
INSERT INTO `goods` VALUES ('甘源原味青豌豆75g', 1.0, '休闲零食', 100, 1.0, 00000000000, 'https://www.hualigs.cn/image/608910f3964d2.jpg', '甘源原味青豌豆75g');
INSERT INTO `goods` VALUES ('白象大骨面', 4.0, '方便面', 50, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890f20559af.jpg', '白象大骨面');
INSERT INTO `goods` VALUES ('百草味-开心果100g盐焗味', 1.5, '无辣不欢', 100, 1.0, 00000000000, 'https://www.hualigs.cn/image/6089115fa7581.jpg', '百草味-开心果100g盐焗味');
INSERT INTO `goods` VALUES ('百草味-碧根果100g奶油味', 2.0, '瓜子坚果', 50, 1.0, 00000000000, 'https://www.hualigs.cn/image/608911215484d.jpg', '百草味-碧根果100g奶油味');
INSERT INTO `goods` VALUES ('百草味吊瓜子奶油味100g', 2.0, '瓜子坚果', 100, 1.0, 00000000000, 'https://www.hualigs.cn/image/608911351baf4.jpg', '百草味吊瓜子奶油味100g');
INSERT INTO `goods` VALUES ('百草味大面筋', 1.0, '无辣不欢', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890eeded8ed.jpg', '百草味大面筋');
INSERT INTO `goods` VALUES ('百草味小米锅巴麻辣味45g', 1.5, '休闲零食', 100, 1.0, 00000000000, 'https://www.hualigs.cn/image/608910aaa8f65.jpg', '百草味小米锅巴麻辣味45g');
INSERT INTO `goods` VALUES ('百草味话梅西瓜子108g', 1.5, '瓜子坚果', 100, 1.0, 00000000000, 'https://www.hualigs.cn/image/60891149b0529.jpg', '百草味话梅西瓜子108g');
INSERT INTO `goods` VALUES ('盼盼鸡味块', 2.0, '休闲零食', 100, 1.0, 00000000000, 'https://www.hualigs.cn/image/60891108a12fb.jpg', '盼盼鸡味块');
INSERT INTO `goods` VALUES ('统一老坛酸菜面', 4.0, '方便面', 100, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890f6bdef53.jpg', '统一老坛酸菜面');
INSERT INTO `goods` VALUES ('统合洗衣液2KG', 15.0, '纸品清洁', 30, 1.0, 00000000000, 'https://www.hualigs.cn/image/608911f30c985.jpg', '统合洗衣液2KG');
INSERT INTO `goods` VALUES ('维达卷纸无芯卫生纸780克10卷', 15.0, '纸品清洁', 30, 1.0, 00000000000, 'https://www.hualigs.cn/image/60891210c78ca.jpg', '维达卷纸无芯卫生纸780克10卷');
INSERT INTO `goods` VALUES ('脆司令干脆面', 1.0, '方便面', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/60890f387d8df.jpg', '脆司令干脆面');
INSERT INTO `goods` VALUES ('苏菲口袋魔法森呼吸240mm超薄日用9片', 15.0, '无辣不欢', 50, 1.0, 00000000000, 'https://www.hualigs.cn/image/6089108a05cda.jpg', '苏菲口袋魔法森呼吸240mm超薄日用9片');
INSERT INTO `goods` VALUES ('蓝月亮洗衣液', 6.0, '纸品清洁', 30, 1.0, 00000000000, 'https://www.hualigs.cn/image/608911d731f45.jpg', '蓝月亮洗衣液');
INSERT INTO `goods` VALUES ('香飘飘奶茶', 3.5, '饮料牛奶', 150, 1.0, 00000000000, 'https://www.hualigs.cn/image/6089102700c0c.jpg', '香飘飘奶茶');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `orderId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(10, 1) DEFAULT NULL,
  `weight` int(10) DEFAULT NULL,
  `totalPrice` decimal(10, 1) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`orderId`) USING BTREE,
  INDEX `o_fk_goodsName`(`goodsName`) USING BTREE,
  INDEX `o_fk_openid`(`openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1619018389905li610c22q3i', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '不怕辣豆角干', 1.0, 1, 1.0, 4, '2021-04-21-23:19:49');
INSERT INTO `order` VALUES ('1619018424976sirlbckn9bk', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '百草味大面筋', 1.0, 1, 1.0, 4, '2021-04-21-23:20:24');
INSERT INTO `order` VALUES ('16190184250221ohc1ygxrj7', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '维达卷纸无芯卫生纸780克10卷', 15.0, 1, 15.0, 6, '2021-04-21-23:20:25');
INSERT INTO `order` VALUES ('1619018425045kt62dhyv7gl', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '可口可乐', 3.0, 1, 3.0, 2, '2021-04-21-23:20:25');
INSERT INTO `order` VALUES ('16191461715771nkn7n117gk', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '佳龙', 2.0, 1, 2.0, 4, '2021-04-23-10:49:31');
INSERT INTO `order` VALUES ('1619149491360jzhqok4ivgd', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '维达卷纸无芯卫生纸780克10卷', 15.0, 1, 15.0, 4, '2021-04-23-11:44:51');
INSERT INTO `order` VALUES ('1619154369702lgidg2n0ke', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '脆司令干脆面', 1.0, 2, 2.0, 2, '2021-04-23-13:6:9');
INSERT INTO `order` VALUES ('1619243489560tfq8ex6o9yj', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '手撕牛排', 1.5, 2, 3.0, 6, '2021-04-24-13:51:29');
INSERT INTO `order` VALUES ('1619404452635cg10mzcrt9u', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '手撕牛排', 1.5, 2, 3.0, 2, '2021-04-26-10:34:12');
INSERT INTO `order` VALUES ('16200061558523mom0wlfc5u', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '佳龙', 2.0, 3, 6.0, 4, '2021-05-03-9:42:35');
INSERT INTO `order` VALUES ('16200982346038mwgzlrmymj', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '哇哈哈AD钙奶', 2.5, 1, 2.5, 5, '2021-05-04-11:17:14');
INSERT INTO `order` VALUES ('1620098234627relv94s3wyr', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '白象大骨面', 4.0, 1, 4.0, 6, '2021-05-04-11:17:14');
INSERT INTO `order` VALUES ('1620098590084861qk7f940d', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '统一老坛酸菜面', 4.0, 3, 12.0, 5, '2021-05-04-11:23:10');
INSERT INTO `order` VALUES ('162009918725120p7j202qf5', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '创味工坊炭烧腰果咸蛋黄味100g', 2.0, 3, 6.0, 1, '2021-05-04-11:33:7');
INSERT INTO `order` VALUES ('1620099211961lljhbyzm63p', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '创味工坊炭烧腰果咸蛋黄味100g', 2.0, 2, 4.0, 5, '2021-05-04-11:33:31');
INSERT INTO `order` VALUES ('16200992579783rvpd3p512h', 'ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', '乐事薯片', 2.0, 1, 2.0, 1, '2021-05-04-11:34:17');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1231231321', '事实上', '21313131', '19913328359', '浙江省杭州市');
INSERT INTO `user` VALUES ('ov-SK5EiJPL9w3GxRnGO28Cl-1Kc', 'mge', 'https://thirdwx.qlogo.cn/mmopen/vi_32/gFsre4I5gopYiaQBaK7uOBvXDeFGflgwj4EiaAmeoUqQgl45nwUYcJlLHeHIZNqqJQicBYcLzMGgZ0NNvjd0r7Hmg/132', '15617526343', '广东省广州市海珠区新港中路397号');

SET FOREIGN_KEY_CHECKS = 1;
