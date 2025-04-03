// 스프레드 문법을 활용한 배열 및 객체 복사

// 1. 배열 복사
let arr = [10, 40, 80];
let arrCopy = [...arr];

console.log(arr);
console.log(arrCopy);
console.log(arr === arrCopy);   // 동등 객체이지 동일 객체는 아니다.(깊은 복사 - 새로운 배열로 복사)

// 2. 객체 복사
let obj = {
    name: "범황",
    age: 20,
    addr: "하멜",
    hobbies: ["창술", "마공"]
};

let objCopy = {...obj}; // 객체의 프로퍼티들을 전개

console.log(obj);
console.log(objCopy);
console.log(obj === objCopy);   // 깊은 복사

// 객체 내부에 추가적인 객체들(객체 또는 배열 등)이 있을 경우 완전한 깊은 복사를 위해서는 추가적인 작업이 필요하다.
console.log(obj.hobbies === objCopy.hobbies);   // 내부 객체는 얕은 복사가 일어난다.(주소 동일) true
objCopy.hobbies = [...obj.hobbies]; // 내부 배열도 다시 한 번 깊은 복사가 일어나도록 해줘야 한다.
console.log(obj.hobbies === objCopy.hobbies);   // false

let classNum = 30;     // 추가
let name = "아라한";   // 수정
let newObj = {classNum, ...obj, name};  // obj의 name이 덮어씌어 수정 됨(obj의 name이 먼저 뿌려지고 나중에 사용자 name이 들어가기 때문에)
console.log(newObj);
