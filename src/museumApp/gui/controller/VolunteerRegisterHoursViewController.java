package museumApp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VolunteerRegisterHoursViewController extends Controller implements Initializable
  {

    @FXML
    private BorderPane borderPane;
    @FXML
    private TextField setHoursLabel;
    @FXML
    private GridPane mainGridPane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        // TODO
      }

    @FXML
    private void goBackToGuildSelection(MouseEvent event)
      {
        try
        {
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

    @FXML
    private void goToFinalView(MouseEvent event)
      {
        /**
         * If the hours label is not empty then show an alert displaying how many
         * hours we input,
         * You can cancel or say "ok", if you say ok it displays a second alert
         * thanking you for your effort, and then goes to the main view.
         */
        if (!setHoursLabel.getText().isEmpty())
        {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("\nRingkøbing-Skjern Museum");
            alert.setHeaderText("You set " + setHoursLabel.getText().trim() + " hours.");
            alert.setContentText("\nAre you sure about this amount of hours?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                Alert congratsAlert = new Alert(AlertType.INFORMATION);
                congratsAlert.setTitle("\nRingkøbing-Skjern Museum");
                congratsAlert.setHeaderText("Thank you for your contribution to Ringkøbing-skjern museum!");
                congratsAlert.setContentText("\nHave a nice day!!");

                Optional<ButtonType> congratsResult = congratsAlert.showAndWait();
                if (congratsResult.get() == ButtonType.OK)
                {
                    try
                    {
                        Stage stage;
                        Parent root;
                        stage = (Stage) borderPane.getScene().getWindow();
                        URL location = this.getClass().getResource("/museumApp/gui/view/LanguageSelectionView.fxml");
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
                else
                {
                }
            }
            else
            {
                alert.close(); //If you press cancel on the first alert then it closes
            }
        }
      }

  }
