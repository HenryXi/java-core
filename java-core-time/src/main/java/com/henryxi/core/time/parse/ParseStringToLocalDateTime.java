package com.henryxi.core.time.parse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseStringToLocalDateTime {
    public static void main(String[] args) {
        String timestampStringUS = "Mon Nov 12 18:43:41 +0800 2018";
        String timestampStringCh = "星期一 十一月 12 18:43:41 +0800 2018";
        DateTimeFormatter formatterUS = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss XXXX yyyy", Locale.US);
        DateTimeFormatter formatterCH = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss XXXX yyyy", Locale.CHINESE);
        LocalDateTime dateTime1 = LocalDateTime.parse(timestampStringCh, formatterCH);
        LocalDateTime dateTime2 = LocalDateTime.parse(timestampStringUS, formatterUS);
        System.out.println(dateTime1);
        System.out.println(dateTime2);
    }
}
