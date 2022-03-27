-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               8.0.15 - MySQL Community Server - GPL
-- Операционная система:         Win64
-- HeidiSQL Версия:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных ibapst
create DATABASE IF NOT EXISTS `ibapst`;
use `ibapst`;

-- Дамп структуры для таблица ibapst.student
create TABLE IF NOT EXISTS `student` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `mobile_no` varchar(12) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `add_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile_no` (`mobile_no`),
  UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ibapst.student: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
insert into `student` (`id`, `fname`, `lname`, `address`, `mobile_no`, `email_id`, `city`, `designation`, `dob`, `doj`, `salary`, `add_date`) values
	(1, 'qwe', 'qw', 'q', 'qwer', 'w', 'e', 'r', '2022-01-29', '2022-01-29', 123.00, '2022-01-29 11:38:14'),
	(3, 'z', 'x', 'c', 'v', 'b', 'n', 'm', '2021-12-14', '2022-01-15', 12234.00, '2022-01-29 13:04:57'),
	(4, 't', 'y', 'u', 'i', 'o', 'p', '[', '2021-12-25', '2022-01-15', 200.00, '2022-01-30 10:16:29');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

create TABLE IF NOT EXISTS `office` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `number` bigint(20)  NOT NULL,
  `name` varchar(30)  NOT NULL,
  `address` varchar(80)  NOT NULL,
  `postCode` varchar(6)  NOT NULL,
  `phoneNumber` varchar(15)  NOT NULL,
   PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into `office` (`id`, `number`, `name`, `address`, `postCode`, `phoneNumber`) values
	(1, 1, 'Office #1', 'Minsk', '123456', '2145698'),
    (2, 2, 'Office #2', 'Grodno', '777777', '21452398'),
    (3, 3, 'Office #3', 'Brest', '5544444', '21456238');