package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.VolunteerTime;
import museumApp.dal.AddData;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;
import museumApp.dal.UpdateData;

public class TimeRegistrationManager extends BllManager
  {

    public TimeRegistrationManager() throws IOException
      {
        getDbMgr = new GetData();
        addDbMgr = new AddData();
        removeDbMgr = new RemoveData();
        updateDbMgr = new UpdateData();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @return
     */
    public List<VolunteerTime> getVolunteerTimeBasedOnVtrId(int vtrId)
      {
        try
        {
            return getDbMgr.getVolunteerTimeBasedOnVtrId(vtrId);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
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

    public void updateVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        updateDbMgr.updateVolunteerTime(vTime);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
