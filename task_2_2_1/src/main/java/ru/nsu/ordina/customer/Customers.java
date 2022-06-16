package ru.nsu.ordina.customer;

import ru.nsu.ordina.queue.MyDequeue;
import ru.nsu.ordina.order.Order;

    public class Customers implements Runnable {
        private boolean runCustomers;
        private final MyDequeue<Order> queue;
        private final int maxQueueSize;

        /**
         * Creates an экземпляр of the class Customers.
         *
         * @param queue - shared order queue.
         * @param maxQueueSize
         */
        public Customers(MyDequeue<Order> queue, int maxQueueSize) {
            this.maxQueueSize = maxQueueSize;
            this.runCustomers = false;
            this.queue = queue;
        }

        /**
         * Implementation of the Runnable interface. Starts the customers flow and stops only when stop method is called.
         */
        @Override
        public void run() {
            runCustomers = true;
            for (int i = 0; runCustomers; i++){
                Order order = new Order(i);
                Customer customer = new Customer(this.queue);
                customer.produce(order);
                if (i == maxQueueSize){
                    break;
                }
            }
        }

        /**
         * Stops the flow of customers.
         */
        public void stop() {
            runCustomers = false;
        }
    }
