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
public class Administrator extends Employee
{

    public Administrator(String userName, String password, String firstName, String lastName, String email, int id)
    {
        super(userName, password, firstName, lastName, email, id);
    }

}
