package museumApp.gui.controller;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import museumApp.gui.model.AdminModel;
import museumApp.gui.model.EmployeeModel;
import museumApp.gui.model.GuildModel;
import museumApp.gui.model.GuildVolunteerModel;
import museumApp.gui.model.LoginModel;
import museumApp.gui.model.ManagerModel;
import museumApp.gui.model.NationalityModel;
import museumApp.gui.model.PrintModel;
import museumApp.gui.model.TimeModel;
import museumApp.gui.model.VolunteerModel;

public abstract class Controller
  {

    double xMouse;
    double yMouse;
    protected Locale locale;
    protected TimeModel timeModel;
    protected AdminModel adminModel;
    protected GuildModel guildModel;
    @FXML
    protected BorderPane borderPane;
    @FXML
    protected GridPane mainGridPane;
    protected ResourceBundle bundle;
    protected LoginModel loginModel;
    protected ManagerModel managerModel;
    protected VolunteerModel volunteerModel;
    protected EmployeeModel employeeModel;
    protected NationalityModel nationalityModel;
    protected GuildVolunteerModel guildVolunteerModel;
    protected PrintModel printModel;

    /** ----------------------------------------------------------------------------------------------------------------. */
    /**
     * Minimizes the view into the taskbar
     *
     * @param event
     */
    @FXML
    protected void handleMinimize(ActionEvent event)
      {
        Stage stage;
        stage = (Stage) mainGridPane.getScene().getWindow();
        stage.setIconified(true);
      }

    /**
     * Maximizes the view into fullscreen
     *
     * @param event
     */
    @FXML
    protected void handleMaximize(ActionEvent event)
      {
        Stage stage;
        stage = (Stage) mainGridPane.getScene().getWindow();
        if (!stage.isMaximized())
        {
            stage.setMaximized(true);
        }
        else
        {
            stage.setMaximized(false);
        }
      }

    /**
     * Exits the application
     *
     * @param event
     */
    @FXML
    protected void handleExit(ActionEvent event)
      {
        System.exit(0);
      }

    /** ----------------------Everything from here is for the custom window decoration------------------------------. */
    /**
     * When you drag the window it gets small
     *
     * @param event
     */
    @FXML
    protected void getXYForMouseDrag(MouseEvent event)
      {
        Stage stage;
        stage = (Stage) mainGridPane.getScene().getWindow();
        if (stage.isMaximized())
        {
            stage.setMaximized(false);
        }
        double x = event.getScreenX();
        double y = event.getScreenY();
        Scene scene = mainGridPane.getScene();
        Window window = scene.getWindow();
        window.setX(x - xMouse);
        window.setY(y - yMouse);
      }

    /**
     * Gets the location of the click
     *
     * @param event
     */
    @FXML
    protected void getXYClickLocation(MouseEvent event)
      {
        xMouse = event.getX();
        yMouse = event.getY();
        Stage stage;
        stage = (Stage) mainGridPane.getScene().getWindow();
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2)
        {
            stage.setMaximized(false);
        }
      }

    /** -------------------------------------------------------------------------------------------------------------------------. */
    /** --------------------------------------------LANGUAGES--------------------------------------------------------.
     * Loads the language.
     *
     * @param lang
     * @param country
     */
    protected void loadLang(String lang, String country)
      {
        locale = new Locale(lang, country);
        bundle = ResourceBundle.getBundle("museumApp.gui.util.lang", locale);
      }

    /** -------------------------------------------------------------------------------------------------------------------------. */
  }
