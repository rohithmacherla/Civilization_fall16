public class Settlement {
    private Building[] buildings;
    private String name;
    private int size;

    public Settlement(String nam) {
        buildings = new Building[10];
        name = nam;
        size = 0;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void addBuilding(Building k) {
        if (size >= buildings.length) {
            Building[] temp = new Building[size * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = buildings[i];
            }
            temp[size] = k;
            size++;
            buildings = temp;
        } else {
            buildings[size] = k;
            size++;
        }

    }

    public boolean build(int allotedMoney, Population population, int cost,
        int workersRequired) {
        if (cost < allotedMoney && population.canWork(workersRequired)) {
            Building obj = new Building(cost, workersRequired);
            addBuilding(obj);
            return true;
        }
        return false;
    }

    public void expandSettlement() {
        Building[] temp = new Building[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            temp[i] = buildings[i];
        }
        buildings = temp;
    }
}