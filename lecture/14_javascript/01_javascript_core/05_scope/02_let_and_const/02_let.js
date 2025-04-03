// 1. 변수 중복 선언 금지
let msg = "안녕";

// let msg = "잘가";

// 2. 블록 레벨 스코프 인정
let i = 0;
for(let i = 0; i < 10; i++) {

}
console.log(i); // 0

// 3. 변수 호이스팅 방지
console.log(x);
let x = 1;
