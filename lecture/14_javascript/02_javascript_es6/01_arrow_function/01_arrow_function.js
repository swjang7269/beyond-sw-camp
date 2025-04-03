// 1. 콜백함수로 화살표 함수를 사용하게 되면 해당 화살표 함수가 사용하는 곳에 따라 this의 의미가 정해진다.

// 화살표 함수: 렉시컬this(화살표 함수는 자신만의 this를 가지지 않음)
//              상위 스코프에서 상속 받아 화살표 함수가 정의된 시점의 상위 스코프에서의 this를 의미하게 된다.
// 단순 익명 함수: 자체 this의 의미가 바인딩되어 있다.
//                  콜백함수로 쓰일 때는 기본적으로 global(전역 객체) 객체를 의미하게 된다.

// 렉시컬 환경: 변수, 함수 선언을 저장하고 스코프 체인을 연결하는 내부적인 환경
// 두 가지 요소: 환경 레코드(변수 저장) + 외부 렉시컬 환경 참조(상위 스코프 연결)
// 함수가 선언된 위치(렉시컬 환경)에서 상위 스코프가 결정된다.


let theater = {
    store: '강남점',
    titles: ['승부', '브리짓 존스의 일기', '너의 결혼식', '슬램덩크', '하이큐'],

    showMovieList() {
        this.titles.forEach(
            title => console.log(this.store + ": " + title) 
            // 애로우 함수 -> 상위 스코프가 global 객체가 아닌 함수 showMovieList가 생성된 곳 즉, theater를 상위 스코프로 가진다.
        );
    }

    // showMovieList() {
    //     this.titles.forEach(
    //         function(title) {
    //             console.log(this.store + ": " + title); // this.store는 theater 객체의 store를 가리키지 못한다.(forEach 안에서의 함수)
    //         }
    //     );
    // }
};

theater.showMovieList();

// 2. 화살표 함수는 new연산자와 함께 사용할 수 없다.(생성자 함수로 쓰일 수 없다.)
const arrowFuc = () => {};
const normalFunc = function() {

};

// new arrowFuc(); // TypeError: is not a constructor   객체로 만들 수 없다.
new normalFunc();

// 3. 화살표 함수는 argument를 지원하지 않는다. 
//      외부 함수의 arguments가 있다면 외부 함수의 arguments가 적용됨(렉시컬 arguments)
const test = () => console.log(arguments);  // this와 같이 화살표 함수의 argument가 아닌 상위 환경의 argument(전역 객체)의 argument가 나옴
// test(1,2,3,4,5);

// 렉시컬 환경: 함수가 선언된 위치 
// -> arrow function은 별도의 this와 argument등을 만들지 않고 함수가 선언된 위치 즉, 렉시컬 환경을 기준으로 this와 argument 등이 결정
//  본인이 선언된 위치의 this와 argument를 그대로 사용(부모 함수나 부모 스코프의 변수 사용)
const test2 = function() {
    console.log(`normal outer:`, arguments);
    const arrowFunc = () => console.log(`arrow inner:`, arguments);
    arrowFunc();    // 상위 환경의 function의 argument를 가지게 된다.(this와 비슷하게 동작)
}

test2(1, 2, 3, 4, 5);