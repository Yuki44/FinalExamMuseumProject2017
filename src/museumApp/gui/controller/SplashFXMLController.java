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
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FOR MORE INFO ABOUT SPLASH SCREEN: https://www.youtube.com/watch?v=f06uUtkmtDE
 *
 * @author Yuki
 */
public class SplashFXMLController implements Initializable
  {

    @FXML
    private BorderPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        /**
         * Causes this thread to begin execution;
         * the Java Virtual Machine calls the run method of this thread,
         * The result is that two threads are running concurrently:
         * the current thread (which returns from the call to the start method) and
         * the other thread (which executes its run method).
         */
        new SplashScreen().start();

      }

    /** ------------------------------------------------------------------------------------------- */
    /**
     * We make a new class that will be responsible to handle a secondary thread
     * so we can display the Splash Screen window.
     */
    class SplashScreen extends Thread
      {

        @Override
        public void run() //We override the run method to specify how we want the thread to run
          {
            try
            {
                /**
                 * We are telling the thread to sleep for 6 SECONDS before we
                 * show the MainView.
                 */
                Thread.sleep(3500);
                /** ------------------------------------------------------------------------------------------ */
                Platform.runLater(new Runnable()
                  {
                    @Override
                    public void run()
                      {
                        try
                        {
                            /**
                             * Now after waiting those 5 Seconds we run the main view.
                             */
                            URL location = this.getClass().getResource("/museumApp/gui/view/LanguageSelectionView.fxml");
                            FXMLLoader loader = new FXMLLoader(location);
                            Parent root = null;
                            root = loader.load();
                            Scene scene = new Scene(root);
                            Stage stage = new Stage(); //Creating a new Stage
                            stage.initStyle(StageStyle.UNDECORATED);// No borders to the window
                            stage.show();
                            stage.setScene(scene);
                            stage.getIcons().add(new Image("/museumApp/gui/img/museum_logo.png")); //Setting an Icon
                            stage.centerOnScreen();
                            stage.setMaximized(false); //Starting it as minimized
                            ResizeHelper.addResizeListener(stage); //We call the ResizeHelper class so we are able to resize our view.
                            /** ------------------------------------------------------------------------------------------ */
                            /**
                             * Now we ran the Main View but, we must also HIDE the splash screen since
                             * we are not going to use it anymore.
                             */
                            rootPane.getScene().getWindow().hide();
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
