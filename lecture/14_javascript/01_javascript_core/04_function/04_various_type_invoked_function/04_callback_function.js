
function increase(value) {  // 고차함수에서 불리는 함수: 콜백함수
    return value + 1;
}

function decrease(value) {
    return value - 1;
}

function apply(func, value) {   // 고차함수: 다른 함수를 활용하는 함수
    return func(value);
}

console.log(apply(increase, 5));    // increase 함수가 콜백
console.log(apply(decrease, 5));    // decrease 함수가 콜백

console.log([3, 2, 1, 5, 4].sort(function(left, right) {return right - left;}));    // 콜백 함수로 익명 함수를 이용한 내림차순 정렬
console.log([3, 2, 1, 5, 4].sort((left, right) => left - right));                   // 애로우 펑션을 이용한 오름차순 정렬
