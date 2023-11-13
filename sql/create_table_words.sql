CREATE TABLE words (
    word_id INT AUTO_INCREMENT PRIMARY KEY,
    word_en VARCHAR(255) NOT NULL,
    word_soundmark VARCHAR(255),
    word_cn VARCHAR(255) NOT NULL,
    word_note TEXT,
    word_sound VARCHAR(255),
    word_reviewtimes INT DEFAULT 0,
    word_forgettimes INT DEFAULT 0,
    word_proficiency INT DEFAULT 0,
    word_modificationtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);