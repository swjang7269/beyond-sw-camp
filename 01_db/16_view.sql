/* view */
-- 테에블을 활용한 가상 테이블
-- view는 원본 테이블을 참조해서 보여주는 용도이고
-- 보여지는건 실제 테이블(베이스 테이블)의 값이다.

SELECT
		 menu_name
	  , menu_price
  FROM tbl_menu;
  
-- DBA(관리자) 입장에서 필요한 만큼만 view를 만들어 전달하는데 사용
-- 컬럼명도 실제 데이터 값이 아닌 별칭을 설정하여 별칭만 노출가능
-- 성능상의 목적이 아닌 사용 편의성or보안성을 위한 목적
-- or replace -> drop과정을 거치지 않고 업데이트 가능
-- view는 실제 데이터 값을 가지고 있는것이 아닌 쿼리문을 저장하고 있다.

-- view 사용 목적
-- 1) DBA가 일반 개발자 각각에게 필요한 만큼의 정보를 제공하기 위해(접근 제어)
-- 2) 실제 비즈니스에서 사용되는 용어로 별칭을 달아 이해하기 쉽게 하기 위해
-- 3) 복잡한 DB 관계를 고민하지 않고 사용할 수 있게 하기 위해

-- 목적에 맞게 사용하고 남용하지 말것

CREATE or replace VIEW v_menu
AS
SELECT
		 menu_name AS '메뉴명'
	  , menu_price AS '메뉴단가'
  FROM tbl_menu;
  
SELECT
		 *
  FROM v_menu;
  
-- view는 DML작업이 가능하지만 사용 비추(경우에 따라 불가능한 경우들이 있음)
-- 베이스 테이블(tbl_menu)
SELECT * FROM tbl_menu;

-- '한식'카테고리만 담은 hansik 뷰 생성
CREATE OR REPLACE VIEW hansik
AS
SELECT
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE category_code = 4;

SELECT * FROM hansik;

-- hansik 뷰를 통해 tbl_menu 베이스 테이블에 영향을 주는지 확인해보자
INSERT
  INTO hansik
VALUES
(NULL, '식혜맛국밥', 5500, 4, 'Y');

SELECT * FROM tbl_menu;

UPDATE hansik
   SET menu_name = '버터맛국밥'
     , menu_price = 6000
 WHERE menu_name = '식혜맛국밥';

-- ----------------------------------------------
-- 실제 베이스 테이블 내에 없는 result set을 view로 만들면 DML작업을 할 수 없다.
-- 베이스 테이블에 영향을 줄 수 없으면 DML작업이 불가능하다.
-- (없는 컬럼, not null, join, group by, distinct, 산술 표현식 등
CREATE OR REPLACE VIEW v_test
AS
SELECT
		 AVG(menu_price) + 3
  FROM tbl_menu;
  
SELECT * FROM v_test;



















