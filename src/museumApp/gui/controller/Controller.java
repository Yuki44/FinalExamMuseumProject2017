package museumApp.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import museumApp.main.MuseumApp;

public abstract class Controller implements Initializable
  {

    //This is necessary for the mouse click location
    double xMouse;
    double yMouse;
    @FXML
    protected BorderPane borderPane;
    @FXML
    private GridPane mainGridPane;
    protected MuseumApp mainApp;

    @FXML
    private void handleMinimize(ActionEvent event)
      {
        Stage stage;
        stage = (Stage) mainGridPane.getScene().getWindow();
        stage.setIconified(true);
      }

    @FXML
    private void handleMaximize(ActionEvent event)
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

    @FXML
    private void handleExit(ActionEvent event)
      {
        System.exit(0);
      }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
      }

    /** --------------------------------------------------------------------------------------- */
    /**
     * Everything from here is for the custom window decoration.
     */
    @FXML
    private void getXYForMouseDrag(MouseEvent event)
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

    @FXML
    private void getXYClickLocation(MouseEvent event)
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
    /** --------------------------------------------------------------------------------------- */

  }
