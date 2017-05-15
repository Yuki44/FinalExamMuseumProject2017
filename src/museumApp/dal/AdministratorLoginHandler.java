package museumApp.dal;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Administrator;
import museumApp.be.Employee;

public class AdministratorLoginHandler extends GetData
  {

    GetData DbMgr;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public AdministratorLoginHandler() throws IOException
      {
        this.DbMgr = new GetData(); // Get a new getData Database Manager
      }

    /** ----------------------------------------------------------------------------------------------------. */
    /**
     * This method is used to check the username and password of an administrator.
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Employee LoginChecker(String username, String password) throws SQLException
      {
        for (Administrator allAdmin : DbMgr.getAllAdmins())
        {
            if (allAdmin.getUserName().getValue().equals(username))
            {
                if (DbMgr.checkPasswordForAdmin(username, password))
                {
                    return DbMgr.getAdminBasedOnUsername(username);
                }
            }
        }
        return null;
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
