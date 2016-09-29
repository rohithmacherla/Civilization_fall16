public class Game {
    private int healthIncrease;

    public Game(int k) {
        healthIncrease = k;
    }

    public Game() {
        this(20);
    }

    public int getHealth() {
        return healthIncrease;
    }
}