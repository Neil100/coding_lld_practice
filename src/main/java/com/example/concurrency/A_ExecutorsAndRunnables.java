package com.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A_ExecutorsAndRunnables {

    public static void main(String[] args) {
        Runnable task = () -> System.out.println("I am in thread " + Thread.currentThread().getName());

        for(int i=0; i<10; i++) {
            new Thread(task).start();
        }

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ExecutorService service = Executors.newSingleThreadExecutor();

        for(int i=0; i<10; i++) {
            service.execute(task);
        }
        service.shutdown();

        ExecutorService service1 = Executors.newFixedThreadPool(4);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for(int i=0; i<10; i++) {
            service1.submit(task);
        }
        service1.shutdown();
    }
}
