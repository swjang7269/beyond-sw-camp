/* DDL(Data Definition Language) 데이터를 저장하기 위한 틀 */
CREATE TABLE tb1 (
	 pk INT PRIMARY KEY,
	 fk INT,
	 coll VARCHAR(255),
	 check(coll IN ('Y','N'))
);

DESCRIBE tb1;
DESC tb1;

INSERT
  INTO tb1
VALUES
(
	2, 2, 'Y'
);
SELECT * FROM tb1;

/* auto_increment */
/* if not exists:존재하지 않으면 실행 */
/* drop: 테이블 삭제 */
-- 관례상 create보다 상단에 위치
DROP TABLE tb2;

CREATE TABLE if not exists tb2(
	pk INT PRIMARY KEY AUTO_INCREMENT,
	fk INT,
	coll VARCHAR(255),
	CHECK(coll IN ('Y','N'))
);

DESC tb2;

INSERT
  INTO tb2
VALUES
(
  NULL, 2, 'N'
);

SELECT * FROM tb2;

-- 수동 커밋 습관화
COMMIT;

-- -----------------------------------------
/* alter (사용을 권장하진 않음) */
-- 컬럼 추가
ALTER TABLE tb2 ADD coll2 INT NOT NULL;
DESC tb2;

-- 컬럼 삭제
ALTER TABLE tb2 DROP column coll2;
DESC tb2;

-- 컬럼 이름 및 컬럼 정의 변경
ALTER TABLE tb2 CHANGE COLUMN fk change_fk INT NOT NULL;
DESC tb2;

-- auuto_increment 먼저 제거(drop이 아닌 modify)
ALTER TABLE tb2 MODIFY pk INT;

-- 다시 primary key 제거
alter TABLE tb2 DROP PRIMARY KEY;

DESC tb2;

/* truncate */
-- 절삭(truncate vs 삭제 (delete)
-- 테이블의 데티어(데이터 관련 제약조건 등 깔끔하게 제어)
-- 데이터의 초기화(테이블을 초기 만들 당시로 되돌려놓음)
CREATE TABLE if NOT EXISTS tb3(
	pk INT PRIMARY KEY AUTO_INCREMENT,
	fk INT,
	coll VARCHAR(255) CHECK(coll IN ('Y','N'))
-- 	PRIMARY KEY(pk)
);

INSERT
  INTO tb3
VALUES
(
	null, 1, 'y'
);

SELECT * FROM tb3;
TRUNCATE TABLE tb3;
