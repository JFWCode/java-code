package com.wk.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 7, 8, 12, 12, 12, 12};
        int[] arr1 = {5,7,7,8,8,10};
        int findVal = 8;
        int left = 0;
        int right = arr.length - 1;

        int index = binarySearch(arr, findVal, left, right);
        System.out.println("Index is " + index);

        List<Integer> indexList = binarySearch3(arr1, findVal, left, right);
        System.out.println("Indexes are " + indexList);
    }

    public static int binarySearch(int[] arr, int findVal, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (arr[mid] == findVal) {
            return mid;
        } else {
            if (findVal < arr[mid]) {
                return binarySearch(arr, findVal, left, mid - 1);
            } else {
                return binarySearch(arr, findVal, mid + 1, right);
            }
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int findVal, int left, int right) {
        if (left > right) {
            return new LinkedList<>();
        }

        int mid = (left + right) / 2;
        if (arr[mid] == findVal) {
            List<Integer> indexList = new LinkedList<>();

            // 寻找所有等于findVal的index
            // 向左扫描
            int index = mid - 1;
            while (index >= 0 && arr[index] == findVal) {
                indexList.add(index);
                index--;
            }
            
            indexList.add(mid);

            // 向右扫描
            index = mid + 1;
            while (index < arr.length && arr[index] == findVal) {
                indexList.add(index);
                index++;
            }
            return indexList;
        } else {
            if (findVal < arr[mid]) {
                return binarySearch2(arr, findVal, left, mid - 1);
            } else {
                return binarySearch2(arr, findVal, mid + 1, right);
            }
        }
    }

    public static List<Integer> binarySearch3(int[] arr, int target, int left, int right) {
        if (left > right) {
            System.out.println("??");
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            List<Integer> list = new ArrayList<>();

            int tmp = mid - 1;
            while (tmp >= 0 && arr[tmp] == target) {
                list.add(tmp);
                tmp--;
            }

            list.add(mid);

            tmp = mid + 1;
            while (tmp < arr.length && arr[tmp] == target) {
                list.add(tmp);
                tmp++;
            }
            return list;
        } else {
            if (arr[mid] < target) {
                return binarySearch3(arr, target, left, mid - 1);
            } else {
                return binarySearch3(arr, target, mid + 1, right);
            }
        }
    }
}
