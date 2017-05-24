package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.VolunteerTime;
import museumApp.bll.TimeRegistrationManager;

public class TimeModel extends Model
  {

    private ObservableList<VolunteerTime> volunteerTime;

    public TimeModel() throws IOException
      {
        timeRegistrationManager = new TimeRegistrationManager();
        volunteerTime = FXCollections.observableArrayList(timeRegistrationManager.getAllVolunteerTime());
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
    public void addVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        volunteerTime.add(vTime); //updates gui through observable
        timeRegistrationManager.addVolunteerTime(vTime); //updates database
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vTime
     * @throws SQLException
     */
    public void removeVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        timeRegistrationManager.removeVolunteerTime(vTime);
        volunteerTime.remove(vTime);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
