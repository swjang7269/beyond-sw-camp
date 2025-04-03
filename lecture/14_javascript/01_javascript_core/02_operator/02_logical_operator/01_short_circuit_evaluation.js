// 단축 평가 구문
// 논리 연산의 결과를 결정짓는 항이 남는다.

// 1. OR의 경우
// Truthy한 값을 반환(앞의 조건이 T라면 뒤의 조건을 살피지 않는다.) -> 연산의 결과를 결정짓는 항을 반환
console.log("apple" || "banana");   // T ||    -> 앞 조건식의 T값 반환(앞의 조건이 T라면 뒤를 볼 필요 없기 때문)
console.log("" || "banana");        // F || T  ->  T값 반환
console.log("apple" || false);      // T ||    ->  T값 반환

// 2. AND의 경우
console.log("apple" && "banana");   // T && T  ->  뒤의 조건식까지 만족해야 T이므로 뒤 조건식의 T값 반환
console.log(false && "banana");     // F &&    ->  앞 조건식이 F면 뒤 볼필요도 없이 F이다.
console.log("apple" && false);      // T && F  ->  하나라도 F면 F이다.
console.log("" && "banana");

// 3. 단축 평가 구문
var num = 3;
num % 2 == 0 && console.log("짝수");    // ? && T   -> 앞의 조건이 true일 떄, 뒤의 로그가 true 여부 결정(실행)
num % 2 == 0 || console.log("홀수");    // ? || T   -> 앞의 연산이 true 여부 결정(앞의 조건이 false일 때, 로그가 true 여부 결정(실행))

// if(num % 2 == 0) {
//     console.log("짝수");
// } else {
//     console.log("홀수");
// }