var sym = Symbol("심볼");

var student = {
    name: "범황",
    age: 20,
    test: undefined
};

student[sym] = "추가";
console.log(student);   // sYMBOL이 프로퍼티로 추가되어 있지만 for-in문에서는 숨겨진다.

// 객체 내에 해당 이름의 프로퍼티가 있는지
console.log("name" in student);
console.log("age" in student);
console.log("test" in student);

// for-in문(프로퍼티 순회 용도)
for(var key in student) {
    console.log(`key: ${key}`);
    console.log(`student[${key}]: ${student[key]}`);
    console.log(`<td>${student[key]}<td>`);
}