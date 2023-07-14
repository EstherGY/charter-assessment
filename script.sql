CREATE DATABASE  IF NOT EXISTS `charter`;
USE `charter`;

CREATE TABLE CUSTOMER (CUSTOMER_ID int, CUSTOMER_NAME VARCHAR(50) );

INSERT INTO CUSTOMER values (1,'Customer1'),
							(2,'Customer2'),
							(3,'Customer3');

CREATE TABLE TRANSACTION (TRANSACTION_ID int,CUSTOMER_ID int ,TRANSACTION_DATE DATE,AMOUNT int);

INSERT INTO TRANSACTION VALUES (1,1,'2023-06-12',120),
							(2,2,'2023-07-01',85),
							(3,3,'2023-06-04',160),
							(4,1,'2023-07-01',90),
							(5,2,'2023-07-04',120),
							(6,3,'2023-07-05',165),
							(7,1,'2023-07-05',113),
							(8,2,'2023-06-27',80),
							(9,3,'2023-06-04',102),
                            (10,1,'2023-05-01',100),
							(11,2,'2023-05-01',150),
							(12,3,'2023-05-01',77);
						