# Java8 convert LocalDateTime to Date
There are two ways to convert `LocalDateTime` to `Date` in java. Both of them need convert `LocalDateTime` to `Instant` 
then convert `Instant` to `Date`. `LocalDateTime` and `Instant` are new classes in Java8 I recommend you to use them instead
of `Date`. Here is the sample code.
```
public class ConvertClient {
    public static void main(String[] args) throws ParseException {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 11, 12, 21, 3, 0);
        Date date1 = new Date(localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        Date date2 = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(8)));
        System.out.println(date1);
        System.out.println(date2);
    }
}
```
output is here
```
Mon Nov 12 21:03:00 CST 2018
Mon Nov 12 21:03:00 CST 2018
```

EOF