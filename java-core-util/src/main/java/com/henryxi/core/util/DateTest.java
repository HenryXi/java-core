package com.henryxi.core.util;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        Date tomorrow = calendar.getTime();
        System.out.println(tomorrow);

        LocalDateTime yesterday = LocalDateTime.from(date.toInstant()).minusDays(1);
        System.out.println(yesterday);
    }
}
