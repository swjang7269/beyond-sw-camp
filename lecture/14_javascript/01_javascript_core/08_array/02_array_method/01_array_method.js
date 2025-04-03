const foodList = ['물회', '삼계탕', '냉면', '수박', '물회'];
console.log(`foodList.indexOf('물회'): ${foodList.indexOf('물회')}`);       // 중복되면 좌측 우선
console.log(`foodList.indexOf('삼겹살'): ${foodList.indexOf('삼겹살')}`);   // 없으면 -1

console.log(`foodList.indexOf('물회'): ${foodList.includes('물회')}`);      // includes: 존재 여부
console.log(`foodList.indexOf('삼겹살'): ${foodList.includes('삼겹살')}`);  // 없으면 false

const chinesefood = ['짜장면', '짬뽕', '탕수육'];
chinesefood.push("팔보채");
chinesefood.push("양장피");
console.log(`push 후: ${chinesefood}`);

// Last In First Out 구조
console.log(`chinesefood.pop(): ${chinesefood.pop()}`);
console.log(`chinesefood.pop(): ${chinesefood.pop()}`);
console.log(`pop 후: ${chinesefood}`);

const chickenList = ['양념', '후라이드', '간장'];
// unshift(): 배열의 앞에 추가(추가 후 배열 길이 반환)
console.log(`chickenList.unshift(): ${chickenList.unshift('마늘')}`);
console.log(`chickenList.unshift(): ${chickenList.unshift('파닭')}`);
console.log(`unshift 후: ${chickenList}`);

// shift(): 배열의 앞 삭제
console.log(`chickenList.shift(): ${chickenList.shift()}`);
console.log(`shift 후: ${chickenList}`);

// concat
const idol1 = ['서태지와아이들', '소녀시대'];
const idol2 = ['원더걸스', '카라'];
const idol3 = ['오마이걸', '프로미스나인'];

console.log(`idol1을 기준으로 idol2 배열을 concat: ${idol1.concat(idol2)}`);

// ES6에서는 스프레드 연산자를 활용해서 concat의 개념을 할 수도 있다.(이후에 배울 내용)
console.log(`idol1을 기준으로 idol2 배열을 concat(spread): ${[...idol1, ...idol2]}`);
console.log(...idol1);

console.log(`idol1을 기준으로 idol2, idol3 배열을 concat: ${idol1.concat(idol2, idol3)}`);
console.log(`idol1을 기준으로 idol2, idol3 배열을 concat(spread): ${[...idol1, ...idol2, ...idol3]}`);

// slice(선택한 요소 복사) / splice(선택한 위치 요소 제거 및 추가)
const front = ['HTML', 'CSS', 'JavaScript', 'Vue'];

console.log(`front.slice(): ${front.slice(1, 3)}`); // 1 <= x < 3 인덱스 복사
console.log(`front: ${front}`); // 원본에 영향 X

console.log(`front.splice(): ${front.splice(1, 2, 'JDBC', 'ㅇㅅㅇ')}`); // 2번 인덱스 부터 이후 2개 제거 후 그 위치에 추가
console.log(`front: ${front}`); // 원본에 영향

// join: 배열에 담긴 값들을 우리가 원하는 구분자를 포함한 문자열로 변환
const gundamList = ['엑시아', '듀나메스', '큐리오스', '버체'];
console.log(`gundamList.join(): ${gundamList.join()}`);
console.log(`gundamList.join(): ${gundamList.join(' / ')}`);
