// 프로퍼티 값 단축

var id = "p-0001";
var price = 3000;

var product = {
    id: id,         // id: "p-0001"
    price: price
};

console.log("product:", product);

// 변수 명이 곧 프로퍼티 키, 변수값이 프로퍼티 값이 된다.
var product2 = {id, price}; // id, price 프로퍼티를 가진 객체 product2
console.log("product2:", product2);