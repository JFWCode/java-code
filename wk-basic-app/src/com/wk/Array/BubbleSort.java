package com.wk.Array;

import java.util.Arrays;

public class BubbleSort implements IArraySort {

    @Override
    public int[] sort(int[] srcArray) {
        int[] arr = Arrays.copyOf(srcArray, srcArray.length);

        for (int i = 1; i < arr.length; i++) {
            Boolean sortedFlag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;

                    sortedFlag = false;
                }
            }

            // flag为true，代表数组本来就是有序的，直接退出循环，时间复杂度为O(1)
            if (sortedFlag) {
                break;
            }
        }
        return arr;
    }
}
