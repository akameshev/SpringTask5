CREATE TABLE tasks (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(50) NOT NULL ,
    status VARCHAR(50) NOT NULL ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);
