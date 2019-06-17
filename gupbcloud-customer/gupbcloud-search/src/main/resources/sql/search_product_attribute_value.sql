/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `search_product_attribute_value` (
	`id` bigint (20),
	`product_id` bigint (20),
	`product_attribute_id` bigint (20),
	`value` varchar (192)
); 
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('1','9','1','X');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('2','10','1','X');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('3','11','1','X');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('4','12','1','X');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('5','13','1','X');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('6','14','1','X');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('7','18','1','X');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('8','7','1','X');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('9','7','1','XL');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('10','7','1','XXL');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('11','22','7','x,xx');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('12','22','24','no110');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('13','22','25','春季');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('14','22','37','青年');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('15','22','38','2018年春');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('16','22','39','长袖');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('124','23','7','米白色,浅黄色');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('125','23','24','no1098');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('126','23','25','春季');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('127','23','37','青年');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('128','23','38','2018年春');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('129','23','39','长袖');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('130','1','13',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('131','1','14',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('132','1','15',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('133','1','16',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('134','1','17',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('135','1','18',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('136','1','19',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('137','1','20',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('138','1','21',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('139','2','13',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('140','2','14',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('141','2','15',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('142','2','16',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('143','2','17',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('144','2','18',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('145','2','19',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('146','2','20',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('147','2','21',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('183','31','24',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('184','31','25','夏季');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('185','31','37','青年');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('186','31','38','2018年夏');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('187','31','39','短袖');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('198','30','24',NULL);
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('199','30','25','夏季');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('200','30','37','青年');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('201','30','38','2018年夏');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('202','30','39','短袖');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('203','26','43','金色,银色');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('204','26','45','5.0');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('205','26','46','4G');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('206','26','47','Android');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('207','26','48','3000');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('213','27','43','黑色,蓝色');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('214','27','45','5.8');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('215','27','46','4G');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('216','27','47','Android');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('217','27','48','3000ml');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('218','28','43','金色,银色');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('219','28','45','5.0');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('220','28','46','4G');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('221','28','47','Android');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('222','28','48','2800ml');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('223','29','43','金色,银色');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('224','29','45','4.7');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('225','29','46','4G');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('226','29','47','IOS');
insert into `search_product_attribute_value` (`id`, `product_id`, `product_attribute_id`, `value`) values('227','29','48','1960ml');
