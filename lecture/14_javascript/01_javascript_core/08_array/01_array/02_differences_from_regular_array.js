const arr = [
    "홍길동",
    20,
    true,
    null,
    undefined,
    NaN,
    Infinity,
    [],
    {},
    function() {}
];

// 자바스크립트의 배열은 자바의 컬렉션(ArrayList)처럼 모든 자료형을 저장할 수 있다.
console.log(arr);

// writable - true면 값을 수정할 수 있다.
// enumerable - true면 반복할 수 있다.
// configurable - true면 삭제할 수 있다.
console.log(Object.getOwnPropertyDescriptors([1, 2, 3]));