-- Câu 1
-- Lấy 10 khách hàng có loyalty_points cao nhất nhưng không thuộc VIP tier = 'NONE'.
SELECT
	CUSTOMER_ID,
	CUSTOMER_NAME,
	LOYALTY_POINTS,
	VIP_TIER
FROM CUSTOMER
WHERE VIP_TIER != 'NONE'
ORDER BY LOYALTY_POINTS DESC
LIMIT 10;

-- Câu 2
-- Lấy 5 đơn hàng có phí vận chuyển cao nhất trong tháng gần đây nhất.
SELECT
	ORDER_NUMBER,
	DATE_TRUNC('MONTH', ORDER_DATE) AS MONTH,
	SHIPPING_FEE
FROM ORDERS
WHERE DATE_TRUNC('MONTH', ORDER_DATE) = (
	SELECT DATE_TRUNC('MONTH', MAX(ORDER_DATE))
	FROM ORDERS
)
ORDER BY SHIPPING_FEE DESC
LIMIT 5;

-- Câu 3
-- Tìm 10 khách hàng đăng ký sớm nhất nhưng có loyalty_points > 1000.
SELECT
	CUSTOMER_ID,
	CUSTOMER_NAME,
	LOYALTY_POINTS,
	CREATED_AT 
FROM CUSTOMER
WHERE LOYALTY_POINTS > 1000
ORDER BY CREATED_AT DESC
LIMIT 10;

-- Câu 4
-- Tìm khách hàng có email chứa 'yahoo' nhưng không ở thành phố New York.
SELECT
	CUSTOMER_ID,
	CUSTOMER_NAME,
	EMAIL,
	CITY
FROM CUSTOMER
WHERE EMAIL ILIKE '%yahoo%' AND CITY != 'New York';

-- Câu 5
-- Tìm đơn hàng có total_amount lớn hơn trung bình của tất cả đơn hàng.
SELECT
	ORDER_NUMBER,
	TOTAL_AMOUNT
FROM ORDERS
WHERE TOTAL_AMOUNT > (
	SELECT AVG(TOTAL_AMOUNT)
	FROM ORDERS
);

-- Câu 6
-- Tìm các thành phố có trung bình loyalty_points > 1500.
SELECT
	CITY,
	ROUND(AVG(LOYALTY_POINTS), 2) AS AVG_LOYALTY_POINTS
FROM CUSTOMER
GROUP BY CITY
HAVING AVG(LOYALTY_POINTS) > 1500;

-- Câu 7
-- Tìm phương thức thanh toán có số đơn hàng > 100 và trung bình total_amount > 200.
SELECT
	PAYMENT_METHOD,
	COUNT(*) AS SO_DON_HANG,
	ROUND(AVG(TOTAL_AMOUNT), 2) AS AVG_TOTAL_AMOUNT
FROM ORDERS
GROUP BY PAYMENT_METHOD
HAVING COUNT(*) > 100 AND AVG(TOTAL_AMOUNT) > 200;

-- Câu 8
-- Liệt kê top 5 kênh bán hàng có tổng doanh thu lớn nhất.
SELECT
	CHANNEL,
	SUM(TOTAL_AMOUNT) AS TOTAL_SALES
FROM ORDERS
GROUP BY CHANNEL
ORDER BY TOTAL_SALES DESC
LIMIT 5;

-- Câu 9
-- Tìm trạng thái đơn hàng có nhiều hơn 50 đơn hàng nhưng tổng giá trị < 5000.
SELECT
	STATUS,
	COUNT(*) AS SO_DON_HANG,
	SUM(TOTAL_AMOUNT) AS TOTAL_SALES
FROM ORDERS
GROUP BY STATUS
HAVING COUNT(*) > 50 AND SUM(TOTAL_AMOUNT) < 5000;

-- Câu 10
-- Liệt kê các VIP tier có ít hơn 20 khách hàng.
SELECT
	VIP_TIER,
	COUNT(*) AS SO_KHACH_HANG
FROM CUSTOMER
GROUP BY VIP_TIER
HAVING COUNT(*)  20;

-- Câu 11
-- Tìm khách hàng có loyalty_points lớn hơn loyalty_points trung bình của tất cả khách hàng.
SELECT
	CUSTOMER_ID,
	CUSTOMER_NAME,
	LOYALTY_POINTS
FROM CUSTOMER
WHERE LOYALTY_POINTS > (
	SELECT AVG(LOYALTY_POINTS)
	FROM CUSTOMER
);

-- Câu 12
-- Tìm đơn hàng có total_amount bằng giá trị lớn nhất trong bảng orders.
SELECT
	ORDER_NUMBER,
	TOTAL_AMOUNT
FROM ORDERS
WHERE TOTAL_AMOUNT = (
	SELECT MAX(TOTAL_AMOUNT)
	FROM ORDERS
);

-- Câu 14
-- Tìm đơn hàng thuộc về khách hàng có tổng số đơn hàng nhiều nhất.
SELECT
	ORDER_NUMBER,
	CUSTOMER_ID
FROM ORDERS
WHERE CUSTOMER_ID = (
	SELECT CUSTOMER_ID
	FROM ORDERS
	GROUP BY CUSTOMER_ID
	ORDER BY COUNT(*) DESC
	LIMIT 1
);

-- Câu 15
-- Tìm khách hàng có tổng chi tiêu lớn hơn bất kỳ khách hàng nào ở thành phố Chicago.
SELECT
	CUSTOMER_ID,
	SUM(TOTAL_AMOUNT) AS TONG_CHI_TIEU
FROM ORDERS O
GROUP BY CUSTOMER_ID
HAVING SUM(TOTAL_AMOUNT) > ANY (
	SELECT SUM(TOTAL_AMOUNT)
	FROM ORDER
	WHERE CUSTOMER_ID IN (
		SELECT C.CUSTOMER_ID
		FROM CUSTOMER C
		WHERE CITY = 'Chicago'
	)
	GROUP BY CUSTOMER_ID
);


-- Câu 16
-- Lấy danh sách khách hàng cùng với tổng số đơn hàng của họ (dùng subquery trong FROM).
SELECT *
FROM (
	SELECT
		CUSTOMER_ID,
		COUNT(*) AS SO_DON_HANG
	FROM ORDERS
	GROUP BY CUSTOMER_ID
);

-- Câu 17
-- Tính trung bình tổng chi tiêu của khách hàng, sau đó liệt kê khách hàng có tổng chi tiêu cao hơn mức đó.
SELECT
	CUSTOMER_ID,
	SUM(TOTAL_AMOUNT) AS TONG_CHI_TIEU
FROM ORDERS
GROUP BY CUSTOMER_ID
HAVING SUM(TOTAL_AMOUNT) > (
	SELECT AVG(TOTAL_AMOUNT)
	FROM ORDERS
);

-- Câu 18
-- Lấy top 5 khách hàng theo tổng loyalty_points nhưng chỉ xét những khách hàng có ít nhất 3 đơn hàng.
SELECT
	CUSTOMER_ID,
	CUSTOMER_NAME,
	SUM(LOYALTY_POINTS) AS SUM_LOYALTY_POINTS
FROM CUSTOMER
WHERE CUSTOMER_ID IN (
	SELECT CUSTOMER_ID
	FROM ORDERS
	GROUP BY CUSTOMER_ID
	HAVING COUNT(*) >= 3
)
GROUP BY CUSTOMER_ID
ORDER BY SUM_LOYALTY_POINTS DESC
LIMIT 5;

-- Câu 19
-- Lấy danh sách các thành phố kèm tổng số tiền đơn hàng đã thanh toán (status = PAID), sắp xếp giảm dần.
SELECT
    C.CITY,
    (
        SELECT SUM(O.TOTAL_AMOUNT)
        FROM ORDERS O
        WHERE O.CUSTOMER_ID IN (
            SELECT CUSTOMER_ID
            FROM CUSTOMER
            WHERE CITY = C.CITY
        )
        AND O.STATUS = 'PAID'
    ) AS TONG_THANH_TOAN
FROM CUSTOMER C
GROUP BY C.CITY
ORDER BY TONG_THANH_TOAN DESC;

-- Câu 20
-- Tìm khách hàng có tổng số đơn hàng hủy (CANCELLED) nhiều hơn 3.
SELECT
	CUSTOMER_ID,
	COUNT(*) AS SO_DON_HUY
FROM ORDERS
WHERE STATUS = 'CANCELLED'
GROUP BY CUSTOMER_ID
HAVING COUNT(*) > 3;

-- Câu 21
-- Tìm 5 khách hàng có tổng chi tiêu cao nhất bằng cách dùng subquery trong SELECT.
SELECT
	C.CUSTOMER_ID,
	C.CUSTOMER_NAME,
	(
		SELECT SUM(TOTAL_AMOUNT)
		FROM ORDERS O
		WHERE C.CUSTOMER_ID = O.CUSTOMER_ID
	) AS TONG_CHI_TIEU
FROM CUSTOMER C
ORDER BY TONG_CHI_TIEU DESC
LIMIT 5;

-- Câu 22
-- Liệt kê khách hàng và đơn hàng gần nhất của họ.
SELECT
	C.CUSTOMER_ID,
	C.CUSTOMER_NAME,
	(
		SELECT ORDER_NUMBER
		FROM ORDERS O
		WHERE C.CUSTOMER_ID = O.CUSTOMER_ID
		ORDER BY CREATED_AT DESC
		LIMIT 1
	) AS LATEST_ORDER
FROM CUSTOMER C;

-- Câu 23
-- Tìm các khách hàng có tổng chi tiêu cao hơn khách hàng ở New York.
SELECT
	CUSTOMER_ID,
	SUM(TOTAL_AMOUNT) AS TONG_CHI_TIEU
FROM ORDERS
GROUP BY CUSTOMER_ID
HAVING SUM(TOTAL_AMOUNT) > ALL (
	SELECT SUM(TOTAL_AMOUNT)
	FROM ORDERS O
	WHERE O.CUSTOMER_ID IN (
		SELECT C.CUSTOMER_ID
		FROM CUSTOMER C
		WHERE C.CITY = 'New York'
	)
	GROUP BY CUSTOMER_ID
);

-- Câu 24
-- Lấy danh sách các đơn hàng có total_amount lớn hơn trung bình đơn hàng của chính khách hàng đó.
SELECT
	ORDER_NUMBER,
	CUSTOMER_ID,
	TOTAL_AMOUNT
FROM ORDERS O
WHERE TOTAL_AMOUNT > (
	SELECT AVG(TOTAL_AMOUNT)
	FROM ORDERS
	WHERE CUSTOMER_ID = O.CUSTOMER_ID
);

-- Câu 25
-- Tìm khách hàng chưa từng có đơn hàng nào.
SELECT
	C.CUSTOMER_ID,
	C.CUSTOMER_NAME
FROM CUSTOMER C
WHERE NOT EXISTS (
	SELECT 1
	FROM ORDERS O
	WHERE O.CUSTOMER_ID = C.CUSTOMER_ID
);
