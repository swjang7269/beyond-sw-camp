// 1. 숫자 1, 문자 '1', true 비교
console.log(`1 == 1: ${1 == 1}`);
console.log(`1 == true: ${1 == true}`);
console.log(`1 == '1': ${1 == '1'}`);   // '==': 동등 비교(내용만 비교)
console.log(`1 === '1': ${1 === '1'}`); // '===': 동일 비교(타입까지 비교)

// 2. NaN는 자신과 일치하지 않는 유일한 값
console.log(`NaN == NaN: ${NaN == NaN}`);   // false
console.log(`NaN === NaN: ${NaN === NaN}`); // false

// 3. 일치하지 않는 값 비교(다르면 true, 같으면 false)
console.log(`1 != '1': ${1 != '1'}`);   // false(타입까지 비교) -> '=='의 반대 (1 == '1'은 true)
console.log(`1 !== '1': ${1 !== '1'}`); // true(내용만 비교)    -> '==='의 반대 (1 === '1'은 false)
