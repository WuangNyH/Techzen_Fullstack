-- 0) Chuẩn bị môi trường
-- Tạo schema lab để mọi bảng tạo trong lab
CREATE SCHEMA IF NOT EXISTS LAB;

-- Đặt search_path để ưu tiên schema lab trước
SET SEARCH_PATH TO LAB, PUBLIC;
SHOW SEARCH_PATH;

-- Nếu đã có bảng cũ (customers2, orders2), enum cũ (order_status), 
-- hãy dọn dẹp sạch sẽ trước để chuẩn bị môi trường.
DROP TABLE IF EXISTS ORDERS2 CASCADE;
DROP TABLE IF EXISTS CUSTOMERS2 CASCADE;
DROP TYPE IF EXISTS ORDER_STATUS CASCADE;


-- A) Cấu trúc bảng, kiểu dữ liệu & ràng buộc
-- 1. Tạo bảng customers2 với các cột & ràng buộc như đề (SERIAL PK, NOT NULL, UNIQUE, CHECK, DEFAULT, TIMESTAMPTZ)
-- - customer_id: khóa chính
-- - full_name: kiểu VARCHAR, ràng buộc không cho phép dữ liệu trống
-- - email: kiểu VARCHAR, ràng buộc dữ liệu không trùng lặp
-- - phone_number: kiểu VARCHAR, ràng buộc CHECK chỉ cho nhập ký tự số 0 đến 9
-- - birth_date: kiểu DATE
-- - is_active: kiểu BOOLEAN với giá trị mặc định là TRUE
-- - created_at: kiểu TIMESTAMPTZ với giá trị mặc định là ngày giờ hiện tại theo hệ thống
CREATE TABLE CUSTOMERS2 (
	CUSTOMER_ID 	SERIAL 			PRIMARY KEY,
	FULL_NAME 		VARCHAR(100) 	NOT NULL,
	EMAIL 			VARCHAR(150) 	UNIQUE,
	PHONE_NUMBER 	VARCHAR(15) 	CHECK (PHONE_NUMBER ~ '^[0-9]+$'),
	BIRTH_DATE 		DATE,
	IS_ACTIVE 		BOOLEAN 		DEFAULT TRUE,
	CREATED_AT 		TIMESTAMPTZ		DEFAULT CURRENT_TIMESTAMP
);

-- 2. Giải thích vì sao phone_number nên là VARCHAR thay vì INT
-- Vì số điện thoại có thể bắt đầu bằng số 0 nếu dùng INT khi INSERT dữ liệu
-- sẽ mất số -> dữ liệu không đúng.

-- 3. Thêm 1 dòng dữ liệu hợp lệ; thử chèn 1 dòng sai định dạng phone_number để quan sát lỗi
-- Hợp lệ
INSERT INTO CUSTOMERS2 (FULL_NAME, EMAIL, PHONE_NUMBER, BIRTH_DATE)
VALUES ('Trần Lê Minh Quân', 'quantlm.0210@gmail.com', '0979702058', '2003-10-02');

-- Không hợp lệ
INSERT INTO CUSTOMERS2 (FULL_NAME, EMAIL, PHONE_NUMBER, BIRTH_DATE)
VALUES ('Sai Phone Number', 'bad@example.com', '09-123-456', '1972-01-01'); 
-- ERROR:  new row for relation "customers2" violates check constraint "customers2_phone_number_check"


-- B) Khởi tạo bảng có ENUM & khóa ngoại
-- 1. Tạo TYPE order_status AS ENUM ('pending','completed','canceled')
CREATE TYPE ORDER_STATUS AS ENUM ('PENDING', 'COMPLETED', 'CANCELED');

-- 2. Tạo bảng orders2 có FK đến customers2(customer_id)
-- - order_id: khóa chính
-- - order_date: kiểu TIMESTAMPTZ với giá trị mặc định là ngày giờ hiện tại theo hệ thống
-- - total_amount: kiểu NUMERIC(12,2) có ràng buộc CHECK >= 0
-- - status: dùng kiểu ENUM, với giá trị mặc định là 'pending'
CREATE TABLE ORDERS2 (
	ORDER_ID 		SERIAL 			PRIMARY KEY,
	CUSTOMER_ID		INTEGER			NOT NULL,
	ORDER_DATE		TIMESTAMPTZ		DEFAULT CURRENT_TIMESTAMP,
	TOTAL_AMOUNT	NUMERIC(12,2)	CHECK (TOTAL_AMOUNT >= 0),
	STATUS			ORDER_STATUS	DEFAULT 'PENDING',

	CONSTRAINT FK_ORDERS2_CUSTOMERS2
	FOREIGN KEY (CUSTOMER_ID)
	REFERENCES CUSTOMERS2 (CUSTOMER_ID)
	ON DELETE CASCADE
);


-- C) INSERT – thêm dữ liệu & kiểm tra ràng buộc
-- 1. Thêm 3 khách hàng mới với dữ liệu hợp lệ vào customers2
INSERT INTO CUSTOMERS2 (FULL_NAME, EMAIL, PHONE_NUMBER, BIRTH_DATE)
VALUES
	('Nguyen Van A', 'vana@example.com', '0912345678', '1995-05-20'),
	('Tran Thi B', 'thib@example.com', '0981234567', '2000-10-15'),
	('Le Van C', 'c.le@example.com', '0987654321', '1988-03-08');

-- 2. Thêm 3 khách hàng tiếp theo vào customers2 với dữ liệu:
-- - Một khách không có email (để kiểm tra cột email có thể NULL)
INSERT INTO CUSTOMERS2 (FULL_NAME, PHONE_NUMBER, BIRTH_DATE)
VALUES ('Nguyen Van D', '0912344544', '1998-05-20');

-- - Một khách có phone_number chứa khoảng trắng (ví dụ '0912 345 678') để quan sát hành vi với CHECK
INSERT INTO CUSTOMERS2 (FULL_NAME, EMAIL, PHONE_NUMBER, BIRTH_DATE)
VALUES ('Tran Thi B', 'thib@example.com', '0981 234 567', '2000-10-15');
-- ERROR:  new row for relation "customers2" violates check constraint "customers2_phone_number_check"

-- - Một khách có birth_date để trống
INSERT INTO CUSTOMERS2 (FULL_NAME, EMAIL, PHONE_NUMBER)
VALUES ('Le Van E', 'vane@example.com', '0987654321');

-- 3. Thêm 4 đơn hàng (ít nhất 1 dòng status mặc định, 1 dòng completed)
-- - Hai đơn hàng cho cùng một khách hàng với các total_amount khác nhau
INSERT INTO ORDERS2 (CUSTOMER_ID, TOTAL_AMOUNT)
VALUES
	(1, 500),
	(1, 350);
	
-- - Một đơn hàng có status = 'completed'
INSERT INTO ORDERS2 (CUSTOMER_ID, TOTAL_AMOUNT, STATUS)
VALUES (3, 700, 'COMPLETED');

-- - Một đơn hàng không chỉ định status (để dùng giá trị mặc định)
INSERT INTO ORDERS2 (CUSTOMER_ID, TOTAL_AMOUNT)
VALUES (5, 550);

-- 4. Thử thêm 1 đơn hàng với total_amount là số âm để quan sát lỗi từ CHECK
INSERT INTO ORDERS2 (CUSTOMER_ID, TOTAL_AMOUNT)
VALUES (5, -550);
-- ERROR:  new row for relation "orders2" violates check constraint "orders2_total_amount_check"

-- 5. Thêm một giá trị ENUM mới, ví dụ 'returned', và chèn ít nhất 1 đơn hàng ở trạng thái này
ALTER TYPE ORDER_STATUS ADD VALUE 'RETURNED';

INSERT INTO ORDERS2 (CUSTOMER_ID, TOTAL_AMOUNT, STATUS)
VALUES (6, 220, 'RETURNED');

-- 6. Xóa giá trị ENUM ‘RETURNED’
-- Chuyển các order có status RETURNED sang CANCELED
UPDATE ORDERS2
SET STATUS = 'CANCELED'
WHERE STATUS = 'RETURNED'
RETURNING *;

-- Tạo enum mới không chứa RETURNED
CREATE TYPE ORDER_STATUS_NEW AS ENUM ('PENDING', 'COMPLETED', 'CANCELED');

-- Xóa default cột status
ALTER TABLE ORDERS2 ALTER COLUMN STATUS DROP DEFAULT;

-- Đổi status sang type mới
ALTER TABLE ORDERS2
ALTER COLUMN STATUS TYPE ORDER_STATUS_NEW
USING STATUS::TEXT::ORDER_STATUS_NEW;

-- Xóa type cũ
DROP TYPE ORDER_STATUS;

-- Đổi tên type mới thành tên cũ
ALTER TYPE ORDER_STATUS_NEW RENAME TO ORDER_STATUS;

-- Đặt lại default
ALTER TABLE ORDERS2 ALTER COLUMN STATUS SET DEFAULT 'PENDING';


-- D) UPDATE – cập nhật dữ liệu
-- 1. Đặt is_active = FALSE cho tất cả khách hàng có birth_date IS NULL
UPDATE CUSTOMERS2
SET IS_ACTIVE = FALSE
WHERE BIRTH_DATE IS NULL
RETURNING *;

-- 2. Với các khách hàng có email kết thúc bằng @example.com, thêm tiền tố [NEW] vào trước full_name
UPDATE CUSTOMERS2
SET FULL_NAME = CONCAT('[NEW] ', FULL_NAME)
WHERE EMAIL ILIKE '%@example.com'
RETURNING *;

-- 3. Xóa tiền tố [NEW] vừa thêm, đảm bảo:
-- - Chỉ xóa ở đầu chuỗi
-- - Không ảnh hưởng tới các vị trí khác nếu tình cờ xuất hiện trong tên
UPDATE CUSTOMERS2
SET FULL_NAME = REPLACE(FULL_NAME, '[NEW] ', '')
WHERE FULL_NAME ILIKE '[NEW]%'
RETURNING *;

-- 4. Cập nhật status = 'returned' cho tất cả đơn hàng của các khách hàng có is_active = FALSE
ALTER TYPE ORDER_STATUS ADD VALUE 'RETURNED';

UPDATE ORDERS2 O
SET STATUS = 'RETURNED'
FROM CUSTOMERS2 C
WHERE O.CUSTOMER_ID = C.CUSTOMER_ID AND IS_ACTIVE = FALSE
RETURNING O.*;

-- 5. Thử cập nhật email của 2 khách hàng khác nhau thành cùng một giá trị để quan sát lỗi ràng buộc UNIQUE
UPDATE CUSTOMERS2
SET EMAIL = 'quantlm.0210@gmail.com'
WHERE CUSTOMER_ID = 3;
-- ERROR:  duplicate key value violates unique constraint "customers2_email_key"


-- E) DELETE – xóa dữ liệu
-- 1. Xóa các đơn hàng có total_amount lớn hơn 900000 và status khác 'canceled'
DELETE FROM ORDERS2
WHERE TOTAL_AMOUNT > 900000 AND STATUS != 'CANCELED'
RETURNING *;

-- 2. Xóa tất cả đơn hàng thuộc các khách hàng không có birth_date (dùng điều kiện trên bảng customers2)
DELETE FROM ORDERS2 O
USING CUSTOMERS2 C
WHERE C.CUSTOMER_ID = O.CUSTOMER_ID AND C.BIRTH_DATE IS NULL
RETURNING O.*;

-- 3. Xóa các khách hàng có email IS NULL và is_active = FALSE
DELETE FROM CUSTOMERS2
WHERE EMAIL IS NULL AND IS_ACTIVE = FALSE
RETURNING *;


-- F) Transaction – BEGIN/COMMIT/ROLLBACK & SAVEPOINT
-- 1. Mở một transaction:
-- - Cập nhật status thành 'completed' cho tất cả đơn hàng của khách hàng customer_id = 1
-- - Thực hiện SELECT kiểm tra
-- - ROLLBACK và xác nhận dữ liệu quay về như cũ
BEGIN;

UPDATE ORDERS2
SET STATUS = 'COMPLETED'
WHERE CUSTOMER_ID = 1
RETURNING *;

SELECT *
FROM ORDERS2
WHERE CUSTOMER_ID = 1;

ROLLBACK;

-- 2. Mở transaction khác:
-- - Đặt is_active = FALSE cho những khách hàng có không đơn hàng nào (sử dụng NOT EXISTS)
-- - Tạo SAVEPOINT
-- - Thử DELETE một khách hàng vẫn còn đơn hàng, rồi rollback lại về SAVEPOINT
-- - COMMIT phần cập nhật hợp lệ còn lại
BEGIN;

UPDATE CUSTOMERS2 C
SET IS_ACTIVE = FALSE
WHERE NOT EXISTS (
	SELECT 1
	FROM ORDERS2 O
	WHERE C.CUSTOMER_ID = O.CUSTOMER_ID
)
RETURNING *;

SAVEPOINT BEFORE_DELETE;

DELETE FROM CUSTOMERS2
WHERE IS_ACTIVE = TRUE;

SELECT * FROM CUSTOMERS2;

ROLLBACK TO BEFORE_DELETE;

COMMIT;

-- G) Schema – tạo/move bảng & search_path
-- 1. Tạo schema mới tên ops
CREATE SCHEMA IF NOT EXISTS OPS;

-- 2. Di chuyển bảng orders2 sang schema ops (sử dụng ALTER TABLE … SET SCHEMA …)
ALTER TABLE ORDERS2 SET SCHEMA OPS;

-- 3. Cấu hình search_path cho schema mới này
SET SEARCH_PATH TO LAB, OPS, PUBLIC;


-- H) ALTER TABLE – thay đổi cấu trúc
-- 1. Trên customers2:
-- - Thêm cột updated_at TIMESTAMPTZ với giá trị mặc định là thời điểm hiện tại
-- - Thêm ràng buộc CHECK đảm bảo full_name không rỗng sau khi TRIM()
ALTER TABLE CUSTOMERS2 ADD COLUMN UPDATED_AT TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE CUSTOMERS2 ADD CONSTRAINT FULL_NAME_NOT_BLANK CHECK (TRIM(FULL_NAME) != '');

-- 2. Đặt giá trị mặc định mới cho orders2.status là 'completed'
ALTER TABLE ORDERS2 ALTER COLUMN STATUS SET DEFAULT 'COMPLETED';

-- 3. Tạo INDEX trên orders2(customer_id, order_date DESC)
CREATE INDEX IF NOT EXISTS IDX_CUSTOMER_ID_DATE ON ORDERS2 (CUSTOMER_ID, ORDER_DATE DESC);

-- 4. Đổi kiểu email của customers2 từ VARCHAR(150) sang VARCHAR(200)
ALTER TABLE CUSTOMERS2
ALTER COLUMN EMAIL TYPE VARCHAR(200);


-- Bài tập nâng cao 
-- Lý thuyết
-- C1. CONCURRENTLY khi tạo Index
-- CREATE INDEX CONCURRENTLY idx_name ON table_name(column);
-- - Cho phép tạo index mà không chặn INSERT, UPDATE, DELETE trên bảng.
-- - Dùng khi bảng lớn và đang chạy production.
-- - Nhược điểm: chậm hơn, tốn tài nguyên hơn, không chạy được trong transaction block.

-- C2. Phân biệt Composite Index & Covering Index
-- - Composite Index: index tạo trên nhiều cột (vd: (col1, col2, col3)),
--   tối ưu truy vấn có điều kiện lọc/ORDER BY theo nhiều cột.
-- - Covering Index: index chứa đủ dữ liệu cho truy vấn (bao gồm cả các cột trong SELECT),
--   giúp tránh đọc thêm dữ liệu từ bảng gốc.
-- => Composite tập trung vào nhiều cột khóa, Covering tập trung vào bao phủ dữ liệu cần thiết.

-- C3. Index Scan vs Index Only Scan
-- - Index Scan: dùng index để tìm hàng, sau đó vẫn phải đọc thêm dữ liệu từ bảng (heap) để lấy các cột khác.
-- - Index Only Scan: chỉ dùng index, không cần đọc bảng vì index đã chứa đủ dữ liệu cho truy vấn.

