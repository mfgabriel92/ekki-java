CREATE TABLE IF NOT EXISTS users (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(45) NOT NULL,
    user_cpf VARCHAR(15) NOT NULL,
    user_phone VARCHAR(16),
    user_balance DECIMAL(15, 2) DEFAULT 1000,

    PRIMARY KEY (user_id)
);

INSERT INTO users (user_name, user_cpf, user_phone)
VALUES ('John Doe', '031.114.430-03', '(51) 9 9999-9999');