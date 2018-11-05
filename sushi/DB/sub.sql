CREATE TABLE t_sub_menu
(
    drink_id      NUMBER          NOT NULL, 
    drink_name    VARCHAR2(20)    NOT NULL, 
    color_id      NUMBER          NOT NULL, 
    CONSTRAINT T_SUB_MENU_PK PRIMARY KEY (drink_id)
);


COMMENT ON TABLE t_sub_menu IS '음료 메뉴 테이블 입니다.';


COMMENT ON COLUMN t_sub_menu.drink_id IS '음료아이디';


COMMENT ON COLUMN t_sub_menu.drink_name IS '음료 종류이름';


COMMENT ON COLUMN t_sub_menu.color_id IS '접시색깔 아이디';


ALTER TABLE t_sub_menu
    ADD CONSTRAINT FK_t_sub_menu_color_id_t_price FOREIGN KEY (color_id)
        REFERENCES t_price (color_id);
        
select *
from t_sub_menu;

insert into t_sub_menu values (201,'cider',301);

insert into t_sub_menu values (202,'coke',302);

insert into t_sub_menu values (203,'juice',303);

insert into t_sub_menu values (204,'beer',304);

commit;



