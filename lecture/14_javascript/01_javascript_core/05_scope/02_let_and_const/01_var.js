// 함수 레벨 스코프

// C, 자바 등 대부분의 프로그래밍 언어는 모든 코드 블록(if, for, while, try/catch 등)이
// 지역 스코프를 만드는 블록 레벨 스코프(block level scope)를 가진다

// 하지만 var 키워드로 선언된 변수는 함수의 코드 블록(함수 몸체)만을 지역 스코프로 인정하는
// 함수 레벨 스코프(function level scope)를 가진다.

var i = 0;
for(var i = 0; i < 10; i++) {

}
console.log(i); // i = 10   for문 안의 var i가 for문 범위를 인정하지 않는다.

// var 키워드의 특징
// 1. 같은 범위(같은 함수 레벨 스코프)에서 변수 중복 선언 가능
var msg = "안녕하세요";
console.log("msg", msg);

var msg = "안녕히가세요";
console.log("msg", msg);

var msg;    // 죽지 않고 이전 msg값이 살아있다.
console.log("msg", msg);

// 2. 함수 레벨 스코프만 인정

// 3. 변수 호이스팅
console.log(test);
test = "반갑습니다.";
var test;