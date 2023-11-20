CREATE TABLE exam (
    exam_id INT AUTO_INCREMENT PRIMARY KEY,
    exam_type INT NOT NULL,
    exam_wid INT NOT NULL,
    question VARCHAR(255),
    choice_1 VARCHAR(30),
    choice_2 VARCHAR(30),
    choice_3 VARCHAR(30),
    choice_4 VARCHAR(30),
    exam_explain VARCHAR(255),
    rightindex INT,
    exam_modificationtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)engine=InnoDB auto_increment=1 default charset=utf8;