/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Employee;
import museumApp.dal.AdministratorLoginHandler;
import museumApp.dal.ManagerLoginHandler;

/**
 *
 * @author Peder
 */
public class LoginManager
{

    private final ManagerLoginHandler managerLoginHandler;
    private final AdministratorLoginHandler adminLoginHandler;

    public LoginManager() throws IOException
    {
        this.managerLoginHandler = new ManagerLoginHandler();
        this.adminLoginHandler = new AdministratorLoginHandler();
    }

    public Employee LoginChecker(String username, String password) throws SQLException
    {
        if (managerLoginHandler.LoginChecker(username, password) != null)
        {
            return managerLoginHandler.LoginChecker(username, password);
        }
        else
        {
            return adminLoginHandler.LoginChecker(username, password);
        }
    }
}
