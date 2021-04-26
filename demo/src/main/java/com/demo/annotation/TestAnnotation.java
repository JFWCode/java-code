package com.demo.annotation;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestAnnotation {
    public static final Logger logger =  LoggerFactory.getLogger(TestAnnotation.class);

    @MyAnnotation
    private String a;

    @MyAnnotation("b")
    private String b;

    @MyAnnotation("test")
    public void print(String value) {
        logger.info(value);
    }

    @MyAnnotation(init = "init1", destroy = "destroy2")
    public TestAnnotation() {
        logger.info("constructor");
    }

    public static void init1(){
        logger.info("init");
    }

    public static void init1(String... args){  // variable parameters
        logger.info("init with args");
        logger.info(args.getClass().getName());
    }

    public static void destroy2(){
        logger.info("destroy");
    }

    @Test
    public void test() {
        Class clz = null;
        try {
            clz = Class.forName("com.demo.annotation.TestAnnotation");
            Method method = clz.getMethod("print", String.class);
            MyAnnotation annotation =  method.getAnnotation(MyAnnotation.class);
            Constructor constructor = clz.getConstructor();
            logger.info(annotation.value());
            logger.info(annotation.init());
            logger.info(annotation.destroy());
            Object object = constructor.newInstance();
            method.invoke(object, "wtf");

            new TestAnnotation().init1("multiple");

            Annotation a = constructor.getAnnotation(MyAnnotation.class);
            if (annotation instanceof MyAnnotation) {
                MyAnnotation ac = (MyAnnotation) a;

                clz.getMethod(ac.init()).invoke(object);
                clz.getMethod(ac.init(), String[].class).invoke(object, (Object) new String[", "B"}); // convert to Object
                clz.getMethod(ac.init(), String[].class).invoke(object, new Object[]{new String[]{"A", "B"}}); // best way
                clz.getMethod(ac.destroy()).invoke(object);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
