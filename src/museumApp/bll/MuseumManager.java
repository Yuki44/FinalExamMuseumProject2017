package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import museumApp.be.Administrator;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.be.Nationality;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;
import museumApp.dal.AddData;
import museumApp.dal.DatabaseManager;
import museumApp.dal.GetData;
import museumApp.dal.RemoveData;
import museumApp.dal.UpdateData;

public class MuseumManager
  {

    protected GetData getDbMgr;
    private AddData addDbMgr;
    private UpdateData updateDbMgr;
    private RemoveData removeDbMgr;
    protected DatabaseManager DbMgr;

    /**
     * Constructor of the MuseumManager.
     */
    public MuseumManager()
      {
        try
        {
            getDbMgr = new GetData(); // Instantiate a new getData Database Manager
            addDbMgr = new AddData(); // Instantiate a new addData Database Manager
            removeDbMgr = new RemoveData();
        }
        catch (IOException ex)
        {

            System.err.println(ex);
            throw new MuseumManagerException("Unable to connect to database.");
        }

      }

    /** ------------------------------getAll() METHODS---------------------------------------------. */
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

    /**
     * Creates a List to fetch the Volunteer time in the database.
     *
     * @return method from GetData
     * @throws SQLException
     */
    public List<VolunteerTime> getAllVTime() throws SQLException
      {
        try
        {
            return getDbMgr.getAllVTime();
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
            throw new MuseumManagerException("Unable to fetch volunteer time.");
        }
      }

    /** --------------------------------GET DATA FROM DATABASE METHODS----------------------------------------------------. */
    /**
     * Method call to the getData Database Manager.
     *
     * @param newValue
     * @return
     */
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
     * Get time based on volunteer, method call to getData Database.
     *
     * @param hours
     * @return
     */
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

    /** ------------------------------ADD DATA TO DATABASE---------------------------------------------. */
    /**
     * Adds a Manager, Method call to DAL layer
     *
     * @param mg
     * @throws SQLException
     */
    public void addManager(Manager mg) throws SQLException
      {
        addDbMgr.addManager(mg);
      }

    /**
     * Adds a Volunteer, Method call to DAL layer.
     *
     * @param vtr
     * @throws SQLException
     */
    public void addVolunteer(Volunteer vtr) throws SQLException
      {
        addDbMgr.addVolunteer(vtr);
      }

    /**
     * Adds a Guild, Method call to DAL layer.
     *
     * @param gd
     * @throws SQLException
     */
    public void addGuild(Guild gd) throws SQLException
      {
        addDbMgr.addGuild(gd);
      }

    public List<Manager> getManagerFromGuild(Guild guild) throws SQLException
      {
        return getDbMgr.getManagerBasedOnGuild(guild);
      }

    /** ------------------------------REMOVE DATA IN DATABASE---------------------------------------------. */
    /**
     * RemoveVolunteer vtr, is a method call to DAL remove Database class.
     *
     * @param vtr
     * @throws SQLException
     */
    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
        removeDbMgr.removeVolunteer(vtr);
      }

    /**
     * RemoveManager mg, is a method call to DAL remove Database class.
     *
     * @param mg
     * @throws SQLException
     */
    public void removeManager(String fName, String lName, String uName, String password) throws SQLException
      {
        removeDbMgr.removeManager(fName, lName, uName, password);
      }

    public void removeGuild(String guildName) throws SQLException
      {
        removeDbMgr.removeGuild(guildName);
      }

    public List<Nationality> getNationality() throws SQLException
      {
        return getDbMgr.getNationality();
      }
    /** ---------------------------------------------------------------------------------------------------. */

  }
