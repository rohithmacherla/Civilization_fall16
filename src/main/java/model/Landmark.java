package model;

class Landmark extends Building {

    public Landmark(Civilization owner) {
        super(200, owner, 0, 0 , 0 , 10 , 0 , 10);
    }

    @Override
    public String toString() {
        return "Landmark. " + super.toString();
    }

    @Override
    public char symbol() {
        return '!';
    }

    public void invest() {
        setTechPointGeneration(getTechPointGeneration() + 5);
    }
}