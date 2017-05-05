/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import museumApp.be.Administrator;
import museumApp.be.Employee;
import museumApp.be.Manager;

/**
 *
 * @author Peder
 */
public class ManagerLoginHandler extends GetData
  {

    GetData DbMgr;

    /**
     *
     * @throws java.io.IOException
     */
    public ManagerLoginHandler() throws IOException {
        this.DbMgr = new GetData();
    }


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
