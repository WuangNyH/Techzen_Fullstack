-- 1. Lấy danh sách 10 khách hàng đầu tiên, hiển thị theo cả 2 yêu cầu sau:
-- - Tên viết hoa
-- - Email ở dạng chữ thường
SELECT
    upper(customer_name) as name,
    lower(email) as email
from customer
limit 10;

-- 2. Tính số tiền sau thuế (giả sử +10% của total_amount) của từng đơn hàng. 
-- Chỉ tính cho các đơn hàng có total_amount từ 100 đến 500, và hiển thị với cột alias tong_sau_thue.
SELECT
    order_number,
    total_amount,
    (total_amount * 1.1) as tong_sau_thue
FROM orders
WHERE total_amount BETWEEN 100 AND 500;

-- 3. Lấy danh sách 1000 khách hàng VIP (GOLD hoặc PLATINUM), sắp xếp theo tên tăng dần, và bỏ qua 500 người đầu tiên.
SELECT
    customer_id,
    customer_name,
    vip_tier
FROM customer
WHERE vip_tier in ('GOLD', 'PLATINUM')
ORDER BY customer_name
LIMIT 1000
OFFSET 500;

-- 4. Lấy danh sách các thành phố (city) duy nhất của khách hàng VIP (GOLD hoặc PLATINUM).
-- Chỉ lấy những khách hàng còn hoạt động (is_active = TRUE), và sắp xếp tên thành phố theo thứ tự bảng chữ cái tăng dần.
SELECT DISTINCT city
FROM customer
WHERE vip_tier in ('GOLD', 'PLATINUM') AND is_active = TRUE
ORDER BY city;

-- 5. Tạo cột mới phân loại trạng thái đơn hàng (alias trang_thai_don_hang) thõa điều kiện:
-- - Nếu status = 'PENDING' → 'Chờ xử lý'
-- - Nếu status = 'PAID' hoặc status = 'SHIPPED' → 'Đang thực hiện'
-- - Ngược lại → 'Khác'
SELECT
    order_number,
    status,
    CASE 
        WHEN status = 'PENDING' THEN 'Chờ xử lý' 
        WHEN status in ('PAID', 'SHIPPED') THEN 'Đang xử lý'
        ELSE 'Khác' 
    END as trang_thai_mo_ta
FROM orders;

-- 6. Hãy viết truy vấn lấy danh sách 100 khách hàng đầu tiên, hiển thị thêm cột phan_loai theo tên như sau:
-- - Nếu customer_name bắt đầu bằng 'Je' → hiển thị 'Tên bắt đầu Je'
-- - Nếu customer_name chứa 'smith' (không phân biệt hoa/thường, dùng ILIKE) → hiển thị 'Tên có chứa Smith'
-- - Ngược lại → 'Khác'
SELECT
    customer_id,
    customer_name,
    CASE 
        WHEN customer_name LIKE 'Je%' THEN 'Tên bắt đầu Je'
        WHEN customer_name ILIKE '%smith%' THEN 'Tên có chứa Smith' 
        ELSE 'Khác'
    END as phan_loai
from customer;

-- 2.4 Bài tập mở rộng
-- Hãy viết truy vấn để hiển thị trang số 3 của danh sách đơn hàng đã giao thành công (status = 'DELIVERED').	
-- Mỗi trang gồm 20 đơn hàng, sắp xếp theo ngày đặt hàng mới nhất trước (nếu cùng ngày, sắp theo order_number ASC).	
SELECT
    order_number,
    status
from orders
WHERE status = 'DELIVERED'
ORDER BY order_date
LIMIT 20
OFFSET 20 * 2;

-- Tạo danh sách 10 khách hàng mới nhất (theo created_at) và hiển thị các cột với alias:
-- - full_info: nối tên khách hàng + email + số điện thoại
-- - name_length: độ dài tên khách hàng
-- - email_domain: chỉ lấy phần domain của email (sau dấu @) (gợi ý: dùng SUBSTRING + POSITION)
SELECT
    concat(customer_name, ' - ', email, ' - ', phone) as full_info,
    length(customer_name) as name_length,
    substring(email from position('@' in email) + 1) as email_domain
from customer
ORDER BY created_at DESC
LIMIT 10;

-- Viết truy vấn lấy danh sách 100 đơn hàng gần nhất (theo created_at) và phân loại cột order_value_level như sau:
-- total_amount < 50 → 'Rất nhỏ'
-- 50 <= total_amount < 200 → 'Nhỏ'
-- 200 <= total_amount < 1000 → 'Trung bình'
-- >= 1000 → 'Lớn'


