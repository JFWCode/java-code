package com.demo.annotation;

import org.junit.Test;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "Uk";
    String init() default "";

    String destroy() default "";
}
