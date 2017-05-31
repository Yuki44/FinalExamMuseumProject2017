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
     * Gets a list of VolunteerTime based on the id of the volunteer
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

    /**
     * Gets a list of VolunteerTime based on the id of the volunteers and guilds.
     *
     * @param vtrId
     * @param gdId
     * @return
     */
    public List<VolunteerTime> getVolunteerAndGuildTimeBasedOnId(int vtrId, int gdId)
      {
        try
        {
            return getDbMgr.getVolunteerAndGuildTimeBasedOnId(vtrId, gdId);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new MuseumManagerException("Unable to fetch Volunteer Time.");

        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Calls the add VolunteerTime function
     *
     * @param vTime
     */
    public void addVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        addDbMgr.addVolunteerTime(vTime);

      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Calls the remove VolunteerTime function
     *
     * @param vTime
     * @throws SQLException
     */
    public void removeVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        removeDbMgr.removeVolunteerTime(vTime);
      }

    /**
     * Calls the update VolunteerTime function
     *
     * @param vTime
     * @throws SQLException
     */
    public void updateVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        updateDbMgr.updateVolunteerTime(vTime);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
