CREATE DATABASE  IF NOT EXISTS `meeting_factory`;
USE `meeting_factory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `meeting`;

CREATE TABLE `meeting` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `date` datetime DEFAULT NULL,
                           `employee_id` int(11) NULL,
                           PRIMARY KEY (`id`),
                           CONSTRAINT FK_employee_id
                               FOREIGN KEY (employee_id) REFERENCES Employee (id)
                                   ON UPDATE CASCADE
                                   ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Data for table `meeting`
--

INSERT INTO `meeting` VALUES
(1,'2020-06-26','3'),
(2,'2010-05-30','4'),
(3,'1486-02-18','5')

