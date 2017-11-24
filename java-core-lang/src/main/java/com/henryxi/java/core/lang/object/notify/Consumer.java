package com.henryxi.java.core.lang.object.notify;

public class Consumer implements Runnable {
    private String consumerName;
    private Warehouse warehouse;

    public Consumer(String consumerName, Warehouse warehouse) {
        this.consumerName = consumerName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            do {
                Product removedProduct = warehouse.remove();
                System.out.println(consumerName + " remove product:" + removedProduct.getName());
                Thread.sleep(3000);
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
