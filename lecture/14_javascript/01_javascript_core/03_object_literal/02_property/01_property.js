var obj  = {
    normal: "normal value",
    "@ s p a c e @": "space value", // 특수기호는(_, $)를 제외하고는 지양
    "": "",                         // 가능하지만 지양
    0: 1,                           // 숫자형 프로퍼티명은 내부적으로 문자열로  ㅕㄴ환
    var: "var",                     // 예약어 사용 지양
    normal: "new value"             // 프로퍼티 명이 중복되면 나중에 작성된 것만 적용
};