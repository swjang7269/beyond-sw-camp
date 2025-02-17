package com.ohgiraffers.chap02.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeSortTest {

    private static int low1 = 0, low2 = 0;
    private static int high1, high2;
    private static int[] act1, act2;
    private static int[] exp1, exp2;

    @BeforeAll
    public static void set() {

        /* 예시1 */
        high1 = 5;      // size는 8
        act1 = new int[]{30, 7, 35, 40, 34, 18};
        exp1 = new int[]{7, 18, 30, 34, 35, 40};

        /* 예시2 */
        high2 = 9;      // size는 9
        act2 = new int[]{22, 19, 33, 7, 8, 39, 32, 11, 26, 20};
        exp2 = new int[]{7, 8, 11, 19, 20, 22, 26, 32, 33, 39};
    }

    public static Stream<Arguments> provideDescendingSource() {
        return Stream.of(
                arguments(low1, high1, act1, exp1),
                arguments(low2, high2, act2, exp2)
        );
    }

    @DisplayName("병합 정렬 테스트")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideDescendingSource")
    public void mergeSortTest(int low, int high, int[] actual, int[] expected) {
        Application5.mergeSort(low, high, actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}