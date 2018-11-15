package com.henryxi.core.time.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class ConvertClient {
    public static void main(String[] args) throws ParseException {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 11, 12, 21, 3, 0);
        Date date1 = new Date(localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        Date date2 = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(8)));
        System.out.println(date1);
        System.out.println(date2);
        findTxnDate();
    }

    private static SimpleDateFormat simpleDateFormatTimestampJPOS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    private static Date findTxnDate() throws ParseException
    {
        Date date;
        String timeStamp = "20181115040613555";
        date = simpleDateFormatTimestampJPOS.parse(timeStamp);

        return date;
    }
}
