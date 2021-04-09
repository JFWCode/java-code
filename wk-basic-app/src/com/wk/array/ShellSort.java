package com.wk.array;

import java.util.Arrays;

public class ShellSort implements IArraySort {
    public static void main(String[] args) {
        int[] srcArray = {4, 35, 2, 8, 32, 1, 3, 11, 42, 2, 54, 0};
        var array = new ShellSort();
        int[] result = array.sort(srcArray);
        System.out.println(Arrays.toString(result));
    }

    @Override
    public int[] sort(int[] srcArray) {
        int[] arr = Arrays.copyOf(srcArray, srcArray.length);
        int n = arr.length;
        int j, tmp;

        for (int k = n/2; k > 0; k /= 2) {

            for (int i = k; i < n; i += k) {
                if (arr[i] < arr[i-k]) {
                    tmp = arr[i];

                    for (j = i - k; j >= 0 && arr[j] > tmp; j -= k) {
                        arr[j+k] = arr[j];
                    }

                    arr[j+k] = tmp;
                }
            }
        }
        return arr;
    }
}
