var dog = {
    name: "뽀삐",
    eat: function(food) {
        console.log(`${this.name}(은)는 ${food}를 먹는다.`);
    }
};

// 1. 마침표 표기법(dot notation)
console.log(dog.name);
dog.eat("감자");

// 2. 대괄호 표기법(squre braket notation)
console.log(dog["name"]);
dog["eat"]("고구마");

// 대괄호 표기법 사용시 고려해야 하는 경우
var obj = {
    under_key: "under_key", // 프로퍼티 키를 문자열이 아닌 형태로 할 수 있다.
    'dash-key': "dash-key" ,
    0: 1
};

// 마침표 표기법은 접근에 한계가 있다.
console.log(obj.under_key);
// console.log(obj."dash-key");
// console.log(obj.0);

// 대괄호 표기법은 다양한 형태의 프로퍼티들을 모두 접근할 수 있다.
console.log(obj["under_key"]);
console.log(obj["dash-key"]);
console.log(obj["0"]);
console.log(obj[0]);    // 숫자 프로퍼티 키일 경우에는 숫자로 바로 접근 가능
