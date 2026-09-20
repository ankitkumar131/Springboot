-- Run inside MySQL after: CREATE DATABASE app_db; USE app_db;

CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(80) NOT NULL,
  email VARCHAR(120) NOT NULL UNIQUE,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE orders (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  total_cents INT NOT NULL,
  CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (name, email) VALUES ('Ada', 'ada@example.com');
INSERT INTO orders (user_id, total_cents) VALUES (1, 1999);

SELECT u.name, o.total_cents
FROM users u
JOIN orders o ON o.user_id = u.id;

-- CRUD
INSERT INTO users (name, email) VALUES ('Grace', 'grace@example.com');
SELECT * FROM users WHERE id = 1;
UPDATE users SET name = 'Ada Lovelace' WHERE id = 1;
DELETE FROM orders WHERE id = 1;
