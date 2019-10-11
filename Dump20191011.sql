-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: wallet_kurs
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (15),(15),(15),(15);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_account`
--

DROP TABLE IF EXISTS `tbl_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_account` (
  `account_number` varchar(255) NOT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `open_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `customer_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account_number`),
  KEY `FK1qtxjngumxldo0gyk2bvlijmh` (`code`),
  KEY `FKib58ca58f0hem9d2t2gt7fjvb` (`customer_number`),
  CONSTRAINT `FK1qtxjngumxldo0gyk2bvlijmh` FOREIGN KEY (`code`) REFERENCES `tbl_account_type` (`code`),
  CONSTRAINT `FKib58ca58f0hem9d2t2gt7fjvb` FOREIGN KEY (`customer_number`) REFERENCES `tbl_customer` (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_account`
--

LOCK TABLES `tbl_account` WRITE;
/*!40000 ALTER TABLE `tbl_account` DISABLE KEYS */;
INSERT INTO `tbl_account` VALUES ('ACC-001','fajri',2000,'2019-06-18 14:13:34.539000','001','CS-001'),('ACC-002','fajri 2',35450,'2019-06-18 14:13:47.239000','002','CS-001'),('ACC-003','tes1',10000,'2019-06-19 07:37:06.114000','001','CS-002'),('ACC-004','tes2',9856,'2019-06-19 07:37:33.288000','002','CS-002');
/*!40000 ALTER TABLE `tbl_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_account_type`
--

DROP TABLE IF EXISTS `tbl_account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_account_type` (
  `code` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_account_type`
--

LOCK TABLES `tbl_account_type` WRITE;
/*!40000 ALTER TABLE `tbl_account_type` DISABLE KEYS */;
INSERT INTO `tbl_account_type` VALUES ('001','Main'),('002','Virtual');
/*!40000 ALTER TABLE `tbl_account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_customer` (
  `customer_number` varchar(255) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mother_name` varchar(255) DEFAULT NULL,
  `nik` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer`
--

LOCK TABLES `tbl_customer` WRITE;
/*!40000 ALTER TABLE `tbl_customer` DISABLE KEYS */;
INSERT INTO `tbl_customer` VALUES ('CS-001','2019-06-18','a@a.com','fajri','pria','alfaritsi','haah','123','202cb962ac59075b964b07152d234b70'),('CS-002','2019-06-19','fajri.saiko@gmail.com','fajri','pria','alfaritsi','mother','12','202cb962ac59075b964b07152d234b70');
/*!40000 ALTER TABLE `tbl_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_exchange`
--

DROP TABLE IF EXISTS `tbl_exchange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_exchange` (
  `rate_id` int(11) NOT NULL,
  `buy` double DEFAULT NULL,
  `ccy1` varchar(255) DEFAULT NULL,
  `ccy2` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `sell` double DEFAULT NULL,
  PRIMARY KEY (`rate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_exchange`
--

LOCK TABLES `tbl_exchange` WRITE;
/*!40000 ALTER TABLE `tbl_exchange` DISABLE KEYS */;
INSERT INTO `tbl_exchange` VALUES (1,14262,'IDR','USD','2019-06-18 14:09:52.000000',14406),(2,13200,'IDR','USD','2019-06-18 14:40:09.000000',14410),(5,14262,'IDR','USD','2019-06-19 03:29:39.000000',14406),(6,13100,'IDR','USD','2019-06-19 07:05:39.000000',13200),(9,14262,'IDR','USD','2019-06-19 07:06:48.000000',14406),(13,14200,'IDR','USD','2019-06-19 13:00:13.000000',14342),(14,14165,'IDR','USD','2019-06-20 13:00:35.000000',14307);
/*!40000 ALTER TABLE `tbl_exchange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_outstanding`
--

DROP TABLE IF EXISTS `tbl_outstanding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_outstanding` (
  `id` int(11) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `outstanding` double DEFAULT NULL,
  `trader_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcx594ygukw929qcngabekx68q` (`trader_id`),
  CONSTRAINT `FKcx594ygukw929qcngabekx68q` FOREIGN KEY (`trader_id`) REFERENCES `tbl_trading` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_outstanding`
--

LOCK TABLES `tbl_outstanding` WRITE;
/*!40000 ALTER TABLE `tbl_outstanding` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_outstanding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_trading`
--

DROP TABLE IF EXISTS `tbl_trading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_trading` (
  `id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `ccy` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `income` double DEFAULT NULL,
  `sisa` double DEFAULT NULL,
  `trading_id` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `rate_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg52vees6h7xfwbdli2nxraogm` (`rate_id`),
  CONSTRAINT `FKg52vees6h7xfwbdli2nxraogm` FOREIGN KEY (`rate_id`) REFERENCES `tbl_exchange` (`rate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_trading`
--

LOCK TABLES `tbl_trading` WRITE;
/*!40000 ALTER TABLE `tbl_trading` DISABLE KEYS */;
INSERT INTO `tbl_trading` VALUES (1,4,'USD','2019-06-18 00:00:00.000000',NULL,4,'cs1','b',1),(2,5,'USD','2019-06-18 00:00:00.000000',NULL,5,'cs1','b',1),(3,4,'USD','2019-06-18 00:00:00.000000',NULL,6,'cs2','b',1),(6,1,'USD','2019-06-19 06:27:01.557000',NULL,0,'CS-001','b',5),(7,1,'USD','2019-06-19 06:31:51.055000',NULL,1,'CS-001','b',5),(8,1,'USD','2019-06-19 06:35:30.341000',0,NULL,'CS-001','s',5),(10,1,'USD','2019-06-19 07:38:39.372000',NULL,0,'CS-002','b',9),(11,1,'USD','2019-06-19 07:39:52.462000',0,NULL,'CS-002','s',9);
/*!40000 ALTER TABLE `tbl_trading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_transaction`
--

DROP TABLE IF EXISTS `tbl_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_transaction` (
  `transaction_id` varchar(255) NOT NULL,
  `account_number_credit` varchar(255) DEFAULT NULL,
  `account_number_debit` varchar(255) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `transaction_type_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FKqtnpqao8qfg4adsyas4yhd53i` (`transaction_type_id`),
  CONSTRAINT `FKqtnpqao8qfg4adsyas4yhd53i` FOREIGN KEY (`transaction_type_id`) REFERENCES `tbl_transaction_type` (`transaction_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_transaction`
--

LOCK TABLES `tbl_transaction` WRITE;
/*!40000 ALTER TABLE `tbl_transaction` DISABLE KEYS */;
INSERT INTO `tbl_transaction` VALUES ('TRX-001','0','ACC-001',0,'2019-06-18 14:13:34.542000',NULL,'006'),('TRX-002','0','ACC-002',0,'2019-06-18 14:13:47.239000',NULL,'006'),('TRX-003','ACC-001','ACC-',2000,'2019-06-19 05:58:28.211000',NULL,'002'),('TRX-004','ACC-002','ACC-',50000,'2019-06-19 06:25:24.236000',NULL,'002'),('TRX-005','0','ACC-002',35594,'2019-06-19 06:27:01.799000',NULL,'004'),('TRX-006','0','ACC-002',21188,'2019-06-19 06:31:51.283000',NULL,'004'),('TRX-007','ACC-002','0',35450,'2019-06-19 06:35:30.421000',NULL,'005'),('TRX-008','0','ACC-003',0,'2019-06-19 07:37:06.115000',NULL,'006'),('TRX-009','0','ACC-004',0,'2019-06-19 07:37:33.288000',NULL,'006'),('TRX-010','ACC-004','ACC-',20000,'2019-06-19 07:38:18.129000',NULL,'002'),('TRX-011','0','ACC-004',5594,'2019-06-19 07:38:39.513000',NULL,'004'),('TRX-012','ACC-004','0',19856,'2019-06-19 07:39:52.617000',NULL,'005'),('TRX-013','ACC-003','ACC-004',10000,'2019-06-19 07:40:28.479000',NULL,'001');
/*!40000 ALTER TABLE `tbl_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_transaction_type`
--

DROP TABLE IF EXISTS `tbl_transaction_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_transaction_type` (
  `transaction_type_id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_transaction_type`
--

LOCK TABLES `tbl_transaction_type` WRITE;
/*!40000 ALTER TABLE `tbl_transaction_type` DISABLE KEYS */;
INSERT INTO `tbl_transaction_type` VALUES ('001','Transfer'),('002','Top Up Account'),('003','Top Up Wallet'),('004','Buy Dollar'),('005','Sell Dollar'),('006','Open Account');
/*!40000 ALTER TABLE `tbl_transaction_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_wallet`
--

DROP TABLE IF EXISTS `tbl_wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_wallet` (
  `wallet_id` varchar(255) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `customer_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wallet_id`),
  KEY `FKruyrbn2nv1xgn6a7ih2knl4lc` (`customer_number`),
  CONSTRAINT `FKruyrbn2nv1xgn6a7ih2knl4lc` FOREIGN KEY (`customer_number`) REFERENCES `tbl_customer` (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_wallet`
--

LOCK TABLES `tbl_wallet` WRITE;
/*!40000 ALTER TABLE `tbl_wallet` DISABLE KEYS */;
INSERT INTO `tbl_wallet` VALUES ('W-001','2019-06-18 14:14:25.925000','OVO','active','CS-001'),('W-002','2019-06-18 14:14:45.350000','M-TIX','active','CS-001'),('W-003','2019-06-19 07:41:04.185000','teswalet','active','CS-002');
/*!40000 ALTER TABLE `tbl_wallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_wallet_account`
--

DROP TABLE IF EXISTS `tbl_wallet_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_wallet_account` (
  `wallet_account_id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `wallet_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wallet_account_id`),
  KEY `FKhdfhygk8gd9ihy7cdhl94evvc` (`account_number`),
  KEY `FK369gugkv068cf9vkrigkvj6rm` (`wallet_id`),
  CONSTRAINT `FK369gugkv068cf9vkrigkvj6rm` FOREIGN KEY (`wallet_id`) REFERENCES `tbl_wallet` (`wallet_id`),
  CONSTRAINT `FKhdfhygk8gd9ihy7cdhl94evvc` FOREIGN KEY (`account_number`) REFERENCES `tbl_account` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_wallet_account`
--

LOCK TABLES `tbl_wallet_account` WRITE;
/*!40000 ALTER TABLE `tbl_wallet_account` DISABLE KEYS */;
INSERT INTO `tbl_wallet_account` VALUES (2,'active','ACC-001','W-001'),(3,'active','ACC-001','W-002'),(4,'active','ACC-001','W-001'),(12,'active','ACC-003','W-003');
/*!40000 ALTER TABLE `tbl_wallet_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-11 19:38:03
