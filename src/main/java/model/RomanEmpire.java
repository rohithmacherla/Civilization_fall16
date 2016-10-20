package model;

class RomanEmpire extends Civilization {

    private Hills hills = new Hills();

    public RomanEmpire(String name) {
        super(name);
    }

    public RomanEmpire() {
        super("RomanEmpire");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        int k = hills.mineCoal();
        produceResources(k);
        return "You explore your Hills and acquire " + k + " resources!";
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }
}