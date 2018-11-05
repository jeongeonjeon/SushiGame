CREATE TABLE t_user
(
    name       VARCHAR2(20)    NOT NULL, 
    profit     NUMBER          NULL, 
    loss       NUMBER          NULL, 
    score      NUMBER          NULL, 
    ranking    NUMBER          NOT NULL, 
    CONSTRAINT T_USER_PK PRIMARY KEY (name)
)
/

COMMENT ON TABLE t_user IS '사용자 테이블입니다.'
/

COMMENT ON COLUMN t_user.name IS '사용자'
/

COMMENT ON COLUMN t_user.profit IS '수익금'
/

COMMENT ON COLUMN t_user.loss IS '폐기'
/

COMMENT ON COLUMN t_user.score IS '최종점수'
/

COMMENT ON COLUMN t_user.ranking IS '최종등수'
/