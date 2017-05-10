package museumApp.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.gui.model.UserModel;

public class ManagementRegisterVolunteerController extends Controller implements Initializable
  {

    @FXML
    private BorderPane borderPane;
    @FXML
    private GridPane mainGridPane;
    @FXML
    private JFXDatePicker regJoinedDatePicker;
    @FXML
    private JFXButton clearFieldsButton;
    @FXML
    private JFXButton saveInfoButton;
    @FXML
    private ComboBox<?> firstGuildSelectionComboBox;
    @FXML
    private JFXButton addExtraGuildButton;
    @FXML
    private Label regUploadPhotoLabel;
    @FXML
    private JFXButton chooseImageButton;
    @FXML
    private JFXButton uploadImageButton;
    @FXML
    private JFXTextField addTFNameTxtF;
    @FXML
    private JFXTextField addTLNameTxtF;
    @FXML
    private JFXTextField addTEmailTxtF;
    @FXML
    private JFXTextField addTUNameTxtF;
    @FXML
    private JFXTextField addTPassTxtF;
    @FXML
    private JFXButton addManagerBTN;
    @FXML
    private JFXButton deleteManagerBTN;
    @FXML
    private TableView<Manager> managerTbl;
    @FXML
    private TableColumn<Manager, String> managerTblColFname;
    @FXML
    private TableColumn<Manager, String> managerTblColLname;
    @FXML
    private JFXTextField txtFieldAddGuildName;
    @FXML
    private ComboBox<Manager> comboBoxAddGuildManager;
    @FXML
    private TableColumn<Guild, String> tblColGuildName;
    @FXML
    private TableColumn<Guild, String> tblColGuildManager;
    @FXML
    private TableView<Guild> tblGuild;
    @FXML
    private JFXTextField txtFieldAddVolunteerPhoneNum;
    @FXML
    private JFXTextField txtFieldAddVolunteerFName;
    @FXML
    private JFXTextField txtFieldAddVolunteerLName;
    @FXML
    private JFXTextField txtFieldAddVolunteerEmail;
    @FXML
    private JFXTextArea txtAreaAddVolunteerComment;

    /** -------------------------------------------------------------------------------------------. */
    /**
     * We initialize the view.
     */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        /**
         * We set the items on the manager table and with a lambda expression we set the individual
         * columns first name and last name.
         */
        managerTbl.setItems(userModel.getManagers());
        managerTblColFname.setCellValueFactory(manager -> manager.getValue().getFirstName());
        managerTblColLname.setCellValueFactory(manager -> manager.getValue().getLastName());
        /**
         * We set the items on the guild table and with a lambda expression we set the individual
         * columns first name and last name.
         */
        tblGuild.setItems(userModel.getGuilds());
        tblColGuildName.setCellValueFactory(guild -> guild.getValue().getName());

        comboBoxAddGuildManager.setItems(userModel.getManagers());
        comboBoxAddGuildManager.setCellFactory(new Callback<ListView<Manager>, ListCell<Manager>>()
          {
            @Override
            public ListCell<Manager> call(ListView<Manager> param)
              {
                return new ListCell<Manager>()
                  {
                    @Override
                    protected void updateItem(Manager manager, boolean empty)
                      {
                        super.updateItem(manager, empty);
                        if (manager == null || empty)
                        {
                            setGraphic(null);
                        }
                        else
                        {
                            setText(manager.getFullNameAsString());
                        }
                      }
                  };
              }
          });
//        tblColGuildManager.setCellValueFactory(guild -> guild.getValue().getManagerName());
      }

    public ManagementRegisterVolunteerController() throws IOException, SQLException
      {
        userModel = new UserModel();
      }

    /** --------------------------------------MANAGER-------------------------------------------. */
    /**
     * We make the register manager methods.
     */
    /**
     * When the Table View is selected it will display the info inside it to the
     * left side onto the text fields.
     *
     * @param event
     */
    @FXML
    private void handleSelectManager(MouseEvent event)
      {
        if (event.getClickCount() == 1)
        {
            Manager selectedManager = managerTbl.getSelectionModel().getSelectedItem();
            addTFNameTxtF.setText(selectedManager.getFirstNameAsString());
            addTLNameTxtF.setText(selectedManager.getLastNameAsString());
            addTEmailTxtF.setText(selectedManager.getEmailAsString());
            addTUNameTxtF.setText(selectedManager.getUserNameAsString());
            addTPassTxtF.setText(selectedManager.getPasswordAsString());
        }
      }

    /**
     * We click the "add" button for registering managers.
     *
     * @param event
     */
    @FXML
    private void handleAddingManager(ActionEvent event) throws SQLException
      {
        /**
         * We get the text in the fields as strings.
         */
        String fName = addTFNameTxtF.getText().trim();
        String lName = addTLNameTxtF.getText().trim();
        String email = addTEmailTxtF.getText().trim();
        String username = addTUNameTxtF.getText().trim();
        String password = addTPassTxtF.getText().trim();
        Manager mg = new Manager(0, fName, lName, email, username, password);
        userModel.addManager(mg);
        addTFNameTxtF.clear();
        addTLNameTxtF.clear();
        addTEmailTxtF.clear();
        addTUNameTxtF.clear();
        addTPassTxtF.clear();
      }

    @FXML
    private void handleRemoveManager(ActionEvent event) throws SQLException
      {

      }

    /** -----------------------------------------GUILD--------------------------------------------. */
    /**
     * We make the Register Guild methods.
     */
    @FXML
    private void handleAddingGuild(ActionEvent event) throws SQLException
      {
        String guildName = txtFieldAddGuildName.getText().trim();
        Guild gd = new Guild(0, guildName, 0);
        userModel.addGuild(gd);
        txtFieldAddGuildName.clear();
        //TO DO
      }

    @FXML
    private void handleRemoveGuild(ActionEvent event)
      {
      }

    @FXML
    private void handleSelectGuild(MouseEvent event)
      {
        if (event.getClickCount() == 1)
        {
            Guild selectedGuild = tblGuild.getSelectionModel().getSelectedItem();
            txtFieldAddGuildName.setText(selectedGuild.getNameAsString());
        }
      }

    @FXML
    private void handleAddAnotherManager(ActionEvent event)
      {

      }

    /** --------------------------------------VOLUNTEER--------------------------------------------. */
    @FXML
    private void handleAddVolunteer(ActionEvent event)
      {
        //TO DO
      }

    @FXML
    private void clearAllFields(ActionEvent event)
      {
      }

    @FXML
    private void addExtraGuild(ActionEvent event)
      {
      }

    /** -------------------------------------------------------------------------------------------. */
    /** ----------------------------------GENERAL SETTINGS-----------------------------------------. */
    @FXML
    private void handleLogout(ActionEvent event)
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

    /** -------------------------------------------------------------------------------------------. */
  }
