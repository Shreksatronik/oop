package ru.nsu.ordina.employee;
import ru.nsu.ordina.queue.MyDequeue;
import ru.nsu.ordina.order.Order;
import ru.nsu.ordina.consumer.Consumer;
import ru.nsu.ordina.order.Status;

import static ru.nsu.ordina.order.Status.*;
import java.util.List;
import java.util.Random;


/**
 * The Courier class simulates the work of a courier.
 * The courier receives one or more orders from the storage and then delivers them.
 */
public class Courier extends Employee implements Consumer<List<Order>> {
    private final static int MAX_DELIVERY_TIME = 100;
    private final int bagCapacity;
    private List<Order> orders;
    private final MyDequeue<Order> storage;
    private final Random random;

    /**
     * Creates an instance of the class Courier.
     *
     * @param id          - courier's id.
     * @param bagCapacity - couriers' bag capacity.
     * @param storage     - place of storage of finished orders.
     */
    public Courier(int id, int bagCapacity, MyDequeue<Order> storage) {
        super(id);
        this.bagCapacity = bagCapacity;
        this.storage = storage;
        this.random = new Random();
    }

    private void setOrdersState(Status status) {
        for (Order order : orders) {
            order.setStatus(status);
        }
    }

    /**
     * Retrieves orders from the warehouse and delivers it.
     *
     * @return - consumed orders.
     */
    @Override
    public List<Order> consume() {
        long deliveryTime = random.nextInt(MAX_DELIVERY_TIME);
        try {
            orders = storage.get(bagCapacity);
            setOrdersState(DELIVERING);
            Thread.sleep(deliveryTime);
            setOrdersState(DELIVERED);
            return orders;
        } catch (InterruptedException exception) {
            System.err.println("The courier №" + getId() + " could not deliver the order.");
            return null;
        }
    }

    /**
     * Receives orders from the storage and delivers them.
     * This method is used in the run method, which allows to simulate the constant work of a courier.
     * In case of failure, this method stops the run method.
     */
    @Override
    void work() {
        List<Order> orders = consume();
        if (orders == null) {
            stop();
        }
    }
}