package com.wk.Array;

import java.util.Arrays;

public class InsertSort implements IArraySort {

    @Override
    public int[] sort(int[] srcArray) {
        int[] arr = Arrays.copyOf(srcArray, srcArray.length);

        int j, tmp;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) { // 和前一个相比，避免超出数组范围
                tmp = arr[i];

                for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                    arr[j+1] = arr[j];
                }

                arr[j+1] = tmp;
            }
        }
        return arr;
    }
}