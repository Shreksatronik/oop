package ru.nsu.ordina.customer;
import java.util.Random;
import ru.nsu.ordina.order.Status;
import ru.nsu.ordina.producer.Producer;
import ru.nsu.ordina.queue.MyDequeue;
import ru.nsu.ordina.order.Order;

public class Customer implements Producer<Order> {
    private static final int MAX_ORDERING_TIME = 100;
    private final Random random;
    private final MyDequeue<Order> queue;

    /**
     * Creates an instance of the class Customer.
     *
     * @param queue - shared order queue.
     */
    public Customer(MyDequeue<Order> queue) {
        this.random = new Random();
        this.queue = queue;
    }

    /**
     * Adds an order to the order queue with a random delay. In case of failure, displays an error message.
     *
     * @param order - object which should be produced.
     */
    @Override
    public void produce(Order order) {
        long orderingTime = random.nextInt(MAX_ORDERING_TIME);
        try {
            Thread.sleep(orderingTime);
            order.setStatus(Status.IN_QUEUE);
            queue.put(order);
        } catch (NullPointerException exception) {
            System.err.println("A non-existent order was received from a customer.");
        } catch (InterruptedException exception) {
            System.err.println("The customer was unable to place an order №" + order.getId() + ".");
        }
    }

    public MyDequeue<Order> getQueue() {
        return queue;
    }
}