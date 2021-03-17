package com.wk.Array;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] srcArray = new int[]{4, 35, 2, 8, 32, 1, 3};
        //var myArray = new BubbleSort();
        //var myArray = new SelectionSort();
        var myArray = new InsertSort();
        int[] result = myArray.sort(srcArray);
        System.out.println(Arrays.toString(result));
    }
}