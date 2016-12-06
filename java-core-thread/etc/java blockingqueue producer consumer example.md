# Java blockingqueue producer consumer example
In this page I will show you how to use `BlockingQueue`. Producer put products into `BlockingQueue` and consumer consumes
the products one by one. The products in `BlockingQueue` will be consumed on a FIFO (first-in-first-out) basis. Sample
code is like following.

**Producer**

Producer produce product (string) and put it into `BlockingQueue`. If there is no room in queue producer thread will
be blocked.
```java
public class Producer implements Runnable {

    protected BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = UUID.randomUUID().toString();
                blockingQueue.put(data);
                System.out.println("put in :" + data + ", total:" + blockingQueue.size());
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

**Consumer**
Consumer gets the product from `BlockingQueue` and consumes it. The method `blockingQueue.take()` will get the product
and remove it from queue. If there is no product in queue consumer thread will be blocked to waiting for product to
consume.
```java
public class Consumer implements Runnable {

    protected BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (blockingQueue.size() >= 7) {
                    Thread.sleep(100);
                } else {
                    Thread.sleep(1500);
                }
                System.out.println("consume:" + blockingQueue.take() + ", total:" + blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

**Client**
```java
public class Client {
    public static void main(String[] args) {
        final BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(15);

        Producer queueProducer = new Producer(linkedBlockingQueue);
        new Thread(queueProducer).start();

        Consumer queueProducer2 = new Consumer(linkedBlockingQueue);
        new Thread(queueProducer2).start();

        Consumer queueConsumer = new Consumer(linkedBlockingQueue);
        new Thread(queueConsumer).start();
    }
}
```

The output is like following.
```
put in :d41db91e-e779-4550-9b68-d42cfa277fa0, total:1
put in :fbed891e-e55b-43df-8830-ae750312413a, total:2
put in :9d1ca1de-13d5-4d62-b462-5ae7f010d807, total:3
put in :152ad972-e7aa-42d0-881b-6cf29d96b6ef, total:4
put in :08da8f3d-7d37-4dad-a2fa-0f3cb7761415, total:5
consume:d41db91e-e779-4550-9b68-d42cfa277fa0, total:4
consume:fbed891e-e55b-43df-8830-ae750312413a, total:3
put in :4e386c26-3af6-4db2-b3df-cd1d22d547fd, total:4
put in :48375055-e9f8-4ca5-b7cd-0d6f9c4420b2, total:5
put in :6a8d2168-d34f-4cb9-a9d6-599106dee1af, total:6
put in :cd0c7b82-e62b-4a66-9f68-6428b690642f, total:7
put in :2c261363-fbe9-45c6-a01b-d00dffb10028, total:8
consume:9d1ca1de-13d5-4d62-b462-5ae7f010d807, total:7
consume:152ad972-e7aa-42d0-881b-6cf29d96b6ef, total:6
consume:08da8f3d-7d37-4dad-a2fa-0f3cb7761415, total:5
put in :044ecfe0-d1ee-4758-85a8-7ae2cb5aa0a2, total:6
put in :55b475b2-81eb-4150-93bf-a33b859a4127, total:7
put in :ff02331b-1fcd-46bb-95e0-bf826863460e, total:8
put in :b8d1ce91-bb2f-4cb9-8918-2e25a4683efa, total:9
put in :9100aec1-2f94-492a-987b-a2fd390f1a6f, total:10
consume:4e386c26-3af6-4db2-b3df-cd1d22d547fd, total:9
consume:48375055-e9f8-4ca5-b7cd-0d6f9c4420b2, total:8
consume:6a8d2168-d34f-4cb9-a9d6-599106dee1af, total:7
put in :05c76248-f713-4d40-beeb-7b793b375d28, total:8
consume:cd0c7b82-e62b-4a66-9f68-6428b690642f, total:7
consume:2c261363-fbe9-45c6-a01b-d00dffb10028, total:6
consume:044ecfe0-d1ee-4758-85a8-7ae2cb5aa0a2, total:5
put in :01c0ea16-7974-4b7f-b9e8-591166201cf4, total:6
put in :2b139a14-4f8a-4e80-978f-03f1ef3d894e, total:7
put in :77970e71-30ca-4480-bd20-0afa872bab0c, total:8
put in :9e7a619b-c22c-45df-94e1-5ec1dca8100a, total:9
put in :3c3ff1d0-ee96-4725-b4ab-65fa78d6ce5f, total:10
```

