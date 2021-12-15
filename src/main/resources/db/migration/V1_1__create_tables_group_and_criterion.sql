--
-- Table structure for table `group_of_criteria`
--

CREATE TABLE `group_of_criteria`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(80) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--
-- Table structure for table `criterion`
--

CREATE TABLE `criterion`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `name`     varchar(80) DEFAULT NULL,
    `group_id` int(11) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT FK_group_id
        FOREIGN KEY (group_id) REFERENCES `group_of_criteria` (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;