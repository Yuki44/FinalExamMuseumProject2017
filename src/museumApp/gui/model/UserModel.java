/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import museumApp.be.User;

/**
 *
 * @author Peder
 */
public class UserModel extends Model
{
    

    public UserModel() throws IOException
    {
        super();
    }
    
    
    /**
     * @return an ArrayList of the different user types.
     * @throws SQLException 
     */
    public List<User> getUsers() throws SQLException
    {
        List<User> result = new ArrayList<>();
        result.addAll(museumManager.getAllVolunteers());
        result.addAll(museumManager.getAllManagers());
        result.addAll(museumManager.getAllAdmins());
        return result;
    }
    
    
}
