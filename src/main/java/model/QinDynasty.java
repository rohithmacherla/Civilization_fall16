package model;

class QinDynasty extends Civilization {

    private Hills hills = new Hills();

    public QinDynasty(String name) {
        super(name);
    }

    public QinDynasty() {
        super("QinDynasty");
    }

    public Hills getHills() {
        return hills;
    }

    public String explore() {
        hills.replenishGame();
        Game k = hills.hunt();
        makeFood(k.getHealth());
        return "You explore your Hills and acquire " + k.getHealth() + " food!";
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }
}