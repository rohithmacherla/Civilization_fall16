public class QinDynasty {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Settlement[] settlements;
    private int counter;
    private Hills hills;

    public CoalMine getCoalMine() {
        return coalMine;
    }

    public Hills getHills() {
        return hills;
    }

    public River getRiver() {
        return river;
    }

    public Settlement[] getSettlements() {
        return settlements;
    }

    public Population getPopulation() {
        return population;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public Technology getTechnology() {
        return technology;
    }

    public boolean buildWall(Settlement sm) {
        if (sm.build(treasury.getCoins(), population, 1000, 100)) {
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildHouse(Settlement sm) {
        if (sm.build(treasury.getCoins(), population, 30, 8)) {
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public void establishLegalism() {
        technology.philosophize();
        if (population.getHappiness() >= 20) {
            population.decreaseHappiness(20);
        }
    }

    public QinDynasty() {
        population = new Population();
        treasury = new Treasury();
        coalMine = new CoalMine();
        river = new River("defaultRiver");
        technology = new Technology();
        strategy = new Strategy();
        hills = new Hills();
        settlements = new Settlement[10];
        counter = 0;
    }

    public boolean settle(Settlement sm) {
        if (counter >= 10) {
            return false;
        } else {
            settlements[counter] = sm;
            counter++;
            return true;
        }
    }

    public int getNumSettlements() {
        return counter;
    }
}