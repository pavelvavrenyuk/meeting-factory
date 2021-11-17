CREATE DATABASE  IF NOT EXISTS `meeting_factory`;
USE `meeting_factory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `group_of_criteria`;

CREATE TABLE `group_of_criteria` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `name` varchar(80) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Data for table `employee`
--

INSERT INTO `group_of_criteria` VALUES
(1,'Spring'),
(2,'Java'),
(3,'Hibernate'),
(4,'Alfresco'),
(5,'React');

