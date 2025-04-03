// var 형태의 변수는 같은 지역에 중복 선언 가능
// 세미콜론은 ASI이 제공되지만 잊지 말고 수동적으로 작성하자

var flag = true;
console.log(flag);

var flag = false;
console.log(flag);

console.log(typeof flag);