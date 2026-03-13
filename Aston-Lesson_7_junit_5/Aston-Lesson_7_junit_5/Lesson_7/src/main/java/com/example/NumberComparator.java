package com.example;

public class NumberComparator {

    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    public static boolean isEqual(int a, int b) {
        return a == b;
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }
}