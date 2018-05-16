package com.gr.bk.service;

public class Zhl {
    public static void main(String args[]) {
        int year = 2010;
        if (year != 0 && year % 4 == 0) {
            System.out.println(year + "年是闰年。");
        } else {
            System.out.println(year + "年不是闰年。");
        }
    }
}
