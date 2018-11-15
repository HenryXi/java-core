package com.henryxi.core.text;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class HandleDate {
    // this is not thread safe
    private SimpleDateFormat simpleDateFormatTimestampJPOS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public void verifyNotThreadSafe(String timeStamp) {
        try {
            // this is thread safe
//            SimpleDateFormat simpleDateFormatTimestampJPOS = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            Date date = simpleDateFormatTimestampJPOS.parse(timeStamp);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            String expectedYear = timeStamp.substring(0, 4);
            String actualYear = String.valueOf(localDateTime.getYear());
            if (!expectedYear.equals(actualYear)) {
                System.out.println("expected:" + expectedYear + ", but real:" + actualYear);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
