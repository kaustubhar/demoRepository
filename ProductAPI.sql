/*
SQLyog Community Edition- MySQL GUI v6.15
MySQL - 5.7.26-log : Database - demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `demo`;

USE `demo`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `categorie` */

DROP TABLE IF EXISTS `categorie`;

CREATE TABLE `categorie` (
  `categori_id` int(11) NOT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `ccharges` int(11) NOT NULL,
  `cdiscount` int(11) NOT NULL,
  `cgst` int(11) NOT NULL,
  PRIMARY KEY (`categori_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `categorie` */

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `base_price` decimal(19,2) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `delivery_charge` decimal(19,2) DEFAULT NULL,
  `discount` decimal(19,2) DEFAULT NULL,
  `final_price` decimal(19,2) DEFAULT NULL,
  `gst` decimal(19,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `categoriid` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKk8eybcj573btgjah7r4mfxu6x` (`categoriid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`product_id`,`base_price`,`category`,`delivery_charge`,`discount`,`final_price`,`gst`,`name`,`product_type`,`categoriid`) values (1,'45000.00','Electronics','350.00','6750.00','45485.00','6885.00','Lenovo Yoga ','Laptop',NULL),(2,'25000.00','Home Appliances','800.00','5500.00','24980.00','4680.00','LG Washing Machine  ','Washing Machine',NULL),(3,'60000.00','Electronics','350.00','9000.00','60530.00','9180.00','Pavilion  ','Laptop',NULL),(4,'1200.00','Clothing','0.00','480.00','806.40','86.40','US Polo Assn  ','T-Shirt',NULL),(5,'350.00','Furniture','300.00','35.00','671.70','56.70','Neelkamal Been Bag  ','Sofa Set',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
