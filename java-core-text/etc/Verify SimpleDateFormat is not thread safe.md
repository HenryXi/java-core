# Verify SimpleDateFormat is not thread safe
Don't use `SimpleDateFormat` in multi-threaded scenario. It is not thread-safe class. Here is the code to verify it. I start
10 threads to parse string to date with the same instance of `SimpleDateFormat`.  
```java
public class HandleDate {
    // this is not thread safe
    private SimpleDateFormat simpleDateFormatTimestampJPOS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public void verifyNotThreadSafe(String timeStamp) {
        try {
            // this is thread safe
            SimpleDateFormat simpleDateFormatTimestampJPOS = new SimpleDateFormat("yyyyMMddHHmmssSSS");
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

public class MultiThreadSimpleDateFormatClient {


    public static void main(String[] args) {
        HandleDate handleDate = new HandleDate();
        Random random = new Random();
        Set<String> randomStrs = new HashSet<>();
        Thread thread1 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread3 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread4 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread5 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread6 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread7 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread8 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread9 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread10 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
    }
}
```
Part of output is here
```
expected:2013, but real:7
expected:2014, but real:1514
expected:2017, but real:15
expected:2012, but real:2014
expected:2014, but real:555
expected:2018, but real:1
expected:2012, but real:1
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Long.parseLong(Long.java:601)
	at java.lang.Long.parseLong(Long.java:631)
	at java.text.DigitList.getLong(DigitList.java:195)
	at java.text.DecimalFormat.parse(DecimalFormat.java:2051)
	at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:2160)
	at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
	at java.text.DateFormat.parse(DateFormat.java:364)
	at com.henryxi.core.text.HandleDate.verifyNotThreadSafe(HandleDate.java:16)
	at com.henryxi.core.text.MultiThreadSimpleDateFormatClient.lambda$main$9(MultiThreadSimpleDateFormatClient.java:71)
	at java.lang.Thread.run(Thread.java:745)
java.lang.NumberFormatException: For input string: ""
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Long.parseLong(Long.java:601)
	at java.lang.Long.parseLong(Long.java:631)
	at java.text.DigitList.getLong(DigitList.java:195)
	at java.text.DecimalFormat.parse(DecimalFormat.java:2051)
	at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:2160)
	at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
	at java.text.DateFormat.parse(DateFormat.java:364)
	at com.henryxi.core.text.HandleDate.verifyNotThreadSafe(HandleDate.java:16)
	at com.henryxi.core.text.MultiThreadSimpleDateFormatClient.lambda$main$6(MultiThreadSimpleDateFormatClient.java:53)
	at java.lang.Thread.run(Thread.java:745)
```
EOF