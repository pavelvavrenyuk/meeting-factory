CREATE DATABASE  IF NOT EXISTS `meeting_factory`;
USE `meeting_factory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `criterion`;

CREATE TABLE `criterion` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(80) DEFAULT NULL,
                           `group_id` int(11) NULL,
                           PRIMARY KEY (`id`),
                           CONSTRAINT FK_group_id
                               FOREIGN KEY (group_id) REFERENCES `group_of_criteria` (id)
                                   ON UPDATE CASCADE
                                   ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Data for table `meeting`
--

INSERT INTO `criterion` VALUES
(1,'Spring boot','1'),
(2,'Spring secure','1'),
(3,'Lambdas','2'),
(4,'Collections','2'),
(5,'Webscript knowledge','4'),
(6,'Events','5');

