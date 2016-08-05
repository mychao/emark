use xlh_mychao;

create table emark_user_account (
	id bigint not null auto_increment comment '用户自增长id',
	user_name varchar(30) not null default '' comment '用户名',
	user_password varchar(128) not null default '' comment '密码',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
	primary key idx_id (id),
	unique key idx_user_name (user_name)
)engine=innodb default charset=utf8 comment = '账户信息';

create table emark_user_company (
	id bigint not null auto_increment comment '自增长id',
	user_acount_id bigint not null default 0 comment '用户账户id，emark_user_account主键',
	company_name varchar(50) not null default '' comment '公司名称',
	company_address varchar(100) not null default '' comment '公司地址',
	company_contract_user varchar(30) not null default '' comment '公司联系人',
	company_contract_method varchar(30) not null default '' comment '公司联系方式',
	company_email varchar(50) not null default '' comment '邮件地址',
	company_delivery_address varchar(100) not null default '' comment '收货地址',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
	primary key idx_id (id),
	unique key idx_company_name (company_name)
)engine=innodb default charset=utf8 comment = '公司信息';

create table emark_category (
	id bigint not null auto_increment comment '类目id',
	category_name varchar(30) not null default '' comment '类目名,普通版、标准版等',
	category_img varchar(100) not null default '' comment '类目图片',
	sort int not null default 0 comment '排序值，值越大越排在前',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
	primary key idx_id (id),
	unique key idx_category_name (category_name)
)engine=innodb default charset=utf8 comment = 'e标类目';

create table emark_category_properties (
	id bigint not null auto_increment comment '自增长id',
	category_id bigint not null default 0 comment '类目id，emark_category主键',
	category_size varchar(30) not null default '' comment '类目尺寸，如22mm*30mm*45mm',
	category_price bigint not null default 0 comment '类目单价，如100，单位为分',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
	primary key idx_id (id),
	key idx_category_id (category_id)
)engine=innodb default charset=utf8 comment = 'e标类目属性';

create table emark_goods(
	id bigint not null auto_increment comment 'e标id，自增长',
	category_id bigint not null default 0 comment '类目id，emark_category主键',
	goods_name varchar(15) not null default '' comment 'e标名称',
	goods_img varchar(100) not null default '' comment 'e标原图',
	goods_thumbnail varchar(100) not null default '' comment 'e标缩略图',
	show_status tinyint not null default 0 comment '上架状态，0=下架；1=上架',
	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
	primary key idx_id(id),
	unique key idx_c_g_name(category_id, goods_name)
)engine=innodb default charset=utf8 comment='e标商品详情';

create table emark_order(
	id bigint not null auto_increment comment '自增长id',
	order_no varchar(30) not null default '' comment '订单号',
	user_acount_id bigint not null default 0 comment '用户账户id，emark_user_account主键',
	user_name varchar(30) not null default '' comment '用户名',
	company_name varchar(50) not null default '' comment '公司名称',
	company_address varchar(100) not null default '' comment '公司地址',
	company_contract_user varchar(30) not null default '' comment '公司联系人',
	company_contract_method varchar(30) not null default '' comment '公司联系方式',
	company_email varchar(50) not null default '' comment '邮件地址',
	company_delivery_address varchar(100) not null default '' comment '收货地址',
	promoter varchar(15) not null default 'angpai' comment '推广人，如angpai等',
	total_price bigint not null default 0 comment '总价',
	order_status tinyint not null default 0 comment '订单状态，无效订单=-99; 新订单=0; 已查阅=1; 已确认=2; 已发货=3; 已收货=4;',

	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
	primary key idx_id(id),
	unique key idx_order_no (order_no)
)engine=innodb default charset=utf8 comment='订单';

create table emark_order_detail(
	id bigint not null auto_increment comment '自增长id',
	order_no varchar(30) not null default '' comment '订单号',
	category_id bigint not null default 0 comment '类目id，emark_category主键',
	category_name varchar(30) not null default '' comment '类目名,普通版、标准版等',
	category_size varchar(30) not null default '' comment '类目尺寸，如22mm*30mm*45mm',
	category_price bigint not null default 0 comment '类目单价，如100，单位为分',
	goods_id bigint not null default 0 comment 'e标id',
	goods_name varchar(15) not null default '' comment 'e标名称',
	goods_num int not null default 0 comment '数量',

	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
	primary key idx_id(id),
	key idx_order_no(order_no)
)engine=innodb default charset=utf8 comment='订单详情';