package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_while {
    public void testSimpleWhileStatement() {

    }

    /* 설명. while은 주로 사용자의 입력값에 따라 반복 횟수가 정해지는 경우에 주로 사용 */
    public void testWhileExample() {
        Scanner sc = new Scanner(System.in);
        /* 설명. 'y' 또는 'Y' 입력시 반복 종료 */
        char answer = '\0';
        while(answer != 'y' && answer != 'Y') {
            System.out.print("멈추려면 'y', 'Y' 누르시오.: ");
            answer = sc.next().charAt(0);
        }
    }
}
