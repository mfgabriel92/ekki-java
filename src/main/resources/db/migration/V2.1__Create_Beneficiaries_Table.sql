CREATE TABLE IF NOT EXISTS beneficiaries (
    beneficiary_id INT NOT NULL AUTO_INCREMENT,
    beneficiary_user_id INT NOT NULL,
    beneficiary_name VARCHAR(45) NOT NULL,
    beneficiary_account_number VARCHAR(15) NOT NULL,
    beneficiary_agency VARCHAR(4) NOT NULL,
    beneficiary_bank_name VARCHAR(15) NOT NULL,
    beneficiary_city VARCHAR(30) NOT NULL,
    beneficiary_state VARCHAR(2) NOT NULL,
    beneficiary_balance DECIMAL(15, 2) DEFAULT 0,
    beneficiary_created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    beneficiary_updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (beneficiary_id),
    FOREIGN KEY (beneficiary_user_id) REFERENCES users(user_id) ON DELETE CASCADE
)