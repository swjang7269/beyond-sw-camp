// 생성자 함수 기반 상속 또는 의사 클래스 상속

// 부모 생성자 함수
function Parent(name) {
    this.name = name;
};

console.log(Parent.prototype); // 함수만 만들어도 프로토타입 존재(함수도 객체라는 증거)

// 속성 프로퍼티 / 기능 프로퍼티 나누어 상속

// 부모 프로토타입
Parent.prototype.sayHello = function() {
    console.log(`hello, how r u ${this.name}`);
}

// 자식 생성자 함수
function Child(name, age) {
    Parent.call(this, name);    // 자바의 super() 개념
    this.age = age;
}

Child.prototype = Object.create(Parent.prototype);  // Child의 프로토타입에 부모 프로토타입 대입(부모 프로토타입의 constructor는 Parent)
Child.prototype.constructor = Child;    // Child의 프로토타입에 대딥된 Parent.prototype의 Constructor를 Child의 Constructor가 되도록 바꿔줌

Child.prototype.sayAge = function() {
    console.log(`${this.age}세`);
}

const child = new Child("홍길동", 20);  // 이 순간 객체가 된다.
child.sayHello();
child.sayAge();

// --------------------------------------------
class Parent {
    constructor(name) {
        this.name = name;
    }

    sayHello() {
        console.log(`hi, I'm ${this.name}`);
    }
}

class Child extends Parent {
    constructor(name, age) {
        super(name);
        this.age = age;
    }
    
    sayAge() {
        console.log(`I'm ${this.age}세에요`);
    }
}