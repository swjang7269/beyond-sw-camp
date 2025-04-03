// 변수의 타입이 정해져 있지 않으며 대입되는 값에 따라 동적으로 정해진다.
var test;
console.log(typeof test);

test = {};
console.log(typeof test);

test = "JavaScript";
console.log(typeof test);

test = true;
console.log(typeof test);

test = Symbol();
console.log(typeof test);

test = {};
console.log(typeof test);

test = [];
console.log(typeof test);

test = function() {};       // 일종의 객체로 볼 수 있다. (기본 자료형은 아니다.)
console.log(typeof test);