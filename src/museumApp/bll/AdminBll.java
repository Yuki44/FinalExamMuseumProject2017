package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.Administrator;
import museumApp.dal.AddData;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;

public class AdminBll extends BllFacade
  {

    public AdminBll() throws IOException
      {
        getDbMgr = new GetData();
        addDbMgr = new AddData();
        removeDbMgr = new RemoveData();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Creates a List to fetch the Administrator in the database.
     *
     * @return method from GetData
     */
    public List<Administrator> getAllAdmins()
      {
        try
        {
            return getDbMgr.getAllAdmins();
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
            throw new MuseumManagerException("Unable to fetch administrators.");
        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param ad
     * @throws SQLException
     */
    public void addAdministrator(Administrator ad) throws SQLException
      {
        addDbMgr.addAdministrator(ad);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param ad
     * @throws SQLException
     */
    public void removeAdministrator(Administrator ad) throws SQLException
      {
        removeDbMgr.removeAdministrator(ad);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
