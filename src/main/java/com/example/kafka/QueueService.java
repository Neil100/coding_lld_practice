package com.example.kafka;

public interface QueueService {
    void postMessage(String msg, int queueNumber);
    int addQueue();
}
