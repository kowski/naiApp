CREATE TABLE shop_owner(
ID SERIAL PRIMARY KEY NOT NULL,
name TEXT NOT NULL,
surname TEXT NOT NULL,
phone_numb TEXT NOT NULL,
address TEXT NOT NULL
);

CREATE TABLE shop
(
ID SERIAL PRIMARY KEY NOT NULL,
city TEXT NOT NULL,
owner_id int REFERENCES shop_owner(id) ON UPDATE CASCADE ON DELETE CASCADE
);

insert into shop_owner(name,surname,phone_numb,address) values('Jan','Wlasciciel','132-33-33','Lodz');
insert into shop(city,owner_id) values('Lodz',1);
insert into shop(city,owner_id) values('Plock',1);