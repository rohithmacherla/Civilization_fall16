import java.util.Random;

public class Population {

    private int warriors;
    private int civilians;
    private int happiness;
    private Random rand = new Random();

    public Population() {
        warriors = 50;
        civilians = 50;
        happiness = 200;
    }

    public int getCivilians() {
        return civilians;
    }

    public int getWarriors() {
        return warriors;
    }

    public void setWarriors(int k) {
        warriors = k;
    }

    public int getHappiness() {
        return happiness;
    }

    public void increaseHappiness(int k) {
        happiness += k;
    }

    public void decreaseHappiness(int k) {
        happiness -= k;
    }

    public boolean canWork(int numWorkers) {
        if (numWorkers >= civilians) {
            civilians -= numWorkers;
            return true;
        }
        return false;
    }


    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public Game hunt(Hills k) {
        return k.hunt();
    }

    public Fish fish(River k) {
        return k.getFish();
    }

    public boolean canCook(Game g1, CoalMine c1) {
        if (c1.getBurnCost() * 4 >= c1.getCoal()) {
            for (int i = 0; i < 4; i++) {
                c1.burn();
            }
            warriors += 40;
            civilians += 60;
            return true;
        }
        return false;
    }

    public boolean canCook(Fish f1, CoalMine c1) {
        if (c1.getBurnCost() * 4 >= c1.getCoal()) {
            for (int i = 0; i < 4; i++) {
                c1.burn();
            }
            warriors += 10;
            civilians += 15;
            return true;
        }
        return false;

    }
}