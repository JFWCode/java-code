package com.demo.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class Calendar {
    @Test
    public void Test() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getDayOfYear());
        System.out.println(now.getDayOfMonth());
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek);

    }
}


