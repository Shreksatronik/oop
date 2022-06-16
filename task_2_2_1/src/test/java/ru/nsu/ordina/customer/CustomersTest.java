package ru.nsu.ordina.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.ordina.order.Order;
import ru.nsu.ordina.queue.MyDequeue;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static ru.nsu.ordina.order.Status.IN_QUEUE;

class CustomersTest {
    private final static int MAX_QUEUE_SIZE = 100;
    private MyDequeue<Order> queue;
    private int queueSize;
    private final Random random = new Random();

    @BeforeEach
    private void init() {
        queueSize = random.nextInt(MAX_QUEUE_SIZE);
        queue = new MyDequeue<>(queueSize);
    }
//
//    @Test
//    public void customers() throws InterruptedException {
//        Customers customers = new Customers(queue, maxQueueSize);
//        Thread customersThread = new Thread(new Customers(queue, maxQueueSize));
//        customersThread.start();
//        while (queue.getSize() != queueSize) {
//        }
//        Thread.sleep(100);
//        customers.stop();
//        List<Order> orders = queue.get(queueSize);
//        orders.forEach(order -> assertEquals(IN_QUEUE, order.getStatus()));
//    }
}