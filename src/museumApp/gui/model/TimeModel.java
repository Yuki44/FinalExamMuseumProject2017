package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import museumApp.be.VolunteerTime;
import museumApp.bll.FacadeBll;

public class TimeModel extends Model
  {

    private ObservableList<VolunteerTime> volunteerTime;

    public TimeModel() throws IOException
      {
        facadeBll = new FacadeBll();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @return volunteerTime
     */
    public ObservableList<VolunteerTime> getVolunteerTime()
      {
        return volunteerTime;
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vTime
     * @throws SQLException
     */
    public void addVolunteerTime(VolunteerTime vTime)
      {
        facadeBll.addVolunteerTime(vTime); //updates database
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vTime
     * @throws SQLException
     */
    public void removeVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        facadeBll.removeVolunteerTime(vTime);
        volunteerTime.remove(vTime);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vTime
     * @throws SQLException
     */
    public void updateVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        facadeBll.updateVolunteerTime(vTime);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
