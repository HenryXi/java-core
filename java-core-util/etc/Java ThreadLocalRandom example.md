# Java ThreadLocalRandom example
`ThreadLocalRandom` is less contention and better performance than `Random`. If you need to use random number in 
multi-thread environment. The example code is here.
```java
public class ThreadLocalRandomClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt();
            int randomIntLessThan2 = ThreadLocalRandom.current().nextInt(2);
            int randomIntBiggerOrEqualThen2LessThan5 = ThreadLocalRandom.current().nextInt(2, 5);
            System.out.println("randomInt:" + randomInt);
            System.out.println("randomIntLessThan2:" + randomIntLessThan2);
            System.out.println("randomIntBiggerOrEqualThen2LessThan5:" + randomIntBiggerOrEqualThen2LessThan5);
        }
    }
}
```
output
```
randomInt:927733376
randomIntLessThan2:1
randomIntBiggerOrEqualThen2LessThan5:4
randomInt:-1210126526
randomIntLessThan2:0
randomIntBiggerOrEqualThen2LessThan5:3
randomInt:-359089879
randomIntLessThan2:0
randomIntBiggerOrEqualThen2LessThan5:3
randomInt:-2112033180
randomIntLessThan2:0
randomIntBiggerOrEqualThen2LessThan5:4
randomInt:-1410394207
randomIntLessThan2:1
randomIntBiggerOrEqualThen2LessThan5:3
randomInt:-1745100708
randomIntLessThan2:0
randomIntBiggerOrEqualThen2LessThan5:4
randomInt:-487542546
randomIntLessThan2:1
randomIntBiggerOrEqualThen2LessThan5:3
randomInt:-1435869749
randomIntLessThan2:0
randomIntBiggerOrEqualThen2LessThan5:2
randomInt:1015078975
randomIntLessThan2:1
randomIntBiggerOrEqualThen2LessThan5:2
randomInt:-76514204
randomIntLessThan2:1
randomIntBiggerOrEqualThen2LessThan5:4
```

**summary**

* `nextInt()` return random int value
* `nextInt(int num)` return the random value between 0 and num(exclude).
* `nextInt(int num1,int num2)` return the random value between num1 and num2(exclude).