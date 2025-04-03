function hello(name) {
    console.log(`넘어온 값:`, name);

    // 모든 인수(전달인자)는 함수 안에서 arguments 객체의 프로퍼티로 보관괸다.
    console.log("arguments:", arguments);
    console.log("두 번째 인수:", arguments[1]);

    return `${name}님 안녕하세요`;
}

var result = hello("아라");
console.log("result:", result);

var result = hello();
console.log("result:", result);

var result = hello("비천", "범황");
console.log("result:", result);