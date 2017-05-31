package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.dal.AddData;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;
import museumApp.dal.UpdateData;

public class ManagerBll extends BllManager
  {

    public ManagerBll() throws IOException
      {
        getDbMgr = new GetData();
        addDbMgr = new AddData();
        removeDbMgr = new RemoveData();
        updateDbMgr = new UpdateData();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Creates a List to fetch the Manager in the database.
     *
     * @return method from GetData
     */
    public List<Manager> getAllManagers()
      {
        try
        {
            return getDbMgr.getAllManagers();
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
            throw new MuseumManagerException("Unable to fetch managers.");
        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Adds a Manager, Method call to DAL layer
     *
     * @param mg
     * @throws SQLException
     */
    public void addManager(Manager mg) throws SQLException
      {
        addDbMgr.addManager(mg);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * RemoveManager mg, is a method call to DAL remove Database class.
     *
     * @param mg
     * @throws SQLException
     */
    public void removeManager(Manager mg) throws SQLException
      {
        removeDbMgr.removeManager(mg);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Gets a list of managers based on the guild(s) they manage.
     *
     * @param guild
     * @return
     */
    public List<Manager> getManagerFromGuild(Guild guild)
      {
        try
        {
            return getDbMgr.getManagerBasedOnGuild(guild);
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
            throw new MuseumManagerException("Unable to find get manager from guild");
        }
      }

    /**
     * Calls the update manager function.
     *
     * @param mg
     * @throws SQLException
     */
    public void updateManager(Manager mg) throws SQLException
      {
        updateDbMgr.updateManager(mg);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
