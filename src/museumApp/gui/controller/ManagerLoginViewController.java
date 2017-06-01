package museumApp.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
    private Employee employee = null;
    @FXML
    private ImageView imgLoading;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public ManagerLoginViewController() throws IOException
      {
        super();
        loginModel = new LoginModel();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        txtUserName.requestFocus();
        loginState = notLoggedIn; // Sets the program as not logged in.
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Method call to the login method below.
     *
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML
    private void handleLogin(ActionEvent event)
      {
        handleDisappearLabel();
        if (!txtPassword.getText().isEmpty() && !txtUserName.getText().isEmpty())
        {
            Runnable r = () ->
            {
                try
                {
                    Thread.sleep(3500);
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                Platform.runLater(() ->
                {
                    try
                    {
                        login();
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                });

            };
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.start();
            imgLoading.setVisible(true);
        }
        else
        {
            handleAppearWrongLoginLabel();
        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * When you click ENTER it will go to password field.
     *
     * @param event
     */
    @FXML
    private void handleGoToPassword(KeyEvent event)
      {
        if (event.getCode().equals(KeyCode.ENTER) && !txtUserName.getText().isEmpty())
        {
            txtPassword.requestFocus();
        }
        handleDisappearLabel();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * When you click ENTER it will login.
     *
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML
    private void handleGoToLogin(KeyEvent event)
      {
        handleDisappearLabel();
        if (event.getCode().equals(KeyCode.ENTER) && !txtPassword.getText().isEmpty() && !txtUserName.getText().isEmpty())
        {
            Runnable r = () ->
            {
                try
                {
                    Thread.sleep(3500);
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                Platform.runLater(() ->
                {
                    try
                    {
                        login();
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                });

            };
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.start();
            imgLoading.setVisible(true);
        }

      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method handles the login feature, It checks the text fields to determine
     * whether or not the username and the password is correct,
     * And then goes on to check whether the user is a manager of an
     * administrator.
     */
    private void login() throws IOException, SQLException
      {
        if (employee == null)
        {
            String username = txtUserName.getText().trim();
            String password = txtPassword.getText().trim();

            employee = loginModel.LoginChecker(username, password);
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
                stage.setScene(scene);
                stage.centerOnScreen();

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

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
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
        imgLoading.setVisible(false);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
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

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * It goes back to language selection when clicked.
     *
     * @param event
     */
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

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
