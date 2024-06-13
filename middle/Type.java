package middle;

public enum Type {
    OWNER(1, -95),
    MANAGER(2, 10),
    DESIGNER(3, 20),
    ARCHITECT(4, 30),
    DEVELOPER(5, 100);

    private final int value;
    private final int increaseRate;

    Type(final int value, final int increaseRate) {
        this.value = value;
        this.increaseRate = increaseRate;
    }

    public int getIncreaseRate() {
        return increaseRate;
    }
}
