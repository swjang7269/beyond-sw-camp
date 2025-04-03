// 자바스크립트는 객체 지향(기반) 프로그래밍 언어로 원시 값을 제외한 나머지 값(함수, 배열, 정규표현식 등)은
// 모두 객체이다.(feat.프로토타입을 가지면 객체)

var name = "홍시";
var age = 10;

var student = {
    // 속성 프로퍼티
    name: "아라 한",
    age: 20,

    // 기능 프로퍼티
    // 속성의 값이 함수인 프로퍼티는 '메소드'이다.
    // 메소드 안에서는 this.을 반드시 쓰자(안쓰면 전역 변수가 나올 수 있음)
    getInfo: function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;  // this. -> 해당 객체의 속성(필드) 값, 메소드가 포함된 객체
    }
}

console.log('student:', student);
console.log("이름:", student.name);
console.log("나이:", student.age);
console.log("정보:", student.getInfo());    // 메소드는 접근하면 소괄호(())를 통해 실행 가능

this.name = "범황"
console.log(this);
