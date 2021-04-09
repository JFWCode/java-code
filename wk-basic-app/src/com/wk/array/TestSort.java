package com.wk.array;

import java.util.Arrays;
import java.util.Random;

public class TestSort {
    private  TestSort() {
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        var length = 10000;
        check(length);
    }

    public static boolean check(int length) {
        int[] srcArr = generateRandomArray(length);
        int[] sortedArr = Arrays.copyOf(srcArr, srcArr.length);
        boolean same = true;
        Arrays.sort(sortedArr);

        //var myArray = new BubbleSort();
        //var myArray = new SelectionSort();
        var myArr = new ShellSort();
        srcArr = myArr.sort(srcArr);

        for (int i = 0; i < length; i++) {
            if (srcArr[i] != sortedArr[i]) same = false;
        }

        System.out.println(same);
        return false;
    }

    public static int[] generateRandomArray(int length) {
        int[] arr = new int[length];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(length);
        }
        return arr;
    }
}