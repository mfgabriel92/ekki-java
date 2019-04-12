CREATE TABLE IF NOT EXISTS beneficiaries (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    name VARCHAR(45) NOT NULL,
    account VARCHAR(15) NOT NULL,
    balance DECIMAL(15, 2) DEFAULT 0,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
)