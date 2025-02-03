-- distinct 중복값 제거

-- 메뉴가 할당된 카테고리들 조회
SELECT
		 category_code
  FROM tbl_menu
 ORDER BY category_code;
 
-- 중복 제거
SELECT
		 DISTINCT category_code
  FROM tbl_menu
 ORDER BY category_code;
 
-- 다중열 distinct
SELECT
		 category_code
	  , orderable_status
  FROM tbl_menu;

-- (category_code, orderable_status)쌍을 대상으로 중복 제거
SELECT
		 distinct
		 category_code
	  , orderable_status
  FROM tbl_menu;