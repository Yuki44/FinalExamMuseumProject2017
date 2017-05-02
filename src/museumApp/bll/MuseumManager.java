/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import museumApp.be.Administrator;
import museumApp.be.Manager;
import museumApp.be.Volunteer;
import museumApp.dal.DatabaseManager;

/**
 *
 * @author Peder
 */
public class MuseumManager
{

    private DatabaseManager DbMgr;

    /**
     * Constructor of the DatabaseManager
     */
    public MuseumManager()
    {
        try
        {
            DbMgr = new DatabaseManager();
        }
        catch (IOException ex)
        {

            Logger.getLogger(MuseumManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new MuseumManagerException("Unable to connect to database.");
        }

    }

    /**
     * Creates a List to fetch the volunteers in the database.
     *
     * @return method from DatabaseManager
     */
    public List<Volunteer> getAllVolunteers()
    {
        try
        {
            return DbMgr.getAllVolunteers();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(MuseumManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new MuseumManagerException("Unable to fetch volunteers.");
        }
    }

    /**
     * Creates a List to fetch the Manager in the database.
     *
     * @return method from DatabaseManager
     */
    public List<Manager> getAllManagers()
    {
        try
        {
            return DbMgr.getAllManagers();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(MuseumManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new MuseumManagerException("Unable to fetch managers.");
        }
    }

    /**
     * Creates a List to fetch the Administrator in the database.
     *
     * @return method from DatabaseManager
     */
    public List<Administrator> getAllAdmins()
    {
        try
        {
            return DbMgr.getAllAdmins();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(MuseumManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new MuseumManagerException("Unable to fetch administrators.");
        }
    }
   
}
