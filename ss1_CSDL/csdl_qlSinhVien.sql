DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `chucVu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `class` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int NOT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `teacher` WRITE;


