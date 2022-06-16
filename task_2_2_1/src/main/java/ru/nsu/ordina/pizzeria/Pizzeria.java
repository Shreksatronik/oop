package ru.nsu.ordina.pizzeria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ru.nsu.ordina.customer.Customers;
import ru.nsu.ordina.employee.Baker;
import ru.nsu.ordina.employee.Courier;
import ru.nsu.ordina.json.BakerJSON;
import ru.nsu.ordina.json.CourierJSON;
import ru.nsu.ordina.json.PizzeriaJSON;
import ru.nsu.ordina.order.Order;
import ru.nsu.ordina.queue.MyDequeue;

    /**
     * This class simulates the operation of a pizzeria.
     */
    public class Pizzeria implements Runnable {
        private boolean runPizzeria;
        private List<Baker> bakers;
        private List<Courier> couriers;
        private final Customers customers;
        private final MyDequeue<Order> queue;
        private final MyDequeue<Order> storage;

        private void setBakers(BakerJSON[] bakers) {
            Stream<BakerJSON> bakerJSONStream = Arrays.stream(bakers);
            this.bakers = bakerJSONStream
                    .map(bakerJSON -> new Baker(bakerJSON.id(),
                            bakerJSON.workingExperience(),
                            this.queue,
                            this.storage))
                    .collect(Collectors.toCollection(ArrayList::new));
            System.out.println("Set bakers length " + bakers.length);
        }

        private void setCouriers(CourierJSON[] couriers) {
            Stream<CourierJSON> courierJSONStream = Arrays.stream(couriers);
            this.couriers = courierJSONStream
                    .map(courierJSON -> new Courier(courierJSON.id(), courierJSON.bagCapacity(), this.storage))
                    .collect(Collectors.toCollection(ArrayList::new));
            System.out.println("Set couriers length " + couriers.length);
        }

        /**
         * Sets up a pizzeria based on the pizzeriaJson content.
         *
         * @param settings - pizzeria configuration.
         */
        public Pizzeria(PizzeriaJSON settings) {
            this.runPizzeria = false;
            this.queue = new MyDequeue<>(settings.queueSize());
            this.storage = new MyDequeue<>(settings.storageSize());
            this.customers = new Customers(this.queue, settings.queueSize());
            setBakers(settings.bakers());
            setCouriers(settings.couriers());
        }

        /**
         * Launches a pizzeria. The pizzeria stops working either when the stop method is called, or when an error occurs.
         */
        @Override
        public void run() {
            runPizzeria = true;
            ExecutorService bakersThreadPool = Executors.newFixedThreadPool(bakers.size());
            ExecutorService couriersThreadPool = Executors.newFixedThreadPool(couriers.size());
            bakers.forEach(bakersThreadPool::execute);
            couriers.forEach(couriersThreadPool::execute);
            Thread customersThread = new Thread(customers);
            customersThread.start();
            System.out.println("The pizzeria is up and running!");
            customers.stop();
            while (runPizzeria && !bakersThreadPool.isTerminated() && !couriersThreadPool.isTerminated()) {
            }
            if (bakersThreadPool.isTerminated() || couriersThreadPool.isTerminated()) {
                System.out.println("Oops, something went wrong. The pizzeria is closed for a technical break.");
            }
            runPizzeria = false;
            System.exit(0);
        }

        /**
         * Stops the pizzeria from working.
         */
        public void stop() {
            System.out.println("The pizzeria is closed. Come visit us tomorrow!");
            runPizzeria = false;
        }
    }
