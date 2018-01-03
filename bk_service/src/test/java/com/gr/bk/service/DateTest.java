package com.gr.bk.service;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws Exception {
        int day = -1;
        System.out.println(getAddDay(new Date(), day));
    }

    public static Date getAddDay(Date date, int day) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.DATE, day);
        return cl.getTime();
    }
}
