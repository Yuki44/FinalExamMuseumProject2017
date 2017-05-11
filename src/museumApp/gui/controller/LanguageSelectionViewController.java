package museumApp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class.
 *
 */
public class LanguageSelectionViewController extends Controller implements Initializable
  {

    @FXML
    private BorderPane borderPane;
    @FXML
    private GridPane mainGridPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
      }

    /** --------------------------------------GO TO DIFFERENT LANGUAGES-------------------------------------------------. */
    @FXML
    private void goToDanishView(MouseEvent event)
      {
        goToChooseVolunteerGuildView();
      }

    @FXML
    private void goToEnglishView(MouseEvent event)
      {
        goToChooseVolunteerGuildView();
      }

    @FXML
    private void goToGermanView(MouseEvent event)
      {
        goToChooseVolunteerGuildView();
      }

    /** ----------------------------------------------------------------------------------------------------------------. */
    /**
     * Goes to ChooseVolunteerGuildView.
     */
    private void goToChooseVolunteerGuildView()
      {
        try
        {
            /**
             * This commented out method works for setting the next fxml in the same scene
             * for a smoother transition, but need to be REFACTOR ed.
             */
//            BorderPane bPane = FXMLLoader.load(getClass().getResource("/museumApp/gui/view/ChooseVolunteerGuildView.fxml"));
//            borderPane.getChildren().setAll(bPane);

            Stage stage;
            Parent root;
            stage = (Stage) borderPane.getScene().getWindow();
            URL location = this.getClass().getResource("/museumApp/gui/view/ChooseVolunteerGuildView.fxml");
            FXMLLoader loader = new FXMLLoader(location);
            root = loader.load();
            Scene scene = new Scene(root);
            stage.hide();
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        }
        catch (IOException ex)
        {
            System.err.println(ex);
        }
      }

    /**
     * Goes to the ManagerLogin View
     *
     * @param event
     */
    @FXML
    private void goToManagerLogin(ActionEvent event)
      {
        try
        {
            Stage stage;
            Parent root;
            stage = (Stage) borderPane.getScene().getWindow();
            URL location = this.getClass().getResource("/museumApp/gui/view/ManagerLoginView.fxml");
            FXMLLoader loader = new FXMLLoader(location);
            root = loader.load();
            Scene scene = new Scene(root);
            stage.hide();
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        }
        catch (IOException ex)
        {
            System.err.println(ex);
        }
      }
    /** ----------------------------------------------------------------------------------------------------------------. */
  }
