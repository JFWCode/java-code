package com.demo;

import java.util.Arrays;
import java.util.Vector;

public class InitDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        InitDemo d = new InitDemo();
        d.show(d);
    }

    public <T> void show(T arr) {
        System.out.println(arr.toString());
    }

    @Override
    public String toString() {
        return "Test";
    }
}
