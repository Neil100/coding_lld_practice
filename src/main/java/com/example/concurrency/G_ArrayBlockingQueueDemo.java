package com.example.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class G_ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(50);

        class Consumer implements Callable<String> {

            @Override
            public String call() throws Exception {
                int count = 0;
                    while(count++ < 50) {
                        queue.take();
                    }
                return "Consumed " + (count-1);
            }
        }

        class Producer implements Callable<String> {

            @Override
            public String call() throws Exception {
                int count = 0;
                while(count++ < 50) {
                    queue.put(count);
                }
                return "Produced " + (count-1);
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Consumer> consumerList = new ArrayList<>();
        List<Producer> producerList = new ArrayList<>();
        List<Future<String>> futureList = new ArrayList<>();

        for(int i=0; i<2; i++) {
            consumerList.add(new Consumer());
            producerList.add(new Producer());
        }

        try {
            for(int i=0; i<consumerList.size(); i++) {
                futureList.add(executorService.submit(consumerList.get(i)));
                futureList.add(executorService.submit(producerList.get(i)));
            }

            futureList.forEach( future ->  {
                try {
                    String result = future.get();
                    System.out.println(result);
                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
//                    throw new RuntimeException(e);
                }
            });
        } finally {
            executorService.shutdown();
        }

    }
}
