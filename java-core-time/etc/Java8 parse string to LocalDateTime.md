# Java8 parse string to LocalDateTime
`SimpleDateFormat` is the only choice when you want to parse `String` to `Date` before Java8. But, `SimpleDateFormat` is
unthread-safe class. You may get the wrong result when you use it in multi-thread scenario. I recommend you use `DateTimeFormatter`
to handle date string. 
```java
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
```
The out put is here.
```
Mon Nov 12 21:03:00 CST 2018
Mon Nov 12 21:03:00 CST 2018
```
You need to define the language which the string use as shown in the code above. `DateTimeFormatter ofPattern(String pattern, Locale locale)`
the second param means where this date time to use. 

EOF