package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.GuildVolunteer;
import museumApp.dal.AddData;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;

public class GuildVolunteerBll extends BllFacade
  {

    public GuildVolunteerBll() throws IOException
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
    public List<GuildVolunteer> getAllGuildVolunteer()
      {
        try
        {
            return getDbMgr.getAllGuildVolunteer();
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
     * @param gv
     * @throws SQLException
     */
    public void addGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        addDbMgr.addGuildVolunteer(gv);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gv
     * @throws SQLException
     */
    public void removeGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        removeDbMgr.removeGuildVolunteer(gv);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
