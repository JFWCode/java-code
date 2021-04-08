package com.demo;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Vector;

public class InitDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
//        InitDemo d = new InitDemo();
        try {
            InitDemo d = (InitDemo) Class.forName("com.demo.InitDemo").getDeclaredConstructor().newInstance();
            d.show(d);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public <T> void show(T arr) {
        System.out.println(arr.toString());
    }

    @Override
    public String toString() {
        return "Test";
    }
}
