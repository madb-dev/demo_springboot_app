create table PRICES (
  brand_id INTEGER NOT NULL,
  start_date TIMESTAMP,
  end_date TIMESTAMP,
  price_list INTEGER,
  product_id INTEGER NOT NULL,
  priority INTEGER NOT NULL,
  price DECIMAL(5,2),
  curr VARCHAR(20)
);
