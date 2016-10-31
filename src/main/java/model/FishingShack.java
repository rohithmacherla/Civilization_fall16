package model;

import java.util.Random;

/**
 * represents a FishingShack type of Building on a Tile on the Map
 * @author Ryan Voor
 * @version 3.0
 */
class FishingShack extends Building {
    private SimpleSet<Fish> fish;
    private static Random rand = new Random();

    /**
     * constructs a new FishingShack object with the
     * given Civilization as its owner
     */
    public FishingShack(Civilization owner) {
        super(200, owner, 5, 0, 10, 0, 0, 10);
        fish = new MySet<>();
        invest();
    }

    @Override
    public void invest() {
        replenishFish();
        int foodGeneration = 0;
        int goldGeneration = 0;
        for (Fish f : fish.toArray()) {
            foodGeneration += (int) (f.getHealth() / 2);
            goldGeneration += f.getHealth() - foodGeneration;
        }
        setFoodGeneration(foodGeneration);
        setGoldGeneration(goldGeneration);
    }

    @Override
    public char symbol() {
        return '&';
    }

    /**
     * Returns a random Fish from the FishingShack if there are
     * any Fish in the FishingShack. The Fish that is returned
     * should be removed. Returns null if there
     * are no Fish in the FishingShack.
     * @return the fish removed from the FishingShack
     */
    public Fish getFish() throws ElementDoesNotExistException {
        if (fish.isEmpty()) {
            Fish k = fish.getRandomElement();
            fish.remove(k);
            return k;
        }
        return null;
    }

    /**
     * Puts 5 new Fish into the FishingShack if the FishingShack is
     * empty.
     * Each Fish should be passed 2 random numbers from 0 (inclusive)
     * to 5 (exclusive)
     * Returns true if the FishingShack's Fish were replenished.
     * Returns false if the FishingShack's Fish were not replenished.
     * @return whether the FishingShack's Fish were replenished
     */
    public boolean replenishFish() {
        if (fish.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                int k = (int) (Math.random() * 5);
                int y = (int) (Math.random() * 5);
                fish.add(new Fish(k , y));
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FishingShack. " + super.toString();
    }
}
