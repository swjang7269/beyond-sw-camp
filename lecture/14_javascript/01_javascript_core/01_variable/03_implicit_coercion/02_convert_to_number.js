console.log(10 - "5");  // string2number
console.log(10 * "5");
console.log(10 / "5");
console.log(10 % "JavaScript"); // NaN
console.log(10 > "5");          // true

console.log("양수로 바꿔서 number로 변환");
console.log(+" ");              // 0
console.log(+"1");              // 1
console.log(+"JavaScript");     // NaN
console.log(+true);             // 1
console.log(+false);            // 0
console.log(+null);             // 0
console.log(+undefined);
// console.log(+Symbol());         // 변환 불가
console.log(+{});               // NaN
console.log(+[]);               // 0
console.log(+function() {});    // NaN

// 빈 문자열, 빈 배열, null, false는 0으로, true는 1로 변환