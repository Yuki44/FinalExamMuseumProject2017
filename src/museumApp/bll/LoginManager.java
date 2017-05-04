/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Employee;
import museumApp.dal.EmployeeLoginHandler;

/**
 *
 * @author Peder
 */
public class LoginManager
{

    private final EmployeeLoginHandler employeeLoginHandler;

    public LoginManager() throws IOException
    {
        this.employeeLoginHandler = new EmployeeLoginHandler();
    }

    public Employee LoginChecker(String username, String password) throws SQLException
    {
        if (employeeLoginHandler.LoginChecker(username, password) != null)
        {
            return employeeLoginHandler.LoginChecker(username, password);
        }
        return null;
    }
}
