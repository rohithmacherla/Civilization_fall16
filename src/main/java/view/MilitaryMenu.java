package view;

import controller.GameController;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        Button attack = new Button("ATTACK");
        Button move = new Button("MOVE");
        this.addMenuItem(attack);
        this.addMenuItem(move);

        attack.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                    GameController.attacking();
                }
            });

        move.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                    GameController.moving();
                }
            });
    }
}
