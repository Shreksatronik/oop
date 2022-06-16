package ru.nsu.ordina.producer;

public interface Producer<T> {
    void produce(T object);
}
