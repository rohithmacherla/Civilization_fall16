package model;

class Egypt extends Civilization {

    private Desert desert = new Desert();

    public Egypt(String name) {
        super(name);
    }

    public Egypt() {
        super("Egypt");
    }

    public Desert getDesert() {
        return desert;
    }

    @Override
    public String explore() {
        int k = desert.findTreasure();
        this.getTreasury().earn(k);
        return "You explore your Desert and acquire " + k + " gold!";
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }
}