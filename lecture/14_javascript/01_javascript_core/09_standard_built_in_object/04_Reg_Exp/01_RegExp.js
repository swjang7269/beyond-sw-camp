// 정규 표현식
let regex = /j/i;   // 패턴: j, 플래그 옵션: i -> 대소문자 구분 없이(case insentive)
regex = new RegExp("j","i");
regex = new RegExp("/j/","i");
regex = new RegExp(/j/i);

let target = "javaScript";
// 유효성 검사(validation check)를 할 수 있다.
console.log(regex.test(target));    // 패턴에 맞는지 유효성 검사(맞으면 true)