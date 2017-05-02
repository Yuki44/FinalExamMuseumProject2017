package museumApp.main;

import java.io.IOException;
import java.net.URL;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class MuseumApp extends Application
  {

    @Override
    public void start(Stage stage) throws IOException
      {
        initRootLayout(stage); // Just a method call
      }

    /**
     * Initializes the root layout.
     *
     * @param stage
     */
    public void initRootLayout(Stage stage)
      {
        try
        {
            URL location = this.getClass().getResource("/museumApp/gui/view/SplashFXML.fxml"); //First of all we start the splash screen
            FXMLLoader loader = new FXMLLoader(location);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            /**
             * This part below is telling the view to make a beautiful fade in
             * transition:
             * From status 0 to status 1 (in 3 seconds) and then count it as it
             * has finished it.
             */
            /** ------------------------------------------------------------------------------------------ */
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);
            fadeIn.play(); //Plays the transition
            /** ------------------------------------------------------------------------------------------ */
            stage.initStyle(StageStyle.UNDECORATED);// No borders to the window
            stage.show();
            stage.setScene(scene);
            stage.getIcons().add(new Image("/museumApp/gui/img/museum_logo.png")); // An icon for our program
            stage.centerOnScreen();
            stage.setMaximized(false);
            /**
             * The following Lambda expression is checking whether the fade in
             * transition has finished so the fade out transition can start.
             */
            /** ------------------------------------------------------------------------------------------ */
            fadeIn.setOnFinished((e) ->
            {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), root);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setCycleCount(1);
                fadeOut.play(); //Plays the transition
            });
            /** ------------------------------------------------------------------------------------------ */

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
      }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        launch(args);
      }

  }
