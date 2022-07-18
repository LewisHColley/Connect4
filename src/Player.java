public class Player {
    private final String name;
    private final Counter counter;

    public Player(String name, Counter counter) {
        this.name = name;
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public Counter getCounter() {
        return counter;
    }
}
