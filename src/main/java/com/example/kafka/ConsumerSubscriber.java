package com.example.kafka;

public interface ConsumerSubscriber {
    void addConsumer(Consumer consumer);
    void removeConsumer(Consumer consumer);
}
