// 스프레드 연산자, 전개문법
let arr = [10, 20, 30];
console.log(arr);
console.log(...arr);

console.log(`가장 큰 값: ${Math.max(10, 20, 30)}`);
console.log(`가장 큰 값: ${Math.max(...arr)}`);

// 배열을 결합(concat)해서 하나의 배열로 만들 때
let arr1 = [10, 20, 30];
let arr2 = [100, 200, 300];
console.log(...arr1, ...arr2);  // arr1을 기준으로 arr2를 결합
console.log(10, ...arr1, -1, ...arr2);