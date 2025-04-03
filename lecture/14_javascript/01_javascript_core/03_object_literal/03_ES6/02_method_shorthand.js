// 메소드 단축

var devi = {
    name: "범황",
    skill: function(skillName) {
        console.log(`${skillName} 사용`);
    }
}

devi.skill("무저갱");

var apsara = {
    name: "비천",
    skill(skillName) {      // 콜론을 없애고 마치 기명함수처럼 작성할 수 있다.
        console.log(`${skillName}} 사용`);
    }
}

apsara.skill("여명");