package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.VolunteerTime;
import museumApp.dal.AddData;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;

public class TimeRegistrationManager extends BllFacade
  {

    public TimeRegistrationManager() throws IOException
      {
        getDbMgr = new GetData();
        addDbMgr = new AddData();
        removeDbMgr = new RemoveData();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @return
     */
    public List<VolunteerTime> getAllVolunteerTime()
      {
        try
        {
            return getDbMgr.getAllVolunteerTime();
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
            throw new MuseumManagerException("Unable to fetch Volunteer Time.");

        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vTime
     */
    public void addVolunteerTime(VolunteerTime vTime)
      {
        try
        {
            addDbMgr.addVolunteerTime(vTime);
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
            throw new MuseumManagerException("Unable to add Volunteer Time.");
        }

      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vTime
     * @throws SQLException
     */
    public void removeVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        removeDbMgr.removeVolunteerTime(vTime);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
