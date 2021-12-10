package owlcounter;

import uniquefinder.Owl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OwlCounter {

    List<String> lines = new ArrayList<>();

    List<Owl> owlList = new ArrayList<>();

    // sorok beolvasása a fileból
    public void readFromFile(Path path) {
        try {
            lines = Files.readAllLines(path);
            owlList = owlReader(lines);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    private List<Owl> owlReader(List<String> lines) {
        List<Owl> result = new ArrayList<>();
        for (String item : lines ) {
            String[] tmp = item.split("=");
            result.add(new Owl(tmp[0], Integer.parseInt(tmp[1])));
        }
        return result;
    }

    public int getNumberOfOwls(String county) {
        int numberOfOwls = 0;
        for (Owl item : owlList) {
            if ( county.equals(item.getCounty())) {
                numberOfOwls = item.getOwlNumber();
            }
        }
        if (numberOfOwls == 0 ) {
            throw new IllegalArgumentException("No such county in Hungary!");
        }
        return numberOfOwls;
    }

    public int getNumberOfAllOwls() {
        int numberOfAllOwls = 0;
        for (Owl item : owlList) {
            numberOfAllOwls += item.getOwlNumber();
        }
        return numberOfAllOwls;
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/owls.txt");
        OwlCounter owlCounter = new OwlCounter();
        owlCounter.readFromFile(path);
        System.out.println(owlCounter.getNumberOfAllOwls());
        System.out.println(owlCounter.getNumberOfOwls("omogy"));
    }
}
