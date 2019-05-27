CREATE DATABASE  IF NOT EXISTS `wallet_kurs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `wallet_kurs`;
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
INSERT INTO `hibernate_sequence` VALUES (1),(1);
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
  `balance` float DEFAULT NULL,
  `open_date` date DEFAULT NULL,
  `account_type_id` int(11) DEFAULT NULL,
  `customer_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account_number`),
  KEY `FKi5qcnysnoqm9xmnfq5xqru8l1` (`account_type_id`),
  KEY `FKib58ca58f0hem9d2t2gt7fjvb` (`customer_number`),
  CONSTRAINT `FKi5qcnysnoqm9xmnfq5xqru8l1` FOREIGN KEY (`account_type_id`) REFERENCES `tbl_account_type` (`account_type_id`),
  CONSTRAINT `FKib58ca58f0hem9d2t2gt7fjvb` FOREIGN KEY (`customer_number`) REFERENCES `tbl_customer` (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_account`
--

LOCK TABLES `tbl_account` WRITE;
/*!40000 ALTER TABLE `tbl_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_account_type`
--

DROP TABLE IF EXISTS `tbl_account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_account_type` (
  `account_type_id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_account_type`
--

LOCK TABLES `tbl_account_type` WRITE;
/*!40000 ALTER TABLE `tbl_account_type` DISABLE KEYS */;
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
  `buy` float DEFAULT NULL,
  `sell` float DEFAULT NULL,
  PRIMARY KEY (`rate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_exchange`
--

LOCK TABLES `tbl_exchange` WRITE;
/*!40000 ALTER TABLE `tbl_exchange` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_exchange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_trading`
--

DROP TABLE IF EXISTS `tbl_trading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_trading` (
  `trading_id` varchar(255) NOT NULL,
  `amount` float DEFAULT NULL,
  `ccy` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `income` float DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `rate_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`trading_id`),
  KEY `FKg52vees6h7xfwbdli2nxraogm` (`rate_id`),
  CONSTRAINT `FKg52vees6h7xfwbdli2nxraogm` FOREIGN KEY (`rate_id`) REFERENCES `tbl_exchange` (`rate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_trading`
--

LOCK TABLES `tbl_trading` WRITE;
/*!40000 ALTER TABLE `tbl_trading` DISABLE KEYS */;
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
  `amount` float DEFAULT NULL,
  `date` date DEFAULT NULL,
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
  `created_date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
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
/*!40000 ALTER TABLE `tbl_wallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_wallet_account`
--

DROP TABLE IF EXISTS `tbl_wallet_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_wallet_account` (
  `wallet_account_id` varchar(255) NOT NULL,
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
/*!40000 ALTER TABLE `tbl_wallet_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'wallet_kurs'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-27 16:48:57
