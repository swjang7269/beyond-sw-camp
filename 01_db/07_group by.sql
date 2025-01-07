-- group by 절
-- 데이터를 기준에 맞춰 그룹을 나누는 것

-- 메뉴가 존재하는 카테고리 그룹 조회
-- 그룹별로 적용하는 그룹함수(sum, avg, count, max, min)를 적용하기 위한 설정

SELECT
		 category_code		-- 그룹의 개수만큼 select(row행)가 일어남
  FROM tbl_menu
 GROUP BY category_code;
 
 -- count
select
       COUNT(*)			-- 해당 그룹 내 행의 개수 (*) - > 값이 null이더라도 카운트
     , category_code
  FROM tbl_menu
 GROUP BY category_code;
 
-- count 함수
-- count(컬럼명 또는 *)
-- count(컬럼명): 해당 컬럼중 null이 아닌 행의 갯수
-- count(*): 모든 행의 갯수
-- 따로 group by설정이 없는 경우 1개의 테이블은 하나의 그룹이다.
SELECT
		 COUNT(*)						-- null을 포함한 모든 행 갯수
	  , COUNT(ref_category_code)	-- null이 아닌 행만 셈
  FROM tbl_category;
  
-- sum 함수 활용
SELECT
		 category_code
	  , SUM(menu_price)				-- 그룹별 가격 합계
  FROM tbl_menu
 GROUP BY category_code;
 
-- group by의 기준(사용된) 컬럼은 유의미한 항이지만 그 이외의 컬럼은 의미를 잃으므로
-- select절에 작성하지 않기
-- group by 절에서 사용된 컬럼 + group함수만 select절에 사용할 것

-- avg 함수 활용
-- 소수점 처리
-- round: 반올림, cel: 올림, floor: 버림
SELECT
		 category_code
	  , floor(avg(menu_price))				-- 그룹별 가격 평균
  FROM tbl_menu
 GROUP BY category_code;
 
 -- --------------------------------------
 -- having 절 (그룹에 대한 조건) 그룹마다 적용
 -- where절은 각 row마다 적용, having은 그룹기준으로 적용
 -- group을 선정할 때 쓰인 컬럼 또는 그룹함수로 조건을 설정
 select
 		 SUM(menu_price)
 	  , category_code
  FROM tbl_menu
 GROUP BY category_code
-- HAVING category_code BETWEEN 5 AND 9;
HAVING SUM(menu_price) >= 20000;

-- -------------------------------------------
-- 6가지 절 모두 활용하기
SELECT
		 category_code
	  , floor(AVG(menu_price))
  FROM tbl_menu
 WHERE menu_price > 10000			-- 각 메뉴에 대한 필터
 GROUP BY category_code
HAVING AVG(menu_price) > 12000	-- 그룹에 대한 필터
 ORDER BY 1 DESC;
 
-- -----------------------------------------------
-- rollup
-- group을 묶을 때 하나의 기준(하나의 컬럼)으로 그룹화 하여 rollup을 하면
-- 총 합계의 개념이 나온다.
SELECT
		 SUM(menu_price)
	  , category_code
  FROM tbl_menu
 GROUP BY category_code
  WITH ROLLUP;

-- group by의 기준이 여러개인 경우 맨 처음의 기준에 대해서 중간 합계가 나온다.
-- 아래 항목의 경우 category_code가 같아도 menu_price가 같은 항목에 대하여 합산 결과를 보여준다.
SELECT
		 SUM(menu_price)
	  , menu_price
	  , category_code
  FROM tbl_menu
 GROUP BY menu_price, category_code
  WITH ROLLUP;