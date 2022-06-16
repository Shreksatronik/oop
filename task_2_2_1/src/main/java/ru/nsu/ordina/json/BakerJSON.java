package ru.nsu.ordina.json;

import java.time.LocalDateTime;

public class BakerJSON {
    private int id;
    private int workingExperience;

    public BakerJSON(int id, int workingExperience) {
        this.id = id;
        this.workingExperience = workingExperience;
    }
    /**
     * Returns read baker's id.
     * @return - baker's id.
     */
    public int id() {
        return id;
    }

    /**
     * Returns read baker's working experience.
     * @return - baker's working experience.
     */
    public int workingExperience() {
        return workingExperience;
    }
}