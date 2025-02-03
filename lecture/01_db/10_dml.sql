/* DML (Data Manipulation language) */
-- insert, update, delete, select(DQL)

/* insert */
-- 새로운 챙을 추가하는 구문
SELECT * FROM tbl_menu;
INSERT
  INTO tbl_menu
(
  menu_name
, menu_price
, category_code
, orderable_status
)
values
(
  '초콜릿죽'
, 6500
, 7
, 'Y'
);  
DESC tbl_menu;

INSERT
  INTO tbl_menu
-- 컬럼명 미작성 시에는 실제 테이블의 컬럼 갯수만큼 컬럼 순서를 지켜 작성해야한다.
-- 하나의 insert 구문으로 여러 데이터를 insert 할 수 있다.
VALUES
(NULL, '참치맛 아이스크림', 1700, 12, 'Y'),
(NULL, '멸치맛 아이스크림', 1500, 11, 'Y'),
(NULL, '소시지맛 커피', 2500, 8, 'Y');

/* update */
-- 테이블에 기록된 컬럼값을 수정
-- 테이블의 전체 행 갯수는 그대로
SELECT
		 *
  FROM tbl_menu;
  
-- 수정하고 싶은 대상에 대한 조건을 걸어 수정 (조건 설정을 안하면 모든 대상을 업데이트한다.) 
UPDATE tbl_menu
	SET category_code = 7
 WHERE menu_code = 25;
 
-- subquery를 활용한 update
UPDATE tbl_menu
   SET category_code = 8
     , menu price = 100
 WHERE menu_code = (SELECT menu_code
 						    FROM tbl_menu
 						   WHERE menu_name = '멸치맛 아이스크림');
 						   
/* DELETE */
-- 테이블의 행을 삭제하는 구문
-- 테이블의 행의 갯수가 줄어든다.

-- mariadb는 기본적으로 autocommit이 true로 설정되어 있다.)
SET autocommit =0;
DELETE
  FROM tbl_menu
 WHERE 1=1; -- 항상 참
 
 SELECT * FROM tbl_menu; 
select tbl_mane
ROLLBACK; -- 이전으로 되돌리기
COMMIT; -- 실행

-- order by , limit을 통해 사용 하능

/* replace */
-- 기존에 있는 값을 쓰면 update, 없는 값을 쓰며 insert
