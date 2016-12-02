package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
//import model.Bandit;
import javafx.application.Application;
//import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
//import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import model.Civilization;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    private CivEnum holder;
    private Civilization civ;

    public void start(Stage primaryStage) {
        StartScreen startScreen = new StartScreen();

        Button button = startScreen.getStartButton();


        Scene scene = new Scene(startScreen, 1300, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Civilization Game");
        primaryStage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                    holder = StartScreen.getCivList().getSelectionModel()
                    .getSelectedItem();
                    primaryStage.setScene(startGame());
                    primaryStage.show();
                }
        });
    }


    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        TextInputDialog popUp = new TextInputDialog("Town"
            + "Name");
        popUp.setTitle("A New Settlement");
        popUp.setHeaderText("You have built a Settlement!");
        popUp.setContentText("Enter the Name of your first town: ");
        Optional<String> townName = popUp.showAndWait();
        if (townName.isPresent()) {
            switch (holder) {
            case ANCIENT_EGYPT:
                civ = new Egypt();
                break;
            case QIN_DYNASTY:
                civ = new QinDynasty();
                break;
            case ROMAN_EMPIRE:
                civ = new RomanEmpire();
                break;
            default:
                break;
            }
        }
        GameController.setCivilization(civ);
        GameScreen k = new GameScreen();
        Map.putSettlement(townName.toString(), GameController.
            getCivilization(), 0, 9);
        return new Scene(k);
    }

}