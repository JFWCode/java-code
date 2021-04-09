package com.wk.Array;

import java.util.Arrays;

public class SelectionSort implements IArraySort {

    @Override
    public int[] sort(int[] srcArray) {
        int[] arr = Arrays.copyOf(srcArray, srcArray.length);

        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    min = j+1;
                }
            }

            if (i != min) {
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
        return arr;
    }
}