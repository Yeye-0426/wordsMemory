CREATE TABLE words (
    word_id INT PRIMARY KEY,
    word_en VARCHAR(255) NOT NULL,
    usphone VARCHAR(255),
    ukphone VARCHAR(255),
    word_cn VARCHAR(255) NOT NULL,
    sound VARCHAR(255),
    word_modificationtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8;