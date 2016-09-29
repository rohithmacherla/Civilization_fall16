public class Egypt {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Settlement[] settlements;
    private int counter;
    private Desert desert;

    public CoalMine getCoalMine() {
        return coalMine;
    }

    public Desert getDesert() {
        return desert;
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

    public boolean buildPyramid(Settlement sm) {
        if (sm.build(treasury.getCoins(), population, 500, 100)) {
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public void practiceHieroglyphics() {
        technology.improveWriting();
        population.increaseHappiness(10);
    }

    public Egypt() {
        population = new Population();
        treasury = new Treasury();
        coalMine = new CoalMine();
        river = new River("defaultRiver");
        technology = new Technology();
        strategy = new Strategy();
        desert = new Desert();
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