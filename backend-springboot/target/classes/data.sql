-- Seed addresses
INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (1, '1', 'First St', 'A', '1 First St, City', '10001');

INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (2, '2', 'Second St', 'B', '2 Second St, City', '10002');

INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (3, '3', 'Third St', 'C', '3 Third St, City', '10003');

INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (4, '4', 'Fourth St', 'D', '4 Fourth St, City', '10004');

INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (5, '5', 'Fifth St', 'E', '5 Fifth St, City', '10005');

INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (6, '6', 'Sixth St', 'F', '6 Sixth St, City', '10006');

INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (7, '7', 'Seventh St', 'G', '7 Seventh St, City', '10007');

INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (8, '8', 'Eighth St', 'H', '8 Eighth St, City', '10008');

INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (9, '9', 'Ninth St', 'I', '9 Ninth St, City', '10009');

INSERT INTO addresses (id, block_number, road_name, building, full_address, postal_code)
VALUES (10, '10', 'Tenth St', 'J', '10 Tenth St, City', '10010');


-- Seed customers referencing addresses
INSERT INTO customers (id, name, address_id)
VALUES (1, 'Alice', 1);

INSERT INTO customers (id, name, address_id)
VALUES (2, 'Bob', 2);

INSERT INTO customers (id, name, address_id)
VALUES (3, 'Carol', 3);

INSERT INTO customers (id, name, address_id)
VALUES (4, 'Dave', 4);

INSERT INTO customers (id, name, address_id)
VALUES (5, 'Eve', 5);

INSERT INTO customers (id, name, address_id)
VALUES (6, 'Frank', 6);

INSERT INTO customers (id, name, address_id)
VALUES (7, 'Grace', 7);

INSERT INTO customers (id, name, address_id)
VALUES (8, 'Heidi', 8);

INSERT INTO customers (id, name, address_id)
VALUES (9, 'Ivan', 9);

INSERT INTO customers (id, name, address_id)
VALUES (10, 'Judy', 10);


-- Seed parent accounts table
-- IDs 1,3,5,7,9 are CHECKING
-- IDs 2,4,6,8,10 are SAVINGS
INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (1, 1500.75, 'CHECKING', 1);

INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (2, 8920.00, 'SAVINGS', 2);

INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (3, 340.40, 'CHECKING', 3);

INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (4, 2200.00, 'SAVINGS', 4);

INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (5, 50.00, 'CHECKING', 5);

INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (6, 9999.99, 'SAVINGS', 6);

INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (7, 120.00, 'CHECKING', 7);

INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (8, 450.50, 'SAVINGS', 8);

INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (9, 780.00, 'CHECKING', 9);

INSERT INTO accounts (id, balance, account_type, customer_id)
VALUES (10, 3000.25, 'SAVINGS', 10);


-- Insert concrete subclass rows for JOINED inheritance
-- checking_account and savings_account IDs must match IDs in accounts

-- Checking accounts
INSERT INTO checking_account (id, next_check_number)
VALUES (1, 1001);

INSERT INTO checking_account (id, next_check_number)
VALUES (3, 1003);

INSERT INTO checking_account (id, next_check_number)
VALUES (5, 1005);

INSERT INTO checking_account (id, next_check_number)
VALUES (7, 1007);

INSERT INTO checking_account (id, next_check_number)
VALUES (9, 1009);

-- Savings accounts
INSERT INTO savings_account (id, interest_rate)
VALUES (2, 2.0);

INSERT INTO savings_account (id, interest_rate)
VALUES (4, 1.8);

INSERT INTO savings_account (id, interest_rate)
VALUES (6, 2.5);

INSERT INTO savings_account (id, interest_rate)
VALUES (8, 1.2);

INSERT INTO savings_account (id, interest_rate)
VALUES (10, 1.75);


-- Reset identity counters so future inserts do not collide
ALTER TABLE addresses ALTER COLUMN id RESTART WITH 11;
ALTER TABLE customers ALTER COLUMN id RESTART WITH 11;
ALTER TABLE accounts ALTER COLUMN id RESTART WITH 11;