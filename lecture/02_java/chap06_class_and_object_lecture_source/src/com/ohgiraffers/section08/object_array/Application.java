package com.ohgiraffers.section08.object_array;

public class Application {
    public static void main(String[] args) {
        // 배열을 사용하지 않는 경우 각각의 객체를 생성하고
        // 각각 함수를 호출해야하는 불편함이 있다.

        // 값이 아닌 각 객체의 주소를 저장하는 배열이다.
        Car[] carArr = new Car[5];
        carArr[0] = new Car("페라리", 300);
        carArr[1] = new Car("메르세데스", 290);
        carArr[2] = new Car("레드불", 295);
        carArr[3] = new Car("맥라렌", 310);
        carArr[4] = new Car("자우버", 240);

        for (int i = 0; i < carArr.length; i++) {
            carArr[i].driveMaxSpeed();
        }

        for(Car i : carArr){
            i.driveMaxSpeed();
        }
    }
}
