// null 병합 연산자
// 함수의 피연산자가 null이거나 undefined면 우항의 결과가 남고(함수면 실행), 그렇지 않으면 좌항이 남는다.(함수면 실행)
var test = null ?? "기본값";
console.log("test:", test); // console.log는 매개변수를 두 개 이상 쓰면 중간에 띄어쓰기를 포함해서 문자열 이어붙이기가 가능

var value1 = "" || "기본 값";
var value2 = "" ?? "기본 값";
console.log("value1:", value1);
console.log("value2:", value2);