package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.Guild;
import museumApp.dal.AddData;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;
import museumApp.dal.UpdateData;

public class GuildBll extends BllManager
  {

    public GuildBll() throws IOException
      {
        getDbMgr = new GetData();
        addDbMgr = new AddData();
        updateDbMgr = new UpdateData();
        removeDbMgr = new RemoveData();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Creates a List to fetch the Guild in the database.
     *
     * @return method from GetData
     */
    public List<Guild> getAllGuilds()
      {
        try
        {
            return getDbMgr.getAllGuilds();
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
            throw new MuseumManagerException("Unable to fetch guilds.");
        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Adds a Guild, Method call to DAL layer.
     *
     * @param gd
     * @throws SQLException
     */
    public void addGuild(Guild gd) throws SQLException
      {
        addDbMgr.addGuild(gd);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Removes a Guild, Method call to DAL layer.
     *
     * @param gd
     * @throws SQLException
     */
    public void removeGuild(Guild gd) throws SQLException
      {
        removeDbMgr.removeGuild(gd);
      }

    /**
     * Updates a Guild, Method call to DAL layer.
     *
     * @param gd
     * @throws SQLException
     */
    public void updateGuild(Guild gd) throws SQLException
      {
        updateDbMgr.updateGuild(gd);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
