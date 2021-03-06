# Java bitwise example
Java provides several bitwise operators: `&`, `|`, `^` and `~`. This page shows you how to use them.
```java
public class BitwiseClient {
    public static void main(String[] args) {
        // 58 =00000000 00000000 00000000 00111010
        int a = 58;
        System.out.println("a = " + a);
        // 27 =00000000 00000000 00000000 00011010
        int b = 27;
        System.out.println("b = " + b);

        // 58 =00000000 00000000 00000000 00111010
        // 27 =00000000 00000000 00000000 00011011
        // 26 =00000000 00000000 00000000 00010010
        System.out.println("a & b = " + (a & b));

        // 58 =00000000 00000000 00000000 00111010
        // 27 =00000000 00000000 00000000 00011011
        // 59 =00000000 00000000 00000000 00111011
        System.out.println("a | b = " + (a | b));

        // 58 =00000000 00000000 00000000 00111010
        // 27 =00000000 00000000 00000000 00011011
        // 33 =00000000 00000000 00000000 00100001
        System.out.println("a ^ b = " + (a ^ b));

        // 27 =00000000 00000000 00000000 00011011
        //~27 =11111111 11111111 11111111 11100100 (two's complement)
        //     11111111 11111111 11111111 11100011 (~27 -1 -> one's complement )
        //-28 =10000000 00000000 00000000 00011100 (true form)
        System.out.println("~b = " + (~b));
    }
}
```
**summary**

* `&`: both are 1 return 1 else return 0;
* `|`: any one is 1 return 1 else return 0;
* `^`: different return 1, same return 0;
* `~`: 1 return 0 , 0 return 1;

EOF