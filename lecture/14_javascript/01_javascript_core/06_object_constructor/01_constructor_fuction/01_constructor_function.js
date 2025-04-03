// 생성자 함수를 활용한 객체 생성
function Student(name, age) {
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`
    }
}

const student1 = new Student("비천", 20);
const student2 = new Student("범황", 24);

console.log(student1);
console.log(student2);

// 리터럴 객체를 활용한 객체 생성
const student3 = {
    name: "대라",
    age: 22,
    getInfo: function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`
    }
}

const student4 = {
    name: "일천",
    age: 23,
    getInfo: function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`
    }
}

console.log(student3);
console.log(student4);

