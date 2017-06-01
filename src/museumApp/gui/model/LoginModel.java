package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Employee;
import museumApp.bll.FacadeBll;
import museumApp.bll.LoginManager;

public class LoginModel extends Model
  {

    /**
     * Constructor
     *
     * @throws IOException
     */
    public LoginModel() throws IOException
      {
        facadeBll = new FacadeBll();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Method call to the loginManager
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Employee LoginChecker(String username, String password) throws SQLException
      {
        return facadeBll.LoginChecker(username, password);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
