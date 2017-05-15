package museumApp.dal;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Employee;
import museumApp.be.Manager;

public class ManagerLoginHandler extends GetData
  {

    GetData DbMgr;

    /**
     * constructor 
     * @throws java.io.IOException
     */
    public ManagerLoginHandler() throws IOException
      {
        this.DbMgr = new GetData();
      }
    /**
     * loop all the managers'username and password in the employee table,
     * to check whether there is record matching the given username and password
     * @param username
     * @param password
     * @return
     * @throws SQLException 
     */

    /**
     * This method checks the username and password of the manager.
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Employee LoginChecker(String username, String password) throws SQLException
      {
        for (Manager allManager : DbMgr.getAllManagers())
        {
            if (allManager.getUserName().getValue().equals(username))
            {
                if (DbMgr.checkPasswordForManager(username, password))
                {
                    return DbMgr.getManagerBasedOnUsername(username);
                }
            }
        }

        return null;
      }
  }
