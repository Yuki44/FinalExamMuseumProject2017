package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.Administrator;
import museumApp.dal.AddData;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;
import museumApp.dal.UpdateData;

public class AdminBll extends BllManager
  {

    public AdminBll() throws IOException
      {
        getDbMgr = new GetData();
        addDbMgr = new AddData();
        updateDbMgr = new UpdateData();
        removeDbMgr = new RemoveData();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Fetches a List of Administrators in the database.
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
     * Calls the add function
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
     * Calls the remove function
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
    /**
     * Calls the update function
     *
     * @param ad
     * @throws SQLException
     */
    public void updateAdministrator(Administrator ad) throws SQLException
      {
        updateDbMgr.updateAdministrator(ad);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
