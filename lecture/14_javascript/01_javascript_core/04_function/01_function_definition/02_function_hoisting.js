console.log(hello("아라"));     // 아래 함수를 끌어올려 실행

function hello(name) {
    return `${name}님 안녕하세요`;
}

// 함수 표현식은 함수 호이스팅이 발생하지 않는다.
console.log(hi("블러디 퀸"));

var hi = function(name) {
    return `${name} 안녕~`;
}

// 함수 선언문은 런타임 이전 자바스크립트 엔진에 의해 먼저 해석된다.(컴파일적 요소)
// 따라서 함수 선언문 이전에 함수를 참조할 수 있으며 호출할 수도 았더,
// 함수 선언문이 코드의 선두로 끌어올려진 것처럼 동작하는 자바스큷트 고유의 특징을
// '호이스팅'이라고 한다.(이후 변수에서도 나올 예정)