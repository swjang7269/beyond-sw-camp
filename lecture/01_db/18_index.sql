/* index */
-- 검색을 빨리 하기 위함
-- 색인, 목차, 라벨링
-- 위치를 저장하기 위함

-- primary key는 처음부터 index 개념이 있다. -> 고유 인덱스(unique index)
-- unique index: 중복된 값이 없는 컬럼에 달린 인덱스 (pk, uk)
-- 비고유 인덱스: 중복된 값이 있는 컬럼에 달린 인덱스
-- 인덱스를 저장할 별도의 저장공간이 필요
-- 인덱스를 매기기 위해 정렬하는 과정을 거치는데 이러한 리소스를 고려하여 남용하면 안된다.
-- 주기적으로 인덱스를 최신화 해줘야 한다.
-- 이러한 것들을 모두 고려하더라도 조회가 제일 우선시 되는 곳이면 투자

SELECT * FROM tbl_menu;

-- pk컬럼은 고유 인덱스가 있으므로 pk컬럼을 활용한 (WHERE)절 조회를 하자
-- 검색속도 향상
CREATE TABLE phone(
	 phone_code INT PRIMARY KEY,
	 phone_name VARCHAR(100),
	 phone_price DECIMAL(10,2)
);

INSERT
  INTO phone
 values
 (1, 'galaxyS24', 1200000),
 (2, 'iphone16pro', 1430000),
 (3, 'galaxyfold7', 1730000);
 
SELECT * FROM phone;
SHOW INDEX FROM phone;

-- query optimmizer가 내부적으로 query를 살펴서
-- index를 사용할지 아닌지 판단한다.
-- explain을 이용하여 쿼리를 어떻게 수행할지 계획을 볼 수 있다.
EXPLAIN SELECT * FROM phone WHERE phone_code = 1;

-- 인덱스를 생성하여 달 수 있다.
-- 다른 컬럼 죄호 성능 향상을 위해서는 인덱스를 수동으로 추가
CREATE INDEX idx_name ON phone(phone_name);
SHOW INDEX FROM phone;

-- 인덱스가 달린 컬럼을 조건으로 조회
EXPLAIN SELECT * FROM phone WHERE phone_name = 'iphone16pro';

-- 인덱스는 필요한 곳에 달아야 한다.
-- 1) 조건으로 활용할 컬럼(where절, having절, join시 on에 사용하는 컬럼)
-- 2) '=' 같다는 조건으로 쓰일 컬럼 
-- 3) 데이터가 자주 수정되지 않는 컬럼에 달아야 한다.
-- 4) 전체 데이터의 10~15퍼 정도의 범위에 해당하는 조건이 가장 효율아 좋다.(비고유 인덱스)
	-- 투자 리소스 대비 효율이 좋다.
-- 5) 카디널리티가 높은 컬럼일 수록 좋다.(중복값이 적을수록)
	-- (카디널리티): 구분되는 행의 갯수
	-- 카디널리티가 높으면 인덱스를 활용하면 검색 횟수가 줄어든다. -> 성능 향상

-- 인덱스 단점
-- 1) 별도의 저장공간 필요
-- 2) 주기적으로 인덱스를 업데이트 해줘야 한다.(일반적으로 한달에 한번 권장)
	-- ex.스프링 스케줄러 활용
	-- oprimize -> 인덱스 업데이트

-- 인덱스 최적화(다시 인덱스 달기)
OPTIMIZE TABLE phone;

-- 인덱스 삭제
DROP INDEX idx_name ON phone;
SHOW INDEX FROM phone;
















