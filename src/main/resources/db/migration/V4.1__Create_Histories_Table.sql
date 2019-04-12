CREATE TABLE IF NOT EXISTS histories (
    id INT NOT NULL AUTO_INCREMENT,
    transfers_id INT NOT NULL,
    type VARCHAR(15) NOT NULL,
    created_at DATETIME DEFAULT NOW(),

    PRIMARY KEY(id),
    FOREIGN KEY(transfers_id) REFERENCES transfers(id)
)