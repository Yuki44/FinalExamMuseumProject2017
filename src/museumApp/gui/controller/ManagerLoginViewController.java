/*
 * Erhvervsakademi Sydvest, Computer Science 2016-2017, Carlos F. Ognissanti
 * To change this header, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import museumApp.be.Administrator;
import museumApp.be.Employee;
import museumApp.be.Manager;
import museumApp.gui.model.LoginModel;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class ManagerLoginViewController extends Controller implements Initializable
  {

    @FXML
    private BorderPane borderPane;
    @FXML
    private GridPane mainGridPane;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private Label lblWrongLogin;

    private static final int notLoggedIn = 1;
    private static final int loggedIn = 2;
    private static final int wrongPassword = 3;
    private int loginState;
    private final LoginModel loginModel;
    private Employee employee = null;

    public ManagerLoginViewController() throws IOException
      {
        this.loginModel = new LoginModel();
      }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        loginState = notLoggedIn;
      }

    /**
     * This method handles the login feature. It checks the text fields to determine
     * whether or not the username and the password is correct.
     * And then goes on to check whether the user is a manager of an
     * administrator.
     *
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML
    private void handleLogin(ActionEvent event) throws IOException, SQLException
      {
        login();
      }

    /**
     * When you click ENTER it will go to password field.
     *
     * @param event
     */
    @FXML
    private void handleGoToPassword(KeyEvent event)
      {
        handleDisappearLabel();
        if (event.getCode().equals(KeyCode.ENTER) && !txtUserName.getText().trim().isEmpty())
        {
            txtPassword.requestFocus();
        }
      }

    /**
     * When you click ENTER it will login.
     *
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML
    private void handleGoToLogin(KeyEvent event) throws IOException, SQLException
      {
        handleDisappearLabel();
        if (event.getCode().equals(KeyCode.ENTER) && !txtPassword.getText().trim().isEmpty() && !txtUserName.getText().trim().isEmpty())
        {
            login();
        }
      }

    private void login() throws IOException, SQLException
      {
        if (employee == null)
        {
            employee = loginModel.LoginChecker(txtUserName.getText().trim(), txtPassword.getText().trim());
        }
        if (loginState != loggedIn && employee != null)
        {
            if (employee.getClass() == Administrator.class)
            {
                loginState = loggedIn;
            }
            if (employee.getClass() == Manager.class)
            {
                loginState = loggedIn;
            }

            if (loginState == loggedIn)
            {
                try
                {
                    Stage stage;
                    Parent root;
                    URL location;
                    location = this.getClass().getResource("/museumApp/gui/view/ManagementRegisterVolunteer.fxml");
                    FXMLLoader loader;
                    loader = new FXMLLoader(location);
                    root = loader.load();
                    Scene scene;
                    scene = new Scene(root);
                    stage = (Stage) borderPane.getScene().getWindow();
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
            if (loginState != loggedIn && employee == null)
            {
                loginState = wrongPassword;
            }

        }
        else
        {
            handleAppearWrongLoginLabel();
        }
      }

    /**
     * If the password is wrong then the label will appear red.
     */
    private void handleAppearWrongLoginLabel()
      {
        txtUserName.setStyle("-jfx-focus-color:#FF1414");
        txtUserName.setStyle("-jfx-unfocus-color: #FF1414");
        txtPassword.setStyle("-jfx-unfocus-color:#FF1414");
        txtPassword.setStyle("-jfx-focus-color:#FF1414");
        lblWrongLogin.setText("This user ID or password is not recognized.");
      }

    /**
     * If the password is correct or the user is trying to change it then from red it will go back to grey.
     */
    private void handleDisappearLabel()
      {
        lblWrongLogin.setText(" ");
        txtUserName.setStyle("-jfx-unfocus-color: #4d4d4d");
        txtPassword.setStyle("-jfx-unfocus-color: #4d4d4d");
        txtUserName.setStyle("-jfx-focus-color: #757575");
        txtPassword.setStyle("-jfx-focus-color:#757575");
      }

    @FXML
    private void goBackToLanguageSelection(MouseEvent event)
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
