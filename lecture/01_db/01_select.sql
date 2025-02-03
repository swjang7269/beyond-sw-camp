SELECT
		 menu_name
	  , menu_price
	  , category_name
  FROM tbl_menu JOIN tbl_category;
  
-- ----------------------------- --from없이 select절만으로도 가능 절(cluase)
SELECT 7+3;

SELECT 8*2;

SELECT 7%3, 8%5;

SELECT NOW();	-- 서버의 현재시간

SELECT CONCAT('유', ' ', '관순');	-- 문자열을 합해주는 함수

-- 별칭(alias)

SELECT 7+3 AS '합';
-- 별칭에 특수기호(띄어쓰기를 포함한) 사용 시에는  (' ')싱클 쿼테이션  생략 불가
-- as는 생략 가능하나 가독성을 위해 생략하지 말자.
SELECT menu_name AS '메뉴명' FROM tbl_menu;
