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
import museumApp.be.GuildVolunteer;
import museumApp.be.Manager;
import museumApp.be.Nationality;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;
import museumApp.dal.AddData;
import museumApp.dal.AdministratorLoginHandler;
import museumApp.dal.DatabaseManager;
import museumApp.dal.GetData;
import museumApp.dal.ManagerLoginHandler;
import museumApp.dal.RemoveData;
import museumApp.dal.UpdateData;

/**
 *
 * @author min
 */
public class FacadeBll
  {

    protected GetData getDbMgr;
    protected AddData addDbMgr;
    protected UpdateData updateDbMgr;
    protected RemoveData removeDbMgr;
    protected DatabaseManager DbMgr;
    protected ManagerLoginHandler managerLoginHandler;
    protected AdministratorLoginHandler adminLoginHandler;
    protected GuildBll guildBll;
    protected AdminBll adminBll;
    protected GuildVolunteerBll guildVolunteerBll;
    protected LoginManager loginManager;
    protected ManagerBll managerBll;
    protected NationalityBll nationalityBll;
    protected TimeRegistrationManager timeRegistrationManager;
    protected VolunteerBll volunteerBll;

    public FacadeBll() throws IOException
      {
        getDbMgr = new GetData();
        addDbMgr = new AddData();
        updateDbMgr = new UpdateData();
        removeDbMgr = new RemoveData();
        adminBll = new AdminBll();
        guildBll = new GuildBll();
        guildVolunteerBll = new GuildVolunteerBll();
        loginManager = new LoginManager();
        managerBll = new ManagerBll();
        nationalityBll = new NationalityBll();
        timeRegistrationManager = new TimeRegistrationManager();
        volunteerBll = new VolunteerBll();

      }

    /*-------------GUILD FACADE---------------------------------------------------------------------------------
     */
    /**
     * Calls the add Guild function
     *
     * @param gd
     */
    public void addGuild(Guild gd)
      {
        try
        {
            guildBll.addGuild(gd);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Calls the remove Guild function
     *
     * @param gd
     */
    public void removeGuild(Guild gd)
      {
        try
        {
            guildBll.removeGuild(gd);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Calls the update Guild function
     *
     * @param gd
     */
    public void updateGuild(Guild gd)
      {
        try
        {
            guildBll.updateGuild(gd);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Gets a list of guilds
     *
     * @return
     */
    public List<Guild> getAllGuilds()
      {
        return guildBll.getAllGuilds();
      }

    /*-------------ADMIN FACADE-----------------------------------------------------------
     */
    /**
     * Gets a list of administrators
     *
     * @return
     */
    public List<Administrator> getAllAdmins()
      {
        return adminBll.getAllAdmins();
      }

    /**
     * Calls the add Administrator function
     *
     * @param ad
     */
    public void addAdministrator(Administrator ad)
      {
        try
        {
            adminBll.addAdministrator(ad);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Calls the remove Administrator function
     *
     * @param ad
     */
    public void removeAdministrator(Administrator ad)
      {
        try
        {
            adminBll.removeAdministrator(ad);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Calls the update Administrator function
     *
     * @param ad
     */
    public void updateAdministrator(Administrator ad)
      {
        try
        {
            adminBll.updateAdministrator(ad);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /*-----------GUILD VOLUNTEER FACADE-------------------------------------------
     */
    /**
     * Gets a list of Guild Volunteers
     *
     * @return
     */
    public List<GuildVolunteer> getAllGuildVolunteer()
      {
        return guildVolunteerBll.getAllGuildVolunteer();
      }

    /**
     * Calls the add Guild Volunteer function
     *
     * @param gv
     */
    public void addGuildVolunteer(GuildVolunteer gv)
      {
        try
        {
            guildVolunteerBll.addGuildVolunteer(gv);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Calls the remove Guild Volunteer function
     *
     * @param gv
     */
    public void removeGuildVolunteer(GuildVolunteer gv)
      {
        try
        {
            guildVolunteerBll.removeGuildVolunteer(gv);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Calls the update Guild Volunteer function
     *
     * @param gv
     */
    public void updateGuildVolunteer(GuildVolunteer gv)
      {
        try
        {
            guildVolunteerBll.updateGuildVolunteer(gv);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /*------------MANAGER FACADE---------------------------------------------
     */
    /**
     * Gets a list of managers
     *
     * @return
     */
    public List<Manager> getAllManagers()
      {
        return managerBll.getAllManagers();
      }

    /**
     * Calls the add Manager function
     *
     * @param mg
     */
    public void addManager(Manager mg)
      {
        try
        {
            managerBll.addManager(mg);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Calls the remove Manager function
     *
     * @param mg
     */
    public void removeManager(Manager mg)
      {
        try
        {
            managerBll.removeManager(mg);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Gets a list of managers based on the guild(s) they manage
     *
     * @param guild
     * @return
     */
    public List<Manager> getManagerFromGuild(Guild guild)
      {
        return managerBll.getManagerFromGuild(guild);
      }

    /**
     * Calls the update Manager function
     *
     * @param mg
     */
    public void updateManager(Manager mg)
      {
        try
        {
            managerBll.updateManager(mg);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /*----------------NATIONALITY FACADE----------------------------------------------------------
     */
    /**
     * Gets a list of nationalities
     *
     * @return
     */
    public List<Nationality> getAllNationalities()
      {
        return nationalityBll.getAllNationalities();
      }

    /*----TIME REGISTER FACADE-----------------------------------------
     */
    /**
     * Gets a list of time based on a volunteers database id
     *
     * @param vtrId
     * @return
     */
    public List<VolunteerTime> getVolunteerTimeBasedOnVtrId(int vtrId)
      {
        return timeRegistrationManager.getVolunteerTimeBasedOnVtrId(vtrId);
      }

    /**
     * Gets a list of time based on the id of volunteers and guilds
     *
     * @param vtrId
     * @param gdId
     * @return
     */
    public List<VolunteerTime> getVolunteerAndGuildTimeBasedOnId(int vtrId, int gdId)
      {
        return timeRegistrationManager.getVolunteerAndGuildTimeBasedOnId(vtrId, gdId);
      }

    /**
     * Calls the add time function
     *
     * @param vTime
     */
    public void addVolunteerTime(VolunteerTime vTime)
      {
        try
        {
            timeRegistrationManager.addVolunteerTime(vTime);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

      }

    /**
     * Calls the remove time function
     *
     * @param vTime
     */
    public void removeVolunteerTime(VolunteerTime vTime)
      {
        try
        {
            timeRegistrationManager.removeVolunteerTime(vTime);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Calls the update time function
     *
     * @param vTime
     */
    public void updateVolunteerTime(VolunteerTime vTime)
      {
        try
        {
            timeRegistrationManager.updateVolunteerTime(vTime);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /*----------VOLUNTEER FACADE--------------------------------------------
     */
    /**
     * Gets a list of volunteers from the database
     *
     * @return
     */
    public List<Volunteer> getAllVolunteers()
      {
        return volunteerBll.getAllVolunteers();
      }

    /**
     * Calls the add Volunteer function
     *
     * @param vtr
     */
    public void addVolunteer(Volunteer vtr)
      {
        try
        {
            volunteerBll.addVolunteer(vtr);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Calls the remove Volunteer function
     *
     * @param vtr
     */
    public void removeVolunteer(Volunteer vtr)
      {
        try
        {
            volunteerBll.removeVolunteer(vtr);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }

    /**
     * Gets a list of volunteers based on guilds they are a part of
     *
     * @param newValue
     * @return
     */
    public List<Volunteer> getVolunteersFromGuild(Guild newValue)
      {
        return volunteerBll.getVolunteersFromGuild(newValue);
      }

    /**
     * Calls the update Volunteer function
     *
     * @param vtr
     */
    public void updateVolunteer(Volunteer vtr)
      {
        try
        {
            volunteerBll.updateVolunteer(vtr);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
      }
  }
