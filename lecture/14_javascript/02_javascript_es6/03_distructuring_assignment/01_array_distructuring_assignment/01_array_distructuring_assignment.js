 // 배열 구조 분해 할당
let nameArr = ['아라', '한', '비천', '!', '여명'];
// let firstName = nameArr[0];
// let lastName = nameArr[1];

// 배열의 경우 필요없는 요소의 경우 빈 칸으로 두면 된다.
// 불필요한 요소를 제외한 필요한 값들만 변수에 담을 수도 있다.
let [firstName, lastName, classLine, , mainSkill] = nameArr; // 배열 구조 분해 할당(해당 인덱스 위치의 변수에 대입)

console.log('firstName:',firstName);
console.log('lastName:',lastName);
console.log('classLine:',classLine);
console.log('주력기:', mainSkill);

let name2 = "Bloody Quene";
let [firstName2, lastName2] = name2.split(" ");
console.log('firstName2:',firstName2);
console.log('lastName2:', lastName2);

let name3 = "Empire Sword"
let [firstName3, lastName3] = name3.match(/[a-z]+/gi);
console.log('firstName3:',firstName3);
console.log('lastName3:', lastName3);