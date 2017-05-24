package museumApp.gui.model;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Nationality;
import museumApp.bll.NationalityBll;

public class NationalityModel extends Model
  {

    private ObservableList<Nationality> nationalities;

    public NationalityModel() throws IOException
      {
        nationalityBll = new NationalityBll();
        nationalities = FXCollections.observableArrayList(nationalityBll.getAllNationalities());
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
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
