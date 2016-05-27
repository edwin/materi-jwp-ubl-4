create database test;

-- ----------------------------
-- Table structure for `testing`
-- ----------------------------
DROP TABLE IF EXISTS `testing`;
CREATE TABLE `testing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of testing
-- ----------------------------
INSERT INTO `testing` VALUES ('1', 'satu', '123');
INSERT INTO `testing` VALUES ('2', 'dua', 'epep');
INSERT INTO `testing` VALUES ('3', 'tiga', 'lelele');
INSERT INTO `testing` VALUES ('4', 'empat', 'ldkdkdk');