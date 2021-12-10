package uniquefinder;

public class Owl {
    private String county;
    private int owlNumber;

    public Owl(String county, int owlNumber) {
        this.county = county;
        this.owlNumber = owlNumber;
    }

    public String getCounty() {
        return county;
    }

    public int getOwlNumber() {
        return owlNumber;
    }
}
