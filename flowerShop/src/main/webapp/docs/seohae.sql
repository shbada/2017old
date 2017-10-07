--10.07

ALTER TABLE product
MODIFY (product_mod number default 10);

ALTER TABLE product
MODIFY (product_buycnt number default 0);

ALTER TABLE product
MODIFY (product_saleyn varchar2(1) default 'N');
CREATE SEQUENCE after_reply_seq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE seq_cart
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE seq_product
START WITH 1
INCREMENT BY 1;

ALTER TABLE product RENAME COLUMN product_comment TO product_desc;

ALTER TABLE after_reply
ADD (user_id varchar2(20));