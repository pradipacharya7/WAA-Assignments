INSERT INTO users(username, password, enabled) VALUES ( 'user', 'user', true );
INSERT INTO users(username, password, enabled) VALUES ( 'admin', 'admin', true );

INSERT INTO authorities(username, authority) VALUES ( 'user', 'ROLE_USER' );
INSERT INTO authorities(username, authority) VALUES ( 'admin', 'ROLE_ADMIN' );

insert into product (id,name,price, tax, cat_id, description, product_image, added_by) values (1,'Boot',1122.12,10,1,'this is boot','boot.jpg',2);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by) values (2,'Boat',1122.12,10,2,'this is boat','boat.jpg',2);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by) values (3,'Glasses',1122.12,10,3,'this is glasses','glasses.png',2);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by) values (4,'Iphoe11',1122.12,10,4,'this is iphone','glasses.jpg',2);


insert into product (id,name,price, tax, cat_id, description, product_image, added_by) values (1,'Boot',1122.12,10,1,'this is boot','boot.jpg',2);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by) values (2,'Boat',1122.12,10,2,'this is boat','boat.jpg',2);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by) values (3,'Glasses',1122.12,10,3,'this is glasses','glasses.png',2);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by) values (4,'Iphoe11',1122.12,10,4,'this is iphone','glasses.jpg',2);