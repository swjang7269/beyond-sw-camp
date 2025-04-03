let exampleProduct = {
    items: ['Coffee', 'Donut'], 
    producer: '신사임당'
};

// 객체를 단순하게 받아내는 매개변수 사용
function displayProduct(obj) {
    // 1. obj를 항상 명시해야 함
    console.log(obj.producer);
    console.log(obj.items);

    // 2. 인수로 던져진 객체에 필요한 프로퍼티가 없을 경우 undefined
    console.log(obj.brand);
};

displayProduct(exampleProduct);

// 매개변수에서 객체 구조 분해 할당 적용
function displayProduct2(producer = '아무개', items = [], brand = 'GenG') {
    console.log(producer);
    console.log(items);
    console.log(brand);
};

displayProduct2(exampleProduct);