package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    List<Fish> fishList = new ArrayList<>();
    public static final int CAPACITY = 20;

    public void addFish(Fish fish) {
        int maxNumberOfFishes = CAPACITY/5;
        int numberOfActualFishes = fishList.size();

        if ( numberOfActualFishes < maxNumberOfFishes ) {
            fishList.add(fish);
        } else {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
    }

    public void feed() {
        for (Fish fishItem : fishList) {
            fishItem.feed();
        }
    }

    public void removeFish(int maxWeight) {
        for (int i=0; i < fishList.size(); i++) {

            if (fishList.get(i).getWeight() > maxWeight) {
                fishList.remove(fishList.get(i));
            }
        }
    }

    public List<String> getStatus() {
        List<String> fishStatus = new ArrayList<>();
        for (Fish fishItem : fishList) {
            fishStatus.add(fishItem.getStatus());
        }
        return fishStatus;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int numberWithMemoryProblems = 0;
        for (Fish item : fishList) {
            if (item.hasMemoryLoss()) {
                numberWithMemoryProblems++;
            }
        }
        return numberWithMemoryProblems;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish item : fishList) {
            if (item.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        Fish resultFish = null;
        int minWeight = 100;
        for (Fish item : fishList) {
            if (item.getWeight() < minWeight ) {
                minWeight = item.getWeight();
                resultFish = item;
            }
        }
        return resultFish;
    }


    public static void main(String[] args) {

        Tang fish1 = new Tang("Bohóc", 12, "piros");
        Tang fish2 = new Tang("Tang", 10, "piros");
        Kong fish3 = new Kong("Kong", 12, "piros");
        Clownfish fish4 = new Clownfish("Bohóc", 16, "piros");

        Aquarium aquarium1 = new Aquarium();
        aquarium1.addFish(fish1);
        aquarium1.addFish(fish2);
        aquarium1.addFish(fish3);
        //aquarium1.addFish(fish4);
        System.out.println(aquarium1.fishList.size());

        aquarium1.addFish(fish1);
        aquarium1.feed();
        aquarium1.feed();
        aquarium1.feed();

        System.out.println("Csökkentés előtt? "+aquarium1.fishList.size());
        aquarium1.removeFish(14);
        System.out.println("Csökkentés után: "+aquarium1.fishList.size());
        System.out.println("A halak státusza: "+aquarium1.getStatus());
        System.out.println("Memory loss");
        aquarium1.getNumberOfFishWithMemoryLoss();
        System.out.println("Ez a státusz: "+aquarium1.getStatus());
    }
}
