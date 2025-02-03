/* type casting */
-- 명시적 형변환

-- 1) 숫자 -> 숫자
SELECT CAST(AVG(menu_price) AS UNSIGNED INTEGER) AS '가격 평균'
  FROM tbl_menu
GROUP BY category_code;


SELECT cast(AVG(menu_price) as double) AS '가격 평균'
  FROM tbl_menu
GROUP BY category_code;

-- 2) 문자 -> 날짜
SELECT CAST('2025#01#07' AS DATE);

-- 3) 숫자 -> 문자
SELECT CAST(1000 AS CHAR);
SELECT CONCAT(CAST(1000 as CHAR), '원');
SELECT CONCAT(1000, '원');						--  묵시적 형변환

-- 암시적 형변환
SELECT 1+'2';
SELECT 5>'반가워';
