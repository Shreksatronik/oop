package ru.nsu.ordina.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.ordina.order.Order;
import ru.nsu.ordina.queue.MyDequeue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static ru.nsu.ordina.order.Status.DELIVERED;

class CourierTest {
    private final static int MAX_STORAGE_SIZE = 20;
    private final static int MAX_ORDERS_NUMBER = 20;
    private final static int COURIERS_NUMBER = 3;
    private final static int BAG_CAPACITY = 3;
    private final static int ID = 0;
    private MyDequeue<Order> storage;
    private List<Order> orders;
    private final Random random = new Random();

    @BeforeEach
    private void init() throws InterruptedException {
        storage = new MyDequeue<>(MAX_STORAGE_SIZE);
        orders = new ArrayList<>();
        int ordersNumber = random.nextInt(MAX_ORDERS_NUMBER);
        for (int i = 0; i < ordersNumber; ++i) {
            Order order = new Order(i);
            orders.add(order);
        }
        for (Order order : orders) {
            storage.put(order);
        }
    }

    @Test
    public void consume() {
        Courier courier = new Courier(ID, BAG_CAPACITY, storage);
        while (!storage.isEmpty()) {
            List<Order> consumed = courier.consume();
            consumed.forEach(order -> {
                assertEquals(DELIVERED, order.getStatus());
                assertTrue(orders.contains(order));
            });
        }
    }
//jsontest
    @Test
    public void work() {
        Courier courier = new Courier(ID, BAG_CAPACITY, storage);
        while (!storage.isEmpty()) {
            courier.work();
        }
        orders.forEach(order -> assertEquals(DELIVERED, order.getStatus()));
    }

    @Test
    public void couriers() throws InterruptedException {
        List<Courier> couriers = new ArrayList<>();
        for (int i = 0; i < COURIERS_NUMBER; ++i) {
            couriers.add(new Courier(i, BAG_CAPACITY, storage));
        }
        couriers.forEach(courier -> new Thread(courier).start());
        while (!storage.isEmpty()) {
        }
        Thread.sleep(1000);
        couriers.forEach(Courier::stop);
        orders.forEach(order -> assertEquals(DELIVERED, order.getStatus()));
    }
}