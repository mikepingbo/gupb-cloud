create table `data_master` (
	`master_code` varchar (120),
	`master_cd` varchar (60),
	`master_text` varchar (300),
	`sort_order` int (11),
	`state` int (11),
	`create_id` int (11),
	`create_name` varchar (300),
	`create_time` datetime ,
	`update_id` int (11),
	`update_name` varchar (300),
	`update_time` datetime
);
insert into `data_master` (`master_code`, `master_cd`, `master_text`, `sort_order`, `state`, `create_id`, `create_name`, `create_time`, `update_id`, `update_name`, `update_time`) values('PROMOTION_NAME','1','大转盘活动','0','1','0','system','2019-06-02 17:37:56','0','system','2019-06-02 17:38:05');
insert into `data_master` (`master_code`, `master_cd`, `master_text`, `sort_order`, `state`, `create_id`, `create_name`, `create_time`, `update_id`, `update_name`, `update_time`) values('PROMOTION_NAME','2','抽奖活动','1','1','0','system','2019-06-02 17:37:56','0','system','2019-06-02 17:37:56');
