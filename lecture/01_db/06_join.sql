-- join
-- 테이블을 결합
-- 최소 한 개 이상의 콜럼 관계

SELECT * FROM tbl_menu;
SELECT * FROM tbl_category;

SELECT
		 menu_name
	  , category_name
--	  , category_code		 ambiguos 에러
  FROM tbl_menu a
  JOIN tbl_category b ON tbl_menu.category_code = tbl_category.category_code;

-- 별칭 작성
-- 테이블 또는 from 절에 별칭을 추가할 시 MariaDB에서는 
-- 싱글 쿼테이션(')을 사용하면 안된다.
-- as는 생략 가능
SELECT
		 a.menu_name
	  , b.category_name
	  , a.category_code
  FROM tbl_menu a
  JOIN tbl_category b ON a.category_code = b.category_code;

-- ------------------------------------------
-- inner join (매칭 된 항목만 가져오기)
-- 1) on 활용(join 조건 작성) (컬럼명이 다를 때는 반드시 on을 작성)
SELECT
		 a.menu_name
	  , b.category_name
	  , a.category_code
  FROM tbl_menu a
  INNER JOIN tbl_category b ON a.category_code = b.category_code;

-- 2) using 활용(공통 컬럼 명이 같을 경우 using을 통해 짧은 구문으로 작성 가능)
-- tbl_menu 입장에서 tbl_category 정보를 가져온 것
-- menu에 할당되지 않은 category_code 정보는 가져오지 않는다.
SELECT
		 a.menu_name
	  , b.category_name
	  , a.category_code
  FROM tbl_menu a
  INNER JOIN tbl_category b USING (category_code);

-- ----------------------------------------------
-- OUTER JOIN
-- 1) LEFT JOIN
-- 기준은 먼저 언급하는 것 (a)가 된다.

-- a를 기준으로 a(왼쪽) 값이 매칭이 안되어도 다 보겠다.
SELECT
		 a.category_name
	  , b.menu_name
  FROM tbl_category a LEFT JOIN tbl_menu b ON a.category_code = b.category_code;
  
-- 2) RIGHT JOIN
-- a를 기준으로 b(오른쪽) 값이 매칭이 안되어도 다 보겠다.
SELECT
		 b.category_name
	  , a.menu_name
  FROM tbl_menu a RIGHT JOIN tbl_category b ON a.category_code = b.category_code;
  
-- 연쇄적인 조인은 from부터 순서대로 조인한다.
-- 조인이 많아지는데 매칭이 안되어도 보고 싶은 항목이 있는 경우 right와 left
-- 를 적절히 사용하여 조인할때마다 살려줘야한다. 연쇄적인 조인과정도중
-- 매칭이 안된 값은 inner join의 경우 소실될 수 있기 때문

-- 3) CROSS JOIN (모든 경우의 수 조인 -> 잘못 조인했을 경우의 결과 m*n)
-- 보통 on구문을 잘못 적었을 때 발생
SELECT
		 *
  FROM tbl_menu a
 CROSS JOIN tbl_category b;
 
-- 4) SELF JOIN (한 개의 테이블을 각각의 테이블로 취급하여 조인)
-- 해당 예제에선 상위 카테고리 코드(ref_category)가 category_code를 참조 중
-- 테이블 하나를 다른 별칭을 달아 개개의 테이블인 것처럼 조인을 하면됨
SELECT
		 a.category_name
	  , a.ref_category_code
	  , b.category_name
  FROM tbl_category a
  JOIN tbl_category b ON a.ref_category_code = b.category_code;
  