package com.henryxi.java.core.lang.object.notify;

public class Producer implements Runnable {
    private Warehouse warehouse;
    private String producerName;

    public Producer(String producerName, Warehouse warehouse) {
        this.producerName = producerName;
        this.warehouse = warehouse;
    }


    @Override
    public void run() {
        do {
            try {
                for (int i = 0; i < 10; i++) {
                    Product product = new Product(producerName + "-No. :" + i);
                    System.out.println("add product");
                    warehouse.add(product);
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
