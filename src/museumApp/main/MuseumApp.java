package museumApp.main;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
            System.out.println(location.getPath());
            FXMLLoader loader = new FXMLLoader(location);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);// No borders to the window
            stage.show();
            stage.setScene(scene);
            stage.getIcons().add(new Image("/museumApp/gui/img/museum_logo.png")); // An icon for our program
            stage.centerOnScreen();
            stage.setMaximized(false);

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
