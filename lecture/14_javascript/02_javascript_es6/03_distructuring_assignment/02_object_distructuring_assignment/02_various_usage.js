// 다양한 사용법
let shirts = {
    productName: '셔츠',

}

// 기본값 설정 가능
let {productName, color = "검정", price = 0} = shirts;
console.log(productName, color, price);


