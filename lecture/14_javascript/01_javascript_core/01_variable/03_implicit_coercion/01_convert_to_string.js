console.log(10 + "20"); // string으로 묵시적 형변환
console.log(`10 + 20: ${10 + 20}`);

console.log(1 + "");
console.log(NaN + "");
console.log(Infinity + "");
console.log(true + "");
console.log(null + "");
console.log(undefined + "");
// console.log(Symbol() + "");         // Symbol()은 문자열로 바꿀 수 없다. (Cannot convert a Symbol value to a string)
console.log({} + "");               // 리터럴 객체
console.log([1, 2] + "");           // 배열
console.log(function() {} + "");    // 함수  -> 모두 object에 속한다.
