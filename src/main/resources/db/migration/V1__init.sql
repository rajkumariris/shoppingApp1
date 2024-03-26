CREATE TABLE catagories
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    CONSTRAINT pk_catagories PRIMARY KEY (id)
);

CREATE TABLE jt_instructor
(
    user_id     BIGINT NOT NULL,
    is_handsome BIT(1) NOT NULL,
    CONSTRAINT pk_jt_instructor PRIMARY KEY (user_id)
);

CREATE TABLE jt_mentor
(
    user_id       BIGINT NOT NULL,
    noof_sessions INT    NOT NULL,
    no_of_mentees INT    NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (user_id)
);

CREATE TABLE jt_ta
(
    user_id BIGINT NOT NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (user_id)
);

CREATE TABLE jt_user
(
    id       BIGINT NOT NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE ms_instructor
(
    id          BIGINT NOT NULL,
    email       VARCHAR(255) NULL,
    password    VARCHAR(255) NULL,
    is_handsome BIT(1) NOT NULL,
    CONSTRAINT pk_ms_instructor PRIMARY KEY (id)
);

CREATE TABLE ms_mentor
(
    id            BIGINT NOT NULL,
    email         VARCHAR(255) NULL,
    password      VARCHAR(255) NULL,
    noof_sessions INT    NOT NULL,
    no_of_mentees INT    NOT NULL,
    CONSTRAINT pk_ms_mentor PRIMARY KEY (id)
);

CREATE TABLE ms_ta
(
    id       BIGINT NOT NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_ms_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    price           INT    NOT NULL,
    title           VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    catagory_id     BIGINT NULL,
    image_url       VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE ta_user
(
    id            BIGINT NOT NULL,
    user_type     INT NULL,
    email         VARCHAR(255) NULL,
    password      VARCHAR(255) NULL,
    noof_sessions INT    NOT NULL,
    no_of_mentees INT    NOT NULL,
    average_rating DOUBLE NOT NULL,
    is_handsome   BIT(1) NOT NULL,
    CONSTRAINT pk_ta_user PRIMARY KEY (id)
);

CREATE TABLE tbc_instructor
(
    id          BIGINT NOT NULL,
    email       VARCHAR(255) NULL,
    password    VARCHAR(255) NULL,
    is_handsome BIT(1) NOT NULL,
    CONSTRAINT pk_tbc_instructor PRIMARY KEY (id)
);

CREATE TABLE tbc_mentor
(
    id            BIGINT NOT NULL,
    email         VARCHAR(255) NULL,
    password      VARCHAR(255) NULL,
    noof_sessions INT    NOT NULL,
    no_of_mentees INT    NOT NULL,
    CONSTRAINT pk_tbc_mentor PRIMARY KEY (id)
);

CREATE TABLE tbc_ta
(
    id             BIGINT NOT NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    average_rating VARCHAR(255) NULL,
    CONSTRAINT pk_tbc_ta PRIMARY KEY (id)
);

CREATE TABLE tbc_user
(
    id       BIGINT NOT NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tbc_user PRIMARY KEY (id)
);

ALTER TABLE jt_instructor
    ADD CONSTRAINT FK_JT_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATAGORY FOREIGN KEY (catagory_id) REFERENCES catagories (id);