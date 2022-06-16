package ru.nsu.ordina.json;

public class CourierJSON {
    private int id;
    private int bagCapacity;

    public CourierJSON(int id, int bagCapacity) {
        this.id = id;
        this.bagCapacity = bagCapacity;
    }

    /**
     * Returns read courier's id.
     *
     * @return - courier's id.
     */
    public int id() {
        return id;
    }

    /**
     * Returns read courier's id.
     *
     * @return - courier's id.
     */
    public int bagCapacity() {
        return bagCapacity;
    }
}
