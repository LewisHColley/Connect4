public enum Counter {
    RED("R"),
    YELLOW("Y"),
    EMPTY("-");

    private final String representation;
    Counter(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }
}
