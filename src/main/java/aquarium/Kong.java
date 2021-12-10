package aquarium;

public class Kong extends Fish {

    private String name;
    private int weight;
    private String color;
    private boolean memoryLoss;

    public Kong(String name, int weight, String color) {
        super(name, weight, color);
        memoryLoss = false;
    }

    @Override
    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    @Override
    public void feed() {
        setWeight(getWeight()+2);
    }

    @Override
    public String getStatus() {
        return getName()+", weight: "+getWeight()+", color: "+getColor()+", short-term memory loss: "+hasMemoryLoss();
    }
}
