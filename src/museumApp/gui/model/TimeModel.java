package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import museumApp.be.VolunteerTime;
import museumApp.bll.FacadeBll;

public class TimeModel extends Model
  {

    private ObservableList<VolunteerTime> volunteerTime;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public TimeModel() throws IOException
      {
        facadeBll = new FacadeBll();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method gets a list of volunteer time.
     *
     * @return volunteerTime
     */
    public ObservableList<VolunteerTime> getVolunteerTime()
      {
        return volunteerTime;
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method makes it possible to add volunteer time.
     *
     * @param vTime
     * @throws SQLException
     */
    public void addVolunteerTime(VolunteerTime vTime)
      {
        Runnable r = () ->
        {

            facadeBll.addVolunteerTime(vTime); //updates database

        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method makes it possible to remove volunteer time.
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
     * This method makes it possible to update volunteer time.
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
