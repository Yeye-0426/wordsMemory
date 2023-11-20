CREATE TABLE users (
	user_id INT AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(255) NOT NULL,
	user_email VARCHAR(255) NOT NULL,
	user_password VARCHAR(255) NOT NULL,
	user_pepdom VARCHAR(255) NOT NULL
)engine=InnoDB auto_increment=1 default charset=utf8;