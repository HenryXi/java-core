package com.henryxi.core.text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatClient {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String today = dateFormat.format(date);
        System.out.println(today);
        System.out.println(TimeZone.getDefault());
    }
}
