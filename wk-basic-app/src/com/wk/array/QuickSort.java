package com.wk.array;


public class QuickSort {

    public int[] quickSort(int[] arr) {
        int len;
        if (arr == null || (len = arr.length) == 0 ||
            len == 1) {
            return arr;
        }

        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public void sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int base = arr[left];

        while (i != j) {
            while (arr[j] >= base && i < j) {
                j--;
            }

            while (arr[i] <= base && i < j) {
                i++;
            }

            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        arr[left] = arr[i];
        arr[i] = base;

        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }
}
