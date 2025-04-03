const str = new String("홍길동");
str[0] = '김';      // String은 배열 같지만 배열이 아니다.(수정 불가)
console.log(str);
console.log(str[0]);
console.log(str[1]);
console.log(str[2]);
console.log(str.length);