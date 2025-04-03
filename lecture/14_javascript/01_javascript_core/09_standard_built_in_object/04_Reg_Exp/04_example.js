const url = 'https://www.google.com';
const url2 = 'http://www.google.com';

console.log(/^https?:\/\//.test(url));
console.log(/^https?:\/\//.test(url2));

const fileName = 'js_test.js';
const fileName2 = 'js_test.com';

console.log(/js$/.test(fileName));      
console.log(/js$/.test(fileName2));     

const target = '12345';
const target2 = '@12345@';
console.log(/^\d+$/.test(target));       
console.log(/^\d+$/.test(target2));       

const id = 'hello123';
const id2 = '가hello123';
const id3 = 'hello12345657890';
console.log(/^[A-Za-z0-9]{6,12}$/.test(id));        
console.log(/^[A-Za-z0-9]{6,12}$/.test(id2));       
console.log(/^[A-Za-z0-9]{6,12}$/.test(id3));       

const phone = '010-1234-5678';
const phone2 = '02-1234-5678';
console.log(/^[0-9]{3}-\d{3,4}-\d{4}$/.test(phone));    
console.log(/^[0-9]{3}-\d{3,4}-\d{4}$/.test(phone2));   

const exceptT = 'hello#world';
console.log(/[^A-Za-z0-9]+/.test(exceptT));             

let target3 = 'https://www.google.com';

// match의 결과가 배열인데 그 배열에 그룹이 담기지 않도록 할꺼면 ?:을 쓴다.
let regex1 = /(https:)?([\/a-z\.]+)/;     
let regex2 = /(?:https:)?([\/a-z\.]+)/;     

console.log('배열의 요소로 뽑고 싶지 않을 때: ', target3.match(regex1));
console.log(target3.match(regex2));

let name = '홍길동전';
console.log(/^[가-힣]{2,4}$/.test(name));

let boundary = 'abc aba abd';
console.log(boundary.match(/\ba/g));    // 단어의 시작이 a라면 a추출
console.log(boundary.match(/a\b/g));   // 단어의 끝이 a라면 a추출

let space = 'abc def ghi';
console.log(space.match(/\s/g));        // 공백만
console.log(space.match(/\S/g));        // 공백이 아닌 것만