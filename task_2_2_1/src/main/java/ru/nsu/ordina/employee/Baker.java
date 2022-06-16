
package ru.nsu.ordina.employee;
import java.util.Random;

import ru.nsu.ordina.consumer.Consumer;
import ru.nsu.ordina.order.Order;
import ru.nsu.ordina.producer.Producer;
import ru.nsu.ordina.queue.MyDequeue;

import static ru.nsu.ordina.order.Status.*;

public class Baker extends Employee implements Consumer<Order>, Producer<Order> {
    private static final int MAX_COOKING_TIME = 50;
    private final int workingExperience;
    private final Random random;
    private final MyDequeue<Order> queue;
    private final MyDequeue<Order> storage;

    /**
     * Creates an instance of the class Baker.
     *  @param id                - baker's id.
     * @param workingExperience - baker's work experience.
     * @param queue             - shared order queue.
     * @param storage           - place of storage of finished orders.
     */
    public Baker(int id, int workingExperience, MyDequeue<Order> queue, MyDequeue<Order> storage) {
        super(id);
        this.workingExperience = workingExperience;
        this.random = new Random();
        this.queue = queue;
        this.storage = storage;
    }

    /**
     * Retrieves an order from the order queue.
     *
     * @return consumed order.
     */
    @Override
    public Order consume() {
        try {
            System.out.println("is storage full? " + storage.getIsFull());

            Order order = queue.get();
            System.out.println("consuming " + order.getId());
            order.setStatus(COOKING);
            return order;
        } catch (InterruptedException exception) {
            System.err.println("The baker №" + getId() + " could not take the order.");
            return null;
        }
    }

    /**
     * Places the finished order in the storage.
     *
     * @param order - object which should be produced.
     */
    @Override
    public void produce(Order order) {
        synchronized (storage) {
            int leadTime = MAX_COOKING_TIME/workingExperience;
            try {
                if (storage.getMaxSize() == storage.getSize()){
                    System.out.println("storage is full waiting");
                    stop();
                    order.setStatus(WAITING);
                    return;
                }
                System.out.println("producing " + order.getId());
                Thread.sleep(leadTime);
                storage.put(order);
                order.setStatus(IN_STOCK);
                System.out.println(storage.getSize());
            } catch (NullPointerException exception) {
                System.err.println("The baker №" + getId() + " tried to fulfill an order that does not exist.");
            } catch (InterruptedException exception) {
                System.err.println("The baker №" + getId() + "could not fulfill the order.");
            }
        }
    }
    /**
     * Takes an order out of the order queue, executes the order within a certain time, and then sends it to the storage.
     * This method is used in the run method, which allows to simulate the constant work of a baker.
     * In case of failure, this method stops the run method.
     */
    @Override
    public void work() {
        Order order = consume();
        if (order == null) {
            stop();
        }
        produce(order);
    }
}
