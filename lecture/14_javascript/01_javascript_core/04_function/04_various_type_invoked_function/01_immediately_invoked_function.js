function hello(name) {
    return `${name}님 안녕`;
};

(function() {
    console.log("익명 즉시 실행 함수! 함수 정의와 동시에 호출");

})();

(function greeting(name) {
    console.log("기명 즉시 실행 함수! 함수 정의와 동시에 호출");
    console.log(`${name}님 반갑습니다.`)
})("아라 한");

// 기명 즉시 실행 함수는 적용은 되지만 외부에서 호출할 수 없다.
// greeting("범황");
