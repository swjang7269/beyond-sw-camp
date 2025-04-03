let target = "Java JavaScript";

console.log(target.match(/VA/));
console.log(target.match(/VA/i));
console.log(target.match(/VA/ig));

target = 'abcdefg';
console.log(target.match(/../g));

// {m,n} 최소 m번, 최대 n번 반복하는 문자열(반복 검색)
target = 'a aa aaa b bb bbb bbbb ab aab abb';
console.log(target.match(/a{2,3}/g));   // {}안에서 띄어쓰기 X
console.log(target.match(/a{2}/g));     // aa
console.log(target.match(/b{3,}/g));    // b 3개 이상   bbb, bbbb

// +: 앞선 패턴이 최소 한 번 이상 반복되는 문자열
console.log(target.match(/b+/g));       // b 1개 이상   b, bb, bbb, bbbb
console.log(target.match(/b{1,}/g));    // b가 최소 1개

// ?: 앞선 패턴이 없거나 하나 있는 문자열
target = 'soul seoul seeoul';
console.log(target.match(/se?oul/g));   // ? 앞 문자가 있거나 없거나    soul, seoul

// |: or, []: or(주로 문자 한글자)
target = 'aa bb cc dd 123 456 abc def_@';
console.log(target.match(/a|b|c|d/g));  // a 또는 b 찾기
console.log(target.match(/[abcd]/g));    
console.log(target.match(/a+|b+/g));    // 반복되는 단어 단위

// 하이픈(-)은 아스키코드 또는 유니코드의 범위(대괄호에서 사용)
console.log(target.match(/[a-zA-Z]/g));    // a부터 z까지
console.log('--------------------------------')

// \d: 숫자
console.log(target.match(/[0-9a-z]+/g));
console.log(target.match(/\d+/g));  // [0-9]

// \w: 알파벳, 숫자, 언더스코어
// \W: \w의 반대
target = 'aa bb cc dd 123 456';
console.log(target.match(/w+/g));
console.log(target.match(/W+/g));

// ^: 시작 위치([]안에서는 not의 의미), $: 마지막 위치
target = `https://www.google.com/http`;
console.log(target.match(/^https/g));   // https로 시작
console.log(target.match(/http$/g));    // http로 끝

// (): 그룹 묶음(한 번에 고려될 묶음)
target = 'test tesk tesa';
console.log(target.match(/test|tesk|tesa/g));
console.log(target.match(/tes(t|k|a)/g));

target = 'RegExr was created by gskinner.com.'
console.log(target.match(/[a-zA-Z.]+/g));