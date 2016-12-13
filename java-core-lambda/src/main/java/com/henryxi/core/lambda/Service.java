package com.henryxi.core.lambda;

public class Service {
    public int getResult(Variables variables, AddService addService) {
        int result = 0;
        for (Integer v : variables.getVariables()) {
            result = addService.add(v, result);
        }
        return result;
    }
}
