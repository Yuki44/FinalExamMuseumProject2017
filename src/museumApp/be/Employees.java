/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

import java.sql.Date;

/**
 *
 * @author Peder
 */
public abstract class Employees extends User
{

    protected String userName;
    protected String password;

    public Employees(String userName, String password, String firstName, String lastName, String email, String phoneNumber, Date birthDate, int id)
    {
        super(firstName, lastName, email, phoneNumber, birthDate, id);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
