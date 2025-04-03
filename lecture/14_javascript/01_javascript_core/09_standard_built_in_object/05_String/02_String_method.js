
const str = 'JavaScript';
console.log(str.indexOf('a'));
console.log(str.indexOf('b'));
console.log(str.indexOf('a', 2));

if(str.indexOf('a') !== -1) console.log('a가 있다');
console.log('--------------------------------');

console.log(str.includes('a'));
console.log(str.includes('b'));
console.log(str.includes('a', 2));

if(str.includes('a')) console.log('a가 있다');  
console.log('--------------------------------');

console.log(str.search(/a/));
console.log(str.search(/b/));
console.log('--------------------------------');

console.log(str.startsWith('Ja'));
console.log(str.startsWith('va', 2));       // 2번 인덱스부터 시작해서 va로 시작하는가
console.log(str.endsWith('pt'));
console.log(str.endsWith('va', 4));         // 4번 인덱스까지만 볼 때, va로 끝나는가
console.log('--------------------------------');

for(let i = 0; i < str.length; i++)
    console.log(str.charAt(i));
console.log('--------------------------------');

console.log(str.substring(1,4));
console.log(str.substring(1));
console.log(str.substring(4,1));
console.log(str.substring(-1));
console.log(str.substring(1,20));
console.log('--------------------------------');

console.log(str.slice(1,4));
console.log(str.slice(1));
console.log(str.slice(4,1));
console.log(str.slice(-1));
console.log(str.slice(1,20));
console.log('--------------------------------');

console.log(str.toUpperCase());
console.log(str.toLowerCase());
console.log('--------------------------------');

const str2 = '   JavaScript   ';
console.log(str2.trim());
console.log('--------------------------------');

console.log(str2.replace('Java', 'Type'));
console.log(str2.replace('a', 'b'));
console.log(str2.replace(/j/ig,'Z'));
console.log('--------------------------------');

const str3 = 'Hello, Everyone! Nice to see you again.';
console.log(str3.split(' '));
console.log(str3.split(''));
console.log(str3.split());
console.log(str3.split(' ', 5));