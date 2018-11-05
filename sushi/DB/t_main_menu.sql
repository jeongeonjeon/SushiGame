CREATE TABLE t_main_menu
(
    menu_id      NUMBER          NOT NULL, 
    menu_name    VARCHAR2(20)    NOT NULL, 
    color_id     NUMBER          NOT NULL, 
    CONSTRAINT T_MAIN_MENU_PK PRIMARY KEY (menu_id)
)
;

COMMENT ON TABLE t_main_menu IS '메인메뉴 테이블입니다.(초밥)'
;

COMMENT ON COLUMN t_main_menu.menu_id IS '초밥아이디'
;

COMMENT ON COLUMN t_main_menu.menu_name IS '초밥이름'
;

COMMENT ON COLUMN t_main_menu.color_id IS '접시색깔 아이디'
;

ALTER TABLE t_main_menu
    ADD CONSTRAINT FK_t_main_menu_color_id_t_pric FOREIGN KEY (color_id)
        REFERENCES t_price (color_id)
;
insert into t_main_menu values (101,'egg',301);

insert into t_main_menu values (102,'tuna',302);

insert into t_main_menu values (103,'shrimp',303);

insert into t_main_menu values (104,'salmon',304);

commit;