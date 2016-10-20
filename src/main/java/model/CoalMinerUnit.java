package model;

class CoalMinerUnit extends Unit implements Convertable  {

    public CoalMinerUnit(Civilization owner) {
        super(owner);
    }

    public Building convert() {
        return this.getOwner().getCoalMine();
    }

    public boolean canConvert(TileType type) {
        return type == TileType.HILLS;
    };

    public char symbol() {
        return 'c';
    }

    @Override
    public String toString() {
        return "Coal Miners. " + super.toString();
    }
}