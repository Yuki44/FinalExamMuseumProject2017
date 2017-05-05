/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import museumApp.be.Administrator;
import museumApp.be.Employee;

/**
 *
 * @author Peder
 */
public class AdministratorLoginHandler extends DatabaseManager
{

    DatabaseManager DbMgr;

    public AdministratorLoginHandler() throws IOException
    {
        this.DbMgr = new DatabaseManager();
    }
    
    public Employee LoginChecker (String username, String password) throws SQLException
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
}
