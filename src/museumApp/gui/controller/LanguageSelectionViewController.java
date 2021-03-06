package museumApp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
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
import javafx.util.Duration;

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
        /** ------------------------------------------------------------------------------------------ */
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.5), borderPane);
        fadeIn.setFromValue(0.1);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.play(); //Plays the transition
        /** ------------------------------------------------------------------------------------------ */
      }

    /** --------------------------------------GO TO DIFFERENT LANGUAGES-------------------------------------------------. */
    /**
     * Selects Danish as language
     *
     * @param event
     */
    @FXML
    private void goToDanishView(MouseEvent event)
      {
        super.loadLang("da", "Danish");
        goToChooseVolunteerGuildView();
      }

    /**
     * Selects English as language
     *
     * @param event
     */
    @FXML
    private void goToEnglishView(MouseEvent event)
      {
        super.loadLang("en", "English");
        goToChooseVolunteerGuildView();
      }

    /**
     * Selects German as language
     *
     * @param event
     */
    @FXML
    private void goToGermanView(MouseEvent event)
      {
        super.loadLang("de", "German");
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
            Stage stage;
            Parent root;
            stage = (Stage) borderPane.getScene().getWindow();
            URL location = this.getClass().getResource("/museumApp/gui/view/ChooseVolunteerGuildView.fxml");
            FXMLLoader loader = new FXMLLoader(location);
            root = loader.load();
            ChooseVolunteerGuildViewController chooseGuild = loader.getController();
            chooseGuild.lblStep1.setText(bundle.getString("lblStep1"));
            chooseGuild.lblStep2.setText(bundle.getString("lblStep2"));
            chooseGuild.guildTblColName.setText(bundle.getString("guildTblColName"));
            chooseGuild.volunteerTblColName.setText(bundle.getString("volunteerTblColName"));
            chooseGuild.getLanguageBundle(bundle);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            ResizeHelper.addResizeListener(stage);
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
            stage.setScene(scene);
            stage.centerOnScreen();
        }
        catch (IOException ex)
        {
            System.err.println(ex);
        }
      }

    /** ----------------------------------------------------------------------------------------------------------------. */
  }
