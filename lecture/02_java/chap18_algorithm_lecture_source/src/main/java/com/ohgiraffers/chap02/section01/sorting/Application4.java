package com.ohgiraffers.chap02.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 수업목표. 퀵 정렬을 이해할 수 있다. */
/* 설명.
 *  퀵 정렬(Quick Sort)
 *   기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해서 정렬하는 것으로
 *   병합 정렬 알고리즘과 함꼐 실제 정렬 알고리즘으로 많이 활용되고 있다.
 *   시간 복잡도는 O(nlog n)이다.
 */
public class Application4 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();

            // 두 포인터와 배열을 인자로 넘김
            quickSort(0,arr.length -1, arr);

            for(int i : arr){
                System.out.print(i + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void quickSort(int low, int high, int[] arr) {
        if(low >= high) return;  // 재귀 함수의 반환 조건(배열의 크기가 1칸이거나, low가 high보다 커진다면)

        /* 설명. process 하나가 끝나고 high 위치가 반환되면 그 위치를 자르기 위한 기준으로 보고 2분할 한다. */
        int pivot = process(low, high, arr);     // 두 블럭으로 나누기 위한 기준 -> (low > high)가 되었을 때의 high 위치
        quickSort(low, pivot, arr);      // pivot을 기준으로 왼쪽을 대상으로 반복
        quickSort(pivot + 1, high, arr);     // pivot을 기준으로 오른쪽을 대상으로 반복
    }

    private static int process(int left, int right, int[] arr) {
        int low = left - 1;
        int high = right + 1;
        int pivot = arr[(left + right) / 2];    // 중앙 값을 pivot으로 설정 (해당 값은 사용자가 설정하는 대로)

        while(true){
            /* 설명. pivot 위치에 있는 값보다 크거나 같은 값을 찾을 때까지 증가 */
            do{
                low++;
            } while (arr[low] < pivot);     // pivot값보다 크거나 같은 값을 탐색

            /* 설명. pivot 위치에 있는 값보다 작거나 같은 값을 찾을 때까지 감소 */
            do {
                high--;
            } while (arr[high] > pivot);    // pivot값보다 작거나 같은 값을 탐색

            if(low >= high) return high;    // 분할점을 찾았다면 반환(pivot값을 기준으로 왼쪽 그룹은 더 작은값, 오른쪽 그룹은 더 큰 값으로 분류된 상태, pivot은 왼쪽 그룹일지, 오른쪽 그룹일지 확정 안됨 -> 각 그룹 내에서는 정렬 안된 상태)

            swap(arr, low, high);           // 아직 low < high라면(분할 점을 찾지 못했다면) 두 값을 교환하고 반복
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
