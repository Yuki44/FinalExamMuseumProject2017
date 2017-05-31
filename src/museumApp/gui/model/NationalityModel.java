package museumApp.gui.model;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Nationality;
import museumApp.bll.NationalityBll;

public class NationalityModel extends Model
  {

    private ObservableList<Nationality> nationalities = FXCollections.observableArrayList();

    public NationalityModel() throws IOException
      {
        nationalityBll = new NationalityBll();
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
     *
     * @return nationalities
     */
    public ObservableList<Nationality> getNationalities()
      {
        return nationalities;
      }

    public void setNationalitiesIntoObservable()
      {
        nationalities.clear();
        nationalities.addAll(nationalityBll.getAllNationalities());
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
