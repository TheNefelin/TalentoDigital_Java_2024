CREATE DATABASE bank_db;

USE bank_db;

CREATE TABLE  customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE banks_accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    balance DECIMAL(10, 2) NOT NULL,
    id_customers INT NOT NULL,
    CONSTRAINT fk_bank_customers FOREIGN KEY (id_customers) REFERENCES customers(id)
);

INSERT INTO customers
    (name)
VALUES
    ('Francisco Kataldo'),
    ('Carolina Lagos');

INSERT INTO banks_accounts
    (balance, id_customers)
VALUES
    (1000000, 1),
    (800000, 2);

UPDATE banks_accounts SET balance = 1000000 WHERE id = 1;
UPDATE banks_accounts SET balance = 800000 WHERE id = 2;
SELECT * FROM banks_accounts;

-- crear procedimiento almacenado
CREATE DEFINER=`root`@`localhost` PROCEDURE `transferir`(IN id_cli_1 INT, IN id_cli_2 INT, IN monto INT)
BEGIN
    DECLARE total INT DEFAULT 0;

    SET AUTOCOMMIT = OFF;

    UPDATE banks_accounts SET balance = balance - monto WHERE id_customers = id_cli_1;
    UPDATE banks_accounts SET balance = balance + monto WHERE id_customers = id_cli_2;

    SET total = (SELECT balance FROM banks_accounts WHERE id_customers = id_cli_1);

    IF (total >= 0) THEN
        COMMIT;
    ELSE
        ROLLBACK;
    END IF;

    SELECT * FROM banks_accounts;

    SET AUTOCOMMIT = ON;
END

-- ejecutar procedimiento almacenado
CALL transferir (1, 2, 200000);

CREATE TABLE cuentas (
    numero_cuenta INT NOT NULL UNIQUE PRIMARY KEY,
    balance FLOAT CHECK (balance >= 0.00)
);

TRUNCATE TABLE cuentas;

INSERT INTO cuentas (numero_cuenta, balance) VALUES (1, 1000);
INSERT INTO cuentas (numero_cuenta, balance) VALUES (2, 1000);

UPDATE cuentas SET balance = 1000 WHERE numero_cuenta = 1;
UPDATE cuentas SET balance = 1000 WHERE numero_cuenta = 2;

START TRANSACTION;
UPDATE cuentas SET balance = balance - 1000 WHERE numero_cuenta = 1;
UPDATE cuentas SET balance = balance + 1000 WHERE numero_cuenta = 2;
COMMIT;
SELECT * FROM cuentas;

START TRANSACTION;
UPDATE cuentas SET balance = balance + 1000 WHERE numero_cuenta = 2;
UPDATE cuentas SET balance = balance - 1000 WHERE numero_cuenta = 1;
ROLLBACK;
SELECT * FROM cuentas;

START TRANSACTION;
INSERT INTO cuentas(numero_cuenta, balance) VALUES (3, 5000);
SAVEPOINT nueva_cuenta;
UPDATE cuentas SET balance = balance + 3000 WHERE numero_cuenta = 3;
UPDATE cuentas SET balance = balance - 3000 WHERE numero_cuenta = 2;
ROLLBACK TO nueva_cuenta;
COMMIT;
SELECT * FROM cuentas;

INSERT INTO cuentas
    (numero_cuenta, balance)
VALUES
    (4, 7000),
    (5, 500),
    (6, 1200),
    (7, 900),
    (8, 100),
    (9, 20000),
    (10, 50);

SELECT * FROM cuentas WHERE balance >= 2000;
SELECT * FROM cuentas WHERE balance <= 1000;
SELECT AVG(balance) FROM cuentas;
SELECT AVG(balance) FROM cuentas WHERE balance >= 2000;

SELECT * FROM cuentas;
