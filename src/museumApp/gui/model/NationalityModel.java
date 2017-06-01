package museumApp.gui.model;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Nationality;
import museumApp.bll.FacadeBll;

public class NationalityModel extends Model
  {

    private ObservableList<Nationality> nationalities = FXCollections.observableArrayList();

    /**
     * Constructor
     *
     * @throws IOException
     */
    public NationalityModel() throws IOException
      {
        facadeBll = new FacadeBll();
        Runnable r = () ->
        {
            setNationalitiesIntoObservable();
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method gets a list of nationalities.
     *
     * @return nationalities
     */
    public ObservableList<Nationality> getNationalities()
      {
        return nationalities;
      }

    /**
     * This method sets the list of nationalities.
     */
    public void setNationalitiesIntoObservable()
      {
        nationalities.clear();
        nationalities.addAll(facadeBll.getAllNationalities());
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
