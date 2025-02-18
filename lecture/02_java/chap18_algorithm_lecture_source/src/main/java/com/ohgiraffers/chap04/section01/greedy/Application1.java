package com.ohgiraffers.chap04.section01.greedy;

public class Application1 {
    public static int solution(int n) {
        /* 설명. 5kg 혹은 3kg 봉투로 정확한 량을 맞출 수 있는 최소 봉투 수 */
        int count = 0;

        while (true) {
            if (n % 5 == 0) { // 남은 설탕을 5kg로 해결 가능한 경우
                return count + n / 5;
            } else {
                n -= 3;
                count++;
                if (n == 0) return count;    // 3kg으로 해결한 경우
                if (n < 0) return -1;
            }
        }
    }
}
