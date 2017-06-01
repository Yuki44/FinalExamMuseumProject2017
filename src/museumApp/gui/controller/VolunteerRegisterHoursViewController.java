package museumApp.gui.controller;

import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import museumApp.be.Guild;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;
import museumApp.dal.DropboxConnection;
import museumApp.gui.model.GuildModel;
import museumApp.gui.model.TimeModel;
import museumApp.gui.model.VolunteerModel;

public class VolunteerRegisterHoursViewController extends Controller implements Initializable
  {

    @FXML
    private BorderPane borderPane;
    @FXML
    private TextField setHoursLabel;
    @FXML
    private GridPane mainGridPane;

    private Volunteer volunteer;
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
    private ImageView imgVolunteer;
    @FXML
    public Label lblGuild;
    @FXML
    public Label lblMemberSince;
    @FXML
    public Label lblHowManyHoursSpend;
    @FXML
    public Label lblAproximateHours;
    @FXML
    private ImageView imgNationalityFlag;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public VolunteerRegisterHoursViewController() throws IOException
      {
        super();
        volunteerModel = new VolunteerModel();
        guildModel = new GuildModel();

      }

    /**
     * Initializer
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
      }

    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Handles the "back" button.
     *
     * @param event
     */
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
            ChooseVolunteerGuildViewController chooseGuild = loader.getController();
            chooseGuild.lblStep1.setText(bundle.getString("lblStep1"));
            chooseGuild.lblStep2.setText(bundle.getString("lblStep2"));
            chooseGuild.guildTblColName.setText(bundle.getString("guildTblColName"));
            chooseGuild.volunteerTblColName.setText(bundle.getString("volunteerTblColName"));
            chooseGuild.getLanguageBundle(bundle);
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
     * Handles the "next" button
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    private void goToFinalView(MouseEvent event) throws SQLException
      {
        if (!setHoursLabel.getText().isEmpty())
        {
            try
            {
                timeModel = new TimeModel();
                VolunteerTime vTime = new VolunteerTime(Date.valueOf(LocalDate.now()), Integer.parseInt(setHoursLabel.getText()), volunteer, guild);
                timeModel.addVolunteerTime(vTime);

                Stage stage;
                Parent root;
                stage = (Stage) borderPane.getScene().getWindow();
                URL location = this.getClass().getResource("/museumApp/gui/view/ThankYouSplash.fxml");
                FXMLLoader loader = new FXMLLoader(location);
                root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                ThankYouSplashController tys = loader.getController();
                tys.lblThankYouFor.setText(bundle.getString("lblThankYouFor"));
                tys.lblHaveANiceDay.setText(bundle.getString("lblHaveANiceDay"));
                /** ------------------------------------------------------------------------------------------ */
                FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), root);
                fadeIn.setFromValue(0.1);
                fadeIn.setToValue(1);
                fadeIn.setCycleCount(1);
                fadeIn.play(); //Plays the transition
                /** ------------------------------------------------------------------------------------------ */
            }
            catch (IOException ex)
            {
                System.err.println(ex.getCause());
            }
        }
      }

    /**
     * Gets the volunteer from the previous controller and sets its info
     *
     * @param volunteer
     * @param guild
     */
    public void setVolunteer(Volunteer volunteer, Guild guild) throws IOException
      {
        {
            DropboxConnection dbc = new DropboxConnection();
            this.volunteer = volunteer;
            this.guild = guild;
            lblVolunteerFullName.setText(volunteer.getFullNameAsString());
            lblGuildName.setText(guild.getNameAsString());
            lblJoinedDate.setText(volunteer.getRegisteredDateAsString());
            String photoName = volunteer.getPhotoAsString();
            String photoPath = dbc.getVolunteerImgFilePath();
            if (photoName != null)
            {
                String absoluteImgPath = (photoPath + "\\" + photoName);
                System.out.println(absoluteImgPath);
                File file = new File(absoluteImgPath);
                Image img = new Image(file.toURI().toString());
                imgVolunteer.setImage(img);
            }
            else
            {
                String userNoImgPath = (photoPath + "\\" + "user" + ".png");
                System.out.println(userNoImgPath);
                File file = new File(userNoImgPath);
                Image img = new Image(file.toURI().toString());
                imgVolunteer.setImage(img);
            }

            String natPhotoPath = dbc.getNationalityImgFilePath() + "\\" + volunteer.getCountryAsString().toLowerCase() + ".png";
            File natFile = new File(natPhotoPath);
            Image natImg = new Image(natFile.toURI().toString());
            imgNationalityFlag.setImage(natImg);
        }

      }

    void getLanguageBundle(ResourceBundle bundle)
      {
        this.bundle = bundle;
      }

  }
