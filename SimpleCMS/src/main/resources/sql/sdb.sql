-- MySQL dump 10.13  Distrib 5.5.27, for Win64 (x86)
--
-- Host: localhost    Database: sdb
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('admin','ROLE_ADMIN'),('stsyhanou','ROLE_ADMIN'),('stsyhanou','ROLE_SUPERVISOR'),('stsyhanou','ROLE_USER'),('user','ROLE_ADMIN'),('user','ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content` (
  `id` varchar(40) NOT NULL,
  `body` text,
  `section_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK38B734799353B45D` (`section_id`),
  CONSTRAINT `FK38B734799353B45D` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` VALUES ('1','<p>\n	changegh</p>\n','1'),('402880694086c295014086c3ce130001','<p>\n	<em>bodybodyzxczxc13</em></p>\n','402880694086c295014086c3ce050000'),('402880694095c35b014095c672eb0007','<p>\n	section ffff</p>\n','402880694095c35b014095c672eb0006'),('402880694095c35b014095c6a0a10009','<p>\n	menu2g</p>\n','402880694095c35b014095c6a0a10008'),('4028806940c970f70140c97180c80001','<p>\n	body<img alt=\"\" src=\"/img/files/example-1.jpg\" style=\"width: 366px; height: 249px;\" /></p>\n','4028806940c970f70140c97180b90000'),('4028806940c970f70140c971fa550003','<p>\n	<span style=\"color:#ee82ee;\">sdrfdsgkdfsigufskjgdfklg</span></p>\n','4028806940c970f70140c971fa550002'),('4028806940c979de0140c97ad6eb0003','<p>\n	dfskgdfkjsgndksflgdfsgdfsg</p>\n','4028806940c979de0140c97ad6eb0002'),('4028806940c979de0140c97b2e250005','<p>\n	shgfphjugf;jhkhjglkjhhkh</p>\n','4028806940c979de0140c97b2e240004'),('4028806940c979de0140c97b7eba0007','<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n	Что стоит за стандартной формулировкой из протокола ГАИ &laquo;отвлекся от управления&raquo;?&nbsp;В некоторых случаях участники ДТП дают столь нетипичные объяснения, что поверить в их правдивость крайне сложно. Это кажется некой попыткой уйти от ответственности, а не реальной причиной. Мы выбрали десять наиболее правдивых причин ДТП, которые в то же время можно назвать случайными и нехарактерными. Например, иногда водители действительно путают педали, и это является не единичной ошибкой. Или часто автомобилистов ослепляет солнце. Они в течение нескольких секунд ничего не видят до момента попадания в аварию. Подчеркиваем, эти причины были указаны в протоколах реальных происшествий.</p>\n<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n	<strong>Ослепило солнце</strong></p>\n<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n	<em>&laquo;Меня ослепило солнце!&raquo;</em>&nbsp;&mdash;&nbsp;иногда объясняют прибывшим на место происшествия инспекторам виновники ДТП. Например, так было с женщиной &mdash;&nbsp;водителем Volkswagen, которая в Слониме на прямом участке дороги&nbsp;<a href=\"http://auto.onliner.by/2013/03/01/dtp-3495/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">врезалась</a>&nbsp;в стоящий микроавтобус &laquo;Газель&raquo;. Снимки на месте аварии были сделаны&nbsp;оперативно, и можно понять, что водителя действительно могло ослепить.</p>\n<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n	Вообще, это очень распространенная ситуация, особенно весной, хотя она может возникнуть в любую пору года. Ослепленные водители&nbsp;<a href=\"http://auto.onliner.by/2012/04/03/dtp-2056/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">не замечают столбы</a>,&nbsp;<a href=\"http://auto.onliner.by/2011/08/09/dtp-972/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">сигнал светофора</a>&nbsp;и даже габаритный общественный транспорт. Так, в Минске молодой человек, управлявший Volkswagen Golf, решил&nbsp;<a href=\"http://auto.onliner.by/2011/09/21/dtp-1175/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">развернуться</a>&nbsp;прямо перед приближающимся трамваем. Водитель последнего утверждала, что маневр был очень резким.&nbsp;Парень же объяснял:&nbsp;<em>&laquo;Заметить вагон помешало ослепившее солнце&raquo;.</em></p>\n<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n	Между прочим, ослепленный и продолжающий движение водитель может быть опаснее пьяного. Потому что он никак не реагирует на появившееся препятствие, пешехода и т.&nbsp;д. В марте этого года в Минске сбили участника мелкого ДТП, который находился на проезжей части возле своей машины. Мужчина получил тяжелейшие травмы. Второй водитель первоначально также&nbsp;<a href=\"http://auto.onliner.by/2013/03/11/dtp-3523/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">объяснял</a>, что был ослеплен солнцем.</p>\n<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n	Подобное объяснение, конечно, не может оправдывать ослепленных водителей. В ГАИ говорят, что в этом случае надо остановить автомобиль, не меняя направление движения, и одновременно включить &laquo;аварийку&raquo;. Да и в конце концов, есть солнцезащитные козырьки, а также специальные водительские очки.</p>\n<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n	<strong>Путаница с педалями</strong></p>\n<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n	Оказывается, перепутать педали в автомобиле с АКПП довольно просто. Это объяснение кажется курьезным, однако в реальности подобная путаница часто приводит к серьезным последствиям, и смешного тут мало. Вместо того чтобы остановиться, машина вдруг получает ускорение. Результат? Часто он может быть мало предсказуемым. В апреле прошлого года на ул. Богдановича в Минске это&nbsp;<a href=\"http://auto.onliner.by/2012/04/02/dtp-2052/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">привело</a>&nbsp;к &laquo;паровозу&raquo; из шести автомобилей.</p>\n<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n	Но жители столицы скорее вспомнят другой случай &mdash; в ТЦ &laquo;Паркинг&raquo;,&nbsp;с пятого этажа которого на козырек&nbsp;<a href=\"http://auto.onliner.by/2011/05/05/dtp-583/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">упал</a>&nbsp;Mercedes ML. Женщина-водитель&nbsp;<a href=\"http://auto.onliner.by/2011/05/06/dtp-669-2/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">утверждала</a>, что ничего не помнит. А экспертиза<a href=\"http://auto.onliner.by/2011/07/15/dtp-877/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">показала</a>, что машина исправна. Тогда у многих появилась версия, что водитель, скорее всего, перепутала педали.</p>\n<div>\n	<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n		И хотя в двух приведенных выше примерах фигурируют водители-женщины, в такие аварии попадают и мужчины, просто они не признаются в этом&nbsp;вслух.</p>\n	<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n		<strong>И тут зазвонил телефон...</strong></p>\n	<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n		<em>&laquo;Боднул мужика на светофоре. Пялился в телефон, поток слева начал движение по стрелке, ну и я с ним&raquo;,</em>&nbsp;&mdash; честно признался водитель, врезавшийся в Honda FR-V.&nbsp;Видеозапись хорошо показывает, как мобильник может отвлечь от управления автомобилем даже в простой ситуации на минимальной скорости.</p>\n	<p style=\"margin: 0px; padding: 0px 0px 21px; color: rgb(0, 0, 0); font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 15px; line-height: 21px;\">\n		Пользование телефоном можно назвать нехарактерной причиной лишь потому, что доказать прямую причинно-следственную связь с ДТП крайне сложно. Сотрудники Следственного комитета (они считают, что половина тяжких аварий происходит из-за разговоров по мобильнику) ранее<a href=\"http://auto.onliner.by/2013/02/26/sledovateli/\" style=\"cursor: pointer; color: rgb(0, 77, 153); text-decoration: none;\">рассказывали</a>, почему:&nbsp;<em>&laquo;Зафиксировать точное время ДТП практически невозможно: источники времени (часы) участников и свидетелей происшествия и серверы операторов сотовой связи выдают разницу до 10 минут! И если в этих пределах был разговор и случилось происшествие, то сопоставить, что раньше, а что позже, сложно&raquo;.</em></p>\n</div>\n','4028806940c979de0140c97b7eba0006'),('4028806940c9927f0140c996dd610007','<p>\n	gdfasgsdgdfg</p>\n','4028806940c9927f0140c996dd610006'),('4028806940ce56160140ce56dc420001','<p>\n	dasdasdas</p>\n','4028806940ce56160140ce56dc3b0000'),('4028806940ce56160140ce58876e0009','<p>\n	gggg</p>\n','4028806940ce56160140ce58876e0008'),('4028806940ce607e0140ce6268dd0001','<p>\n	<u><em>body</em></u></p>\n','4028806940ce607e0140ce6268d50000'),('4028806940e2d7e80140e2d863a40001','<p>\n	dasssssssss</p>\n','4028806940e2d7e80140e2d863910000'),('4028806940e2e4330140e2e4a3490001','<p>\n	fffffffffffff</p>\n','4028806940e2e4330140e2e4a3410000');
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section` (
  `id` varchar(40) NOT NULL,
  `date` datetime DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `published` tinyint(1) DEFAULT NULL,
  `parent_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK756F7EE5F4D91878` (`parent_id`),
  CONSTRAINT `FK756F7EE5F4D91878` FOREIGN KEY (`parent_id`) REFERENCES `section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES ('1','2013-09-03 00:00:00','submenu 1',1,'402880694095c35b014095c6a0a10008'),('402880694086c295014086c3ce050000','2012-12-12 00:00:00','menu 1',1,NULL),('402880694095c35b014095c672eb0006','2012-12-19 00:00:00','section 1',1,'402880694086c295014086c3ce050000'),('402880694095c35b014095c6a0a10008','2012-10-13 00:00:00','menu 2',1,NULL),('4028806940c970f70140c97180b90000','2013-08-15 00:00:00','submenu 2',1,'402880694095c35b014095c6a0a10008'),('4028806940c970f70140c971fa550002','2013-08-22 00:00:00','section 2',1,'402880694086c295014086c3ce050000'),('4028806940c979de0140c97ad6eb0002','2013-08-07 00:00:00','section 3',1,'402880694086c295014086c3ce050000'),('4028806940c979de0140c97b2e240004','2013-08-14 00:00:00','new section 2',1,'4028806940c970f70140c971fa550002'),('4028806940c979de0140c97b7eba0006','2013-08-08 00:00:00','submenu 3',1,'402880694095c35b014095c6a0a10008'),('4028806940c9927f0140c996dd610006','2013-08-16 00:00:00','section 4',1,'402880694086c295014086c3ce050000'),('4028806940ce56160140ce56dc3b0000','2013-08-30 00:00:00','section',1,'1'),('4028806940ce56160140ce58876e0008','2013-08-29 00:00:00','menu 3',1,NULL),('4028806940ce607e0140ce6268d50000','2013-08-02 00:00:00','menu 4',1,NULL),('4028806940e2d7e80140e2d863910000','2013-09-18 00:00:00','sectionold 1',1,'4028806940ce56160140ce58876e0008'),('4028806940e2e4330140e2e4a3410000','2013-08-13 00:00:00','submenu44',1,'4028806940ce607e0140ce6268d50000');
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','admin',''),('stsyhanou','12345',''),('user','123456','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-18 16:55:14
