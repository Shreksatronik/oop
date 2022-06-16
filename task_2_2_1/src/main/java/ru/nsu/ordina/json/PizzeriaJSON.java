package ru.nsu.ordina.json;

public class PizzeriaJSON {
    private int queueSize;
    private int storageSize;
    private BakerJSON[] bakers;
    private CourierJSON[] couriers;

    public PizzeriaJSON(int queueSize, int storageSize, BakerJSON[] bakers, CourierJSON[] couriers) {
        this.queueSize = queueSize;
        this.storageSize = storageSize;
        this.bakers = bakers;
        this.couriers = couriers;
    }


    /**
     * Returns read queue size.
     *
     * @return - queue size.
     */
    public int queueSize() {
        return queueSize;
    }

    /**
     * Returns read storage size.
     *
     * @return - storage size.
     */
    public int storageSize() {
        return storageSize;
    }

    /**
     * Returns read array of bakers data.
     *
     * @return - array of bakers data.
     */
    public BakerJSON[] bakers() {
        return bakers;
    }

    /**
     * Returns read array of couriers data.
     *
     * @return - array of couriers data.
     */
    public CourierJSON[] couriers() {
        return couriers;
    }
}
