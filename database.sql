CREATE TABLE IF NOT EXISTS posts (
    post_id INT PRIMARY KEY AUTO_INCREMENT,
    title   TEXT NOT NULL,
    author  TEXT NOT NULL,
    creation_date DATE NOT NULL DEFAULT (datetime('now','localtime')),
    content TEXT NOT NULL,
);