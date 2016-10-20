package model;

class MasterBuilderUnit extends Unit implements Convertable  {
    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    public Building convert() {
        return this.getOwner().getLandmark();
    }

    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    };

    public char symbol() {
        return 'm';
    }

    @Override
    public String toString() {
        return "MasterBuilders. " + super.toString();
    }
}