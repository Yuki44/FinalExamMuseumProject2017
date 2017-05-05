/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.Administrator;
import museumApp.be.Guild;
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
     * Constructor of the DatabaseManager.
     */
    public MuseumManager()
      {
        try
        {
            DbMgr = new DatabaseManager();
        }
        catch (IOException ex)
        {

            System.err.println(ex);
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
            System.err.println(ex);
            throw new MuseumManagerException("Unable to fetch volunteers.");
        }
      }

    /**
     * Creates a List to fetch the Guild in the database.
     *
     * @return method from DatabaseManager
     */
    public List<Guild> getAllGuilds()
      {
        try
        {
            return DbMgr.getAllGuilds();
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
            throw new MuseumManagerException("Unable to fetch guilds.");
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
            System.err.println(ex);
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
            System.err.println(ex);
            throw new MuseumManagerException("Unable to fetch administrators.");
        }
      }

    public void addManager(Manager mg)
      {
        DbMgr.addManager(mg);
      }

  }
