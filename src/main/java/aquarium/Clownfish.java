package aquarium;

public class Clownfish extends Fish {

    private String name;
    private int weight;
    private String color;
    private boolean memoryLoss;

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color);
        this.memoryLoss = false;
    }

    @Override
    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    @Override
    public void feed() {
        setWeight(getWeight()+1);
    }

    @Override
    public String getStatus() {
        return getName()+", weight: "+getWeight()+", color: "+getColor()+", short-term memory loss: "+hasMemoryLoss();
    }
}
