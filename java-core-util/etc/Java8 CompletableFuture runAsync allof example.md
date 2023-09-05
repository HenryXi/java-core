# Java8 CompletableFuture runAsync allof example
In the previous blog [Java8 CompletableFuture concurrence example](http://www.henryxi.com/java8-completablefuture-concurrence-example)
we have learned how to use the method `allof` and `supplyAsync` of `CompletableFuture` to achieve concurrency. The problem is that
the code is less readable when there are multiple `CompletableFuture`.

Consider the code in the previous blog
```java
public static void main(String[] args) throws ExecutionException, InterruptedException {
    long beginTime = System.currentTimeMillis();
    String userName = "henry";
    CompletableFuture<String> addressFuture = CompletableFuture.supplyAsync(() -> getAddress(userName));
    CompletableFuture<String> companyNameFuture = CompletableFuture.supplyAsync(() -> getCompanyName(userName));
    CompletableFuture<String> familyFuture = CompletableFuture.supplyAsync(() -> getFamilyInfo(userName));
    CompletableFuture<String> allInfoFuture = CompletableFuture.allOf(addressFuture, companyNameFuture, familyFuture)
            .thenApply(i -> {
                String address = addressFuture.join();
                String companyName = companyNameFuture.join();
                String familyInfo = familyFuture.join();
                return "userId:\t" + userName + " \r\n" + address + "\r\n" + companyName + "\r\n" + familyInfo;
            });
    String allInfo = allInfoFuture.get();
    System.out.println(allInfo + "\r\ntime cost:" + (System.currentTimeMillis() - beginTime));
}
```
As the resources that require concurrent requests increase, the logic in the `thenApply` method will become very complicated.
Using `runAsync` instead of `supplyAsync`, the code looks a lot cleaner.
```java
public class CompletableFutureConcurrenceCodeFormatClient {
    private static final Executor executor =
            Executors.newFixedThreadPool(600, r -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long beginTime = System.currentTimeMillis();
        String userName = "henry";
        UserInfo userInfo = new UserInfo();
        CompletableFuture<Void> addressFuture = CompletableFuture.runAsync(() -> assembleAddress(userName, userInfo), executor);
        CompletableFuture<Void> companyNameFuture = CompletableFuture.runAsync(() -> assembleCompany(userName, userInfo), executor);
        CompletableFuture<Void> familyFuture = CompletableFuture.runAsync(() -> assembleFamilyInfo(userName, userInfo), executor);
        CompletableFuture.allOf(addressFuture, companyNameFuture, familyFuture).join();
        System.out.println("user info: " + userInfo + "\r\ntime cost:" + (System.currentTimeMillis() - beginTime));
    }

    private static void assembleCompany(String userName, UserInfo userInfo) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userInfo.setCompanyName("my_company");
    }

    private static void assembleAddress(String userName, UserInfo userInfo) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userInfo.setAddress("beijing");
    }

    private static void assembleFamilyInfo(String userName, UserInfo userInfo) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userInfo.setFamilyInfo("wife and son");
    }
}
```
Assemble attribute values in each concurrent method, rather than concurrently getting the attribute values before assembling.

EOF