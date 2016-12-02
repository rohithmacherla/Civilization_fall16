package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;

public class ResourcesMenu {

    private Civilization civilization;

    private Text[] elements = new Text[6];

    private HBox box;
    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        civilization = GameController.getCivilization();
        update();
        box = new HBox();
        for (int i = 0; i < elements.length; i++) {
            box.getChildren().add(elements[i]);
        }

    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        elements[0] = new Text("Strat Level: "
            + civilization.getStrategy().getStrategyLevel());
        elements[1] = new Text("Resources: "
            + civilization.getResources());
        elements[2] = new Text("Settlements: "
            + civilization.getNumSettlements());
        elements[3] = new Text("Money: "
            + civilization.getTreasury().getCoins());
        elements[4] = new Text("Food: "
            + civilization.getFood());
        elements[5] = new Text("Happiness: "
            + civilization.getHappiness());

    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        //TODO
        return box;
    }
}