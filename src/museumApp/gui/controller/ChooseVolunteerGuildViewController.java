package museumApp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        guildListView.setItems(userModel.getGuilds());
        guildTblColName.setCellValueFactory(guild -> guild.getValue().getName()); //Lambda expression sets values into laug name column
        guildListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Guild>()
          {
            @Override
            public void changed(ObservableValue<? extends Guild> observable, Guild oldValue, Guild newValue)
              {
                volunterListView.setItems(userModel.getVolunteerFromGuild(newValue));
                StringProperty volunteerInTable = newValue.getName();
              }
          });
      }

    public ChooseVolunteerGuildViewController() throws IOException
      {
        userModel = new UserModel();
      }

    @FXML
    private void goToRegisterHoursView(MouseEvent event)
      {
        try
        {
            Stage stage;
            Parent root;
            stage = (Stage) borderPane.getScene().getWindow();
            URL location = this.getClass().getResource("/museumApp/gui/view/VolunteerRegisterHoursView.fxml");
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

  }
