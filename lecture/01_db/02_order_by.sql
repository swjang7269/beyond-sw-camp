 -- order by(정렬)
 
 -- 오름차순 (Ascending, ASC)
 -- 내림차순(Descending, DESC)
 
 select
 		 menu_code		-- 1st column
 	  , menu_name		-- 2nd column
 	  , menu_price		-- 3rd column
 	  
   FROM tbl_menu
  ORDER BY menu_price asc, menu_code asc;
  
-- from으로부터 select를 하여 나온 result에 order by로 최종적으로 정렬
-- default는 오름차순(ASC)
-- select절에 작성한 column의 순번을 통해 정렬 가능
--	order by 3, 2 desc;
-- 정렬의 우선순위를 가지고 여러 정렬 기준 적용 가능 (앞부터 선형적)
-- 별칭을 활용한 정렬 또한 가능
SELECT
		 menu_code AS 메뉴코드
	  , menu_name AS 메뉴명
	  , menu_price AS 메뉴단가
  FROM tbl_menu
 ORDER BY 메뉴단가 DESC;
 
-- 별칭에 특수기호가 있을 시 별칭을 활용한 정렬 불가(특수기호 쓰지 말자)

-- field 함수를 활용한 정렬이 가능하다.
-- 첫 번째 인자에 나머지 인자가 있으면 순서대로 넘버링
SELECT FIELD('a', 'b', 'c', 'd');	-- a가 b와 같다면 1, c와 같다면 2, d와 같다면 3... 을 반환하여 정렬 순서를 의도적으로 맞출 수 있다.

-- 주문 불가능한 메뉴부터 보기
SELECT
		 orderable_status
	  , FIELD(orderable_status, 'Y', 'N') AS 가능여부	-- orderable_status의 값에 따라 넘버링 가능(해당 예시에서 Y는 1, N은 2)
  FROM tbl_menu
 ORDER BY FIELD(orderable_status, 'Y', 'N');
-- order by 2 desc;
-- order by 가능여부 desc;

-- -----------------------------------------------------------------
-- null 값에 대한 정렬
SELECT * FROM tbl_category;

-- default > 오름차순 시 null값이 최전선 
-- 고로 내림차순 시 null값이 최후미
SELECT
		 *
  FROM tbl_category
 ORDER BY ref_category_code ASC;
 
 
-- null값 정렬 순서를 default와 반대로 할 생각이라면
-- null값 정렬에 적용할 오름/내림차순 정렬 옵션을 설정
-- column은 null값 정렬과 반대로 정렬하고 싶다면 column에 -붙인다.
-- -column desc의 경우 > column을 desc(내림차순)의 반대 오름차순으로 정렬
SELECT
		 *
  FROM tbl_category
 ORDER BY -ref_category_code desc;