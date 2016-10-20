package model;

class BlackPowderUnit extends SiegeUnit {
    public BlackPowderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
    }

    @Override
    public char symbol() {
        return 'B';
    }

    @Override
    public String toString() {
        return "BlackPowder. " + super.toString();
    }
}