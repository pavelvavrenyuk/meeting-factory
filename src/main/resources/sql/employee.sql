CREATE DATABASE  IF NOT EXISTS `meeting_factory`;
USE `meeting_factory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES
	(1,'Andrey','Zvonov'),
	(2,'Alexander','Hakimov'),
	(3,'Oleg','Torsunov'),
	(4,'Marina','Targakova'),
	(5,'Vasiliy','Tuneev');

