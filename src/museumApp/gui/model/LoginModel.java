/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Employee;
import museumApp.bll.LoginManager;

/**
 *
 * @author Peder
 */
public class LoginModel
{

    private final LoginManager loginManager;

    public LoginModel() throws IOException
    {
        this.loginManager = new LoginManager();
    }

    public Employee LoginChecker(String username, String password) throws SQLException
    {
        return loginManager.LoginChecker(username, password);
    }
}
