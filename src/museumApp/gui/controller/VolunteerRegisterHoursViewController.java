package museumApp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import museumApp.be.Guild;
import museumApp.be.Volunteer;
import museumApp.gui.model.UserModel;

public class VolunteerRegisterHoursViewController extends Controller implements Initializable
  {

    @FXML
    private BorderPane borderPane;
    @FXML
    private TextField setHoursLabel;
    @FXML
    private GridPane mainGridPane;

    private UserModel userModel;
    private Volunteer volunteer;
    private Guild guild;
    @FXML
    private Label lblGuildName;
    @FXML
    private Label lblVolunteerFullName;
    @FXML
    private Label lblJoinedDate;

    public VolunteerRegisterHoursViewController() throws IOException, SQLException
      {
        this.userModel = new UserModel();
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

    /** ---------------------------------------------------------------------------------------------------------------------------. */
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
                /**
                 * TODO: create the add function so that when the user presses "OK" he/she confirmes the amount of
                 * hours he/she wants to register.
                 * It should be inside this if statement.
                 */
                userModel.addTime();
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

    /**
     * THIS CODE HAS TO BE PUT(or refactored)
     * INTO A NEW MODEL THAT IS NOT "userModel"
     *
     * @param volunteer
     * @param guild
     */
    public void setVolunteer(Volunteer volunteer, Guild guild)
      {
        this.volunteer = volunteer;
        this.guild = guild;
        lblVolunteerFullName.setText(volunteer.getFullNameAsString());
        lblGuildName.setText(guild.getNameAsString());
        lblJoinedDate.setText(volunteer.getRegisteredDateAsString());
      }

  }
