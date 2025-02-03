/* constaint */
/* 1. not null 제약조건 */
-- null값을 포함할 수 없는 컬럼에 대한 제약조건
-- 컬럼레벨에서만 가능한 제약 (컬럼 옆에 적어야한다.)
DROP TABLE if EXISTS user_notnull;
CREATE TABLE if not EXISTS user_notnull(
    user_no INT NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);

INSERT
  INTO user_notnull
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com'),
(2, 'user02', 'pass02', '유관순', '여', '010-777-7777', 'yu77@gmail.com');

SELECT * FROM user_notnull;

/* 2. unique 제약 조건 */
/* 기존 데이터와 중복되지 않아야함 */
-- 컬럼레벨 및 테이블 레벨 모두 가능
-- PRIMARY KEY는 한 개만 존재

CREATE TABLE if NOT EXISTS user_unique(
    user_no INT NOT NULL unique,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    UNIQUE(phone)
);

INSERT
  INTO USER_unique
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com'),
(2, 'user02', 'pass02', '유관순', '여', '010-777-7777', 'yu77@gmail.com');

SELECT * FROM user_unique;

/* 3. primary key 제약조건 */
-- not null + unique 제약 조건
-- 모든 테이블은 반드시 primary key를 가져야 한다.
-- 행을 구분할 수 있어야 함.
CREATE TABLE if NOT EXISTS user_primarykey(
    user_no INT,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    UNIQUE (phone),
    PRIMARY KEY(user_no)
);

/* 4. foreign key 제약조건 */
-- 4-1. 회원등급 부모 테이블 먼저 생성
DROP TABLE if EXISTS user_grade;
CREATE TABLE if NOT EXISTS user_grade(
	 grade_code INT NOT NULL UNIQUE,
	 grade_name VARCHAR(255) NOT null
);

-- 4-2. 회원 자식 테이블 이후에 생성
-- 대상 테이블의 대상 컬럼값을 참조하는 값만 입력받도록 제약
CREATE TABLE if NOT EXISTS user_foreignkey1(
	 user_no INT PRIMARY KEY,
	 user_id VARCHAR(255) NOT NULL,
	 user_pwd VARCHAR(255) NOT NULL,
	 user_name VARCHAR(255) NOT NULL,
	 gender VARCHAR(3),
	 phone VARCHAR(255) NOT NULL,
	 email VARCHAR(255),
	 grade_code INT,
	 FOREIGN KEY(grade_code) REFERENCES user_grade(grade_code)
);

INSERT
  INTO user_grade
VALUES
(10, '일반회원'),
(20, '우수회원'),
(30, '특별회원');

SELECT * FROM user_grade;

-- foreign key 제약조건이 걸릴 컬럼은 부모 테이블의 pk값(또는 not null unique)
-- + null값이 들어갈 수 있다.
INSERT
  INTO user_foreignkey1
VALUES
(1, 'user01','pass01','유관순','여','010-333-2222','yu@gmail.com',20),
(2, 'user02','pass02','홍길동','남','010-1234-5678','hong@gmail.com',NULL);

SELECT * FROM user_foreignkey1;

-- fk 제약조건에 의해 발생하는 문제
-- 자식에서 참조중인 값은 삭제 불가(설정 가능)
-- 1) 참조하지 않는 등급 삭제 (10,30)
DELETE FROM USER_grade WHERE grade_code = 10;
SELECT * FROM user_grade;
-- 2) 참조하는 등급 삭제(20)
-- -> 참조중이므로 (유관순) 삭제가 안된다.
DELETE FROM user_grade WHERE grade_code = 20;

-- 참조하고 있는(자식 테이블) 데이터부터 삭제해야 부모테이블 데이터도 삭제가 온전히 된다.

-- 참조하고 이쓴ㄴ 자식테이블을 신경쓰지 않고 부모테이블의 데이터를 지우려면
-- 삭제룰을 가진 fk제약조건을 만들어야한다.
-- 4-3. 
CREATE TABLE if NOT EXISTS user_foreignkey2(
	 user_no INT PRIMARY KEY,
	 user_id VARCHAR(255) NOT NULL,
	 user_pwd VARCHAR(255) NOT NULL,
	 user_name VARCHAR(255) NOT NULL,
	 gender VARCHAR(3),
	 phone VARCHAR(255) NOT NULL,
	 email VARCHAR(255),
	 grade_code INT,
	 FOREIGN KEY(grade_code) REFERENCES user_grade(grade_code)
	 ON DELETE SET NULL -- 참조대상이 사라지면 null로
);

INSERT
  INTO user_foreignkey2
VALUES
(1, 'user01','pass01','유관순','여','010-333-2222','yu@gmail.com',20),
(2, 'user02','pass02','홍길동','남','010-1234-5678','hong@gmail.com',NULL);

SELECT * FROM user_foreignkey2;

DELETE FROM user_grade WHERE grade_code = 20;
-- 부모데이터를 삭제하면 20이었던 참조값이 null로 바뀐다.

/* 5.check 제약조건(조건식을 활용) */
DROP TABLE if EXISTS user_check;
CREATE TABLE if NOT EXISTS user_check(
	 user_no INT AUTO_INCREMENT PRIMARY KEY,
	 user_name VARCHAR(255) NOT NULL,
	 gender VARCHAR(3) CHECK(gender IN('남', '여')),
	 age INT CHECK(age>=10)
);

INSERT
  INTO user_check
VALUES
(NULL,'홍길동','남',25),
(NULL,'신사임당','여',33);

SELECT * FROM user_check;

-- check 제약조건 위반시 에러
INSERT
  INTO user_check
VALUES
(NULL,'유관순','여',16),			--나이 위반
(NULL, '플라나리아','중성',20) -- gender 위반

-- default 제약조건
CREATE TABLE if NOT EXISTS tbl_country(
	 country_code INT AUTO_INCREMENT PRIMARY KEY,
	 country_name VARCHAR(255) DEFAULT '한국',
	 population VARCHAR(255) DEFAULT '0명',
	 add_day DATE DEFAULT(CURRENT_DATE),
	 add_time DATETIME DEFAULT (CURRENT_TIME)
);

INSERT
  INTO tbl_country
VALUES
(NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

SELECT * FROM tbl_country;















