-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: database_qlsinhvien
-- ------------------------------------------------------
-- Server version	8.0.21
-- Table structure for table `class`

DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `chucVu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int NOT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `teacher` WRITE;


