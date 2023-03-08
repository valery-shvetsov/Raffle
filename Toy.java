package raffle;

public class Toy {

    private String name;
    private int weight;

    public Toy(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "{weight=" + weight + "}";
    }
}
