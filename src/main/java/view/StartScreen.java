package view;

// import model.Civilization;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
//import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {
    private static Button button;
    private static ListView<CivEnum> list;

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {

        Image image = new Image("File:./src/main/java/view/civ_background.png");
        ImageView imv = new ImageView();
        imv.setImage(image);

        ObservableList<CivEnum> names = FXCollections.observableArrayList(
            CivEnum.ANCIENT_EGYPT, CivEnum.QIN_DYNASTY, CivEnum.ROMAN_EMPIRE);
        this.list = new ListView<CivEnum>(names);
        this.button = new Button("START");

        list.setMaxHeight(100);
        list.setMaxWidth(200);

        VBox box = new VBox();
        box.setAlignment(Pos.BOTTOM_CENTER);
        box.getChildren().addAll(list, button);
        this.getChildren().add(imv);
        this.getChildren().add(box);


    }
    /**
    * gets the start button
    * @return the start button
    */
    public static Button getStartButton() {
        return button;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public static ListView<CivEnum> getCivList() {
        return list;
    }
}