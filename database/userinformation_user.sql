-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: userinformation
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) DEFAULT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nguyen van a','0123456789','staff'),(2,'abc','0199999','manager'),(3,'nguyen hoang long','098195245','manager'),(4,'quach quynh nhu','093456789','employee'),(5,'asdq3','t525624','staff'),(6,'new employee','0123','staff'),(7,'another','356908','staff'),(8,'hmkdukfhm','3455','staff'),(9,'hihihi','92486','staff'),(10,'aaaa','11111','staff'),(11,'ttt','333','staff'),(12,'new','565','staff'),(13,'kkk','0123','staff'),(14,'bbb','1','staff'),(15,'mmmm','0987','staff'),(16,'new again','10394','staff'),(17,'haizz','324','staff'),(18,'asdasdasdasd','33','sdaf'),(19,'519','519','519'),(20,'qweqweqweqweqwe','14','wqe'),(21,'paul','013401349','manager'),(22,'bien','09352958','adogha'),(23,'duong','0210648014','odfhaogh'),(24,'bbcvcv','245','sdfdsg'),(25,'519','519','519'),(26,'1','1','1'),(27,'2','2','2'),(28,'3','3','3'),(29,'4','4','4'),(30,'5','5','5'),(31,'6','6','6'),(32,'7','7','7'),(33,'8','8','8'),(34,'9','9','9'),(35,'10','10','10'),(36,'11','11','11'),(37,'12','12','12'),(38,'13','13','13'),(39,'14','14','14'),(40,'15','15','15'),(41,'16','16','16');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-25 22:05:12
