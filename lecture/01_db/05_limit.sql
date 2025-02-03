-- limit 
-- 일부분을 추출
SELECT
		 menu_code
	  , menu_name
	  , menu_price
  FROM tbl_menu
 ORDER BY menu_price DESC, menu_code DESC;
 
-- 자르고 싶은 index로부터 n개(index는 0부터)
SELECT
	    menu_code
	  , menu_name
	  , menu_price
  FROM tbl_menu
 ORDER BY menu_price DESC, menu_code DESC
LIMIT 4, 3;

SELECT
		 *
  FROM tbl_menu
 ORDER BY menu_code LIMIT 10;	-- 처음부터 10개