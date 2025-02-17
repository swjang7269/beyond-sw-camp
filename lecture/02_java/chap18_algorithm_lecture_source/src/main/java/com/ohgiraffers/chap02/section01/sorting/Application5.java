package com.ohgiraffers.chap02.section01.sorting;

/* 수업목표. 병합 정렬을 이해할 수 있다. */

import java.util.Arrays;

public class Application5 {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 13, 2, 69, 43, 33, 22};
        mergeSort(0, 6, arr);
        System.out.println(Arrays.toString(arr));
    }
    /* 설명. 사본을 가지고 원본을 수정하는 방식 */
    public static void mergeSort(int low, int high, int[] arr){
        int[] temp;
        if(high - low == 0) return;     // 한 칸이면 return     한 칸이 될때까지 쪼개기(divide)

        int mid = (high + low) / 2;
        mergeSort(low, mid, arr);             // pivot 왼쪽 절반
        mergeSort(mid + 1, high, arr);    // pivot 오른쪽 절반

        /* 설명. 하나의 엘리먼트 단위로 다 분할하고 나서 이제 값을 정복(정렬해서 합한다.)한다. */
        temp = arr.clone();

        /* 설명. 분할 정복 방식으로 작은 값부터 값을 쌓음 */
        int k = low;
        int index1 = low;
        int index2 = mid + 1;

        // 분할된 두 개의 배열을 기준으로 맨 앞값들을 비교하며 작은 값부터 넣기(오름차순)
        /* 설명. index1 또는 index2가 진행할 수 있는 만큼 진행하며 arr[k]번째에 값을 옮겨 담기 */
        while(index1 <= mid && index2 <= high) {
            if(temp[index1] < temp[index2]) {
                arr[k++] = temp[index1++];
            } else {
                arr[k++] = temp[index2++];
            }
        }

        // 한 쪽 배열을 모두 다 넣었으면 나머지 배열은 뒤에 이어 붙인다.
        /* 설명. 좌측 인덱스가 남았을 때 마저 옮기기 */
        while(index1 <= mid){
            arr[k++] = temp[index1++];
        }
        /* 설명. 우측 인덱스가 남았을 때 마저 옮기기 */
        while(index2 <= high){
            arr[k++] = temp[index2++];
        }
    }
}
