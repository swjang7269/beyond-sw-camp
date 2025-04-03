// 일급 객체의 특징 (일급 객체: 프로그래밍 언어에서 함수나 변수를 일반적인 값처럼 취급할 수 있는 개념)
//  1. 무명의 리터럴로 생성할 수 있다. 즉, 런타임에 생성이 가능하다. 
//  2. 변수나 자료구조(객체, 배열 등)에 저장할 수 있다.
//  3. 함수의 매개변수로 전달할 수 있다.
//  4. 함수의 반환값으로 사용할 수 있다.

// 1, 2번에 해당
var hello = function() {
    return "안녕하세요";
};

// 3번에 해당
function repeat(func, count) {
    for(var i = 0; i < count; i ++) {
        console.log(func());
    }

    // 내부 함수를 반환
    // 렉시컬 환경(자신이 생성된 환경)을 활용한 함수를 반환(이렇게 반환된 함수를 클로저(Closure) 함수라 한다.)
    // 렉시컬 환경: 코드가 작성된 위치(어휘적 구조)를 기준으로 변수와 함수의 범위(Scope)가 결정됨.
    //      즉, 변수의 유효 범위는 "코드가 실행되는 순간"이 아니라 "코드를 작성한 위치"에서 결정됨.
    // Closure 함수: 외부 함수의 변수를 기억하고, 외부 함수가 종료된 후에도 접근할 수 있는 함수
    // 4번에 해당
    return function() {
        console.log(`${count}번 반복 완료`);
    }
}

repeat(hello, 3);   // repeat내의 콜백함수를 3번 수행
repeat(hello, 5)(); // () 덕분에 repeat의 내부함수도 실행이 된다.