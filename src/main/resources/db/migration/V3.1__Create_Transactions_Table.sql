CREATE TABLE IF NOT EXISTS transactions (
    transaction_id INT NOT NULL AUTO_INCREMENT,
    transaction_user_id INT NOT NULL,
    transaction_beneficiary_id INT NOT NULL,
    transaction_amount DECIMAL(15, 2) NOT NULL,
    transaction_created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY(transaction_id),
    FOREIGN KEY(transaction_user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY(transaction_beneficiary_id) REFERENCES beneficiaries(beneficiary_id) ON DELETE CASCADE
)