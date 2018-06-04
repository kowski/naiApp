CREATE TABLE supplier
(
ID SERIAL PRIMARY KEY NOT NULL,
company_name TEXT NOT NULL,
contact_number TEXT NOT NULL,
city TEXT NOT NULL
);
CREATE TABLE product
(
  ID SERIAL PRIMARY KEY NOT NULL,
  code text NOT NULL,
  product_code text NOT NULL,
  name text NOT NULL,
  body text,
  supplier_id INT not null REFERENCES supplier(ID)
);



insert into supplier(company_name,contact_number,city) values('Natural Products','333-333','Lodz');
insert into product(code,product_code,name,body,supplier_id) values('A1','AA2','Milk','Milk',1);