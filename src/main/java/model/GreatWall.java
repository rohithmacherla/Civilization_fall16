package model;

class GreatWall extends Landmark {

    public GreatWall(Civilization owner) {
        super(owner);
    }

    @Override
    public String toString() {
        return "GreatWall. " + super.toString();
    }

    public void invest() {
        super.invest();
        this.getOwner().getStrategy().setStrategyLevel(
            this.getOwner().getStrategy().getStrategyLevel() + 10);
    }
}