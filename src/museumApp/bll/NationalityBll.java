package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.Nationality;
import museumApp.dal.GetData;

public class NationalityBll extends BllManager
  {

    public NationalityBll() throws IOException
      {
        getDbMgr = new GetData();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Gets a list of nationalities from database
     *
     * @return
     */
    public List<Nationality> getAllNationalities()
      {
        try
        {
            return getDbMgr.getAllNationalities();
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
            throw new MuseumManagerException("Unable to fetch nationalities.");
        }
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
