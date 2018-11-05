CREATE TABLE t_price
(
    color_id    NUMBER          NOT NULL, 
    price       NUMBER          NOT NULL, 
    color       VARCHAR2(20)    NOT NULL, 
    CONSTRAINT T_PRICE_PK PRIMARY KEY (color_id)
);

COMMENT ON TABLE t_price IS '가격테이블입니다.';

COMMENT ON COLUMN t_price.color_id IS '접시색깔아이디';

COMMENT ON COLUMN t_price.price IS '가격';

COMMENT ON COLUMN t_price.color IS '접시색깔';

select *
    from t_price;
    
insert into t_price values (301,1000,'red');

insert into t_price values (302,1500,'blue');

insert into t_price values (303,3000,'green');

insert into t_price values (304,4500,'yellow');

commit;


