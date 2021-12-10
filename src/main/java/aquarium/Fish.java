package aquarium;

import java.util.PrimitiveIterator;

public abstract class Fish {
    private String name;
    private int weight;
    private String color;
    private boolean memoryLoss;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.memoryLoss = false;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public abstract String getStatus();

    public abstract void feed();
}
