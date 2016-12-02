package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
//import javafx.scene.control.ScrollPane;


/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private static VBox box;
    private static ResourcesMenu resourcesMenu;
    private static AbstractMenu abstractMenu;

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        box = new VBox();
        resourcesMenu = new ResourcesMenu();
        GridFX gridFX = GridFX.getInstance();
        abstractMenu = new AbstractMenu();

        this.setTop(resourcesMenu.getRootNode());
        this.setLeft(abstractMenu.getRootNode());
        this.setRight(gridFX);
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        resourcesMenu.update();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        //TODO
        return resourcesMenu;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    //NEUTRAL, MILITARY, WORKER, BUILDING, RECRUITING, ATTACKING, MOVING
    public static void switchMenu(GameController.GameState state) {
        switch (state) {
        case NEUTRAL:
            abstractMenu = new StatusMenu();
            break;
        case MILITARY:
            abstractMenu = new MilitaryMenu();
            break;
        case WORKER:
            abstractMenu = new WorkerMenu();
            break;
        case BUILDING:
            abstractMenu = new BuildingMenu();
            break;
        case RECRUITING:
            abstractMenu = new RecruitMenu();
            break;
        default:
            break;
        }
    }
}