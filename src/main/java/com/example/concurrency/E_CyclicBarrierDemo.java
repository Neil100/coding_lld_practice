package com.example.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class E_CyclicBarrierDemo {


    public static void main(String[] args) {

        // Barrier and latches

        class Friend implements Callable<String> {

            private CyclicBarrier barrier;

            Friend(CyclicBarrier barrier) {
                this.barrier = barrier;
            }

            @Override
            public String call() throws Exception {
                System.out.println("I have arrived at the spot, waiting for others.");
                Random random = new Random();
                Thread.sleep(random.nextInt(20)*100+100);
                barrier.await(5000, TimeUnit.MILLISECONDS);

                System.out.println("Okkk, lets go.");

                return "ok";
            }
        }

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        Callable<String> friend1 = new Friend(cyclicBarrier);
        Callable<String> friend2 = new Friend(cyclicBarrier);
        Callable<String> friend3 = new Friend(cyclicBarrier);
        Callable<String> friend4 = new Friend(cyclicBarrier);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> futureList = new ArrayList<>();
        try {
            futureList.add(executorService.submit(friend1));
            futureList.add(executorService.submit(friend2));
            futureList.add(executorService.submit(friend3));
            futureList.add(executorService.submit(friend4));

            for(int i=0; i<futureList.size(); i++) {
                try {
                    futureList.get(i).get();
                } catch (ExecutionException | InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                }
            }
        } finally {
            executorService.shutdown();
        }
    }
}
