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
public class EmployeeLoginHandler extends DatabaseManager
{

    DatabaseManager DbMgr;

    public EmployeeLoginHandler() throws IOException
    {
        this.DbMgr = new DatabaseManager();
    }

    public Employee LoginChecker(String username, String password) throws SQLException
    {
        for (Manager allManager : DbMgr.getAllManagers())
        {
            if (allManager.equals(username))
            {
                if (DbMgr.checkPasswordForManager(username, password))
                {
                    return DbMgr.getManagerBasedOnUsername(username);
                }
            }
        }
        for (Administrator allAdmin : DbMgr.getAllAdmins())
        {
            if (allAdmin.equals(username))
            {
                if (DbMgr.checkPasswordForAdmin(username, password))
                {
                    return DbMgr.getAdminBasedOnUsername(username);
                }
            }
        }
        return null;
    }
}
