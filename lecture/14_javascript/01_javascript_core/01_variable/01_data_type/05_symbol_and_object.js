var sym1 = Symbol();
var sym2 = Symbol();
console.log(sym1 == sym2);  // false

var sym3 = Symbol("설명");
var sym4 = Symbol("설명");
console.log(sym3 == sym4);  // false
console.log(sym3.description);
console.log(sym4.description);

var obj = {};              // 리터럴 객체{}를 생성해서 추후에 동적으로 프로퍼티(속성)을 추가 및 제거할 수 있다.
obj["일반속성"] = "일반";   // 대괄호([])는 객체의 속성에 접근 또는 없으면 추가하는 개념
obj[sym3] = "값1";
obj[sym4] = "값2";

console.log(obj);
console.log(typeof obj);
console.log(obj[sym3]);
console.log(obj[sym4]);

// 숨겨진 프로퍼티
var hidden = Symbol("숨겨진 프로퍼티");
obj[hidden] = "비밀 값";
obj["name"] = "아라 한";
console.log(obj);
console.log(obj[hidden]);
// Object.keys의 매개변수에 던져진 객체의 프로퍼티를 추출해서 보여주는 함수
console.log(Object.keys(obj));  // Symbol타입은 숨겨져서 보이지 않는다.

// Symbol 사용 목적
// 1. 같은 이름의 값. 즉, 객체의 고유한 키를 만들고 싶을 때
// 2. 열거되지 않는 속성 값을 만들 때(숨길 때)
