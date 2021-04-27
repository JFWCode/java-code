package com.demo.enums;

import java.util.Arrays;

public enum DayOfWeek {
    MONDAY(1, "Sad"),
    TUESDAY(2, "Sad"),
    WEDNESDAY(3, "Sad"),
    THURSDAY(4, "Sad"),
    FRIDAY(5, "Sad"),
    SATURDAY(6, "Happy"),
    SUNDAY(7, "appy");

    private final int val;
    private final String mood;

    private DayOfWeek(int val, String mood) {
        this.val = val;
        this.mood = mood;
    }

    public int getVal() {
        return val;
    }

    public String getMood() {
        return mood;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DayOfWeek.values()));
        System.out.println("Value: " + DayOfWeek.MONDAY.getVal());
        System.out.println("Mood: " + DayOfWeek.MONDAY.getMood());
    }
}
