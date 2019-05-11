-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_bookstore
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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authors` (
  `id_author` int(11) NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_author`),
  UNIQUE KEY `id_author` (`id_author`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Adam','Mickiewicz'),(2,'Juliusz','Słowacki'),(3,'William','Shakespeare'),(4,'Jan','Kochanowski'),(5,'Aleksander','Fredro'),(6,'Henryk','Sienkiewicz'),(7,'Bolesław','Prus'),(8,'Stanisław','Wyspiański'),(9,'Lew','Tołstoj'),(10,'J.R.R.','Tolkien'),(11,'J.K.','Rowling'),(12,'Unni','Lindell');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_author`
--

DROP TABLE IF EXISTS `book_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book_author` (
  `id_author` int(11) NOT NULL,
  `id_book` int(11) NOT NULL,
  PRIMARY KEY (`id_author`,`id_book`),
  KEY `id_book` (`id_book`),
  CONSTRAINT `id_author` FOREIGN KEY (`id_author`) REFERENCES `authors` (`id_author`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_book` FOREIGN KEY (`id_book`) REFERENCES `books` (`id_book`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_author`
--

LOCK TABLES `book_author` WRITE;
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
INSERT INTO `book_author` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9),(4,10),(5,11),(6,12),(6,13),(6,14),(6,15),(7,16),(8,17),(9,18),(9,19),(10,20),(10,21),(11,22),(11,23),(11,24),(11,25),(11,26),(11,27),(11,28),(11,29),(12,30),(12,31),(12,32),(1,33);
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_format`
--

DROP TABLE IF EXISTS `book_format`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book_format` (
  `id_format` int(11) NOT NULL,
  `book_format` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_format`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_format`
--

LOCK TABLES `book_format` WRITE;
/*!40000 ALTER TABLE `book_format` DISABLE KEYS */;
INSERT INTO `book_format` VALUES (1,'audiobook'),(2,'e-book'),(3,'książka');
/*!40000 ALTER TABLE `book_format` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `books` (
  `id_book` int(11) NOT NULL,
  `title` varchar(30) DEFAULT NULL,
  `genre` varchar(30) DEFAULT NULL,
  `number_of_pages` int(11) DEFAULT NULL,
  `image` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_book`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Dziady Cz.III','dramat',290,''),(2,'Wybrane Wiersze','poezja',524,''),(3,'Konrad Wallenrod','dramat',243,''),(4,'Kordian, Balladyna','dramat',303,''),(5,'Wybrane Wiersze','poezja',626,''),(6,'Lilla Weneda','dramat',84,''),(7,'Makbet','dramat',158,''),(8,'Romeo i Julia','dramat',135,''),(9,'Hamlet','dramat',229,''),(10,'Fraszki, Pieśni, Treny','liryka',290,''),(11,'Zemsta','dramat',140,''),(12,'W Pustyni i W Puszczy','powieść',462,''),(13,'Quo Vadis','powieść',668,''),(14,'Krzyżacy','powieść',358,''),(15,'Potop','powieść',935,''),(16,'Lalka','powieść',536,''),(17,'Wesele','dramat',232,''),(18,'Noc Listopadowa','dramat',284,''),(19,'Anna Karenina','powieść',908,''),(20,'Wojna i Pokój Tom1','powieść',483,''),(21,'Władca Pierścieni','powieść',1021,''),(22,'Hobbit','powieść',348,''),(23,'Harry Potter i Kamień Filozofi','powieść',326,''),(24,'Harry Potter i Komnata Tajemni','powieść',365,''),(25,'Harry Potter i Więzień Azkaban','powieść',458,''),(26,'Harry Potter i Czara Ognia','powieść',766,''),(27,'Harry Potter i Zakon Feniksa','powieść',954,''),(28,'Harry Potter i Książę Półkrwi','powieść',703,''),(29,'Harry Potter i Insygnia Śmierc','powieść',782,''),(30,'Czerwony Kapturek','kryminał',321,''),(31,'Miodowa Pułapka','kryminał',373,''),(32,'Człowiek Mroku','kryminał',439,''),(33,'Pan Tadeusz','dramat',393,'');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opinions`
--

DROP TABLE IF EXISTS `opinions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `opinions` (
  `id_book` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `opinion` text,
  PRIMARY KEY (`id_book`,`id_user`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `opinions_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id_book`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `opinions_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opinions`
--

LOCK TABLES `opinions` WRITE;
/*!40000 ALTER TABLE `opinions` DISABLE KEYS */;
INSERT INTO `opinions` VALUES (8,3,'Świetna historia o tragicznej miłości!'),(25,5,'Trzecia częćś przygód młodego czarodzieja zachwyca.'),(30,1,'Wciąga fabułą!!');
/*!40000 ALTER TABLE `opinions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_history`
--

DROP TABLE IF EXISTS `order_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_history` (
  `id_book_warehouse` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `purchase_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_book_warehouse`,`id_user`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `order_history_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `order_history_ibfk_2` FOREIGN KEY (`id_book_warehouse`) REFERENCES `warehouse` (`id_book_warehouse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_history`
--

LOCK TABLES `order_history` WRITE;
/*!40000 ALTER TABLE `order_history` DISABLE KEYS */;
INSERT INTO `order_history` VALUES (8,3,'2019-05-07',1,16),(25,5,'2019-05-01',2,47),(30,1,'2019-04-02',1,27);
/*!40000 ALTER TABLE `order_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shopping_cart` (
  `id_book_warehouse` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_book_warehouse`,`id_user`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `shopping_cart_ibfk_1` FOREIGN KEY (`id_book_warehouse`) REFERENCES `warehouse` (`id_book_warehouse`),
  CONSTRAINT `shopping_cart_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
INSERT INTO `shopping_cart` VALUES (8,3,1),(25,5,2),(30,1,1);
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `nation` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `login` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `access_to_comments` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Adrian','Mak','polska','Katowice','Poziomkowa','maczek','lkjuio324','maczek123@gmail.com',1),(2,'Katarzyna','Worek','polska','Gliwice','Kwiatowa','woreczek','mnbpoi159','kworek@gmail.com',1),(3,'Adam','Kruk','polska','Chorzów','Miła','adasko','qwemna356','adam.kruk@gmail.com',1),(4,'Wojciech','Nowak','polska','Katowice','Ptasia','wojnow','kjulop659','wojtus@gmail.com',1),(5,'Tomasz','Wolny','polska','Ruda Śląska','Kolejowa','tomasz125','asdert145','tomasz125@gmail.com',1),(6,'Magdalena','Czips','polska','Katowice','Gliwicka','lays','zxcdsa369','paprykowe@gmail.com',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `warehouse` (
  `id_book_warehouse` int(11) NOT NULL,
  `id_book` int(11) DEFAULT NULL,
  `id_format` int(11) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `discount` decimal(2,0) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `purchase_price` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id_book_warehouse`),
  KEY `id_book` (`id_book`),
  KEY `id_format` (`id_format`),
  CONSTRAINT `warehouse_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id_book`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `warehouse_ibfk_2` FOREIGN KEY (`id_format`) REFERENCES `book_format` (`id_format`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (1,1,3,25.80,0,5,20.80),(2,2,3,36.20,0,6,31.20),(3,3,3,19.30,0,4,14.30),(4,4,3,28.30,0,4,23.80),(5,5,3,40.90,0,2,35.90),(6,6,3,23.90,0,6,18.90),(7,7,3,23.70,0,8,18.70),(8,8,3,21.40,0,10,16.40),(9,9,3,25.60,0,12,20.60),(10,10,3,18.70,0,3,13.70),(11,11,3,8.90,0,2,3.90),(12,12,3,27.50,0,6,22.50),(13,13,3,29.00,0,7,24.00),(14,14,3,28.10,0,10,23.10),(15,15,3,36.60,0,13,31.60),(16,16,3,38.40,0,9,33.40),(17,17,3,21.50,0,34,16.50),(18,18,3,19.70,0,2,14.70),(19,19,3,41.00,0,6,36.00),(20,20,3,30.60,0,8,25.60),(21,21,3,48.40,0,13,43.40),(22,22,3,32.00,0,16,37.00),(23,23,3,26.30,0,8,21.30),(24,24,3,26.90,0,7,21.90),(25,25,3,28.30,0,1,23.30),(26,26,3,29.80,0,3,24.80),(27,27,3,30.70,0,2,25.70),(28,28,3,35.90,0,9,30.90),(29,29,3,33.80,0,9,28.80),(30,30,3,32.20,0,2,27.20),(31,31,3,27.90,0,6,22.90),(32,32,3,27.90,0,4,22.90),(33,33,3,27.90,0,7,27.90),(34,1,2,25.00,0,4,20.00),(35,2,1,32.80,0,6,27.80),(36,3,2,25.00,0,8,20.00),(37,4,2,25.00,0,5,20.00),(38,5,2,25.00,0,4,20.00),(39,6,1,18.90,0,2,13.90),(40,7,1,29.00,0,3,24.00),(41,8,2,25.00,0,2,20.00),(42,9,1,26.00,0,41,21.00),(43,10,2,25.00,0,4,20.00),(44,11,2,25.00,0,15,20.00),(45,12,2,25.00,0,23,20.00),(46,13,1,30.50,0,2,25.50),(47,14,2,25.00,0,33,20.00),(48,15,1,40.30,0,12,35.30),(49,16,2,25.00,0,14,20.00),(50,17,2,25.00,0,8,20.00),(51,18,1,20.00,0,9,15.00),(52,19,2,25.00,0,5,20.00),(53,20,1,25.70,0,3,20.70),(54,21,1,50.00,0,6,45.00),(55,22,1,30.70,0,4,25.70),(56,23,2,25.00,0,15,20.00),(57,24,2,25.00,0,7,20.00),(58,25,2,25.00,0,8,20.00),(59,26,1,29.60,0,4,24.60),(60,27,2,25.00,0,6,20.00),(61,28,1,31.80,0,14,26.80),(62,29,2,25.00,0,18,20.00),(63,30,1,32.70,0,19,27.70),(64,31,2,25.00,0,16,20.00),(65,32,1,26.40,0,14,21.40),(66,33,2,25.00,0,11,20.00);
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-11 17:31:57
