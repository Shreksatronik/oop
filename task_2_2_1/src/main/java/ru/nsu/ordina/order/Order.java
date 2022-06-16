package ru.nsu.ordina.order;

public class Order {

        private final int id;
        private Status status;

        /**
         * Creates an instance of the class Order.
         *
         * @param id - order's id.
         */
        public Order(int id) {
            this.id = id;
        }

        /**
         * Returns order's id.
         *
         * @return order's id.
         */
        public int getId() {
            return id;
        }

        /**
         * Returns order's state.
         *
         * @return order's state.
         */
        public Status getStatus() {
            return status;
        }

        /**
         * Changes the order status and prints a new state
         *
         * @param status - new order's state.
         */
        public void setStatus(Status status) {
            this.status = status;
            System.out.println(this);
        }

        /**
         * Represents the order as a string.
         *
         * @return order.
         */
        @Override
        public String toString() {
            return "[Order №" + id + "], [" + status.getStatus() + "]";
        }
    }

