// 유한한 값인가
console.log(globalThis.isFinite(10));
console.log(globalThis.isFinite(Infinity));

// NaN인가
console.log(global.isNaN(NaN));
console.log(global.isNaN(10));

// js에서 uri 경로 상에 한글이 포함된 값을 처리해야 할 경우라면 encoding 또는 decoding을 해주어야 한다.
// 이 때, 전역 객체에서 제공하는 메소드를 활용할 수 있다.

// 아래 문자만 uri상 허용된다.(ASCII)
// 알파벳: A-Z, a-z
// 숫자: 0-9
// 특수기호: - _ . ! ~ * ' ()
const uriComp = `name=홍길동&job=student`;
const encComp = global.encodeURIComponent(uriComp);
console.log(encComp);

const decodeComp = global.decodeURIComponent(encComp);
console.log(decodeComp);