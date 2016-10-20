package model;

class LegionUnit extends MeleeUnit {

    public LegionUnit(Civilization civilization) {
        super(civilization);
        this.setDamage((int) (30 * 1.5));
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof MeleeUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public String toString() {
        return "Legion Unit. " + super.toString();
    }
}