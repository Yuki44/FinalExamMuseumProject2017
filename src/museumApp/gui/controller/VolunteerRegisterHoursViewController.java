package museumApp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import museumApp.be.Guild;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;
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
    private VolunteerTime vTime;
    private Guild guild;
    @FXML
    private Label lblGuildName;
    @FXML
    private Label lblVolunteerFullName;
    @FXML
    private Label lblJoinedDate;
    @FXML
    private ImageView next;
    @FXML
    private ImageView back;
    @FXML
    private ImageView volunteerImage;
    @FXML
    private Label memberSince;
    @FXML
    private Label howManyHoursSpend;
    @FXML
    private Label aproximateHours;

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
        BorderPane bPane;
        try
        {
            userModel.addTime(Date.valueOf(LocalDate.now()), Integer.parseInt(setHoursLabel.getText()), volunteer, guild);
            bPane = FXMLLoader.load(getClass().getResource("/museumApp/gui/view/ThankYouSplash.fxml"));
            borderPane.getChildren().setAll(bPane);
            /** ------------------------------------------------------------------------------------------ */
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), bPane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);
            fadeIn.play(); //Plays the transition
            /** ------------------------------------------------------------------------------------------ */
        }
        catch (IOException ex)
        {
            System.err.println(ex);
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
        {
            this.volunteer = volunteer;
            this.guild = guild;
            lblVolunteerFullName.setText(volunteer.getFullNameAsString());
            lblGuildName.setText(guild.getNameAsString());
            lblJoinedDate.setText(volunteer.getRegisteredDateAsString());
        }

      }

  }
