// 전역 객체는 코드가 실행되기 이전 단계에 자바스크립트 엔진에 의해 어떤 객체보다도 먼저
// 생성되는, 그리고 어떤 객체에도 속하지 않는 최상위 객체를 뜻한다.
// Node.js 환경에서는 global이 전역 객체이고, 웹 브라우저 환경에서는 window가 전역 객체이다.

// 글로벌 객체
console.log(globalThis);
console.log(Object.getOwnPropertyDescriptors(global));

// Infinity
console.log(global.Infinity);
console.log(10 / 0);

// NaN
console.log(global.NaN);
console.log(Number("abc"));