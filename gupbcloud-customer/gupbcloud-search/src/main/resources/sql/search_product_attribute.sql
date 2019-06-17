/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `search_product_attribute` (
	`id` bigint (20),
	`product_attribute_category_id` bigint (20),
	`name` varchar (192),
	`select_type` int (1),
	`input_type` int (1),
	`input_list` varchar (765),
	`sort` int (11),
	`filter_type` int (1),
	`search_type` int (1),
	`related_status` int (1),
	`hand_add_status` int (1),
	`type` int (1)
); 
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('1','1','尺寸','2','1','M,X,XL,2XL,3XL,4XL','0','0','0','0','0','0');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('7','1','颜色','2','1','黑色,红色,白色,粉色','100','0','0','0','1','0');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('13','0','上市年份','1','1','2013年,2014年,2015年,2016年,2017年','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('14','0','上市年份1','1','1','2013年,2014年,2015年,2016年,2017年','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('15','0','上市年份2','1','1','2013年,2014年,2015年,2016年,2017年','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('16','0','上市年份3','1','1','2013年,2014年,2015年,2016年,2017年','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('17','0','上市年份4','1','1','2013年,2014年,2015年,2016年,2017年','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('18','0','上市年份5','1','1','2013年,2014年,2015年,2016年,2017年','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('19','0','适用对象','1','1','青年女性,中年女性','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('20','0','适用对象1','2','1','青年女性,中年女性','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('21','0','适用对象3','2','1','青年女性,中年女性','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('24','1','商品编号','1','0','','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('25','1','适用季节','1','1','春季,夏季,秋季,冬季','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('32','2','适用人群','0','1','老年,青年,中年','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('33','2','风格','0','1','嘻哈风格,基础大众,商务正装','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('35','2','颜色','0','0','','100','0','0','0','1','0');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('37','1','适用人群','1','1','儿童,青年,中年,老年','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('38','1','上市时间','1','1','2017年秋,2017年冬,2018年春,2018年夏','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('39','1','袖长','1','1','短袖,长袖,中袖','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('40','2','尺码','0','1','29,30,31,32,33,34','0','0','0','0','0','0');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('41','2','适用场景','0','1','居家,运动,正装','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('42','2','上市时间','0','1','2018年春,2018年夏','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('43','3','颜色','0','0','','100','0','0','0','1','0');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('44','3','容量','0','1','16G,32G,64G,128G','0','0','0','0','0','0');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('45','3','屏幕尺寸','0','0','','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('46','3','网络','0','1','3G,4G','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('47','3','系统','0','1','Android,IOS','0','0','0','0','0','1');
insert into `search_product_attribute` (`id`, `product_attribute_category_id`, `name`, `select_type`, `input_type`, `input_list`, `sort`, `filter_type`, `search_type`, `related_status`, `hand_add_status`, `type`) values('48','3','电池容量','0','0','','0','0','0','0','0','1');
