-- Q 2 A
-- store_items values
Insert into store_items values
(22, 3000, 40);

Insert into store_items values
(33, 4000, 50);

Insert into store_items values
(44, 5000, 6);

Insert into store_items values
(55, 4000, 7);

Insert into store_items values
(66, 3000, 4);

Insert into store_items values
(77, 4000, 5);

Insert into store_items values
(88, 5000, 6);

Insert into store_items values
(99, 4000, 7);

Insert into store_items values
(111, 3000, 4);

Insert into store_items values
(122, 4000, 5);

Insert into store_items values
(133, 5000, 6);

Insert into store_items values
(23, 4000, 7);

Insert into store_items values
(34, 3000, 4);

Insert into store_items values
(45, 4000, 5);

Insert into store_items values
(56, 5000, 6);

Insert into store_items values
(67, 4000, 7);

Insert into store_items values
(78, 3000, 4);

Insert into store_items values
(89, 4000, 5);

Insert into store_items values
(100, 5000, 6);

Insert into store_items values
(112, 4000, 7);

Insert into store_items values
(123, 3000, 4);

Insert into store_items values
(134, 4000, 5);

-- comic_books values
insert into comic_books values
(22, 'Batman', date '1997-01-10');

insert into comic_books values
(33, 'Green lantern', date '1998-02-20');

insert into comic_books values
(44, 'Green Goblin', date '1999-03-30');

insert into comic_books values
(55, 'Ghost Rider', date '2000-04-20');

insert into comic_books values
(66, 'Hanuman', date '2001-05-10');

insert into comic_books values
(77, 'He-Man', date '2002-06-20');

insert into comic_books values
(88, 'Hulk', date '2003-07-10');

insert into comic_books values
(99, 'Iron Man', date '2004-08-20');

insert into comic_books values
(111, 'Joker', date '2005-09-10');

insert into comic_books values
(122, 'Loki', date '2006-10-20');

insert into comic_books values
(133, 'Mystique', date '2007-11-20');

--cartoon movies values
Insert into cartoon_movies values
(23, 'Batman', 'DC comics', 'Nolan movies');

Insert into cartoon_movies values(34, 'Green lantern','Sony Entertainment', 'Ryan Reynolds movies');

Insert into cartoon_movies values
(45, 'Green Goblin','Sony Entertainment', 'Spiderman villain');

Insert into cartoon_movies values
(56, 'Ghost Rider','Marvel', 'Nicolas Cage');

Insert into cartoon_movies values
(67, 'Hanuman','Durdarshan', 'Indian god');

Insert into cartoon_movies values
(78, 'He-Man','John Doe studios', 'Power of the universe');

Insert into cartoon_movies values
(89, 'Hulk','Marvel', 'Bruce Banner');

Insert into cartoon_movies values
(100, 'Iron Man','Marvel', 'Tony Stark');

Insert into cartoon_movies values
(112, 'Joker','DC comics', 'Ugly truth');

Insert into cartoon_movies values
(123, 'Loki','Marvel', 'Anti-hero');

Insert into cartoon_movies values
(134, 'Mystique','DC comics', 'X-Men movies');


--customer values
Insert into customer values
(1000, 'regular', 'Amit', 6667778888, 'benton st', date '2020-10-11');

Insert into customer values
(1001, 'gold', 'Balu', 6607778880, 'first st', date '2021-02-10');

Insert into customer values
(1002, 'regular', 'Chintan', 6617778881, 'pierce st', date '2022-10-21');

Insert into customer values
(1003, 'gold', 'Dan', 6627778882, 'second st', date '2019-10-01');

Insert into customer values
(1004, 'regular', 'Elli', 666718881, 'benton st', date '2020-10-11');

Insert into customer values
(1005, 'gold', 'Fang', 6607728882, 'first st', date '2021-02-10');

Insert into customer values
(1006, 'regular', 'Gary', 6617738883, 'pierce st', date '2022-10-21');

Insert into customer values
(1007, 'gold', 'Hanna', 6627748884, 'second st', date '2019-10-01');

Insert into customer values
(1008, 'regular', 'Ishvar', 6667758885, 'benton st', date '2020-10-11');

Insert into customer values
(1009, 'gold', 'Jack', 6607768886, 'first st', date '2021-02-10');

Insert into customer values
(1010, 'regular', 'Kenny', 6617778887, 'pierce st', date '2022-10-21');

Insert into customer values
(1011, 'gold', 'Lary', 6627788888, 'second st', date '2019-10-01');

--test data for Q2 D
Insert into cust_order values
(4998, 1008, date '2020-10-01', date '2020-10-01', 10, 2);
Insert into cust_order values
(4999, 1008, date '2022-10-11', date '2022-12-25', 10, 2);

--test data for Q2 E
Insert into cust_order values
(4997, 1008, date '2020-10-01',NULL,10,2);

--test data for Q2 F
Insert into cust_order values
(5001, 1002, date '2022-10-21', date '2022-12-07', 5002, 2);

Insert into order_line_items values
(10002, 33, 5001, 3);

