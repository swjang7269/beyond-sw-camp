// 객체 리터럴 기반 상속 또는 프로토 타입 직접 연결 상속

const user = {
    activate: true,
    login: function() {
        console.log("로그인");
    }
};

console.log(user);
console.log(typeof user);

// 객체 생성시 Object(Constructor)와 Object.prototype(Prototype) 쌍 생성
// 모든 객체는 프로토타입을 가진다.
console.log(user.constructor == Object);
console.log(user.__proto__ == Object.prototype);    // 생성자 함수가 프로토타입을 접근할 때와 객체가 접근할 때 방식(문법)이 다르다. but 권장하는 방식은 아님
console.log(user.constructor == Object.prototype.constructor);

// __proto__는 권장되지 않고 Object의 getPrototypeOf() 사용을 권장.(일부 js엔진이나 웹 브라우저 이슈)
console.log(Object.getPrototypeOf(user) == Object.prototype);   // 권장하는 방식

// 상속
const user2 = {
    activate: "활성",
    login: function() {
        console.log("로그인 실패");
    }
};

console.log(user2.__proto__);

const student = {
    passion: true
};

// prototype에 객체를 넣어 상속
// student.__proto__ = user2;
Object.setPrototypeOf(student, user2);  // __proto__ 대신 setPrototypeOf() 권장
console.log(student.activate);  // prototype에 담긴 user2의 activate를 상속받아 사용

console.log(student.__proto__);

const greedyStudent = {
    class: 1
};

greedyStudent.__proto__ = student;

// 순차적으로 프로토타입을 타고 올라가며 탐색한다.
// 프로토타입 체인을 통한 접근
// greedyStudent -> student -> user2 -> Object.prototype -> null
console.log(greedyStudent.passion); // 부모 객체에서 가져옴
greedyStudent.login(); // 조부모 객체에서 가져옴