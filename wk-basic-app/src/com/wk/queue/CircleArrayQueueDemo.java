package com.wk.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        CircleArrayQueue queue = new CircleArrayQueue(4); // 设置最大值为4，但是有效数据最大值为3
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");
    }

}

class CircleArrayQueue {
    private int maxSize;
    // rear, front初始值为0，才能满足 (rear + 1) % maxSize == front
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int size) {
        maxSize = size;
        arr = new int[maxSize];
        front = rear = 0;
    }

    public boolean isFull() {
        return ((rear + 1) % maxSize == front);
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, can't get value!");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void addQueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full, can't add value");
            return;
        }

        arr[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, no value!");
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // get valid size
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, no value!");
        }

        return arr[front+1];
    }
}
