/* trigger */
delimiter //

CREATE OR REPLACE TRIGGER after_order_menu_insert
	 AFTER INSERT		-- 트리거 발종 이벤트(insert / update / delete)
	 ON tbl_order_menu
	 FOR EACH ROW		-- 아래 조건을 만족하는 모든 row에 적용
BEGIN
	 UPDATE tbl_order
	 SET total_order_price = total_order_price + NEW.order_amount *
	 (SELECT menu_price FROM tbl_menu WHERE menu_code = NEW.menu_code)
	 WHERE order_code = NEW.order_code;
END //

delimiter ;

-- 주문 테이블(tbl_order)에 insert후 주문 메뉴 테이블(tbl_order_menu)에
-- 주문한 메뉴마다 insert 후 주문 테이블의 초 윽ㅁ액이 insert할 때마다 업데이트 되는지 확인

-- 1) 주문 테이블 insert
INSERT
  INTO tbl_order
(
  order_code, order_date
, order_time, total_order_price
)
VALUES
(
  NULL
, CONCAT(CAST(YEAR(NOW()) AS VARCHAR(4))
		 , CAST(LPAD(MONTH(NOW()), 2, 0) AS VARCHAR(2))
		 , CAST(LPAD(DAYOFMONTH(NOW()), 2, 0) AS VARCHAR(2))
		 )
, CONCAT(CAST(LPAD(HOUR(NOW()), 2, 0) AS VARCHAR(2))
		 , CAST(LPAD(MINUTE(NOW()), 2, 0) AS VARCHAR(2))
		 , CAST(LPAD(SECOND(NOW()), 2, 0) AS VARCHAR(2))
		 )
, 0 
);

SELECT * FROM tbl_order;
SELECT * FROM tbl_order_menu;
SELECT * FROM tbl_menu;

-- 열무김치라떼 2개 주문
INSERT
  INTO tbl_order_menu
( order_code, menu_code, order_amount)
VALUES
( 1, 1, 2);

-- 추가로 같은 주문에서 우럭 스무디 3개 주문
INSERT
  INTO tbl_order_menu
( order_code, menu_code, order_amount)
VALUES
( 1, 2, 3);

INSERT
  INTO tbl_order_menu
( order_code, menu_code, order_amount)
VALUES
(1, 15, 1),
(1, 5, 2);

-- --------------------------------------------------

/* 상품 입출고와 관련된 trigger활용 예제 */
-- 1) 이력 테이블(update가 발생하는 테이블)
CREATE OR replace TABLE product(
	 pcode INT PRIMARY KEY AUTO_INCREMENT,
	 pname VARCHAR(30),
	 brand VARCHAR(30),
	 price INT,
	 stock INT DEFAULT 0,
	 CHECK(stock>=0)
);

-- 2) 내역 테이블(insert가 발생하는 테이블)
CREATE or replace TABLE pro_detail(
	 dcode INT PRIMARY KEY AUTO_INCREMENT,
	 pcode INT,
	 pdate DATE,
	 amount INT,
	 STATUS VARCHAR(10) CHECK(STATUS IN('입고', '출고')),
	 FOREIGN KEY(pcode) REFERENCES product		-- 참조 대상은 primary key 안적어도 자동인식
	 
);

-- 입출고용 트리거 생성
delimiter //

CREATE OR REPLACE TRIGGER trg_productafter
	 AFTER insert
	 ON pro_detail
	 FOR EACH row
BEGIN
	 if new.STATUS = '입고' then
	     UPDATE product
	        SET stock = stock + NEW.amount
	      WHERE pcode = NEW.pcode;
	 ELSEIF NEW.status = '출고' then
	     UPDATE product
	        SET stock = stock - NEW.amount
	      WHERE pcode = NEW.pcode;
	 END if;
END //

delimiter ;


SHOW TRIGGERS;
-- product 테이블에 기본 상품 추가
INSERT
  INTO product
(
  pcode, pname, brand
, price, stock
)
VALUES
(
  NULL, '갤럭시플립', '삼송'
, 900000, 5
),
(
  NULL, '아이펀', '아이퐁'
, 1100000, 5
),
(
  NULL, '투명폰립', '삼송'
, 2100000, 5
);

SELECT * FROM pro_detail;

-- 내역 테이블에 insert 시행(입추고 진행)
INSERT
  INTO pro_detail
(
  dcode, pcode, pdate
, amount, status
)
VALUES
(
  NULL, 7, CURDATE()
, 5, '출고'
);
SELECT * FROM product;
SELECT * FROM pro_detail;