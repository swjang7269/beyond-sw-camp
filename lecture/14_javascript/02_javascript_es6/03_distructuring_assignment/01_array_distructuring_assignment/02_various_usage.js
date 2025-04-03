// 다양한 사용법
let user = {};
[user.firstName, user.lastName] = 'Flame Lord'.split(' ');

console.log(user);

// rest 문법
let [first, second, ...rest] = ['비천', '범황', '대라', '일천', '아네모스', '데이브레이커', '트와일라잇', '프로피티스'];

console.log('first',first)
console.log('second',second);
console.log('rest',rest);   // 나머지 요소들은 배열로 받아낼 수 있다.

// 배열 구조 분해 할당을 활용한 변수 교환
let student = '디아';
let teacher = '범황';

console.log('student', student);
console.log('teacher', teacher);

[student, teacher] = [teacher, student];
console.log('-------- swap ---------');
console.log('student', student);
console.log('teacher', teacher);

// default 설정 가능
// 기본 값을 설정하고 사용할 수도 있다.
let [firstName2 = '비천', lastName2 = '한'] = ['아라'];
console.log('firstName2',firstName2);
console.log('lastName2',lastName2);