-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: data_ltw
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `baiviet`
--

DROP TABLE IF EXISTS `baiviet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baiviet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tieuDe` varchar(500) NOT NULL,
  `tomTat` text NOT NULL,
  `noiDung` text NOT NULL,
  `theLoai_id` int NOT NULL,
  `nguoiTao` varchar(50) DEFAULT NULL,
  `ngayTao` timestamp NULL DEFAULT NULL,
  `nguoiSua` varchar(50) DEFAULT NULL,
  `ngaySua` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bv_tl` (`theLoai_id`),
  CONSTRAINT `fk_bv_tl` FOREIGN KEY (`theLoai_id`) REFERENCES `theloai` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baiviet`
--

LOCK TABLES `baiviet` WRITE;
/*!40000 ALTER TABLE `baiviet` DISABLE KEYS */;
INSERT INTO `baiviet` VALUES (3,'test','test','test',1,'test','2022-06-07 09:02:18',NULL,NULL);
/*!40000 ALTER TABLE `baiviet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `quyen` varchar(20) NOT NULL,
  `trangThai` tinyint(1) NOT NULL DEFAULT '1',
  `nguoiTao` varchar(50) NOT NULL,
  `ngayTao` timestamp NULL DEFAULT NULL,
  `nguoiSua` varchar(50) DEFAULT NULL,
  `ngaySua` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES (1,'admin','admin','123456','ADMIN',1,'admin',NULL,NULL,NULL),(2,'user','user','1234567','USER',1,'user','2022-06-07 10:11:34',NULL,NULL);
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theloai`
--

DROP TABLE IF EXISTS `theloai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theloai` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(50) NOT NULL,
  `ma` varchar(50) NOT NULL,
  `nguoiTao` varchar(50) DEFAULT NULL,
  `ngayTao` timestamp NULL DEFAULT NULL,
  `nguoiSua` varchar(50) DEFAULT NULL,
  `ngaySua` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theloai`
--

LOCK TABLES `theloai` WRITE;
/*!40000 ALTER TABLE `theloai` DISABLE KEYS */;
INSERT INTO `theloai` VALUES (1,'Thể thao','THETHAO',NULL,NULL,NULL,NULL),(2,'Giáo dục','GIAODUC',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `theloai` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-14  8:48:37
