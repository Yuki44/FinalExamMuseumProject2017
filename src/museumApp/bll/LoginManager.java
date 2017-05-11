package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Employee;
import museumApp.dal.AdministratorLoginHandler;
import museumApp.dal.ManagerLoginHandler;

public class LoginManager
  {

    private final ManagerLoginHandler managerLoginHandler;
    private final AdministratorLoginHandler adminLoginHandler;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public LoginManager() throws IOException
      {
        this.managerLoginHandler = new ManagerLoginHandler();
        this.adminLoginHandler = new AdministratorLoginHandler();
      }

    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Checks wether is a manager or an administrator
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
  }
