package com.example.kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class QueueServiceImplementation implements QueueService, ConsumerSubscriber {

    private HashMap<Integer, List<String>> queueMap = new HashMap<>();
    private HashMap<String, Integer> consumerToQueueMap;
    private HashMap<String, Integer> consumerToMessageId;

//    3 2 1 (2)
//    (1)

    // t - 1
    // t+1 - 2
    // 0
    // 1
    //

    private List<Consumer> consumerList = new ArrayList<>();
    @Override
    public void addConsumer(Consumer consumer) {
        consumerList.add(consumer);
    }

    @Override
    public void removeConsumer(Consumer consumer) {
        //
    }

    @Override
    public void postMessage(String msg, int queueNumber) {

    }

    @Override
    public int addQueue() {
        return 0;
    }
}
