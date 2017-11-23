package com.henryxi.java.core.lang.thread.notify;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Warehouse {
    private final int MAX_NUM = 10;
    private final List<Product> products = new LinkedList<>();
    private Random random = new Random();

    public void add(Product product) throws InterruptedException {
        synchronized (products) {
            do {
                if (products.size() >= MAX_NUM) {
                    products.wait();
                } else {
                    break;
                }
            } while (true);
            products.add(product);
            System.out.println("current size:" + products.size());
            products.notifyAll();
        }
    }

    public Product remove() throws InterruptedException {
        synchronized (products) {
            do {
                if (products.size() == 0) {
                    products.wait();
                } else {
                    break;
                }
            } while (true);
            int tobeSoldIndex = random.nextInt(products.size());
            Product removedProduct = products.remove(tobeSoldIndex);
            products.notifyAll();
            System.out.println("current size:" + products.size());
            return removedProduct;
        }
    }
}
