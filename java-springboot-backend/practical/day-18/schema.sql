CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE TABLE employees (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  name TEXT NOT NULL,
  email TEXT NOT NULL UNIQUE,
  attrs JSONB NOT NULL DEFAULT '{}'::jsonb
);
INSERT INTO employees (name, email, attrs)
VALUES ('Ada', 'ada@example.com', '{"dept":"ENG"}'::jsonb);
SELECT id, email, attrs->>'dept' AS dept FROM employees;
INSERT INTO employees (name, email) VALUES ('Ada', 'ada@example.com')
ON CONFLICT (email) DO UPDATE SET name = EXCLUDED.name;
