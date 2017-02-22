# Java BigDecimal example
In Java do not use float or double to do decimal arithmetic. Use `BigDecimal` instead of float and double. If you want to
know the details click [here](https://en.wikipedia.org/wiki/Floating_point).
```java
public class TestBigDecimal {
    public static void main(String[] args) throws Exception {
        System.out.println("float result:" + (1.34f + 2.4f) + ", decimal result:" + add(1.34, 2.4));
        System.out.println("float result:" + (1.34 - 2.4) + ", decimal result:" + sub(1.34, 2.4));
        System.out.println("float result:" + (1.34 * 2.4) + ", decimal result:" + mul(1.34, 2.4));
        System.out.println("float result:" + (1.34 / 2.4) + ", decimal result:" + div(1.34, 2.4, 3));
    }

    public static double add(double value1, double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.add(b2).doubleValue();
    }

    public static double sub(double value1, double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.subtract(b2).doubleValue();
    }

    public static double mul(double value1, double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.multiply(b2).doubleValue();
    }

    public static double div(double value1, double value2, int scale) throws IllegalAccessException {
        if (scale < 0) {
            throw new IllegalAccessException("scale can not less than 0");
        }
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.divide(b2, scale).doubleValue();
    }
}
```
The output is like following.
```
float result:3.7400002, decimal result:3.74
float result:-1.0599999999999998, decimal result:-1.06
float result:3.216, decimal result:3.216
float result:0.5583333333333333, decimal result:0.55
```