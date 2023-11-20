CREATE TABLE newword (
    newword_id INT AUTO_INCREMENT PRIMARY KEY,
    newword_wid INT NOT NULL,
    newword_uid INT NOT NULL,
    newword_reviewtimes INT DEFAULT 0,
    newword_forgettimes INT DEFAULT 0,
    newword_proficiency INT DEFAULT 0,
    newword_modificationtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)engine=InnoDB auto_increment=1 default charset=utf8;