-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema shopping
--

CREATE DATABASE IF NOT EXISTS shopping;
USE shopping;

--
-- Definition of table `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `bill_no` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `b_code` varchar(20) NOT NULL,
  `date` datetime NOT NULL,
  `total` int(20) unsigned NOT NULL,
  PRIMARY KEY (`bill_no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` (`bill_no`,`b_code`,`date`,`total`) VALUES 
 (1,'b10','2010-10-27 00:00:00',17500),
 (2,'b10','2010-10-27 00:00:00',3500),
 (3,'b10','2010-10-27 00:00:00',21600),
 (4,'b10','2010-10-31 00:00:00',21000),
 (5,'b3','2010-10-31 00:00:00',28000),
 (6,'b10','2010-10-31 00:00:00',31500),
 (7,'b10','2010-10-31 00:00:00',3500),
 (8,'b10','2010-10-31 00:00:00',3500),
 (9,'b10','2010-10-31 00:00:00',14000),
 (10,'b10','2010-11-23 00:00:00',22800);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;


--
-- Definition of table `bill_detail`
--

DROP TABLE IF EXISTS `bill_detail`;
CREATE TABLE `bill_detail` (
  `bill_no` varchar(20) NOT NULL,
  `i_code` varchar(20) NOT NULL,
  `i_aquantity` int(20) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_detail`
--

/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
INSERT INTO `bill_detail` (`bill_no`,`i_code`,`i_aquantity`) VALUES 
 ('1','119',1),
 ('1','15',1),
 ('2','119',1),
 ('3','10',12),
 ('4','119',2),
 ('4','15',1),
 ('5','15',2),
 ('6','119',1),
 ('6','23',1),
 ('7','119',1),
 ('8','119',1),
 ('9','15',1),
 ('10','119',2),
 ('10','15',1),
 ('10','10',1);
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;


--
-- Definition of table `branch_detail`
--

DROP TABLE IF EXISTS `branch_detail`;
CREATE TABLE `branch_detail` (
  `b_code` varchar(20) NOT NULL,
  `b_name` varchar(45) NOT NULL,
  `b_address` varchar(45) NOT NULL,
  PRIMARY KEY (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch_detail`
--

/*!40000 ALTER TABLE `branch_detail` DISABLE KEYS */;
INSERT INTO `branch_detail` (`b_code`,`b_name`,`b_address`) VALUES 
 ('b10','kalawad','rajkot'),
 ('b2','rani tower','kalawad road'),
 ('b5','jay','sardhar'),
 ('b7','jayvik','jay');
/*!40000 ALTER TABLE `branch_detail` ENABLE KEYS */;


--
-- Definition of table `branch_item`
--

DROP TABLE IF EXISTS `branch_item`;
CREATE TABLE `branch_item` (
  `b_code` varchar(20) NOT NULL,
  `i_code` varchar(20) NOT NULL,
  `i_quantity` int(20) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch_item`
--

/*!40000 ALTER TABLE `branch_item` DISABLE KEYS */;
INSERT INTO `branch_item` (`b_code`,`i_code`,`i_quantity`) VALUES 
 ('b10','119',42),
 ('b10','15',19),
 ('b3','15',16),
 ('b10','23',9),
 ('b10','10',102);
/*!40000 ALTER TABLE `branch_item` ENABLE KEYS */;


--
-- Definition of table `item_detail`
--

DROP TABLE IF EXISTS `item_detail`;
CREATE TABLE `item_detail` (
  `i_code` varchar(20) NOT NULL,
  `i_name` varchar(45) NOT NULL,
  `i_company` varchar(20) NOT NULL,
  `i_price` int(20) unsigned NOT NULL,
  PRIMARY KEY (`i_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_detail`
--

/*!40000 ALTER TABLE `item_detail` DISABLE KEYS */;
INSERT INTO `item_detail` (`i_code`,`i_name`,`i_company`,`i_price`) VALUES 
 ('10','f9','gfive',1800),
 ('11','6681','nokia',7500),
 ('112','w705','sony',10599),
 ('119','3110','nokia',3500),
 ('123','5130','nokia',4599),
 ('15','n86','nokia',14000),
 ('20','5320 music','nokia',9990),
 ('200','3310','samsang',3550),
 ('23','galaxys','samsang',28000),
 ('3','5230','nokia',7500),
 ('4','3310','samsung',3530),
 ('5','3200','samsung',3500);
/*!40000 ALTER TABLE `item_detail` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `u_id` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `u_type` varchar(10) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`u_id`,`pwd`,`u_type`) VALUES 
 ('admin','admin','a'),
 ('b10','user','c'),
 ('b2','user','c'),
 ('b3','user','c'),
 ('b45','afdfaf','c'),
 ('b6','sdfsf','c'),
 ('b7','jayvik','c'),
 ('jayvik','jayvik','a');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
