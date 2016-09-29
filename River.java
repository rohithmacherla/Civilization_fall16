public class River {
    private String name;
    private Fish[] fish;

    public River(String n) {
        name = n;
        fish = new Fish[5];
        for (int i = 0; i < 5; i++) {
            fish[0] = new Fish((int) (Math.random() * 5));
        }
    }

    public String getName() {
        return name;
    }

    public Fish getFish() {
        Fish k = null;
        int i;
        for (i = fish.length - 1; i > 0; i--) {
            if (fish[i] != null) {
                k = fish[i];
                fish[i] = null;
                break;
            }
        }
        return k;
    }

    public boolean replenishFish() {
        if (fish[0] == null) {
            for (int i = 0; i < fish.length; i++) {
                fish[0] = new Fish((int) Math.random() * 5);
            }
            return true;
        }
        return false;
    }
}