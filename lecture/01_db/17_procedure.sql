/* stored procedure */
-- 저장해둔 일련의 sql문장을 불러와 반복 재사용함으로써
-- 반복적인 작업을 효율화
-- 네트워크 트래픽을 줄일 수 있다. (DB에서 일어나는 일이기 때문)

-- 문장의 끝을 구분하는 구분자를 무엇으로 하겠다.
delimiter //		-- ';'이 아니라 '//'이 문장의 끝이다 선언
						-- 관례상 '//'을 사용

-- 기능 단위로 procedure를 만들어서 설정 반복문과 조건을 사용시 효율적
-- 함수 선언과 유사
-- 너무 복잡한 기능을 구현하여 DB에서 대부분을 처리하게 되면
-- java가 들러리가 되어버린다.
CREATE OR REPLACE PROCEDURE getAllEmployees()
BEGIN
	 SELECT emp_id, emp_name, salary
	 FROM employee;
END //

delimiter ;

CALL getAllEmployees();

-- --------------------------------
-- IN 매개변수 -> 사용자가 입력하는 변수
delimiter //

CREATE OR REPLACE PROCEDURE getEmployeesByDepartment (
	 IN dept CHAR(2),
	 IN jobb CHAR(2)
)
BEGIN
	 SELECT emp_id, emp_name, salary, dept_code, job_code
	 FROM employee
	 WHERE dept_code = dept OR job_code = jobb;
END //

delimiter ;

CALL getEmployeesByDepartment('D9', 'j7');
CALL getEmployeesByDepartment('D5', '');

-- ----------------------------------------------
-- OUT 매개변수 -> procedure의 변수를 받아내는 변수
-- 함수 결과물을 받아내는 변수
-- return의 명시적인 개념은 없지만 매개변수를 통해 return을 받는다.
delimiter //
CREATE OR  REPLACE PROCEDURE getEmployeeSalary(
	 IN id VARCHAR(3),
	 OUT sal DECIMAL(10,2)
)
BEGIN
	 SELECT salary INTO sal		-- salary를 sal에 저장
	 FROM employee
	 WHERE emp_id = id;
END //

delimiter ;

SET @sal = 0;
CALL getEmployeeSalary('204', @sal);
SELECT @sal;

-- ------------------------------------------------------
-- INOUT 매개변수 IN + OUT 양방향 가능 (호출 -> 내부, 내부 -> return)
delimiter //
CREATE OR REPLACE PROCEDURE updateAndReturnSalary(
	 IN id VARCHAR(3),
	 INOUT sal DECIMAL(10, 2)
)
BEGIN
	 UPDATE employee
	 SET salary = sal
	 WHERE emp_id = id;
	 
	 SELECT salary + (salary * ifnull(bonus, 0)) INTO sal
	 FROM employee
	 WHERE emp_id = id;
END //

delimiter ;

-- ifnull = nvl(null value) 동일한 역할 null이면 치환
-- 연산시 null이 들어가면 결과는 무조건 null -> 원한다면 함수를 통해 null값을 바꿔줘야한다.
SET @new_sal = 9000000;
CALL updateAndReturnSalary('200', @new_sal);
SELECT @new_sal;

-- @변수의 의미
-- 1) '사용자 정의형 변수'
-- 2) 크기를 따로 정하지 않지만 대입되는 값에 맞춰진다.
-- 3) 전역 변수의 의미를 가짐

-- --------------------------------------------------------
-- if-else 활용

-- 지역변수 선언 declare
delimiter //

CREATE OR REPLACE PROCEDURE checkEmployeeSalary(
	 IN id VARCHAR(3),
	 IN threshold DECIMAL(10,2),
	 OUT result VARCHAR(50)
)
BEGIN
	 DECLARE sal DECIMAL(10,2);
	 
	 SELECT salary INTO sal
	 FROM employee
	 WHERE emp_id = id;
	 
	 if sal > threshold then
	     SET result = '기준치를 넘는 급여 입니다.';
	 else
	     SET result = '기준치 이하의 급여입니다.';
	 END if;
END //

delimiter ;

SET @result = '';
CALL checkEmployeeSalary('200', 3000000, @result);
SELECT @result;

-- ------------------------------------------------------
-- case
delimiter //

CREATE OR REPLACE PROCEDURE getDepartmentMessage(
	 IN id VARCHAR(3),
	 OUT message VARCHAR(100)
)
BEGIN
	 DECLARE dept VARCHAR(50);
	 
	 SELECT dept_code INTO dept
	 FROM employee
	 WHERE emp_id = id;
	 
	 case
        when dept = 'D1' then
           SET message = '인사관리부 직원이시군요!';
        when dept = 'D2' then
			  SET message = '회계관리부 직원이시군요!';
		  when dept = 'D3' then
			  SET message = '마케팅부 직원이시군요!';
		  else
			  set message = '어떤 부서 직원이신지 모르겠어요!';
	 END case;
END //

delimiter ;

SET @msg = '';
CALL getDepartmentMessage('221', @msg);
SELECT @msg;

-- while 활용
delimiter //
CREATE OR REPLACE PROCEDURE calculateSumUpTo(
	 IN max_num INT,
	 OUT SUM_result INT
)
BEGIN
	 DECLARE current_num INT DEFAULT 1;
	 DECLARE total_sum INT DEFAULT 0;
	 
	 while current_num <= max_num DO
	      SET total_sum = total_sum+current_num;
	      SET current_num = current_num + 1;
	 END while;
	 
	 SET sum_result = total_sum;
	 
END //

delimiter ;

SET @result = 0;
CALL calculateSumUpTo(10000, @result);
SELECT @result;

-- -----------------------------------------
-- 예외 처리
delimiter //

CREATE PROCEDURE divideNumbers(
	 IN numerator DOUBLE,
	 IN denominator DOUBLE,
	 OUT result double
)
BEGIN
	 DECLARE division_by_zero CONDITION FOR SQLSTATE '45000';
	 DECLARE exit handler FOR division_by_zero
	 begin
	     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = '0으로 나눌 수 없습니다.';
	 END;
	 
	 if(denominator = 0) then
	     SIGNAL division_by_zero;
	 else
	     SET result = numerator / denominator;
	 END if;
END //

delimiter ;

CALL divideNumbers(10, 2, @result);
SELECT @result;
call divideNumbers(10,0,@result);	-- handler로 설정한 에러 띄움

-- ---------------------------------------------
-- stored function
delimiter //

CREATE OR REPLACE FUNCTION getAnnualSalary(
	 id VARCHAR(3)
)
RETURNS DECIMAL(15,2)	-- procedure과의 가장 큰 차이
DETERMINISTIC				-- 결과가 항상 같냐 / not 아니냐
								-- 결정론적 / 비 결정론적
BEGIN
	 DECLARE monthly_salary DECIMAL(10,2);
	 DECLARE annual_salary DECIMAL(15,2);
	 
	 SELECT salary INTO monthly_salary
	 FROM employee
	 WHERE emp_id = id;
	 
	 SET annual_salary = monthly_salary * 12;
	 
	 RETURN annual_salary;
END //

delimiter ;

SELECT
		 emp_name
	  , getAnnualSalary(emp_id) AS '연봉'
  from employee;












