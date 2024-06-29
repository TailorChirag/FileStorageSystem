CREATE TABLE files
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    created_at  datetime NULL,
    file_name   VARCHAR(255) NULL,
    file_path   VARCHAR(255) NULL,
    file_size DOUBLE NULL,
    uploaded_at datetime NULL,
    CONSTRAINT pk_files PRIMARY KEY (id)
);