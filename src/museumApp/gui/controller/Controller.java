package museumApp.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import museumApp.gui.model.UserModel;

public abstract class Controller
  {

    //This is necessary for the mouse click location
    double xMouse;
    double yMouse;
    @FXML
    protected BorderPane borderPane;
    @FXML
    protected GridPane mainGridPane;
    protected UserModel userModel;

    /** ----------------------------------------------------------------------------------------------------------------. */
    /**
     * Minimizes the view into the taskbar
     *
     * @param event
     */
    @FXML
    protected void handleMinimize(ActionEvent event)
      {
        Stage stage;
        stage = (Stage) mainGridPane.getScene().getWindow();
        stage.setIconified(true);
      }

    /**
     * Maximizes the view into fullscreen
     *
     * @param event
     */
    @FXML
    protected void handleMaximize(ActionEvent event)
      {
        Stage stage;
        stage = (Stage) mainGridPane.getScene().getWindow();
        if (!stage.isMaximized())
        {
            stage.setMaximized(true);
        }
        else
        {
            stage.setMaximized(false);
        }
      }

    /**
     * Exits the application
     *
     * @param event
     */
    @FXML
    protected void handleExit(ActionEvent event)
      {
        System.exit(0);
      }

    /** ----------------------Everything from here is for the custom window decoration------------------------------. */
    /**
     * When you drag the window it gets small
     *
     * @param event
     */
    @FXML
    protected void getXYForMouseDrag(MouseEvent event)
      {
        Stage stage;
        stage = (Stage) mainGridPane.getScene().getWindow();
        if (stage.isMaximized())
        {
            stage.setMaximized(false);
        }
        double x = event.getScreenX();
        double y = event.getScreenY();
        Scene scene = mainGridPane.getScene();
        Window window = scene.getWindow();
        window.setX(x - xMouse);
        window.setY(y - yMouse);
      }

    /**
     * Gets the location of the click
     *
     * @param event
     */
    @FXML
    protected void getXYClickLocation(MouseEvent event)
      {
        xMouse = event.getX();
        yMouse = event.getY();
        Stage stage;
        stage = (Stage) mainGridPane.getScene().getWindow();
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2)
        {
            stage.setMaximized(false);
        }
      }
    /** -------------------------------------------------------------------------------------------------------------------------. */

  }
