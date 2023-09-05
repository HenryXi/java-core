# Java wait notify consumer producer example
`wait`, `notify` and `notifyAll` are all method of `Object`. It means that every object in java can be a lock monitor.
When you use `synchronized` you get the lock of object. Use `synchronized` on the method current thread will get the 
lock of instance. If you add `synchronized` on a static method that means current thread will get the lock of this `Class`.
These 3 methods can not be used without `synchronized` (you can release the lock without geting it). 

As we all known, `BlockingQueue` can help you to implement "producer-consumer" model (you can click [Java blockingqueue producer consumer example](http://www.henryxi.com/java-blockingqueue-producer-consumer-example) for more detail).
In this page I will show you how to use `wait` and `notify` to implement "producer-consumer" model.

**code**
```java
public class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    //getter and setter method
}

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
            products.notify();
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
            products.notify();
            System.out.println("current size:" + products.size());
            return removedProduct;
        }
    }
}

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

public class NotifyClient {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        for (int i = 0; i < 10; i++) {
            new Thread(new Producer("producer" + i, warehouse)).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer("consumer" + i, warehouse)).start();
        }
    }
}
```

**analyze**

* `wait` method will release the currently acquired lock, and block current thread.
* `notify` method will wake up one thread (randomly select one) which blocked by the lock, and if all goes well this thread will get the lock.
* `notifyAll` method will wake up all thread which blocked by the lock, and highest priority one will get the lock, and if all goes well this thread will get the lock.

EOF