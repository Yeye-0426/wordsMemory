CREATE TABLE thesaurus (
    thesaurus_id INT AUTO_INCREMENT PRIMARY KEY,
    thesaurus_wid INT,
    thesaurus_name VARCHAR(255),
    thesaurus_modificationtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)engine=InnoDB auto_increment=1 default charset=utf8;