package com.demo;

import java.util.Arrays;
import java.util.LinkedList;

public class MatrixDemo {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int[][] matrix = {{1}, {2}, {3}};
        //int[][] matrix = {{1}};
        int[] arr = spiralMatrixMethod1(matrix);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] spiralMatrixMethod1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int[] arr = new int[matrix.length * matrix[0].length];

        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;

        int arrIndex = 0;
        while (left < right && top < bottom) {
            for (int col = left; col < right; col++) {
                arr[arrIndex++] = matrix[top][col];
            }
            top++;
            for (int row = top; row < bottom; row++) {
                arr[arrIndex++] = matrix[row][right-1];
            }
            right--;

            if (top < bottom && left < right) {
                for (int col = right - 1; col >= left; col--) {
                    arr[arrIndex++] = matrix[bottom-1][col];
                }
                bottom--;
                for (int row = bottom - 1; row >= top; row--) {
                    arr[arrIndex++] = matrix[row][left];
                }
                left++;
            }
        }

        return arr;
    }

    public static int[] spiralMatrixMethod2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int[] arr = new int[matrix.length * matrix[0].length];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        int arrIndex = 0;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                arr[arrIndex++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                arr[arrIndex++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    arr[arrIndex++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    arr[arrIndex++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return arr;
    }
}
