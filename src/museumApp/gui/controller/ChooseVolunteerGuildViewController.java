package museumApp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import museumApp.be.Guild;
import museumApp.be.Volunteer;
import museumApp.gui.model.UserModel;

public class ChooseVolunteerGuildViewController extends Controller implements Initializable
  {

    @FXML
    private TableView<Guild> guildListView;
    @FXML
    private TableView<Volunteer> volunterListView;
    @FXML
    private BorderPane borderPane;
    @FXML
    private GridPane mainGridPane;
    @FXML
    private TableColumn<Guild, String> guildTblColName;
    @FXML
    private TableColumn<Volunteer, String> volunteerTblColName;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        /**
         * Initializes the Guild listView.
         */
        guildListView.setItems(userModel.getGuilds());
        guildTblColName.setCellValueFactory(guild -> guild.getValue().getName()); //Lambda expression sets values into laug name column
        listGenerator();
      }

    /**
     * Constructor
     *
     * @throws IOException
     */
    public ChooseVolunteerGuildViewController() throws IOException, SQLException
      {
        userModel = new UserModel(); // New userModel Instance
      }

    /** ----------------------------------------------------------------------------------------------------------------. */
    /**
     * We create the Volunteer listView after selecting the guild.
     */
    public void listGenerator()
      {
        guildListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Guild>()
          {
            /**
             * Creates an observable list of the volunteers contained in the chosen guild.
             * Which is then shown in the volunteer list with their full names diplayed.
             *
             * @param observable
             * @param oldValue
             * @param newValue
             */
            @Override
            public void changed(ObservableValue<? extends Guild> observable, Guild oldValue, Guild newValue)
              {
                ObservableList<Volunteer> volunteerList = FXCollections.observableArrayList();
                volunteerList.addAll(userModel.getVolunteerFromGuild(newValue));
                volunterListView.setItems(volunteerList);
                volunteerTblColName.setCellValueFactory(volunteer -> volunteer.getValue().getFullName());
              }
          });
      }

    /**
     * If the volunteer has been selected we go to the next view.
     *
     * @param event
     */
    @FXML
    private void goToRegisterHoursView(MouseEvent event)
      {
        try
        {
            Volunteer volunteerSelected = volunterListView.getSelectionModel().getSelectedItem();
            Guild guildSelected = guildListView.getSelectionModel().getSelectedItem();
            if (volunteerSelected != null && guildSelected != null)
            {
                Stage stage;
                Parent root;
                stage = (Stage) borderPane.getScene().getWindow();
                URL location = this.getClass().getResource("/museumApp/gui/view/VolunteerRegisterHoursView.fxml");
                FXMLLoader loader = new FXMLLoader(location);
                root = loader.load();
                /** -------------------------------------------REFACTOR START-------------------------------------------. */
                /* It should pass the value to the method in model of the next controller not to the controller directly */
                VolunteerRegisterHoursViewController vrhvc = loader.getController();
                vrhvc.setVolunteer(volunteerSelected, guildSelected);
                /** --------------------------------------------REFACTOR END-------------------------------------------. */
                Scene scene = new Scene(root);
                stage.hide();
                stage.setScene(scene);
                stage.show();
                stage.centerOnScreen();
            }
        }
        catch (IOException ex)
        {
            System.err.println(ex);
        }
      }

    /**
     * Just a method that goes to the Language selection view
     *
     * @param event
     */
    @FXML
    private void goToLanguageSelection(MouseEvent event)
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
    /** ----------------------------------------------------------------------------------------------------------------. */
  }
