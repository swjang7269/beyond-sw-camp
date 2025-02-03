package com.ohgiraffers.section04.scanner;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. java.util.Scanner를 이용해 다양한 자료형의 값 입력 받기 */
        Scanner sc = new Scanner(System.in);

        /* 설명. 0. next()를 활용한 문자열 입력 next()는 띄어쓰기와 엔터키 인식하지 못함 -> 버퍼에 남음 */
        System.out.print("소속을 입력하세요: ");
        String classname = sc.next();   // 띄어쓰기 인식 x 띄어쓰기 이후 내용은 버퍼에 남음  cin 같은 느낌 (한 단어씩 받아들임)
        System.out.println("classname = " + classname);

        sc.nextLine(); // 버퍼에 남은 엔터 제거용

        /* 설명. 1. nextLine()을 활용한 콘솔에서의 문자열 입력 */
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();    // enter키를 인식 (줄 단위로 인식) 버퍼에 남아있는 enter를 인식하고 입력한 것처럼 받아들임
        System.out.println("name = " + name);

        /* 설명. 2. nextInt()를 활용한 정수 입력 */
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("age = " + age);

        /* 설명. 3. nextDouble()을 활용한 실수 입력 */
        System.out.print("키를 입력하세요: ");
        double height = sc.nextDouble();
        System.out.println("height = " + height);
    }
}
