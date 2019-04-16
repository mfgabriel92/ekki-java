CREATE TABLE IF NOT EXISTS beneficiaries (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    name VARCHAR(45) NOT NULL,
    account_number VARCHAR(15) NOT NULL,
    agency VARCHAR(4) NOT NULL,
    bank_name VARCHAR(15) NOT NULL,
    city VARCHAR(30) NOT NULL,
    state VARCHAR(2) NOT NULL,
    balance DECIMAL(15, 2) DEFAULT 0,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
)