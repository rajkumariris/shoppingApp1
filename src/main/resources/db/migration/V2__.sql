CREATE TABLE dummy
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    name            VARCHAR(255) NULL,
    CONSTRAINT pk_dummy PRIMARY KEY (id)
);

DROP TABLE catagories_seq;

DROP TABLE jt_user_seq;

DROP TABLE ms_instructor_seq;

DROP TABLE ms_mentor_seq;

DROP TABLE ms_ta_seq;

DROP TABLE product_seq;

DROP TABLE ta_user_seq;

DROP TABLE tbc_user_seq;