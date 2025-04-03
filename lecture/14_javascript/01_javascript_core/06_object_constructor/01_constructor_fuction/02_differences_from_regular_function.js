// new 연산자를 안 붙이고 일반 함수로 썼을 때 내부의 this는 전역 객체이며 함수명만 대문자로 시작하는 상태
const student = Student("대라", 23);    // 일반 함수로써 활용 시
console.log(student);

// console.log(this);   // 가짜 전역 객체
// console.log(globalThis)

function Dog(name, age) {
    this.name = name;
    this.age = age;
};

const dog = new Dog("불독", 3);
console.log(dog);


// new 연산자의 유무와 관계없이 객체를 생성하도록 만든 함수를 빌트인 함수라 한다.