package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.Guild;
import museumApp.be.Volunteer;
import museumApp.dal.AddData;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;

public class VolunteerBll extends BllFacade
  {

    public VolunteerBll() throws IOException
      {
        getDbMgr = new GetData();
        addDbMgr = new AddData();
        removeDbMgr = new RemoveData();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Creates a List to fetch the volunteers in the database.
     *
     * @return method from GetData
     */
    public List<Volunteer> getAllVolunteers()
      {
        try
        {
            return getDbMgr.getAllVolunteers();
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
            throw new MuseumManagerException("Unable to fetch volunteers.");
        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Adds a Volunteer, Method call to DAL layer.
     *
     * @param vtr
     * @throws SQLException
     */
    public void addVolunteer(Volunteer vtr) throws SQLException
      {
        addDbMgr.addVolunteer(vtr);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * RemoveVolunteer vtr, is a method call to DAL remove Database class.
     *
     * @param vtr
     * @throws SQLException
     */
    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
        removeDbMgr.removeVolunteer(vtr);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Method call to the getData Database Manager.
     *
     * @param newValue
     * @return
     */
    public List<Volunteer> getVolunteersFromGuild(Guild newValue)
      {
        try
        {
            return getDbMgr.getVolunteerBasedOnGuild(newValue);
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
            throw new MuseumManagerException("Unable to find new value");
        }
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
