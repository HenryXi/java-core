package com.henryxi.java.core.math;

import java.math.BigDecimal;

public class TestDivision {
    public static void main(String[] args) {
        BigDecimal total = new BigDecimal(7);
        BigDecimal part = new BigDecimal(3);
        System.out.print(part.divide(total, 4, BigDecimal.ROUND_UP).multiply(BigDecimal.valueOf(100)).intValue());

    }
}
