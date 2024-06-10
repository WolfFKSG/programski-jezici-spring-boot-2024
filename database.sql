-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: example_db
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `uq_course_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Programski Jezici','2024-06-10 12:17:19',NULL,NULL),(2,'Razvoj Softvera','2024-06-10 12:17:19',NULL,NULL),(3,'Strukture podataka i algoritmi','2024-06-10 13:42:31',NULL,NULL),(4,'Cloud computing','2024-06-10 13:42:31',NULL,NULL),(5,'Internet technology and web services','2024-06-10 13:42:31',NULL,NULL),(6,'Security aspects of software and data engineering','2024-06-10 13:42:31',NULL,NULL),(7,'Praktikum sistemi e-poslovanja','2024-06-10 13:42:32',NULL,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `surname` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `indeks` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `study_programme_id` int unsigned NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `uq_student_index` (`indeks`),
  KEY `fk_student_study_programme_idx` (`study_programme_id`),
  CONSTRAINT `fk_student_study_programme` FOREIGN KEY (`study_programme_id`) REFERENCES `study_programme` (`study_programme_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Petar','Kresoja','2019200948',5,'2024-05-25 09:41:13','2024-06-10 11:11:10',NULL),(2,'Petar','Kresoja','2023410087',12,'2024-05-25 10:13:42','2024-06-10 10:50:53',NULL),(3,'Ivan','Ivanovic','2024123123',1,'2024-06-08 21:33:34',NULL,NULL),(4,'Sara','Saric','20191234562323',1,'2024-06-08 21:34:54','2024-06-09 20:17:45',NULL),(5,'Petar','Kresoja','2024785234',1,'2024-06-09 14:20:55',NULL,'2024-06-09 15:28:53'),(8,'Pero','Nikic','2024785235',1,'2024-06-09 14:27:39','2024-06-09 14:58:47','2024-06-09 16:39:15'),(9,'Ivan','Ivanovic','2024561234',1,'2024-06-09 16:31:29',NULL,'2024-06-09 16:38:44'),(10,'Primer','Prezime','20131234566',6,'2024-06-10 11:21:07','2024-06-10 11:21:28',NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_course` (
  `student_course_id` int unsigned NOT NULL AUTO_INCREMENT,
  `student_id` int unsigned NOT NULL,
  `course_id` int unsigned NOT NULL,
  PRIMARY KEY (`student_course_id`),
  KEY `fk_student_course_student_idx` (`student_id`),
  KEY `fk_student_course_course_idx` (`course_id`),
  CONSTRAINT `fk_student_course_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_student_course_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` VALUES (3,3,2),(11,1,1),(12,1,2),(13,1,5),(14,1,3);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_programme`
--

DROP TABLE IF EXISTS `study_programme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_programme` (
  `study_programme_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`study_programme_id`),
  UNIQUE KEY `uq_sp_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_programme`
--

LOCK TABLES `study_programme` WRITE;
/*!40000 ALTER TABLE `study_programme` DISABLE KEYS */;
INSERT INTO `study_programme` VALUES (1,'Racunarske Nauke','2024-06-09 17:55:05',NULL,NULL),(2,'Informacione tehnologije','2024-06-09 17:55:05',NULL,NULL),(3,'Softversko i Informaciono inzenjerstvo','2024-06-09 17:55:05',NULL,NULL),(4,'Anglistika','2024-06-09 17:57:56',NULL,NULL),(5,'Menadzment u turizmu i hotelijerstvu','2024-06-09 17:57:56',NULL,NULL),(6,'Poslovna ekonomija','2024-06-09 17:57:56',NULL,NULL),(7,'Vestacka inteligencija','2024-06-09 17:57:56',NULL,NULL),(8,'Farmacija','2024-06-09 17:57:56',NULL,NULL),(9,'Menadzment u sportu','2024-06-09 17:57:56',NULL,NULL),(10,'Fizicko vaspitanje i sport','2024-06-09 17:57:56',NULL,NULL),(11,'Psihologija','2024-06-09 17:57:56',NULL,NULL),(12,'Savremene informacione tehnologije','2024-06-09 19:53:20','2024-06-09 20:26:58',NULL);
/*!40000 ALTER TABLE `study_programme` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-10 17:33:21
