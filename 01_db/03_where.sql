-- where 절 (조건)
-- 주문 가능한 메뉴만 조회(메뉴명만 조회)
SELECT * FROM tbl_menu;

-- 스키마 조회 (테이블의 구조 파악)
DESC tbl_menu;

SELECT
		 menu_name
  FROM tbl_menu
 WHERE orderable_status = 'y';
 
 -- from으로부터 행 하나하나에 대해 where 적용(필터링)
 -- mariadb는 대소문자 크게 상관x, 해석 순서 잘 인지할 것
 -- 해석 순서는 from -> where -> select -> order by(항상 마지막)
 
 -- '기타' 카테고리에 해당하지 않는 메뉴를 조회하시오.
 select
 		 *
  FROM tbl_category
 WHERE category_name = '기타';	-- '='하나가 같은지 확인(T/F)
 -- 카테고리 테이블을 통해 메뉴에도 있는 카테고리 코그 번호를 알게 됨(10번)
 select
 		 *
  FROM tbl_menu
-- '!='과 '<>'는 다른지 확인(mariadb 기준)
 WHERE category_code = 10;
 -- 카테코리 코드 10번(기타)를 조회
 
 -- 서브쿼리 사용
select
 		 *
  FROM tbl_menu
 WHERE category_code != (select category_code
								   FROM tbl_category
								  WHERE category_name = '기타');
	
						  
-- =, != 와 같이 대소 비교 연산자(>, <, >=, <=)도 사용 가능
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price >= 5000
 ORDER BY menu_price ASC;
 
 -- 논리 연산자
 -- AND -> 둘 다 만족해야 true
 -- OR -> 둘 중 하나만 만족해도 true
 -- NOT -> 부정
 -- XOR -> 다르면 true, 같으면 false
 
 -- 5000 이상이면서 7000원 미만인 메뉴 조회(AND)
 select
    	 *
  FROM tbl_menu
 WHERE menu_price >= 5000
   AND menu_price < 7000;

-- 10000원 초과 이거나 5000원 이하인 메뉴 조회(OR)
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price > 10000
    OR menu_price <= 5000
 ORDER BY menu_price ASC;
 
 -- 5000원 이하이거나 카테고리 번호가 10번인 메뉴 조회
 SELECT * FROM tbl_menu;
 DESC tbl_menu;
SELECT
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE menu_price <= 5000
 	 OR category_code = 10;
 	 
-- -------------------------------
-- between 연산자 활용하기
-- 가격이 5000원 이상이면서 9000원 이하인 메뉴 전체 컬럼 조회
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price >= 5000
   AND menu_price <= 9000;

-- between 연산은 등호 포함
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price BETWEEN 5000 AND 9000;
 
-- 5000원 미만 또는 9000원 초과인 메뉴 between 조건 부정
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price NOT BETWEEN 5000 AND 9000;
 
-- ------------------------------
-- like문
-- 제목, 작성자 등을 검색할 때 사용
SELECT
		 *
  FROM tbl_menu
 WHERE menu_name LIKE '%밥%';
-- '%'와일드카드(기능이 있는 특수 기호)
-- 0개 이상의 문자를 뜻하는 특수기호이다.
-- ~~~밥~~ 인 경우
-- 밥~~~
-- ~~~밥
-- not 부정
SELECT
		 *
  FROM tbl_menu
 WHERE menu_name not LIKE '%밥%';

-- ---------------------------------------
-- in 연산자
-- 카테고리가 '중식'or'커피'or'기타'인 메뉴 조회하기
SELECT
		 *
  FROM tbl_menu
 WHERE category_code = 5 	-- 중식
 	 OR category_code = 8	-- 커피
 	 OR category_code = 10;	-- 기타
 	 
-- 하나라도 일치하면
SELECT
		 *
  FROM tbl_menu
-- WHERE category_code IN (5, 8, 10);
 WHERE category_code NOT IN (5,8,10);
 
-- --------------------------------
-- is null 연산자 활용
-- 상위 카테고리가 null -> 즉 자기가 최고 상위 카테고리
SELECT
		 *
  FROM tbl_category
 WHERE ref_category_code IS NULL;
 
-- 상위 카테고리(ref_category)가 null이 아닌애 -> 하위 카테고리
SELECT
		 *
  FROM tbl_category
 WHERE ref_category_code IS not NULL;

