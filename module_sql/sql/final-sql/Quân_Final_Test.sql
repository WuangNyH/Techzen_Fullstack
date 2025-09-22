-- Câu 1
SELECT
    order_number,
    order_date,
    status
FROM orders
WHERE status = 'DELIVERED'
ORDER BY order_date DESC, order_number ASC
LIMIT 50
OFFSET 50 * (4 - 1);

-- Câu 2
SELECT 
    signup_source,
    COUNT(*) as tong_so_khach,
    COUNT(*) FILTER (WHERE marketing_opt_in = TRUE) as so_khach_opt_in,
    CONCAT(ROUND(
        100.0 * COUNT(*) FILTER (WHERE marketing_opt_in = TRUE) / COUNT(*),
        2
    ), '%'),
    BOOL_OR(marketing_opt_in) AS any_opt_in,
	BOOL_AND(marketing_opt_in) AS all_opt_in
FROM customer
GROUP BY signup_source;

-- Câu 3
SELECT
	city,
    COUNT(*) AS so_khach_hang,
	ARRAY_TO_STRING((ARRAY_AGG(customer_name ORDER BY CREATED_AT DESC)) [1:5], ', ') AS five_customer_name
FROM customer
WHERE is_active = TRUE AND vip_tier IN ('GOLD', 'PLATINUM')
GROUP BY city
ORDER BY so_khach_hang DESC
LIMIT 10;

-- Câu 4
SELECT *
FROM (
    SELECT 
        DATE_TRUNC('DAY', order_date) as date,
        SUM(total_amount) as tong_doanh_thu
    FROM orders
    GROUP BY DATE_TRUNC('DAY', order_date)
) AS daily_revenue
ORDER BY tong_doanh_thu DESC
LIMIT 1;

-- Câu 5 
SELECT DISTINCT
    c.customer_id,
    c.customer_name
FROM customer c
JOIN orders o USING (customer_id)
WHERE o.status = 'CANCELLED';

-- Câu 6
DROP SCHEMA IF EXISTS lab2 CASCADE;
CREATE SCHEMA lab2;

-- Set search path
SET search_path to lab2, public;

-- Tạo bảng customer2 
CREATE TABLE IF NOT EXISTS customers2 (
    customer_id         SERIAL          PRIMARY KEY,
    full_name           VARCHAR(150)    NOT NULL,
    email               VARCHAR(200)    UNIQUE,
    phone_number        VARCHAR(15)     CHECK (phone_number ~ '^[0-9]+$'),
    birth_date          DATE,
    is_active           BOOLEAN         DEFAULT TRUE,
    created_at          TIMESTAMPTZ     DEFAULT CURRENT_TIMESTAMP
)

-- Enum order_status
CREATE TYPE order_status AS ENUM ('pending', 'completed', 'canceled');

-- Tạo bảng orders
CREATE TABLE IF NOT EXISTS orders2 (
    order_id            SERIAL          PRIMARY KEY,
    customer_id         INTEGER         NOT NULL,
    order_date          TIMESTAMPTZ     DEFAULT CURRENT_TIMESTAMP,
    total_amount        NUMERIC(12,2)   CHECK (total_amount >= 0),
    status              order_status    DEFAULT 'pending',

    CONSTRAINT fk_orders2_customers2
	FOREIGN KEY (customer_id)
	REFERENCES customers2 (customer_id)
	ON DELETE CASCADE
)

-- 5 dòng dữ liệu hợp lệ vào bảng lab2.customers2
INSERT INTO customers2 (full_name, email, phone_number, birth_date)
VALUES 
('Trần Lê Minh Quân', 'quantlm@example.com', '0912345678', '2003-10-02'),
('Nguyễn Quang Minh', 'minhnq@example.com', '0987654321', '2003-05-15'),
('Lưu Ngọc Yến Như', 'nhulny@example.com', '0901122334', '2004-09-20'),
('Trần Hữu Thủy', 'thuyth@example.com', '0933445566', '2003-12-30'),
('Nguyen Van A', 'anv@example.com', '0977554433', '1995-07-07');

-- 10 dòng dữ liệu hợp lệ vào bảng lab2.orders2
INSERT INTO orders2 (customer_id, total_amount, status) VALUES
(1, 1500000, 'completed'),
(2, 250000, 'pending'),
(3, 500000, 'canceled'),
(4, 1200000, 'completed'),
(5, 300000, 'pending'),
(1, 800000, 'completed'),
(2, 950000, 'canceled'),
(3, 400000, 'pending'),
(4, 2000000, 'completed'),
(5, 600000, 'completed');

-- 6.4
UPDATE customers2
SET is_active = FALSE
WHERE birth_date IS NULL
RETURNING *;

-- 6.5
DELETE
FROM customers2
WHERE email IS NULL AND is_active = FALSE
RETURNING *;

-- 6.6
ALTER TYPE ORDER_STATUS ADD VALUE 'returned';

INSERT INTO orders2 (customer_id, total_amount, status) VALUES
(1, 1500000, 'returned')

-- 6.7
-- Chuyển các order có status RETURNED sang CANCELED
UPDATE orders2
SET STATUS = 'canceled'
WHERE STATUS = 'returned'
RETURNING *;

-- Tạo enum mới không chứa RETURNED
CREATE TYPE order_status_new AS ENUM ('pending', 'completed', 'canceled');

-- Xóa default cột status
ALTER TABLE orders2 ALTER COLUMN STATUS DROP DEFAULT;

-- Đổi status sang type mới
ALTER TABLE orders2
ALTER COLUMN status TYPE order_status_new
USING status::text::order_status_new;

-- Xóa type cũ
DROP TYPE order_status;

-- Đổi tên type mới thành tên cũ
ALTER TYPE order_status_new RENAME TO order_status;

-- Đặt lại default
ALTER TABLE orders2 ALTER COLUMN status SET DEFAULT 'pending';

-- Câu 7
SELECT
    o.status,
    COUNT(*) as so_don_hang
FROM orders o
JOIN customer c USING (customer_id)
WHERE o.order_date >= CURRENT_DATE - 30
GROUP BY o.status;

-- Câu 8
SELECT
    c.customer_id,
    c.customer_name
FROM customer c
LEFT JOIN orders o 
ON c.customer_id = o.customer_id AND o.status = 'DELIVERED'
WHERE o.status IS NULL;

-- SET search path
SET search_path TO lab1, public;

-- Câu 9
SELECT
    o.*,
    SUM(oi.quantity * oi.unit_price) as tong_so_tien
FROM orders o
JOIN order_items oi USING (order_id)
GROUP BY o.order_id;

-- Câu 10
SELECT
    c.customer_id,
    COALESCE(SUM(oi.quantity * oi.unit_price), 0) as tong_so_tien
FROM orders o
JOIN order_items oi USING (order_id)
RIGHT JOIN customers c USING (customer_id)
GROUP BY c.customer_id
ORDER BY tong_so_tien DESC;

-- Câu 11
SELECT
    c.customer_id,
    c.customer_name,
    count(o.*) AS orders_count
FROM orders o
RIGHT JOIN customers c USING (customer_id)
GROUP BY c.customer_id
ORDER BY orders_count DESC, customer_name;

-- Câu 12
WITH orders_over_400k as (
    SELECT
        o.order_id,
        o.customer_id,
        SUM(oi.quantity * oi.unit_price) as tong_gia_tri,
        s.shipper_name
    FROM orders o
    JOIN order_items oi USING (order_id)
    LEFT JOIN shipments USING (order_id)
    LEFT JOIN shippers s USING (shipper_id)
    GROUP BY o.order_id, s.shipper_name
    HAVING SUM(oi.quantity * oi.unit_price) > 400000
)
SELECT
    c.customer_name,
    o.shipper_name,
    o.tong_gia_tri
FROM orders_over_400k o
JOIN customers c USING (customer_id);

-- Câu 13
WITH doanh_thu AS (
    SELECT
        o.customer_id,
        sp.shipper_name,
        SUM(oi.quantity * oi.unit_price) AS tong_doanh_thu
    FROM orders o
    JOIN order_items oi USING (order_id)
    JOIN shipments s USING (order_id)
    JOIN shippers sp USING (shipper_id)
    GROUP BY o.order_id, sp.shipper_name
)
SELECT
    c.customer_id,
    c.customer_name,
    COALESCE(dt.tong_doanh_thu, 0) AS tong_doanh_thu,
    dt.shipper_name
FROM customers c
LEFT JOIN doanh_thu dt USING (customer_id)

-- Câu 14
WITH payment_success as (
    SELECT order_id
    FROM payments
    WHERE status = 'SUCCESS'
)
SELECT 
    c.category_name,
    SUM(oi.quantity * oi.unit_price) as revenue
FROM orders o
JOIN order_items oi USING (order_id)
JOIN products USING (product_id)
JOIN product_categories USING (product_id)
JOIN categories c USING (category_id)
JOIN payment_success ps USING (order_id)
GROUP BY c.category_name;

-- Câu 15
SELECT
    cs.customer_id,
    cs.customer_name,
    COUNT(DISTINCT c.category_name) as distinct_categories,
    STRING_AGG(DISTINCT c.category_name, ', ') as categories_list
FROM orders o
JOIN order_items oi USING (order_id)
JOIN products p USING (product_id)
JOIN product_categories pc USING (product_id)
JOIN categories c USING (category_id)
JOIN customers cs USING (customer_id)
GROUP BY cs.customer_id;

-- SET search path
SET search_path TO public;

-- Câu 16
EXPLAIN ANALYZE
SELECT order_number
FROM orders
WHERE date_trunc('day', order_date) = DATE '2025-08-01';

CREATE INDEX IF NOT EXISTS idx_orders_order_date ON orders (order_date) INCLUDE (order_number);

EXPLAIN ANALYZE
SELECT order_number
FROM orders
WHERE order_date >= '2025-08-01' AND order_date <  '2025-08-02';

-- Câu 17
EXPLAIN ANALYZE
SELECT
    order_number,
    customer_id,
    order_date,
    total_amount
FROM orders
WHERE status = 'DELIVERED'
ORDER BY order_date DESC, order_number ASC
LIMIT 50 OFFSET 0;

CREATE INDEX IF NOT EXISTS idx_orders_status_date_number 
ON orders (status, order_date DESC, order_number) INCLUDE (customer_id, total_amount);

EXPLAIN ANALYZE
SELECT
    order_number,
    customer_id,
    order_date,
    total_amount
FROM orders
WHERE status = 'DELIVERED'
ORDER BY order_date DESC, order_number ASC
LIMIT 50;

-- Câu 18
EXPLAIN ANALYZE
SELECT
    o.order_number,
    o.order_date,
    c.customer_name
FROM orders o
JOIN customer c ON o.customer_id = c.customer_id
WHERE o.order_date = '2025-01-01';
-- Dùng lại index câu 16 

-- Câu 19
EXPLAIN ANALYZE
SELECT
    c.customer_id,
    c.customer_name
FROM customer c
WHERE (
    SELECT SUM(o.total_amount)
    FROM orders o
    WHERE o.customer_id = c.customer_id
) > 30000;

EXPLAIN ANALYZE
SELECT
    c.customer_id,
    c.customer_name
FROM customer c
JOIN orders o USING (customer_id)
GROUP BY c.customer_id
HAVING SUM(o.total_amount) > 30000;

-- Câu 20
EXPLAIN ANALYZE
SELECT
    c.customer_id,
    c.customer_name,
    (
        SELECT
            MAX(o.order_date) 
        FROM orders o
        WHERE o.customer_id = c.customer_id
    ) AS last_order_date
FROM customer c
WHERE c.email LIKE '%@gmail.com';

EXPLAIN ANALYZE
WITH customer_gmail as (
    SELECT
        customer_id,
        customer_name
    FROM customer
    WHERE email LIKE '%@gmail.com'
)
SELECT
    c.customer_id,
    c.customer_name,
    MAX(o.order_date) as last_order_date
FROM orders o
JOIN customer_gmail c USING (customer_id)
GROUP BY c.customer_id, c.customer_name;

