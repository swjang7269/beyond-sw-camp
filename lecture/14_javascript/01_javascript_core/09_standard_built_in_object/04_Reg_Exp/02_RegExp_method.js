// flag option의 종류
// i(case insensitive): 대소문자 구분하지 않고 패턴 적용
// g(clobal): 대상 문자열 텍스트 내에서 패턴과 일치하는 모든 문자열을 전역 검색
// m(multi Line): ^와 $가 문자열 전체의 시작과 끝이 아닌 각 줄의 시작과 끝을 기준으로 작동되게 하는 옵션
// enter를 기준으로 문자열의 시작과 끝을 구분. 즉, 각 줄마다 패턴을 적용

const target = "Java JavaScript";
const reg = /va/g;

// exec: 정규표현식에서 제공하는 메소드로 인수로 문자열을 주면 패턴을 찾아 배열을 반환
console.log(reg.exec(target));      // 찾으면 index반환
console.log(reg.exec(target));
console.log(/hello/.exec(target));  // 없으면 null

// test: 정규표현식에서 제공하는 메소드로 매칭 결과를 boolean으로 반환
console.log(/va/.test(target)); // true / false

// match: 문자열이 제공하는 메소드로 인수로 정규표현식을 주면 패턴을 찾아 배열을 반환
console.log(target.match(/va/));