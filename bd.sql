-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
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
  `id_author` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_author`),
  UNIQUE KEY `id_author` (`id_author`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Adam','Mickiewicz'),(2,'Juliusz','Słowacki'),(3,'William','Shakespeare'),(4,'Jan','Kochanowski'),(5,'Aleksander','Fredro'),(6,'Henryk','Sienkiewicz'),(7,'Bolesław','Prus'),(8,'Stanisław','Wyspiański'),(9,'Lew','Tołstoj'),(10,'J.R.R.','Tolkien'),(11,'J.K.','Rowling'),(12,'Unni','Lindell'),(20,'a','b'),(21,'a','a'),(22,'m','m'),(23,'a','m'),(25,'d','d');
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
INSERT INTO `book_author` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9),(4,10),(5,11),(6,12),(6,13),(6,14),(6,15),(7,16),(8,17),(9,18),(9,19),(10,20),(10,21),(11,22),(11,23),(11,24),(11,25),(11,26),(11,27),(11,28),(11,29),(12,30),(12,31),(12,32),(1,33),(20,68),(25,74);
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
  `id_book` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `genre` varchar(30) DEFAULT NULL,
  `number_of_pages` int(11) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id_book`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Dziady Cz.III','dramat',290,'https://3.allegroimg.com/s512/065f87/8122636c42848aee2b029e1def03/Adam-Mickiewicz-Dziady-czesc-III',NULL),(2,'Wybrane Wiersze','poezja',524,'http://ksiegarnia.arcana.pl/144-large_default/wojciech-wencel-wiersze-wybrane.jpg',NULL),(3,'Konrad Wallenrod','dramat',243,'https://ecsmedia.pl/c/konrad-wallenrod-w-iext38867309.jpg',NULL),(4,'Kordian, Balladyna','dramat',303,'https://ecsmedia.pl/c/balladyna-kordian-b-iext47800372.jpg',NULL),(5,'Wybrane Wiersze','poezja',626,'http://www.tom1.pl/349-large_default/lilla-weneda-slowacki-juliusz.jpg',NULL),(6,'Lilla Weneda','dramat',84,'http://www.tom1.pl/349-large_default/lilla-weneda-slowacki-juliusz.jpg',NULL),(7,'Makbet','dramat',158,'https://6.allegroimg.com/s512/000580/64d9bf274253b6abe7a52e5b7726/Makbet-William-Szekspir/Makbet-William-Szekspir',NULL),(8,'Romeo i Julia','dramat',135,'https://image.ceneostatic.pl/data/products/49439472/i-romeo-i-julia.jpg',NULL),(9,'Hamlet','dramat',229,'http://2.bp.blogspot.com/--MiYmUKB3Sk/UWgMxzmTiDI/AAAAAAAACLY/c4ykrvCK-M0/s1600/51cy7hZXHDL.jpg',NULL),(10,'Fraszki, Pieśni, Treny','liryka',290,'https://image.ceneostatic.pl/data/products/24163/i-fraszki-piesni-treny.jpg',NULL),(11,'Zemsta','dramat',140,'https://ecsmedia.pl/c/zemsta-b-iext47974845.jpg',NULL),(12,'W Pustyni i W Puszczy','powieść',462,'https://vignette.wikia.nocookie.net/ksiazkopedia/images/8/84/W_pustyni_i_puszczy.jpg/revision/latest?cb=20130213123252&path-prefix=pl',NULL),(13,'Quo Vadis','powieść',668,'https://zst.chelm.pl/wp-content/uploads/2016/09/quo-vadis-henryk-sienkie_5524.jpg',NULL),(14,'Krzyżacy','powieść',358,'https://ecsmedia.pl/c/krzyzacy-henryka-sienkiewicza-streszczenie-analiza-interpretacja-b-iext43264059.jpg',NULL),(15,'Potop','powieść',935,'https://1.allegroimg.com/s512/033af7/927804c443058c698aa498a8c971/Sienkiewicz-Henryk-Potop-Agencja-Elipsa',NULL),(16,'Lalka','powieść',536,'https://ecsmedia.pl/c/lalka-w-iext39898101.jpg',NULL),(17,'Wesele','dramat',232,'https://b.allegroimg.com/original/0c24eb/41efb5ef4a1eb31d9e53024309cb',NULL),(18,'Noc Listopadowa','dramat',284,'https://wolnelektury.pl/media/book/cover/noc-listopadowa.jpg',NULL),(19,'Anna Karenina','powieść',908,'https://images.penguinrandomhouse.com/cover/9780679783305',NULL),(20,'Wojna i Pokój Tom1','powieść',483,'http://s.lubimyczytac.pl/upload/books/4823000/4823521/675807-352x500.jpg',NULL),(21,'Władca Pierścieni','powieść',1021,'http://cyfroteka.pl/catalog/ebooki/00611084/006/cover/1/e_702f.jpg',NULL),(22,'Hobbit','powieść',348,'https://ssl-gfx.filmweb.pl/po/98/67/469867/7585361.3.jpg',NULL),(23,'Harry Potter i Kamień Filozofi','powieść',326,'https://vignette.wikia.nocookie.net/harrypotter/images/8/8e/HarryPotteriKamie%C5%84FilozoficznyKSIAZKA_%28by_Urbanski97%29.jpg/revision/latest?cb=20130105213114&path-prefix=pl',NULL),(24,'Harry Potter i Komnata Tajemni','powieść',365,'https://vignette.wikia.nocookie.net/harrypotter/images/2/2e/HarryPotteriKomnataTajemnicKSIAZKA_%28by_Urbanski97%29.jpg/revision/latest?cb=20130105213206&path-prefix=pl',NULL),(25,'Harry Potter i Więzień Azkaban','powieść',458,'https://vignette.wikia.nocookie.net/harrypotter/images/f/fa/HarryPotteriWi%C4%99zie%C5%84AzkabanuKSIAZKA_%28by_Urbanski97%29.jpg/revision/latest?cb=20130105213254&path-prefix=pl',NULL),(26,'Harry Potter i Czara Ognia','powieść',766,'https://image.ceneostatic.pl/data/products/10380836/i-harry-potter-i-czara-ognia.jpg',NULL),(27,'Harry Potter i Zakon Feniksa','powieść',954,'https://image.ceneostatic.pl/data/products/18159/i-harry-potter-i-zakon-feniksa.jpg',NULL),(28,'Harry Potter i Książę Półkrwi','powieść',703,'https://media.merlin.pl/media/original/000/004/314/56babdce997ab.jpg',NULL),(29,'Harry Potter i Insygnia Śmierc','powieść',782,'https://ecsmedia.pl/c/harry-potter-i-insygnia-smierci-tom-7-b-iext44138795.jpg',NULL),(30,'Czerwony Kapturek','kryminał',321,'http://s.lubimyczytac.pl/upload/books/291000/291133/446448-352x500.jpg',NULL),(31,'Miodowa Pułapka','kryminał',373,'https://www.czarnaowca.pl/files/elibri/694738320.jpg',NULL),(32,'Człowiek Mroku','kryminał',439,'http://s.lubimyczytac.pl/upload/books/204000/204733/221862-352x500.jpg',NULL),(33,'Pan Tadeusz','dramat',393,'https://image.ceneostatic.pl/data/products/109070/i-pan-tadeusz.jpg',NULL),(68,'Puchacz','56',56,'https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Eagle.owl.arp.750pix.jpg/250px-Eagle.owl.arp.750pix.jpg','56'),(74,'d','5',5,'d','5');
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
  `reported` int(11) DEFAULT '0',
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
INSERT INTO `opinions` VALUES (8,3,'Świetna historia o tragicznej miłości!',0),(19,1,'ba',1),(25,3,'a',0),(25,4,'b',1),(25,5,'Trzecia częćś przygód młodego czarodzieja zachwyca.',0),(25,6,'c',0);
/*!40000 ALTER TABLE `opinions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_history`
--

DROP TABLE IF EXISTS `order_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_history` (
  `id_order_history` int(11) NOT NULL AUTO_INCREMENT,
  `id_book_warehouse` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `purchase_price` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id_order_history`),
  KEY `id_user_idx` (`id_user`),
  KEY `id_book_warehouse_idx` (`id_book_warehouse`),
  CONSTRAINT `id_book_warehouse` FOREIGN KEY (`id_book_warehouse`) REFERENCES `warehouse` (`id_book_warehouse`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_history`
--

LOCK TABLES `order_history` WRITE;
/*!40000 ALTER TABLE `order_history` DISABLE KEYS */;
INSERT INTO `order_history` VALUES (1,19,14,'2019-06-05',1,41.00),(2,42,14,'2019-06-05',10,260.00),(11,30,14,'2019-06-11',2,64.00),(12,30,14,'2019-06-11',1,32.00),(13,30,14,'2019-06-11',1,32.00),(17,19,14,'2019-06-11',5,205.00),(18,19,14,'2019-06-11',1,41.00),(19,19,14,'2019-06-11',1,41.00),(20,19,14,'2019-06-11',1,41.00),(21,30,14,'2019-06-11',1,32.00),(22,30,14,'2019-06-11',4,129.00),(23,30,14,'2019-06-11',1,32.00),(24,30,14,'2019-06-11',1,32.00),(25,30,14,'2019-06-11',5,161.00),(26,30,14,'2019-06-11',1,32.00),(27,30,14,'2019-06-11',1,32.00),(28,30,14,'2019-06-11',5,161.00),(29,77,14,'2019-06-11',1,5.00);
/*!40000 ALTER TABLE `order_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_role`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'user'),(2,'worker');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
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
  CONSTRAINT `shopping_cart_ibfk_1` FOREIGN KEY (`id_book_warehouse`) REFERENCES `warehouse` (`id_book_warehouse`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shopping_cart_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `nation` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `access_to_comments` tinyint(1) NOT NULL,
  `id_role` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `id_role_idx` (`id_role`),
  CONSTRAINT `id_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Adrian','Mak','polska','Katowice','Poziomkowa','maczek','lkjuio324','maczek123@gmail.com',0,1),(2,'Katarzyna','Worek','polska','Gliwice','Kwiatowa','woreczek','mnbpoi159','kworek@gmail.com',1,1),(3,'Adam','Kruk','polska','Chorzów','Miła','adasko','qwemna356','adam.kruk@gmail.com',1,1),(4,'Wojciech','Nowak','polska','Katowice','Ptasia','wojnow','kjulop659','wojtus@gmail.com',1,1),(5,'Tomasz','Wolny','polska','Ruda Śląska','Kolejowa','tomasz125','asdert145','tomasz125@gmail.com',1,1),(6,'Magdalena','Czips','polska','Katowice','Gliwicka','lays','zxcdsa369','paprykowe@gmail.com',1,1),(11,'marc','dud','pol','kat','paistow','stelfos','admin','m@d.pl',1,1),(12,'Franciszek','Berger','Polska','Bieruń','Torowa 21','Franek','admin','bergerfranek@gmail.com',1,1),(14,'admin','admin','ad','ad','ad','admin','admin','ad@ad.ad',1,2),(24,'x','x','x','x','x','x','x','x@x.pl',1,1),(25,'z','z','z','z','z','z','z','z@z.z',1,1),(26,'aac','aac','aac','aac','aac','admin1','abc','a@a.pl',1,1),(27,'mmmmmmmmmmmmmmmmmmmmmmmmmmmmmm','mmmmmmmmmmm','mmmmmmmmmmmmmmmmmmmm','mmmmmmmmmmmmmmmmmmmmmmm','mmmmmmmmmmmmmmmmmmmmmmmmmmmm','llllllllllllllllllllllllllllll','pppppppppppppppppppppppppppppp','mmmmmmmmmmmmm@mmmmmmmmmmmmmm.p',1,1),(28,'aaa','aaa','aaa','aaa','aaa','aaa','aaa','a@a.p',1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `warehouse` (
  `id_book_warehouse` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `id_format` int(11) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `discount` decimal(2,0) DEFAULT NULL,
  `quantity` int(11) unsigned DEFAULT NULL,
  `purchase_price` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id_book_warehouse`),
  KEY `id_format` (`id_format`),
  KEY `warehouse_ibfk_1_idx` (`id_book`),
  CONSTRAINT `warehouse_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id_book`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `warehouse_ibfk_2` FOREIGN KEY (`id_format`) REFERENCES `book_format` (`id_format`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (1,1,3,25.80,0,5,20.80),(2,2,3,36.20,0,6,31.20),(3,3,3,19.30,0,4,14.30),(4,4,3,28.30,0,4,23.80),(5,5,3,40.90,0,2,35.90),(6,6,3,23.90,0,6,18.90),(7,7,3,23.70,0,8,18.70),(8,8,3,21.40,0,10,16.40),(9,9,3,25.60,0,12,20.60),(10,10,3,18.70,0,3,13.70),(11,11,3,8.90,0,2,3.90),(12,12,3,27.50,0,6,22.50),(13,13,3,29.00,0,7,24.00),(14,14,3,28.10,0,10,23.10),(15,15,3,36.60,0,13,31.60),(16,16,3,38.40,0,9,33.40),(17,17,3,21.50,0,34,16.50),(18,18,3,19.70,0,2,14.70),(19,19,3,41.00,0,5,36.00),(20,20,3,30.60,0,8,25.60),(21,21,3,48.40,0,13,43.40),(22,22,3,32.00,0,16,37.00),(23,23,3,26.30,0,8,21.30),(24,24,3,26.90,0,7,21.90),(25,25,3,28.30,0,1,23.30),(26,26,3,29.80,0,3,24.80),(27,27,3,30.70,0,2,25.70),(28,28,3,35.90,0,9,30.90),(29,29,3,33.80,0,9,28.80),(30,30,3,32.20,0,0,27.20),(31,31,3,27.90,0,6,22.90),(32,32,3,27.90,0,4,22.90),(33,33,3,27.90,0,7,27.90),(34,1,2,25.00,0,4,20.00),(35,2,1,32.80,0,6,27.80),(36,3,2,25.00,0,8,20.00),(37,4,2,25.00,0,5,20.00),(38,5,2,25.00,0,4,20.00),(39,6,1,18.90,0,2,13.90),(40,7,1,29.00,0,3,24.00),(41,8,2,25.00,0,2,20.00),(42,9,1,26.00,0,31,21.00),(43,10,2,25.00,0,4,20.00),(44,11,2,25.00,0,15,20.00),(45,12,2,25.00,0,23,20.00),(46,13,1,30.50,0,2,25.50),(47,14,2,25.00,0,33,20.00),(48,15,1,40.30,0,12,35.30),(49,16,2,25.00,0,14,20.00),(50,17,2,25.00,0,8,20.00),(51,18,1,20.00,0,9,15.00),(52,19,2,25.00,0,5,20.00),(53,20,1,25.70,0,3,20.70),(54,21,1,50.00,0,6,45.00),(55,22,1,30.70,0,4,25.70),(56,23,2,25.00,0,15,20.00),(57,24,2,25.00,0,7,20.00),(58,25,2,25.00,0,8,20.00),(59,26,1,29.60,0,4,24.60),(60,27,2,25.00,0,6,20.00),(61,28,1,31.80,0,14,26.80),(62,29,2,25.00,0,18,20.00),(63,30,1,32.70,0,19,27.70),(64,31,2,25.00,0,16,20.00),(65,32,1,26.40,0,14,21.40),(66,33,2,25.00,0,11,20.00),(71,68,2,56.00,56,56,56.00),(77,74,3,5.00,0,4,5.00);
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bookstore'
--

--
-- Dumping routines for database 'bookstore'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 19:13:56
