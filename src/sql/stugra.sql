/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - stugraman
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stugraman` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `stugraman`;

/*Table structure for table `clazz` */

DROP TABLE IF EXISTS `clazz`;

CREATE TABLE `clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `clazz` */

insert  into `clazz`(`id`,`name`) values (1,'1班'),(2,'2班'),(3,'3班'),(4,'4班'),(5,'1班'),(6,'2班'),(7,'3班'),(8,'4班'),(9,'1班'),(10,'2班'),(11,'3班'),(12,'4班'),(13,'5班');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `course` */

insert  into `course`(`id`,`name`) values (1,'语文'),(2,'数学'),(3,'英语'),(4,'物理');

/*Table structure for table `escore` */

DROP TABLE IF EXISTS `escore`;

CREATE TABLE `escore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clazzid` int(11) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  `courseid` int(11) DEFAULT NULL,
  `score` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `escore` */

insert  into `escore`(`id`,`clazzid`,`studentid`,`courseid`,`score`) values (1,1,1,1,123),(2,1,1,2,56),(3,1,1,3,67),(4,1,1,4,78),(5,1,1,5,54),(7,1,2,2,67),(8,1,2,3,120),(9,1,2,4,76),(10,1,2,5,78),(11,1,3,1,67),(12,1,3,2,87),(13,1,3,3,66),(14,1,3,4,56),(15,1,3,5,88),(16,1,4,1,89),(17,1,4,2,34),(18,1,4,3,55),(19,1,4,4,90),(20,1,4,5,90),(21,1,5,1,99),(22,1,5,2,89),(23,1,5,3,142),(24,1,5,4,66),(25,1,5,5,79),(26,1,6,1,109),(27,1,6,2,90),(28,1,6,3,90),(29,1,6,4,78),(30,1,6,5,65),(31,1,7,1,45),(32,1,7,2,45),(33,1,7,3,67),(34,1,7,4,90),(35,1,7,5,88),(36,1,8,1,65),(37,1,8,2,34),(38,1,8,3,98),(39,1,8,4,98),(40,1,8,5,45),(41,1,9,1,67),(42,1,9,2,56),(43,1,9,3,69),(44,1,9,4,67),(45,1,9,5,97),(47,1,10,2,123),(48,1,10,3,135),(49,1,10,4,99),(50,1,10,5,39),(51,1,11,1,34),(52,1,11,2,76),(53,1,11,3,55),(54,1,11,4,44),(55,1,11,5,66),(56,1,12,1,67),(57,1,12,2,90),(58,1,12,3,99),(59,1,12,4,67),(60,1,12,5,98),(61,1,13,1,55),(62,1,13,2,87),(63,1,13,3,68),(64,1,13,4,76),(65,1,13,5,45),(227,0,10,1,60),(230,0,2,1,60);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qq` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clazzid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_student_FK` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `student` */

insert  into `student`(`id`,`number`,`name`,`sex`,`phone`,`qq`,`clazzid`) values (1,'201301001','蒙奇D路飞','男','18345345612','252345',1),(2,'201301002','妮可罗宾','女','16342346345','345745',1),(3,'201301003','罗罗诺亚卓洛','女','16234574564','734577',1),(4,'201301004','托尼托尼乔巴','男','15436574765','3546634',1),(5,'201301005','娜美','女','15346235622','7453256',1),(6,'201301006','山治','男','16234514532','8456257',1),(7,'201301007','布鲁克','男','16345234664','7257346',1),(8,'201301008','乌索普','男','16236457676','8345756',1),(9,'201301009','弗兰奇','男','17346734768','23563457',1),(10,'201301010','娜菲鲁塔利薇薇','女','11452356234','235345',1),(11,'201301011','小鱿','男','17632878467','6235745',1),(12,'201301012','梅里号','男','15235543456','2352346',1),(13,'201301013','阳光号','男','15232342355','45236',1);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qq` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_teacher_FK` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`number`,`name`,`sex`,`phone`,`qq`) values (1,'2001','卡卡西','女','183123412421','252345'),(2,'2002','卡普','男','13927387432','65686786'),(3,'2003','战国','男','11389823821','1233456'),(4,'2004','青雉','女','1523452213','7456345'),(5,'2005','爱德华纽盖特','男','16234243242','34634534'),(6,'2006','香克斯','男','16345475689','35464573'),(7,'2007','波风水门','男','15234234234','35683673'),(8,'2008','纲手','女','14352341231','73456236'),(9,'2009','大筒木辉夜','女','13452342342','234523455'),(10,'2010','漩涡玖辛奈','男','14423423543','734562356'),(14,'2011','夕日红','女','15234234523','7243821'),(15,'2012','鹰眼米霍克','男','15236345346','8345632');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci DEFAULT '111111',
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` tinyint(1) DEFAULT '2',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_user_FK` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`name`,`type`) values (1,'admin','111111','管理员',1),(2,'2001','111111','卡卡西',3),(3,'2002','111111','卡普',3),(4,'2003','111111','战国',3),(5,'2004','111111','青雉',3),(6,'2005','111111','爱德华纽盖特',3),(7,'2006','111111','香克斯',3),(8,'2007','111111','波风水门',3),(9,'2008','111111','纲手',3),(10,'2009','111111','大筒木辉夜',3),(11,'2010','111111','漩涡玖辛奈',3),(15,'2011','111111','夕日红',3),(16,'2012','111111','鹰眼米霍克',3),(17,'201301001','111111','蒙奇D路飞',2),(18,'201301002','111111','妮可罗宾',2),(19,'201301003','111111','罗罗诺亚卓洛',2),(20,'201301004','111111','托尼托尼乔巴',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
