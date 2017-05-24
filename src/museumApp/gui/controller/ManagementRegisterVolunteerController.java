package museumApp.gui.controller;

import com.github.sarxos.webcam.Webcam;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.be.Nationality;
import museumApp.be.Volunteer;
import museumApp.dal.DropboxConnection;
import museumApp.gui.model.GuildModel;
import museumApp.gui.model.GuildVolunteerModel;
import museumApp.gui.model.ManagerModel;
import museumApp.gui.model.NationalityModel;
import museumApp.gui.model.VolunteerModel;

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
    private ComboBox<Nationality> comboBoxNationality;
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
    @FXML
    private Label lblWebcamOperation;
    private Webcam webcam;
    private BufferedImage webcamImage;
    private Dimension dimension = new Dimension(640, 480);
    BufferedImage takenImage;
    @FXML
    private Tab TbColumnFilterVolunteerId;
    @FXML
    private TextField txtLbFilterFName;
    @FXML
    private TextField txtLbFilterLName;
    @FXML
    private TextField txtLbFilterGuild;
    @FXML
    private TextField txtLbFilterFmTime;
    @FXML
    private TextField txtLbFilterToTime;
    @FXML
    private TextField txtLbFilterComment;
    @FXML
    private TableColumn<?, ?> tbViewVolunteerFilter;
    @FXML
    private TableColumn<?, ?> TbColumnFilterVolunteerFName;
    @FXML
    private TableColumn<?, ?> TbColumnFilterVolunteerLName;
    @FXML
    private TableColumn<?, ?> TbColumnFilterVolunteerGuild;
    @FXML
    private TableColumn<?, ?> TbColumnFilterVolunteerTel;
    @FXML
    private TableColumn<?, ?> TbColumnFilterVolunteerEmail;
    @FXML
    private TableColumn<?, ?> TbColumnFilterVolunteerComment;
    @FXML
    private TextField txtLbFilterHours;
    @FXML
    private TextField txtLbFilterTimeFName;
    @FXML
    private TextField txtLbFilterTimeLName;
    @FXML
    private TextField txtLbFilterTimeGuild;
    @FXML
    private JFXButton addManagerBTN;
    @FXML
    private JFXButton deleteManagerBTN;
    @FXML
    private TableView<Volunteer> volunteerTbl;
    @FXML
    private TableColumn<Volunteer, String> volunteerTblColFname;
    @FXML
    private TableColumn<Volunteer, String> volunteerTblColLname;
    @FXML
    private JFXTextField txtFieldSearchText;
    List<Volunteer> allVolunteersList;
    ObservableList<Volunteer> volunteerInfo;
    File myImageFile;
    @FXML
    private AnchorPane paneRegisterVtr;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private JFXTextField txtFieldAddVolunteerCity;
    @FXML
    private JFXTextField txtFieldAddVolunteerBirthdate;
    @FXML
    private JFXTextField txtFieldAddVolunteerAddress;
    @FXML
    private JFXTextField txtFieldAddVolunteerZipcode;
    @FXML
    private TextArea txtAreaAddVolunteerComment;
    @FXML
    private GridPane gridPaneRegVtr;
    @FXML
    private Label lblAddVtrSuccess;
    @FXML
    private Label lblFieldsRequired;
    @FXML
    private Label lblFieldRequiredStar;
    @FXML
    private JFXDatePicker addVtDatePicker;
    @FXML
    private TextField textLbSetHours;
    @FXML
    private Label lblJoinedGuild;

    /** -------------------------------------------------------------------------------------------. */
    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb)
      {
        initializeManagers();
        initializeGuilds();
        initializeNationailities();
        updateList();
        lblWebcamOperation.setText("Webcam is closed");
        lblWebcamOperation.setStyle("-fx-text-fill: #a04124;");
        txtFieldAddVolunteerFName.requestFocus();
        lblFieldsRequired.setText("");
        lblFieldRequiredStar.setText("");
//        getInfoFromList();
        handleSelectGuild();
        handleSelectManager();
        handleSelectVolunteer();
      }

    public ManagementRegisterVolunteerController() throws IOException
      {
        super();
        guildModel = new GuildModel();
        managerModel = new ManagerModel();
        volunteerModel = new VolunteerModel();
        nationalityModel = new NationalityModel();
        guildVolunteerModel = new GuildVolunteerModel();
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
        managerTbl.setItems(managerModel.getManagers());
        managerTblColFname.setCellValueFactory(manager -> manager.getValue().getFirstName());
        managerTblColLname.setCellValueFactory(manager -> manager.getValue().getLastName());
        comboBoxAddGuildManager.setItems(managerModel.getManagers());
        comboBoxAddGuildManager.setCellFactory((ListView<Manager> param) -> new ListCell<Manager>()
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
          });

      }

    public void initializeGuilds()
      {
        /**
         * We set the items on the guild table and with a lambda expression we set the individual
         * columns first name and last name.
         */
        tblGuild.setItems(guildModel.getGuilds());
        tblColGuildName.setCellValueFactory(guild -> guild.getValue().getName());
        tblColGuildManager.setCellValueFactory(guild -> guild.getValue().getManager().getFullName());
        comboBoxFirstGuildSelection.setItems(guildModel.getGuilds());
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
        comboBoxNationality.setItems(nationalityModel.getNationalities());
      }

    /**
     * When the Table View is selected it will display the info inside it to the
     * left side onto the text fields.
     *
     * @param event
     */
    private void handleSelectManager()
      {
        managerTbl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Manager>()
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
            public void changed(ObservableValue<? extends Manager> observable, Manager oldValue, Manager newValue)
              {
                Manager selectedManager = newValue;
                addTFNameTxtF.setText(selectedManager.getFirstNameAsString());
                addTLNameTxtF.setText(selectedManager.getLastNameAsString());
                addTEmailTxtF.setText(selectedManager.getEmailAsString());
                addTUNameTxtF.setText(selectedManager.getUserNameAsString());
                addTPassTxtF.setText(selectedManager.getPasswordAsString());
              }
          });

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
        managerModel.addManager(mg);
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
        Manager mg = managerTbl.getSelectionModel().getSelectedItem();
        if (mg != null)
        {
            managerModel.removeManager(mg);
            addTFNameTxtF.clear();
            addTLNameTxtF.clear();
            addTUNameTxtF.clear();
            addTPassTxtF.clear();
        }
      }

    /** -----------------------------------------GUILD--------------------------------------------. */
    /**
     * This method makes it possible to add a guild to the system.
     * And choose a manager for the guild.
     */
    @FXML
    private void handleAddingGuild(ActionEvent event) throws SQLException
      {
        String guildName = txtFieldAddGuildName.getText().trim();
        Manager manager = comboBoxAddGuildManager.getSelectionModel().getSelectedItem();
        Guild gd = new Guild(0, guildName, manager);
        guildModel.addGuild(gd);
        txtFieldAddGuildName.clear();

      }

    /**
     * Removes the Guild
     *
     * @param event
     */
    @FXML
    private void handleRemoveGuild(ActionEvent event) throws SQLException
      {
        Guild gd = tblGuild.getSelectionModel().getSelectedItem();
        if (gd != null)
        {
            guildModel.removeGuild(gd);
            txtFieldAddGuildName.clear();
        }

      }

    /**
     * When a guild is selected from the view then put its name into the text field
     *
     * @param event
     */
    private void handleSelectGuild()
      {
        tblGuild.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Guild>()
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
                Guild selectedGuild = newValue;
                txtFieldAddGuildName.setText(selectedGuild.getNameAsString());
                Manager guildManager = selectedGuild.getManager();
              }
          });
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
    private void handleAddVolunteer(ActionEvent event) throws IOException, SQLException
      {
        if (!txtFieldAddVolunteerFName.getText().isEmpty() && !txtFieldAddVolunteerLName.getText().isEmpty()
                && !comboBoxNationality.getSelectionModel().getSelectedItem().getCountryAsString().isEmpty()
                && !regJoinedDatePicker.getValue().toString().isEmpty())
        {
            String firstName = txtFieldAddVolunteerFName.getText().trim();
            String lastName = txtFieldAddVolunteerLName.getText().trim();
            String fullName = firstName + lastName;
            String phoneNumber = txtFieldAddVolunteerPhoneNum.getText().trim();
            String email = txtFieldAddVolunteerEmail.getText().trim();
            LocalDate localDate = regJoinedDatePicker.getValue();
            Date registeredDate = java.sql.Date.valueOf(localDate);
            String nationality = comboBoxNationality.getSelectionModel().getSelectedItem().getCountryAsString();
            String city = txtFieldAddVolunteerCity.getText().trim();
            String address = txtFieldAddVolunteerAddress.getText().trim();
            String birthDate = txtFieldAddVolunteerBirthdate.getText().trim();
            String zipCode = txtFieldAddVolunteerZipcode.getText().trim();
            String comment = txtAreaAddVolunteerComment.getText().trim();
            String country = comboBoxNationality.getSelectionModel().getSelectedItem().getCountryAsString();
            String photo = null;
            if (takenImage != null)
            {
                DropboxConnection dbc = new DropboxConnection();
                photo = fullName + LocalDate.now() + "_" + System.currentTimeMillis() + ".png";
                myImageFile = new File(dbc.getVolunteerImgFilePath(), photo);
                ImageIO.write(takenImage, "PNG", myImageFile);
            }
            Volunteer vtr = new Volunteer(0, firstName, lastName, birthDate, phoneNumber, email,
                    nationality, registeredDate, photo, comment, address, city, zipCode, country);
            Guild guild = comboBoxFirstGuildSelection.getSelectionModel().getSelectedItem();
            if (guild != null)
            {
                System.out.println("Guild: " + guild.getId());
                System.out.println("Volunteer: " + vtr.getId());
//                GuildVolunteer gv = new GuildVolunteer(guild, vtr);
//                guildVolunteerModel.addGuildVolunteer(gv); 
            }
//            volunteerModel.addVolunteer(vtr);
            lblFieldsRequired.setText("");
            lblFieldRequiredStar.setText("");
            updateList();
            lblAddVtrSuccess.setText(firstName + " " + lastName + " saved!");
            clearFields();
        }
        else
        {
            lblFieldsRequired.setText("Fields required:");
            lblFieldRequiredStar.setText("*");
        }
      }

    public void clearFields()
      {
        txtFieldAddVolunteerFName.clear();
        txtFieldAddVolunteerLName.clear();
        txtFieldAddVolunteerPhoneNum.clear();
        txtFieldAddVolunteerEmail.clear();
        regJoinedDatePicker.setValue(null);
        comboBoxNationality.getSelectionModel().clearSelection();
        txtFieldAddVolunteerCity.clear();
        txtFieldAddVolunteerAddress.clear();
        txtFieldAddVolunteerBirthdate.clear();
        txtFieldAddVolunteerZipcode.clear();
        txtAreaAddVolunteerComment.clear();
        comboBoxFirstGuildSelection.getSelectionModel().clearSelection();
        imgViewProfilePic.setImage(null);
        imgPane.setStyle("-fx-background-image: url(\"../img/dragAndDrop.png\")");
        imgPane.setStyle("-fx-background-size: stretch");
        imgPane.setStyle("-fx-background-repeat: stretch");
        imgPane.setStyle("-fx-background-position: center center");
        /** ------------------------------------------------------------------------------------------ */
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(4), lblAddVtrSuccess);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);
        fadeOut.play(); //Plays the transition
        /** ------------------------------------------------------------------------------------------ */
      }

    @FXML
    private void handleAddMoreVtrInfo(ActionEvent event) throws IOException
      {
        paneRegisterVtr.setLeftAnchor(anchorpane, 0.0);
        gridPaneRegVtr.setVisible(false);
        /** ------------------------------------------------------------------------------------------ */
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), anchorpane);
        fadeIn.setFromValue(0.1);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.play(); //Plays the transition
        /** ------------------------------------------------------------------------------------------ */
      }

    @FXML
    private void handleGoToNecessaryInfo(ActionEvent event)
      {
        paneRegisterVtr.setLeftAnchor(anchorpane, -900.0);
        gridPaneRegVtr.setVisible(true);
        txtFieldAddVolunteerFName.requestFocus();
        /** ------------------------------------------------------------------------------------------ */
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), gridPaneRegVtr);
        fadeIn.setFromValue(0.1);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.play(); //Plays the transition
        /** ------------------------------------------------------------------------------------------ */
      }

    private void handleSelectVolunteer()
      {
        volunteerTbl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Volunteer>()
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
            public void changed(ObservableValue<? extends Volunteer> observable, Volunteer oldValue, Volunteer newValue)
              {
                Volunteer selectedVolunteer = newValue;
                txtFieldSearchText.setText(selectedVolunteer.getFullNameAsString());
              }
          });

      }

    /** -------------------------------------------------------------------------------------------. */
    /** ----------------------------------MANAGER REGISTER VTR HOURS-----------------------------------------. */
//    public void getInfoFromList()
//      {
//        volunteerTbl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Volunteer>()
//          {
//            /**
//             * Creates an observable list of the volunteers contained in the chosen guild.
//             * Which is then shown in the volunteer list with their full names diplayed.
//             *
//             * @param observable
//             * @param oldValue
//             * @param newValue
//             */
//            @Override
//            public void changed(ObservableValue<? extends Volunteer> observable, Volunteer oldValue, Volunteer newValue)
//              {
//
//              }
//          });
//      }
    public void updateList()
      {
        allVolunteersList = new ArrayList<>();
        try
        {
            allVolunteersList.addAll(volunteerModel.getVolunteers());
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
        volunteerInfo = FXCollections.observableArrayList(allVolunteersList);
        volunteerListViewColumns();
      }

    private void volunteerListViewColumns()
      {
        volunteerTbl.setItems(volunteerInfo);
        volunteerTblColFname.setCellValueFactory(volunteer -> volunteer.getValue().getFirstName());
        volunteerTblColLname.setCellValueFactory(volunteer -> volunteer.getValue().getLastName());
      }

    @FXML
    private void handleSearchOnInput(KeyEvent event)
      {
        try
        {
            String query = txtFieldSearchText.getText().trim();
            if (query.isEmpty())
            {
                volunteerInfo.clear();
                volunteerInfo.addAll(allVolunteersList);
            }
            else
            {
                List<Volunteer> searchResults = new ArrayList<>();
                for (Volunteer vtrs : allVolunteersList)
                {
                    String volunteerFirstName = vtrs.getFirstNameAsString().toLowerCase();
                    String volunteerLastName = vtrs.getLastNameAsString().toLowerCase();
                    String volunteerEmail = vtrs.getEmailAsString().toLowerCase();
                    String volunteerNationality = vtrs.getNationality().get().toLowerCase();
                    String volunteerPhoneNumber = vtrs.getPhoneNumber().get().toLowerCase();
                    String volunteerCity = vtrs.getCity().get().toLowerCase();
                    String volunteerZipcode = vtrs.getZipCode().get().toLowerCase();
                    if (volunteerFirstName.contains(query.toLowerCase())
                            || volunteerLastName.contains(query.toLowerCase())
                            || volunteerEmail.contains(query.toLowerCase())
                            || volunteerNationality.contains(query.toLowerCase())
                            || volunteerPhoneNumber.contains(query.toLowerCase())
                            || volunteerCity.contains(query.toLowerCase())
                            || volunteerZipcode.contains(query.toLowerCase()))
                    {
                        searchResults.add(vtrs);
                    }

                }
                volunteerInfo.clear();
                volunteerInfo.addAll(searchResults);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

      }

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
        if (!webcam.isOpen())
        {
            webcam.setViewSize(dimension);
        }
        if (webcam != null)
        {
            webcam.open();
            System.out.println("Webcam found...");

            if (webcam.isOpen())
            {
                lblWebcamOperation.setText("Webcam is working");
                lblWebcamOperation.setStyle("-fx-text-fill: #4b9e40;");
            }
        }
      }

    @FXML
    private void handleTakePhoto(ActionEvent event)
      {
        try
        {
            if (webcam.isOpen())
            {

                this.webcamImage = webcam.getImage();
                Image myImage = SwingFXUtils.toFXImage(webcamImage, null); //convert to JavaFX image
                imgPane.setStyle("-fx-background-image: null");
                imgViewProfilePic.setImage(myImage); //show on ImageView
                this.takenImage = webcam.getImage();

            }
        }
        catch (Exception ex)
        {
            System.err.println("Must open webcam first!");
        }
      }

    @FXML
    private void handleCloseWebcam(ActionEvent event)
      {
        try
        {
            webcam.close();
            lblWebcamOperation.setText("Webcam is closed");
            lblWebcamOperation.setStyle("-fx-text-fill: #a04124;");
        }
        catch (Exception ex)
        {
            System.err.println("Webcam hasn't been opened");
        }
      }

    @FXML
    private void handleFilterVol(ActionEvent event)
      {

      }

    @FXML
    private void handleFilterTime(ActionEvent event)
      {

      }

    @FXML
    private void handleFocusOnSearch(Event event)
      {
        txtFieldSearchText.requestFocus();
      }

    @FXML
    private void handleManagerAddHour(ActionEvent event) throws IOException
      {

        LocalDate localDate = addVtDatePicker.getValue();
        Date date = java.sql.Date.valueOf(localDate);
        int hours = Integer.parseInt(textLbSetHours.getText().trim());

      }

    /** -------------------------------------------------------------------------------------------. */
  }
