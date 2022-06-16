
package ru.nsu.ordina.queue;
import java.util.*;
public class MyDequeue<T> {
    private final int size;
    private final Deque<T> dequeue;

    private boolean isFull = false;

    public boolean getIsFull(){
        return isFull;
    }

    public MyDequeue(int size) {
        this.size = size;
        this.dequeue = new ArrayDeque<>();
    }

    public synchronized boolean isEmpty() {
        return dequeue.size() == 0;
    }

    public synchronized int getSize() {
        return dequeue.size();
    }

    public int getMaxSize() {
        return size;
    }
    public synchronized T get() throws InterruptedException {
        while (dequeue.isEmpty()) {
            wait();
        }
        T object = dequeue.pop();
        notifyAll();
        return object;
    }

    public synchronized List<T> get(int amount) throws IllegalArgumentException, InterruptedException {
        if (amount < 1 || amount > size) {
            return null;
        }
        while (dequeue.isEmpty()) {
            wait();
        }
        List<T> objects = new ArrayList<>();
        while (!dequeue.isEmpty() && objects.size() != amount) {
            objects.add(dequeue.pop());
        }

        return objects;
    }
        public synchronized void put(T object) throws NullPointerException, InterruptedException {
            synchronized (dequeue) {
                if (object == null) {
                    throw new NullPointerException();
                }
                while (dequeue.size() == size) {
                    isFull = true;
                    wait();
                }
                dequeue.push(object);
                notifyAll();
            }
        }

    public Deque<T> getDequeue() {
        return dequeue;
    }
}

