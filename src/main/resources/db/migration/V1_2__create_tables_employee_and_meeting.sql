--
-- Table structure for table `employee`
--

CREATE TABLE `employee`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name`  varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--
-- Table structure for table `meeting`
--

CREATE TABLE `meeting`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT,
    `date`          datetime      DEFAULT NULL,
    `questions`     varchar(1000) DEFAULT NULL,
    `agreements`    varchar(1000) DEFAULT NULL,
    `group_records` JSON NOT NULL,
    `employee_id`   int(11) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT FK_employee_id
        FOREIGN KEY (employee_id) REFERENCES Employee (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;