public class RomanEmpire {
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

    public boolean buildAqueduct(Settlement sm) {
        if (sm.build(treasury.getCoins(), population, 250, 130)) {
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildBathHouse(Settlement sm) {
        if (sm.build(treasury.getCoins(), population, 100, 20)) {
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildVilla(Settlement sm) {
        if (sm.build(treasury.getCoins(), population, 80, 15)) {
            technology.increaseExperience(5);
            return true;
        }
        return false;
    }

    public void studyPhilosophy() {
        if (population.getHappiness() >= 10) {
            population.decreaseHappiness(10);
        }
        technology.philosophize();
    }

    public RomanEmpire() {
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