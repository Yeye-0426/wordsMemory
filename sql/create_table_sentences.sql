CREATE TABLE sentences (
    sentence_id INT AUTO_INCREMENT PRIMARY KEY,
    sentence_wid INT,
    sentence_wen VARCHAR(255),
    sentence_en VARCHAR(255),
    sentence_cn VARCHAR(255),
    sentence_modificationtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)engine=InnoDB auto_increment=1 default charset=utf8;