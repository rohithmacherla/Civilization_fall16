package model;

class Coliseum extends Landmark {

    public Coliseum(Civilization owner) {
        super(owner);
    }

    @Override
    public String toString() {
        return "Coliseum. " + super.toString();
    }


    public void invest() {
        super.invest();
        this.getOwner().increaseHappiness(50);
    }
}