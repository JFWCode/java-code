package com.wk.stack;

import java.util.Spliterator;

public class ArrayStack {
    private int top = -1;
    private int maxSize;
    private int[] arr;

    public ArrayStack(int size) {
        maxSize = size;
        arr = new int[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }


    public void list() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }

        top++;
        arr[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        int value = arr[top];
        top--;
        return value;
    }
}
