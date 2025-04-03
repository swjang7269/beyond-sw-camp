var x = "global x";
var y = "global y";
var z = "global z";

function outer() {
    var z = "outer's local z";

    console.log(x); // global x
    console.log(y); // global y
    console.log(z); // outer z

    function inner() {
        var x = "inner's local x";

        console.log(x); // inner x
        console.log(y); // global y
        console.log(z); // outer z
    }

    inner();
}

outer();
// 작은 범위(내부 스코프)로 부터 탐색 없으면 더 넓은 범위(상위 스코프)로 탐색을 진행

// 스코프 체인
// inner scope -> outer scope -> global scope 순으로 우선순위 결정
// 모든 스코프는 하나의 계층적 구조로 연결되며 자바스크립트 엔진은 스코프 체인을 통해
// 변수를 참조하는 코드의 스코프에서 상위 스코프 방향으로 이동하며 선언한 변수를 참조한다.
// (하위 스코프에서 유효한 변수를 상위 스코프에서는 참조할 수 없다.)

// 렉시컬 스코프(Lexical Scope)(개념)
// "변수가 선언된 위치"를 기준으로 스코프를 결정하는 방식.
// 즉, 함수를 어디서 호출했는지가 아니라, 어디서 선언했는지가 중요함.
// 렉시컬 환경(내부 동작 구조)
// 변수와 함수 선언 정보를 저장하고 관리하는 내부 데이터 구조
// 함수가 실행되면 해당 함수의 렉시컬 환경이 생성되고 관리됨