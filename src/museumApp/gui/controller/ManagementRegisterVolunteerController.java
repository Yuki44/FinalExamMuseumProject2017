/*
 * Erhvervsakademi Sydvest, Computer Science 2016-2017, Carlos F. Ognissanti
 * To change this header, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
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
    private ComboBox<?> regFromLocationComboBox;
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
    private JFXTextArea regCommentArea;
    @FXML
    private ComboBox<?> managementSetLocationButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        // TODO
      }

  }
