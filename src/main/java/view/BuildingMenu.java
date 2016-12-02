package view;

// import controller.GameController;
// import model.Building;
// import model.Settlement;
// import javafx.event.EventHandler;
// import javafx.event.ActionEvent;
/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        Button invest = new Button("INVEST");
        Button demolish = new Button("DEMOLISH");
        this.addMenuItem(invest);
        this.addMenuItem(demolish);

        // invest.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override public void handle(ActionEvent e) {
        //             GameController.
        //         }
        //     });

        // demolish.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override public void handle(ActionEvent e) {
        //             GameController.moving();
        //         }
        //     });
    }
}
