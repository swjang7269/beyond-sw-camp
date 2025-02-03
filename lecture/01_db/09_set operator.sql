/* set operator */
-- 구조가 똑같은 테이블에 대해 세로로 늘리는 것(row를 늘리는 것)

/* union */ -- 합집합 (교집합은 한번만)
SELECT
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE category_code = 10
 
union
 
select
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE menu_price < 9000;
 
 /* union all */ 중복값 생략 안함 (교집합 두 번씩)
 SELECT
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE category_code = 10
UNION all
select
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE menu_price < 9000;
 
/* intersect */ -- 교집합
-- mysql과 mariadbb는 intersect가 공식적으로 지원되지 않는다.
-- 1) inner join + 서브쿼리 활용
SELECT
		 a.menu_code
	  , a.menu_name
	  , a.menu_price
	  , a.category_code
	  , a.orderable_status
  FROM tbl_menu a
 INNER JOIN (SELECT b.menu_code
 						, b.menu_name
 						, b.menu_price
 						, b.category_code
 						, b.orderable_status
 					FROM tbl_menu b
 				  WHERE b.menu_price < 9000) c ON (a.menu_CODE = c.menu_code)
 WHERE a.category_code = 10;
 
-- 2) in 연산자 활용
SELECT
		 a.menu_code
  FROM tbl_menu a
 where a.category_code = 10
   AND a.menu_code IN (SELECT b.menu_code
   							 FROM tbl_menu b
   						   WHERE b.menu_price<9000);
   						   
/* minus - 차집합 */
SELECT
		 a.menu_code
	  , a.menu_name
	  , a.menu_price
	  , a.category_code
	  , a.orderable_status
	  , c.menu_code
  FROM tbl_menu a
  LEFT JOIN (SELECT b.menu_code
					   , b.menu_name
					 	, b.menu_price
					 	, b.category_code
					 	, b.orderable_status					  
			    	FROM tbl_menu b
			     WHERE b.menu_price <9000) c ON (a.menu_code = c.menu_code)
 WHERE a.category_code = 10
   AND c.menu_code IS employeeNULL;		-- a부분에서 c와 동일하지 않은 부분(매칭되지 않은 부분)