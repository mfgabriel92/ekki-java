CREATE TABLE IF NOT EXISTS transfers (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    beneficiary_id INT NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    created_at DATETIME DEFAULT NOW(),

    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(beneficiary_id) REFERENCES beneficiaries(id)
)