package com.henryxi.core.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Locale;

public class TimeDifferentClient {
    public static void main(String[] args) throws InterruptedException, ParseException {
        String dateTime1 = "Mon 17:00";
        String dateTime2 = "Tue 5:00";
        SimpleDateFormat formatterUS = new SimpleDateFormat("EEE HH:mm", Locale.US);
        Date date1 = formatterUS.parse(dateTime1);
        Date date2 = formatterUS.parse(dateTime2);
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(date1.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(date2.toInstant(), ZoneId.systemDefault());
        Duration timeElapsed = Duration.between(localDateTime1, localDateTime2);
        System.out.println("duration second:" + timeElapsed.getUnits());
    }
}
