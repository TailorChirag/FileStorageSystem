CREATE TABLE files
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    created_at  datetime NULL,
    userid_id   BIGINT NULL,
    file_name   VARCHAR(255) NULL,
    file_path   VARCHAR(255) NULL,
    file_size DOUBLE NULL,
    uploaded_at datetime NULL,
    CONSTRAINT pk_files PRIMARY KEY (id)
);

CREATE TABLE user
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    hashed_passord VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE files
    ADD CONSTRAINT FK_FILES_ON_USERID FOREIGN KEY (userid_id) REFERENCES user (id);