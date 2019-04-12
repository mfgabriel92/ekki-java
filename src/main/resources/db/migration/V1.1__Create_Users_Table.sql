CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    phone VARCHAR(16),
    balance DECIMAL(15, 2) DEFAULT 1000,

    PRIMARY KEY (id)
);

INSERT INTO users (name, cpf, phone)
VALUES ('John Doe', '031.114.430-03', '(51) 9 9999-9999');