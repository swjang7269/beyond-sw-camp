package com.ohgiraffers.chap01.section01.timecomplexity;

import java.util.Arrays;

/* 수업목표. 시간 복잡도를 이해할 수 있다. */
/* 설명. 알고리즘 실행 시 입력 값이 증가함에 따라 연산이 걸리는 시간의 증가도를 나타낸다. */
public class Application {
    public static void main(String[] args) {

        int[] arr = new int[]{3, 1, 2, 16, 4, 7, 9, 10};

//        System.out.println(getFirst(arr));
//        System.out.println(binarySearch(arr, 9));
//        System.out.println(Arrays.toString(reverse(arr)));
        System.out.println(fibonacci(10));
    }

    /* 설명. 상수 시간 O(1) */
    /* 설명. 입력값의 크기와 상관없이 항상 일정한 시간이 걸리는 알고리즘. */
    // input의 갯수가 증가하더라도 소요 시간이 동일하다. (실제 소요 시간을 말하는 것이 아니다.)
    private static int getFirst(int[] arr){
        return arr[0];
    }

    /* 설명. 로그 시간 O(log n) */
    /* 설명.
     *  입력값이 증가함에 따라 처리 시간이 로그만큼 증가하는 알고리즘.
     *   ex. 이진 탐색은 매 단계마다 탐색 범위를 절반으로 줄이므로 매우 효율적이며 O(log n)에 해당한다. (단, 정렬이 선행 되어야 한다.)
     */
    private static int binarySearch(int[] arr, int target) {
        /* 설명. 초기 세팅(배열을 오름차순 정렬하고 시작) */
        Arrays.sort(arr);       // 내부적으로 보통 퀵 정렬(nlog n) or 병합 정렬(log n)

        /* 설명. 배열의 처음과 끝을 지칭하는 위치(인덱스)를 담은 변수 두 개(두 개의 포인터) */
//        int left = 0;
//        int right = arr.length - 1;
        int left = 0, right = arr.length - 1;

        // target을 찾을 때까지 중간값을 target과 비교하여 이상(이하)값을 제외하고 다시 중간값을 구하며 비교를 반복한다.
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }

        // target이 배열 내에 없는 경우
        return -1;
    }

    /* 설명. 선형 시간 O(n) */
    /* 설명.
     *  입력값이 증가함에 따라 처리 시간이 선형적으로 증가하는 알고리즘.
     *   ex. 배열의 모든 요소를 한 번씩 순회해야 하므로 배열의 크기에 비례하는 시간이 필요
     */
    private static int[] reverse(int[] arr) {
        int[] rArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rArr[i] = arr[arr.length - 1 - i];
        }
        return rArr;
    }

    /* 설명. 지수 시간 O(2^n) */
    /* 설명.
     *  입력값이 증가함에 따라 시간이 기하급수적으로 증가하는 알고리즘.
     *   ex. 피보나치 수열: 재귀적으로 두 번씩 자신을 호출하므로 매우 비효율적인 시간 복잡도를 가진다.
     */
    private static int fibonacci(int n){
        if(n<=1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
