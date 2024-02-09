-- Table creation and constraints

-- Q1.1 C
create table store_items(
item_id number not null primary key,
price number not null,
number_of_copies number not null,
constraint number_of_copies_check CHECK (number_of_copies > 0)
);

create table comic_books(
item_id number not null primary key,
title varchar(30) unique,
published_date date,
constraint FK_comicBooks foreign key (item_id) references store_items(item_id)
);

create table cartoon_movies(
--item_id number not null references store_items(item_id),
item_id number not null primary key,
title varchar(30) references comic_books(title),
studio_name varchar(20),
description varchar(100),
constraint FK_cartoonMovies foreign key (item_id) references store_items(item_id)
);

-- Q1.1 A, Q1.1 B
create table customer(
cust_id number primary key,
cust_type varchar(7) not null,
name varchar(25),
phone number(10) not null unique,
address varchar(100),
date_joined date,
constraint check_cust_type
CHECK (cust_type IN ('regular','gold'))
);

create table gold_customer(
cust_id references customer(cust_id),
date_joined date,
coupons varchar(5)
);

create table cust_order(
order_id number primary key,
cust_id number references customer(cust_id),
date_of_order date,
shipped_date date,
shipping_fee number,
number_of_orderLineItems number
);

CREATE SEQUENCE orderId_seq START WITH 5000;

create table order_line_items(
line_id number,
item_id number,
order_id number,
quantity number not null,
constraint PK_orderLineItems primary key(line_id, order_id),
constraint FK_orderLineItems foreign key(item_id) references store_items(item_id),
constraint FK2_orderLineItems foreign key(order_id) references cust_order(order_id)
);

CREATE SEQUENCE lineId_seq START WITH 10001;

create table payment_details(
payment_id number primary key,
tax number,
discount number,
total number,
grand_total number,
shipping_fee number,
order_id number references cust_order(order_id)
);

CREATE SEQUENCE payment_id_sequence
  START WITH 1
  INCREMENT BY 1
  CACHE 100;

create table cart_items
(cart_item_id number primary key,
item_id number,
quantity number,
price number,
tax number,
total number,
cust_id number);

CREATE SEQUENCE cart_item_id_sequence
  START WITH 1
  INCREMENT BY 1
  CACHE 100;

-- Q1.1 D
-- This has been implemented as part of Q 2 C.

-- Q1.1 E
alter table cust_order 
add constraint shipping_date_check
check (shipped_date >= date_of_order)
ENABLE NOVALIDATE;

-- Q1.1 F
CREATE OR REPLACE TRIGGER updateShippingFee
AFTER UPDATE
OF cust_type
ON customer
FOR EACH ROW
WHEN (NEW.cust_type='gold')
BEGIN
	UPDATE cust_order
    SET shipping_fee = 0
    WHERE cust_id= :new.cust_id AND shipped_date!=NULL;
END;
/



