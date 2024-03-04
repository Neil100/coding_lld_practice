package com.example.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class D_ProducerConsumerWithLocks {

    public static void main(String[] args) {

        List<Integer> buffer = new ArrayList<>();
        Lock lock = new ReentrantLock();
        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();

        class Producer implements Callable<String> {
            @Override
            public String call() throws Exception {

                int count = 0;
                int temp = 10/0;
                while(count++ < 50) {
                    try{
                        lock.lock();

                        while((buffer.size() == 50)) {
                            isFull.await();
                        }
                        buffer.add(1);
                        isEmpty.signalAll();
                    } finally {
                        lock.unlock();
                    }

                }

                return "Produced " + (count-1);
            }
        }

        class Consumer implements Callable<String> {
            @Override
            public String call() throws TimeoutException, InterruptedException {

                int count = 0;
                while(count++ < 50) {
                    try{
                        if(lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                            throw new TimeoutException("Consumer time out exception");
                        }
                        while(buffer.isEmpty()) {
                            isEmpty.await();
                        }
                        buffer.remove(buffer.size()-1);
                        isFull.signalAll();
                    } finally {
                        lock.unlock();
                    }

                }

                return "Consumed " + (count-1);
            }
        }

        List<Consumer> consumers = new ArrayList<>(4);

        for(int i=0; i<4; i++) {
            consumers.add(new Consumer());
        }

        List<Producer> producers = new ArrayList<>(4);

        for(int i=0; i<4; i++) {
            producers.add(new Producer());
        }

        List<Callable<String>> producersAndConsumers = new ArrayList<>();
        producersAndConsumers.addAll(producers);
        producersAndConsumers.addAll(consumers);

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        try {

            List<Future<String>> futures = executorService.invokeAll(producersAndConsumers);

            futures.stream().forEach(fu -> {
                try {
                    System.out.println(fu.get());
                } catch (ExecutionException | InterruptedException e) {
                    System.out.println("Exception thrown " + e);
                }
            });

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
            System.out.println("Executor service shut down.");
        }
    }
}
