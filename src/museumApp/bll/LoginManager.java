package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Employee;
import museumApp.dal.AdministratorLoginHandler;
import museumApp.dal.ManagerLoginHandler;

public class LoginManager extends BllManager
  {

    /**
     * Constructor
     *
     * @throws IOException
     */
    public LoginManager() throws IOException
      {
        managerLoginHandler = new ManagerLoginHandler();
        adminLoginHandler = new AdministratorLoginHandler();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Checks whether the user login in is a manager or an administrator.
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Employee LoginChecker(String username, String password) throws SQLException
      {
        if (managerLoginHandler.LoginChecker(username, password) != null)
        {
            return managerLoginHandler.LoginChecker(username, password);
        }
        else if (adminLoginHandler.LoginChecker(username, password) != null)
        {
            return adminLoginHandler.LoginChecker(username, password);
        }
        else
        {
            return null;
        }
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
