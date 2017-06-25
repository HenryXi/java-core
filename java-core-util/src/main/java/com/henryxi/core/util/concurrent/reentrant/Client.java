package com.henryxi.core.util.concurrent.reentrant;

public class Client {
    public static void main(String[] args) {
        Worker worker = new Worker();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    worker.execute(3000);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    worker.execute(3000);
                }
            }
        }.start();
    }
}
