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
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;
import museumApp.dal.AddData;
import museumApp.dal.DatabaseManager;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;
import museumApp.dal.UpdateData;

/**
 *
 * @author Peder
 */
public class MuseumManager
  {

    protected GetData getDbMgr;
    private AddData addDbMgr;
    private UpdateData updateDbMgr;
    private RemoveData removeDbMgr;
    protected DatabaseManager DbMgr;

    /**
     * Constructor of the GetData.
     */
    public MuseumManager()
      {
        try
        {
            getDbMgr = new GetData();
            addDbMgr = new AddData();
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
     * @return method from GetData
     */
    public List<Volunteer> getAllVolunteers()
      {
        try
        {
            return getDbMgr.getAllVolunteers();
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
     * @return method from GetData
     */
    public List<Guild> getAllGuilds()
      {
        try
        {
            return getDbMgr.getAllGuilds();
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
            throw new MuseumManagerException("Unable to fetch guilds.");
        }
      }

    public List<Volunteer> getVolunteersFromGuild(Guild newValue)
      {
        try
        {
            return getDbMgr.getVolunteerBasedOnGuild(newValue);
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
            throw new MuseumManagerException("Unable to find new value");

        }
      }

    /**
     * Creates a List to fetch the Manager in the database.
     *
     * @return method from GetData
     */
    public List<Manager> getAllManagers()
      {
        try
        {
            return getDbMgr.getAllManagers();
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
     * @return method from GetData
     */
    public List<Administrator> getAllAdmins()
      {
        try
        {
            return getDbMgr.getAllAdmins();
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
            throw new MuseumManagerException("Unable to fetch administrators.");
        }
      }

    public List<VolunteerTime> getTimeBasedOnVolunteer(Volunteer hours)
      {
        try
        {
            return getDbMgr.getTimeBasedOnVolunteer(hours);
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
            throw new MuseumManagerException("Unable to get Volunteer hours.");
        }
        
      }

    public void addManager(Manager mg) throws SQLException
      {
        addDbMgr.addManager(mg);
      }

    public void addVolunteer(Volunteer vtr) throws SQLException
      {
        addDbMgr.addVolunteer(vtr);
      }

    public void addHours(VolunteerTime vTime) throws SQLException
      {
        addDbMgr.addHours(vTime);
      }

    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
        removeDbMgr.removeVolunteer(vtr);
      }

    public void removeManager(Manager mg) throws SQLException
      {
        removeDbMgr.removeManager(mg);
      }

  }
