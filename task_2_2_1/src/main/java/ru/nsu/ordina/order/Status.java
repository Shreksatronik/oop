package ru.nsu.ordina.order;

public enum Status {

        IN_QUEUE("in queue"), COOKING("cooking"), IN_STOCK("in stock"),
        DELIVERING("delivering"), DELIVERED("delivered"), WAITING("waiting till open storage");
        private final String status;

        Status(String status) {
            this.status = status;
        }

        /**
         * Returns status as a string.
         *
         * @return status.
         */
        public String getStatus() {
            return status;
        }
    }
