// Falsy한 값 정도는 알아두면 은근히 쓸 곳이 있다.
console.log(Boolean("JavaScript"));
console.log(Boolean(""))            // false
console.log(Boolean(1))
console.log(Boolean(0))             // false
console.log(Boolean(NaN))           // false
console.log(Boolean(Infinity))
console.log(Boolean(null))          // false
console.log(Boolean(undefined))     // false
console.log(Boolean({}))
console.log(Boolean([]))

console.log(!!"JavaSceipt");
console.log(!!"");
console.log(!!0);
console.log(!!1);
console.log(!!NaN);
console.log(!!Infinity);
console.log(!!null);
console.log(!!undefined);
console.log(!!{});
console.log(!![]);