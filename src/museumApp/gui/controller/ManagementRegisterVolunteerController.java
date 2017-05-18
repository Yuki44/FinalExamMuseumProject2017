package museumApp.gui.controller;

import com.github.sarxos.webcam.Webcam;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.be.Volunteer;
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
    private Label regUploadPhotoLabel;
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
    private ComboBox<Volunteer> comboBoxNationality;
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
    private ComboBox<Guild> comboBoxFirstGuildSelection;
    @FXML
    private JFXButton buttonAddMoreManagersToGuild;
    @FXML
    private ImageView imgViewProfilePic;
    @FXML
    private Pane imgPane;
    @FXML
    private JFXButton buttonSaveInfo;
    @FXML
    private JFXButton buttonUseWebcam;
    @FXML
    private JFXButton buttonTakePhoto;
    Webcam webcam;
    BufferedImage webcamImage;

    /** -------------------------------------------------------------------------------------------. */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        initializeManagers();
        initializeGuilds();
      }

    public ManagementRegisterVolunteerController() throws IOException, SQLException
      {
        userModel = new UserModel();
      }

    /** --------------------------------------MANAGER-------------------------------------------. */
    /**
     * Managers in the tables.
     */
    public void initializeManagers()
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
      }

    public void initializeGuilds()
      {
        comboBoxFirstGuildSelection.setItems(userModel.getGuilds());
        comboBoxFirstGuildSelection.setCellFactory(new Callback<ListView<Guild>, ListCell<Guild>>()
          {
            @Override
            public ListCell<Guild> call(ListView<Guild> param)
              {
                return new ListCell<Guild>()
                  {
                    @Override
                    protected void updateItem(Guild guild, boolean empty)
                      {
                        super.updateItem(guild, empty);
                        if (guild == null || empty)
                        {
                            setGraphic(null);
                        }
                        else
                        {
                            setText(guild.getNameAsString());
                        }
                      }
                  };
              }
          });
      }

    public void initializeNationailities()
      {
      }

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

    /**
     * Removes the manager
     *
     * @param event
     * @throws SQLException
     */
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

    /**
     * Removes the Guild
     *
     * @param event
     */
    @FXML
    private void handleRemoveGuild(ActionEvent event)
      {
      }

    /**
     * When a guild is selected from the view then put its name into the text field
     *
     * @param event
     */
    @FXML
    private void handleSelectGuild(MouseEvent event)
      {
        if (event.getClickCount() == 1)
        {
            Guild selectedGuild = tblGuild.getSelectionModel().getSelectedItem();
            txtFieldAddGuildName.setText(selectedGuild.getNameAsString());
        }
      }

    /**
     * If you want to add more managers to the same guild.
     *
     * @param event
     */
    @FXML
    private void handleAddAnotherManager(ActionEvent event)
      {

      }

    /** --------------------------------------VOLUNTEER--------------------------------------------. */
    /**
     * Add new volunteers.
     *
     * @param event
     */
    @FXML
    private void handleAddVolunteer(ActionEvent event)
      {
        //TO DO
      }

    /** -------------------------------------------------------------------------------------------. */
    /** ----------------------------------GENERAL SETTINGS-----------------------------------------. */
    /**
     * Needed to Logout and go back to the ManagerLoginView
     * {There is in the MLV Initializer a method that sets the application as logged out)
     *
     * @param event
     */
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

    /**
     * This method accepts any kind of file when you drag over it
     *
     * @param event
     */
    @FXML
    private void handleDragOver(DragEvent event)
      {
        if (event.getDragboard().hasFiles())
        {
            event.acceptTransferModes(TransferMode.ANY);
        }
      }

    /**
     * This method gets the dropped image file, sets the ImageView with that image and removes the background of the pane on top of it.
     *
     * @param event
     * @throws FileNotFoundException
     */
    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException
      {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imgViewProfilePic.setImage(img);
        imgPane.setStyle("-fx-background-image: null");
      }

    /**
     * The standard upload of images
     *
     * @param event
     */
    @FXML
    private void handleUploadImage(MouseEvent event)
      {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.JPG", "*.jpg", "*.png", "*.JPEG", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null)
        {
            Image image = new Image(file.toURI().toString());
            imgViewProfilePic.setImage(image);
            imgPane.setStyle("-fx-background-image: null");
        }
      }

    /**
     * Clears the image and sets the background again.
     *
     * @param event
     */
    @FXML
    private void handleClearImage(ActionEvent event)
      {
        imgViewProfilePic.setImage(null);
        imgPane.setStyle("-fx-background-image: url(\"../img/dragAndDrop.png\")");
        imgPane.setStyle("-fx-background-size: stretch");
        imgPane.setStyle("-fx-background-repeat: stretch");
        imgPane.setStyle("-fx-background-position: center center");

      }

    @FXML
    protected void handleUseWebcam(ActionEvent event)
      {
        this.webcam = Webcam.getDefault();
        webcam.open();
      }

    @FXML
    private void handleTakePhoto(ActionEvent event)
      {
        if (webcam.isOpen())
        {
            this.webcamImage = webcam.getImage();
            Image myImage = SwingFXUtils.toFXImage(webcamImage, null); //convert to JavaFX image
            imgPane.setStyle("-fx-background-image: null");
            imgViewProfilePic.setImage(myImage); //show on ImageView
        }
      }

    /** -------------------------------------------------------------------------------------------. */
  }
