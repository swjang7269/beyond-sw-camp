// 객체 구조 분해 할당 기본 문법
let pants = {
    productName: '팬츠',
    color: '검정색',
    price: 30000,
    getInfo() {
        console.log(this.color, this.productName, 'good');
    }
}

// let productName = pants.productName;
// let color = pants.color;

// 배열 구조 분해 할당과 달리 프로퍼티 순서는 중요하지 않지만 프로퍼티 명과 일치하는 변수명을 써 주어야 한다.
let {productName, getInfo, color, price} = pants;    // 이름으로 찾기에 순서는 상관없음
console.log(productName, getInfo,color, price);

//메소드에서의 this와 따로 뽑아낸 독립적인 함수의 this(전역 객체)는 다르다.
pants.getInfo();
getInfo();  // this 때문에 undefined 반환

// : 을 이용해 변수명 리네임 가능
// 프로퍼티에 접근해서 다른 변수에 담는 객체 구조 분해 할당을 원할 시
let{color:co, price:pr, productName:pn} = pants;
console.log(co, pr, pn);