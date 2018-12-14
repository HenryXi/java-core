package com.henryxi.core.misc.volatile_;

public class VolatileClient {
    public volatile static int[] arr = new int[20];
    

    public static void main(String[] args) throws Exception {
        new Thread(new Thread() {
            @Override
            public void run() {
                //Thread A
                do {
                    if (arr[19] == 0) {
                        System.out.println("Thread A print.");
                        arr[19] = 2;
                    }
                } while (true);
            }
        }).start();
        new Thread(new Thread() {
            @Override
            public void run() {
                //Thread B
                do {
                    if (arr[19] == 2) {
                        System.out.println("Thread B print.");
                        arr[19] = 0;
                    }
                } while (true);
            }
        }).start();
    }
}
