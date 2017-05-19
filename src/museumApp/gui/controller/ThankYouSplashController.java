/*
 * Erhvervsakademi Sydvest, Computer Science 2016-2017, Carlos F. Ognissanti
 * To change this header, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class ThankYouSplashController extends Controller implements Initializable
  {

    @FXML
    private BorderPane borderPaneThanks;
    @FXML
    private GridPane mainGridPane;
    @FXML
    protected Label lblThankYouFor;
    @FXML
    protected Label lblHaveANiceDay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        new ThankYouSplash().start();
      }

    /**
     * We make a new class that will be responsible to handle a secondary thread
     * so we can display the Splash Screen window.
     */
    class ThankYouSplash extends Thread
      {

        @Override
        public void run() //We override the run method to specify how we want the thread to run
          {
            try
            {
                /**
                 * We are telling the thread to sleep for some SECONDS before we
                 * show the MainView.
                 */
                Thread.sleep(4000);
                /** ------------------------------------------------------------------------------------------. */
                Platform.runLater(new Runnable()
                  {
                    @Override
                    public void run()
                      {
                        try
                        {
                            Stage stage;
                            Parent root;
                            stage = (Stage) borderPaneThanks.getScene().getWindow();
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
                  });
            }
            catch (InterruptedException ex)
            {
                System.err.println(ex); //We print out the error
            }
          }
      }
  }
