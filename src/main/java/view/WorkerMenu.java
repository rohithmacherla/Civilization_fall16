package view;

import controller.GameController;
import model.Convertable;
// import model.MapObject;
// import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by RuYiMarone on 11/11/2016.
 */

public class WorkerMenu extends AbstractMenu {
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */

    public WorkerMenu() {
        Button move = new Button("MOVE");
        Button convert = new Button("CONVERT");
        this.addMenuItem(move);
        this.addMenuItem(convert);

        move.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                    GameController.moving();
                }
            });

        convert.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                    if (((Convertable) GameController.getLastClicked()
                        .getTile().getOccupant()
                            ).canConvert(GameController.getLastClicked()
                            .getTile().getType())) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(((Convertable)
                                GameController.getLastClicked().getTile()
                                .getOccupant()).convert());
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Convert Status");
                        alert.setHeaderText("Convert did not work");
                        alert.setContentText("Your Convert did not process");
                        alert.showAndWait();
                    }
                }
            });
    }
}