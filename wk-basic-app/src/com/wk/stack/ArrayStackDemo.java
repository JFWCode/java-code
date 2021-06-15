package com.wk.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key;
        
        while(loop) {
            System.out.println("s(show): 显示栈");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到栈");
            System.out.println("g(get): 从栈取出数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    stack.list();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = stack.pop();
                        System.out.printf("取出的数据是%d\n", res);
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
    }
}
