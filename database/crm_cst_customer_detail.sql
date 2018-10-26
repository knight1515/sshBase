/*
SQLyog v10.2 
MySQL - 5.1.72-community : Database - crm_hibernate
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `cst_customer_detail` */

CREATE TABLE `cst_customer_detail` (
  `cust_id` bigint(32) NOT NULL,
  `cust_region` varchar(64) DEFAULT NULL COMMENT '客户地区',
  `cust_zip` varchar(16) DEFAULT NULL COMMENT '客户邮政编码',
  `cust_address` varchar(128) DEFAULT NULL COMMENT '客户联系地址',
  `cust_fax` varchar(64) DEFAULT NULL COMMENT '客户传真',
  `cust_website` varchar(128) DEFAULT NULL COMMENT '客户网址',
  `cust_licence` varchar(64) DEFAULT NULL COMMENT '客户营业执照注册号',
  `cust_corporation` varchar(64) DEFAULT NULL COMMENT '企业法人',
  `cust_capital` bigint(16) DEFAULT NULL COMMENT '客户注册资金',
  `cust_bank` varchar(512) DEFAULT NULL COMMENT '开户银行及账号',
  `cust_pic` varchar(64) DEFAULT NULL COMMENT '客户资质图片',
  `cust_memo` longtext COMMENT '客户简介',
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
