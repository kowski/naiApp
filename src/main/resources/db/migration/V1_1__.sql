CREATE TABLE orders
(
ID SERIAL PRIMARY KEY NOT NULL,
order_date date NOT NULL
);

CREATE TABLE order_product
(
order_id int REFERENCES orders(id) ON UPDATE CASCADE ON DELETE CASCADE,
product_id int REFERENCES product(id) ON UPDATE CASCADE,
CONSTRAINT order_product_pkey PRIMARY KEY (order_id,product_id));
);