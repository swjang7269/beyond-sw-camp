// var 키워드로 선언한 변수는 암묵적으로 undefined로 초기화 되어 있다.
// 변수를 선언한 이후 값을 할당하지 않은 변수는 undefined인데 개발자가 의도적으로 변수에 할당하는 것은
// 본래 취지와 어긋나고 혼란을 줄 수 있으므로 지양한다.(대신 null 대입)

// 값이 대입된 적이 없다.
var undef;
console.log(typeof undef);
console.log(undef);

// 의도적으로 값을 비울때는 null 대입
// null: 변수에 값이 없음을 의도적으로 명시해 주어야 할 때 사용된다.
var nullVal = "something";
// nullVal = undefined -> 사용 지양
nullVal = null;
console.log(nullVal);