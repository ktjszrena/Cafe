-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: localhost    Database: staff
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pftable`
--

DROP TABLE IF EXISTS `pftable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pftable` (
  `date` date DEFAULT NULL,
  `pt` int DEFAULT NULL,
  `ft` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pftable`
--

LOCK TABLES `pftable` WRITE;
/*!40000 ALTER TABLE `pftable` DISABLE KEYS */;
INSERT INTO `pftable` VALUES ('2023-11-16',1,2),('2023-11-15',3,4),('2023-11-17',4,3),('2023-11-18',2,6),('2023-11-19',2,3),('2023-11-20',3,3),('2023-11-21',3,1),('2023-11-22',3,2),('2023-12-01',3,3);
/*!40000 ALTER TABLE `pftable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffavail`
--

DROP TABLE IF EXISTS `staffavail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staffavail` (
  `role` varchar(50) DEFAULT NULL,
  `id` int DEFAULT NULL,
  `days` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffavail`
--

LOCK TABLES `staffavail` WRITE;
/*!40000 ALTER TABLE `staffavail` DISABLE KEYS */;
INSERT INTO `staffavail` VALUES ('Chef',1,'WED, FRI, SAT, '),('Waiter',5,'FRI, SAT, THU, WED, TUE, MON, '),('Waiter',8,'THU, TUE, SAT, '),('Cashier',9,'MON, '),('Chef',10,'SAT, SUN, FRI, '),('Chef',41,'WED, SAT, FRI, '),('Waiter',42,'THU, TUE, MON, SAT, '),('Cashier',44,'TUE, MON, SAT, SUN, '),('Waiter',45,'FRI, WED, MON, SUN, '),('Chef',48,'SAT, THU, TUE, '),('Waiter',50,'WED, THU, FRI, SUN, SAT, '),('Chef',51,'MON, '),('Cashier',54,'THU, SAT, SUN, '),('Waiter',57,'SUN, FRI, MON, TUE, WED, THU, '),('Chef',60,'THU, TUE, '),('Cashier',64,'SUN, SAT, '),('Waiter',100,'WED, ');
/*!40000 ALTER TABLE `staffavail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffshift`
--

DROP TABLE IF EXISTS `staffshift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staffshift` (
  `date` date DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `id` int DEFAULT NULL,
  `approve` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffshift`
--

LOCK TABLES `staffshift` WRITE;
/*!40000 ALTER TABLE `staffshift` DISABLE KEYS */;
INSERT INTO `staffshift` VALUES ('2023-11-18','Waiter',5,3),('2023-11-13','Waiter',5,2),('2023-11-16','Chef',1,0),('2023-11-15','Chef',3,0),('2023-11-20','Waiter',2,0),('2023-11-19','Cashier',2,0),('2023-11-27','Cashier',3,0),('2023-11-20','Chef',3,0),('2023-11-28','Chef',1,0),('2023-11-15','Waiter',2,0),('2023-11-18','Waiter',8,2),('2023-11-23','Waiter',5,3),('2023-11-19','Waiter',42,0),('2023-11-18','Cashier',44,0),('2023-11-19','Waiter',45,0),('2023-11-18','Chef',48,0),('2023-11-27','Waiter',50,0),('2023-11-29','Chef',51,0),('2023-11-02','Waiter',57,0),('2023-11-18','Chef',60,1),('2023-11-21','Cashier',64,0),('2023-11-22','Cashier',64,0),('2023-11-18','Waiter',100,2),('2023-12-01','Waiter',45,1),('2023-12-01','Waiter',5,0);
/*!40000 ALTER TABLE `staffshift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suspendacc`
--

DROP TABLE IF EXISTS `suspendacc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suspendacc` (
  `id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suspendacc`
--

LOCK TABLES `suspendacc` WRITE;
/*!40000 ALTER TABLE `suspendacc` DISABLE KEYS */;
/*!40000 ALTER TABLE `suspendacc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suspendpro`
--

DROP TABLE IF EXISTS `suspendpro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suspendpro` (
  `role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suspendpro`
--

LOCK TABLES `suspendpro` WRITE;
/*!40000 ALTER TABLE `suspendpro` DISABLE KEYS */;
/*!40000 ALTER TABLE `suspendpro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `useraccount` (
  `name` varchar(30) DEFAULT NULL,
  `id` int DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `dob` varchar(15) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `profile` varchar(50) DEFAULT NULL,
  `scope` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccount`
--

LOCK TABLES `useraccount` WRITE;
/*!40000 ALTER TABLE `useraccount` DISABLE KEYS */;
INSERT INTO `useraccount` VALUES ('John Doe',1,'johnpass','28 Dec 1999','John Street','Cafe Staff','Chef'),('Jane Smith',2,'passjane','22 Mar 1990','5678 Sample Avenue, Sample Town, CA 67890','Cafe Manager','Manager'),('Emily Davis',4,'ildavis','05 May 1993','4321 Trial Lane, Trialville, FL 54321','System Admin','Admin'),('Alex Thomson',3,'alexpass','10 Nov 1982','Alex New Address here','Cafe Owner','Owner'),('Brown Michael',5,'passmike','12 Jul 1988','New Address Here ','Cafe Staff','Waiter'),('Sarah Miller',6,'milldruid','08 Feb 1980','2101 Prototype Street, Prototown, GA 21098','Cafe Staff','Cashier'),('Kevin White',1250621202,'hmmpass','30 Sep 1995','3579 Sandbox Road, Sandbox City, WA 87654','Cafe Staff','Waiter'),('Jessica Taylor',8,'jessicapass','08 Jul 2001','6543 Placeholder Lane, Placeholderville, NC 45678','Cafe Staff','Waiter'),('Brian Wilson',9,'brianpass','12 Feb 1994','9876 Dummy Avenue, Dummytown, MI 32109','Cafe Staff','Cashier'),('Megan Jones',10,'meganpass','19 Aug 1993','5432 Null Street, Nullsville, OH 76543','Cafe Staff','Chef'),('David Carter',11,'johnpass','24 Jan 1997','7891 Void Drive, Void City, PA 23456','Cafe Manager','Manager'),('Lauren Moore',12,'janepass','07 May 2000','2345 Fictitious Road, Fictiville, IL 78901','Cafe Manager','Manager'),('Matthew Reed',13,'alexpass','11 Dec 1999','8769 Imaginary Lane, Imaginatown, NJ 56789','Cafe Manager','Manager'),('Ashley Adams',14,'emilypass','02 Mar 1998','3210 Placeholder Street, Placeville, CO 34567','Cafe Manager','Manager'),('Christopher Clark',15,'michaelpass','28 Aug 1996','7654 Simulation Road, Simuland, TN 89012','Cafe Manager','Manager'),('Olivia Turner',16,'sarahpass','13 Oct 1995','1098 Virtual Drive, Virtualville, AL 65432','Cafe Manager','Manager'),('Daniel Harris',17,'kevinpass','05 Jul 2000','4567 Mockingbird Lane, Mocksville, VA 21098','Cafe Manager','Manager'),('Rachel Walker',18,'jessicapass','09 Feb 1993','5678 Hypothetical Street, Hypothetica, KY 54321','Cafe Manager','Manager'),('Justin Allen',19,'brianpass','17 Jun 1997','8765 Fictional Road, Fictionburg, MO 10987','Cafe Manager','Manager'),('Samantha Turner',20,'meganpass','22 Dec 1994','5432 Speculative Avenue, Speculand, HI 87654','Cafe Manager','Manager'),('Tyler Baker',21,'johnpass','26 May 1996','2109 Uncharted Lane, Uncharteville, LA 23456','Cafe Owner','Owner'),('Vanessa Wright',22,'janepass','31 Aug 2001','7890 Mirage Drive, Mirage City, RI 32109','Cafe Owner','Owner'),('Eric Turner',23,'alexpass','10 Feb 1999','4321 Enigma Street, Enigmaville, NM 54321','Cafe Owner','Owner'),('Paige Turner',24,'emilypass','14 Apr 1994','8765 Illusion Road, Illusiontown, OK 67890','Cafe Owner','Owner'),('Brandon Foster',25,'michaelpass','03 Nov 1993','6543 Dream Lane, Dreamville, WI 21098','Cafe Manager','Manager'),('Haley Mitchell',26,'sarahpass','19 Jul 1998','7891 Whimsical Street, Whimsyland, DE 76543','Cafe Owner','Owner'),('Ryan Turner',27,'kevinpass','22 Mar 1995','2345 Fantasy Drive, Fantasy City, MS 23456','Cafe Owner','Owner'),('Courtney Davis',28,'jessicapass','01 Sep 1996','8769 Wonderland Road, Wonderland, IA 89012','Cafe Owner','Owner'),('Jordan King',29,'brianpass','28 Jan 1997','1098 Mystic Lane, Mystictown, AR 56789','Cafe Owner','Owner'),('Morgan Knight',30,'meganpass','17 May 1994','7654 Whirlwind Street, Whirlwindville, WV 32109','Cafe Owner','Owner'),('Alexis Parker',31,'johnpass','09 Oct 1995','3210 Mirage Avenue, Mirageville, MT 56789','System Admin','Admin'),('Dylan Harris',32,'janepass','15 Feb 1992','5678 Serenity Lane, Serenityville, ND 76543','System Admin','Admin'),('Hailey Turner',33,'alexpass','06 Jun 1996','8765 Harmony Road, Harmony City, SD 23456','System Admin','Admin'),('Nathan Adams',34,'emilypass','29 Dec 1993','6543 Zenith Street, Zenithville, NE 89012','System Admin','Admin'),('Zoey Lewis',35,'michaelpass','04 Mar 1998','2101 Celestial Drive, Celestialtown, IA 54321','System Admin','Admin'),('Evan Foster',36,'sarahpass','11 Jul 2000','4321 Ethereal Lane, Etherealtown, MN 67890','System Admin','Admin'),('Madison Turner',37,'kevinpass','13 Oct 1999','7890 Tranquil Road, Tranquilville, IL 10987','System Admin','Admin'),('Kyle Mitchell',38,'jessicapass','20 Aug 1994','5432 Serendipity Street, Serendipityville, OK 32109','System Admin','Admin'),('Lily King',39,'brianpass','24 Jan 1998','8769 Cascade Avenue, Cascade City, NC 65432','System Admin','Admin'),('Jordan Turner',40,'meganpass','30 Apr 1997','1098 Essence Lane, Essencetown, ID 87654','System Admin','Admin'),('Riley Clark',41,'johnpass','10 Sep 1994','7654 Unity Road, Unityville, GA 21098','Cafe Staff','Chef'),('Sophia White',42,'janepass','01 Mar 1996','3210 Reflection Street, Reflectionville, TX 56789','Cafe Staff','Waiter'),('Caleb Baker',43,'alexpass','07 Jul 1993','5678 Nebula Lane, Nebulatown, FL 76543','Cafe Owner','Owner'),('Grace Turner',44,'emilypass','16 Nov 1995','7891 Celestial Drive, Celestialburg, CA 89012','Cafe Staff','Cashier'),('Ethan Harris',45,'michaelpass','23 May 1994','2109 Zenith Road, Zenithburg, NY 10987','Cafe Staff','Waiter'),('Zoey Davis',46,'sarahpass','02 Aug 2000','4321 Cosmos Street, Cosmostown, WA 54321','System Admin','Admin'),('Mason Turner',47,'kevinpass','29 Dec 1998','8765 Ethereal Lane, Etherealtown, NJ 67890','Cafe Manager','Manager'),('Hailey Foster',48,'jessicapass','18 Oct 1997','6543 Serendipity Road, Serendipitytown, CO 21098','Cafe Staff','Chef'),('Oliver Mitchell',49,'brianpass','14 Mar 2000','1098 Nebula Drive, Nebulatown, VA 56789','Cafe Owner','Owner'),('Chloe King',50,'meganpass','05 Jun 1996','7654 Harmony Street, Harmonyville, TN 32109','Cafe Staff','Waiter'),('Jack Turner',51,'johnpass','22 Jan 1999','2101 Unity Road, Unityville, AZ 89012','Cafe Staff','Chef'),('Aria Davis',52,'janepass','12 May 1997','5432 Reflection Avenue, Reflectionville, OH 65432','Cafe Manager','Manager'),('Mason White',53,'alexpass','08 Oct 1995','8769 Cosmos Street, Cosmostown, IL 76543','System Admin','Admin'),('Zoe Taylor',54,'emilypass','26 Feb 1994','4321 Serendipity Lane, Serendipitytown, MO 10987','Cafe Staff','Cashier'),('Elijah Foster',55,'michaelpass','09 Aug 1996','5678 Nebula Road, Nebulatown, GA 32109','Cafe Owner','Owner'),('Mia Turner',56,'sarahpass','03 Mar 1995','7890 Ethereal Avenue, Etherealtown, WA 56789','Cafe Manager','Manager'),('Caleb Baker',57,'kevinpass','27 Jun 1993','1098 Cosmos Drive, Cosmostown, TX 21098','Cafe Staff','Waiter'),('Layla Mitchell',58,'jessicapass','21 Nov 1999','6543 Nebula Avenue, Nebulatown, CA 89012','System Admin','Admin'),('Isaac Adams',59,'brianpass','10 Sep 1997','2109 Serendipity Lane, Serendipitytown, NY 54321','Cafe Manager','Manager'),('Scarlett Harris',60,'meganpass','18 Dec 1994','8765 Harmony Drive, Harmonyville, FL 67890','Cafe Staff','Chef'),('Luke Turner',61,'johnpass','14 Mar 1998','5432 Reflection Road, Reflectionville, NJ 10987','Cafe Manager','Manager'),('Stella White',62,'janepass','29 Aug 1996','4321 Unity Street, Unityville, IL 76543','System Admin','Admin'),('Jackson Foster',63,'alexpass','23 Jan 1999','7654 Cosmos Lane, Cosmostown, MO 21098','Cafe Owner','Owner'),('Lila Turner',64,'emilypass','31 May 1995','1098 Nebula Road, Nebulatown, TN 56789','Cafe Staff','Cashier'),('Aiden Baker',65,'michaelpass','19 Feb 1994','8769 Harmony Avenue, Harmonyville, TX 32109','Cafe Staff','Waiter'),('Zoey Mitchell',66,'sarahpass','05 Jul 1993','6543 Nebula Lane, Nebulatown, CA 89012','System Admin','Admin'),('Liam Adams',67,'kevinpass','02 Nov 1997','2109 Serendipity Drive, Serendipitytown, NY 54321','Cafe Manager','Manager'),('Ava Turner',68,'jessicapass','27 Apr 1994','5432 Harmony Avenue, Harmonyville, FL 67890','Cafe Staff','Chef'),('Oliver White',69,'brianpass','08 Sep 1996','8765 Cosmos Road, Cosmostown, IL 76543','Cafe Owner','Owner'),('Chloe Harris',70,'meganpass','16 Jan 1995','4321 Unity Lane, Unityville, MO 21098','Cafe Staff','Waiter'),('Mason Turner',71,'johnpass','23 Jun 2000','1098 Reflection Road, Reflectionville, TN 56789','Cafe Staff','Chef'),('Sophia Foster',72,'janepass','04 Oct 1998','7654 Nebula Avenue, Nebulatown, TX 32109','Cafe Manager','Manager'),('Ethan Adams',73,'alexpass','30 Mar 1997','2101 Serendipity Lane, Serendipitytown, CA 89012','System Admin','Admin'),('Isabella Turner',74,'emilypass','14 Aug 1995','5432 Harmony Road, Harmonyville, NY 54321','Cafe Staff','Cashier'),('Noah Harris',75,'michaelpass','20 Jan 1996','8769 Cosmos Drive, Cosmostown, FL 67890','Cafe Staff','Waiter'),('Mia Baker',76,'sarahpass','11 May 1993','6543 Nebula Road, Nebulatown, IL 76543','System Admin','Admin'),('Jackson Turner',77,'kevinpass','28 Sep 1994','7890 Reflection Lane, Reflectionville, MO 21098','Cafe Manager','Manager'),('Lily White',78,'jessicapass','25 Dec 1997','1098 Unity Avenue, Unityville, TN 56789','Cafe Staff','Chef'),('Aiden Foster',79,'brianpass','03 Jul 1999','4321 Cosmos Drive, Cosmostown, TX 32109','Cafe Owner','Owner'),('Scarlett Turner',80,'meganpass','27 Aug 1993','8765 Serendipity Lane, Serendipitytown, CA 89012','Cafe Staff','Waiter'),('Oliver Mitchell',81,'johnpass','19 Apr 1994','2109 Nebula Road, Nebulatown, NY 54321','Cafe Staff','Chef'),('Emma Harris',82,'janepass','08 Sep 1997','5432 Harmony Lane, Harmonyville, FL 67890','Cafe Manager','Manager'),('Ethan Turner',83,'alexpass','05 Jan 1995','7654 Reflection Avenue, Reflectionville, IL 76543','System Admin','Admin'),('Ava Baker',84,'emilypass','30 Mar 1998','3210 Cosmos Road, Cosmostown, MO 21098','Cafe Staff','Cashier'),('Michael Brown',85,'michaelpass','24 Jul 1996','Elm Street','Cafe Owner','Owner'),('Sarah Miller',86,'sarahpass','13 Dec 1994','Cedar Street','Cafe Manager','Manager'),('Kevin White',87,'kevinpass','02 May 1993','Maple Street','Cafe Staff','Waiter'),('Jessica Taylor',88,'jessicapass','21 Oct 1999','Oak Street','System Admin','Admin'),('Brian Wilson',89,'brianpass','14 Aug 1997','Pine Street','Cafe Manager','Manager'),('Megan Jones',90,'meganpass','25 Jan 1996','Elm Street','Cafe Staff','Chef'),('John Doe',91,'johnpass','17 Mar 1998','Cedar Street','Cafe Manager','Manager'),('Jane Smith',92,'janepass','29 Jul 1995','Maple Street','System Admin','Admin'),('Alex Johnson',93,'alexpass','18 Dec 1993','Oak Street','Cafe Owner','Owner'),('Emily Davis',94,'emilypass','04 Jun 1997','Pine Street','Cafe Staff','Cashier'),('Michael Brown',95,'michaelpass','30 Sep 1994','Elm Street','Cafe Staff','Waiter'),('Sarah Miller',96,'sarahpass','11 Jan 1993','Cedar Street','System Admin','Admin'),('Kevin White',97,'kevinpass','28 Apr 1996','Maple Street','Cafe Manager','Manager'),('Jessica Taylor',98,'jessicapass','09 Aug 1999','Oak Street','Cafe Staff','Chef'),('Brian Wilson',99,'brianpass','02 Oct 1995','Pine Street','Cafe Owner','Owner'),('Megan Jones',100,'meganpass','07 Mar 1994','Elm Street','Cafe Staff','Waiter'),('Thomas Tom',101,'tompass','12 Feb 2000','tom address here','Cafe Staff','Cashier'),('John Doe',12345,'password123','28 Dec 1990','1234 Test Street, Test City, TX 12345','Cafe Staff','Chef');
/*!40000 ALTER TABLE `useraccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userprofile`
--

DROP TABLE IF EXISTS `userprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userprofile` (
  `role` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `permission` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userprofile`
--

LOCK TABLES `userprofile` WRITE;
/*!40000 ALTER TABLE `userprofile` DISABLE KEYS */;
INSERT INTO `userprofile` VALUES ('System Admin','Manage all user accounts','sysadm'),('Cafe Manager','Handles bids for slots','manager'),('Cafe Owner','Manage work slots','owner'),('Cafe Staff','Bids for work slots','staff'),('Cafe Cleaner','Cleaning up the cafe','staff');
/*!40000 ALTER TABLE `userprofile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workslots`
--

DROP TABLE IF EXISTS `workslots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workslots` (
  `role` varchar(50) DEFAULT NULL,
  `slots` int DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workslots`
--

LOCK TABLES `workslots` WRITE;
/*!40000 ALTER TABLE `workslots` DISABLE KEYS */;
INSERT INTO `workslots` VALUES ('Waiter',1,'2023-11-15'),('Cashier',1,'2023-11-15'),('Chef',2,'2023-11-15'),('Chef',4,'2023-11-17'),('Cashier',3,'2023-11-17'),('Waiter',5,'2023-11-17'),('Waiter',0,'2023-11-18'),('Waiter',1,'2023-11-19'),('Waiter',1,'2023-11-20'),('Waiter',4,'2023-11-21'),('Chef',1,'2023-11-18'),('Chef',3,'2023-11-19'),('Chef',2,'2023-11-20'),('Chef',2,'2023-11-21'),('Chef',2,'2023-11-22'),('Chef',4,'2023-11-23'),('Chef',4,'2023-11-24'),('Chef',4,'2023-11-25'),('Chef',2,'2023-11-26'),('Chef',2,'2023-11-27'),('Chef',0,'2023-11-28'),('Chef',2,'2023-11-29'),('Waiter',3,'2023-11-02'),('Waiter',5,'2023-11-22'),('Waiter',1,'2023-11-23'),('Waiter',1,'2023-11-24'),('Waiter',3,'2023-11-25'),('Waiter',3,'2023-11-26'),('Waiter',3,'2023-11-27'),('Waiter',6,'2023-11-28'),('Cashier',1,'2023-11-18'),('Cashier',1,'2023-11-19'),('Cashier',2,'2023-11-20'),('Cashier',2,'2023-11-21'),('Cashier',2,'2023-11-22'),('Cashier',2,'2023-11-23'),('Cashier',2,'2023-11-24'),('Cashier',1,'2023-11-25'),('Cashier',1,'2023-11-26'),('Cashier',2,'2023-11-27'),('Cashier',2,'2023-11-28'),('Cashier',1,'2023-11-29'),('Waiter',0,'2023-12-01'),('Cashier',3,'2023-12-01');
/*!40000 ALTER TABLE `workslots` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-17 20:16:44
