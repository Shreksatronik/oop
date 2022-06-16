package ru.nsu.ordina.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.ordina.order.Order;
import ru.nsu.ordina.queue.MyDequeue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static ru.nsu.ordina.order.Status.COOKING;
import static ru.nsu.ordina.order.Status.IN_STOCK;

class BakerTest {
    private final static int MAX_QUEUE_SIZE = 10;
    private final static int MAX_STORAGE_SIZE = 20;
    private final static int MAX_ORDERS_NUMBER = 10;
    private final static int BAKERS_NUMBER = 3;
    private MyDequeue<Order> queue;
    private MyDequeue<Order> storage;
    private List<Order> orders;
    private final Random random = new Random();

    @BeforeEach
    private void init() throws InterruptedException {
        queue = new MyDequeue<>(MAX_QUEUE_SIZE);
        storage = new MyDequeue<>(MAX_STORAGE_SIZE);
        orders = new ArrayList<>();
        int ordersNumber = random.nextInt(MAX_ORDERS_NUMBER);
        for (int i = 0; i < ordersNumber; ++i) {
            Order order = new Order(i);
            orders.add(order);
        }
        for (Order order : orders) {
            queue.put(order);
        }
    }

    @Test
    public void produce() throws InterruptedException {
        Baker baker = new Baker(0, 10, queue, storage);
        orders.forEach(baker::produce);
        int storageSize = storage.getSize();
        assertEquals(orders.size(), storageSize);
        for (int i = 0; i < storageSize; ++i) {
            Order produced = storage.get();
            assertEquals(IN_STOCK, produced.getStatus());
            assertTrue(orders.contains(produced));
        }
    }

    @Test
    public void consume() {
        Baker baker = new Baker(0, 10, queue, storage);
        for (int i = 0; i < orders.size(); ++ i) {
            Order consumed = baker.consume();
            assertEquals(COOKING, consumed.getStatus());
            assertTrue(orders.contains(consumed));
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    public void work() {
        Baker baker = new Baker(0, 1, queue, storage);
        int ordersNumber = orders.size();
        for (int i = 0; i < ordersNumber; ++i) {
            baker.work();
        }
        orders.forEach(order -> assertEquals(IN_STOCK, order.getStatus()));
        assertTrue(queue.isEmpty());
    }

    @Test
    public void bakers() throws InterruptedException {
        List<Baker> bakers = new ArrayList<>();
        for (int i = 0; i < BAKERS_NUMBER; ++ i) {
            bakers.add(new Baker(i, 1000, queue, storage));
        }
        bakers.forEach(baker -> new Thread(baker).start());
        while (!storage.isEmpty()) {
        }
        Thread.sleep(100);
        bakers.forEach(Baker::stop);
        assertEquals(orders.size(), storage.getSize());
        orders.forEach(order -> assertEquals(IN_STOCK, order.getStatus()));
    }
}