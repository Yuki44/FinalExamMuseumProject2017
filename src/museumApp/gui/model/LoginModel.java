package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Employee;
import museumApp.bll.LoginManager;

public class LoginModel
  {

    private final LoginManager loginManager;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public LoginModel() throws IOException
      {
        this.loginManager = new LoginManager();
      }

    /** ---------------------------------------------------------------------------------------------------------------------------. */
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
        return loginManager.LoginChecker(username, password);
      }
    /** ---------------------------------------------------------------------------------------------------------------------------. */
  }
