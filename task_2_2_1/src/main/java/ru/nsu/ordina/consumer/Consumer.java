package ru.nsu.ordina.consumer;

public interface Consumer<T> {
    /**
     * The implementation of this method must allow the class to consume an object from some shared resource.
     *
     * @return - consumed object.
     */
    T consume();
}