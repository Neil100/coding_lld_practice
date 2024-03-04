package com.example.concurrency;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class B_CallablesAndFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            sleep(300);
            return "I am in thread " + Thread.currentThread().getName();
        };

        ExecutorService service = Executors.newFixedThreadPool(4);
        try {
            for(int i=0; i<10; i++) {
                Future<String> future = service.submit(task);
                System.out.println(future.get());
            }
        } finally {
            service.shutdown();
        }


    }
}
