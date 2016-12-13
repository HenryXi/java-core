package com.henryxi.core.lambda;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Variables variables = new Variables();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(8);
        integerList.add(9);
        variables.setVariables(integerList);
        Service service = new Service();
        int result = service.getResult(variables, new AddService() {
            @Override
            public int add(int a, int b) {
                int temp = a / b;
                int temp2 = a - b;
                return a + b + temp2 + temp;
            }

            @Override
            public int add2(int a, int b) {
                int temp = a / b + a;
                int temp2 = (a - b) / a;
                return a + b + temp2 + temp;
            }
        });
        System.out.println(result);
    }
}
