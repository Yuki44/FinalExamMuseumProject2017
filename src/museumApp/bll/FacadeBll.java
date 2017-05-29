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
    public void addGuild(Guild gd)
      {
        try
        {
            guildBll.addGuild(gd);
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
        }
      }

    public void removeGuild(Guild gd)
      {
        try
        {
            guildBll.removeGuild(gd);
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
        }
      }

    public void updateGuild(Guild gd)
      {
        try
        {
            guildBll.updateGuild(gd);
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
        }
      }

    public List<Guild> getAllGuilds()
      {
        return guildBll.getAllGuilds();
      }
    /*-------------ADMIN FACADE-----------------------------------------------------------    
    */
     public List<Administrator> getAllAdmins()
           {
               return adminBll.getAllAdmins();
           }
      
      public void addAdministrator(Administrator ad) 
      {
        try {
            adminBll.addAdministrator(ad);
        } catch (SQLException ex) {
            System.err.println(ex.getCause());
        }
      }
      
       public void removeAdministrator(Administrator ad)
      {
        try {
            adminBll.removeAdministrator(ad);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
        public void updateAdministrator(Administrator ad)
      {
        try {
            adminBll.updateAdministrator(ad);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
        /*-----------GUILD VOLUNTEER FACADE-------------------------------------------        
        */
        public List<GuildVolunteer> getAllGuildVolunteer()
      {
          return guildVolunteerBll.getAllGuildVolunteer();
      }
        
        public void addGuildVolunteer(GuildVolunteer gv) 
      {
        try {
            guildVolunteerBll.addGuildVolunteer(gv);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
         public void removeGuildVolunteer(GuildVolunteer gv) 
         {
        try {
            guildVolunteerBll.removeGuildVolunteer(gv);
        } catch (SQLException ex) {
            System.err.println(ex.getCause());
        }
      }
         public void updateGuildVolunteer(GuildVolunteer gv)
      {
        try {
            guildVolunteerBll.updateGuildVolunteer(gv);
        } catch (SQLException ex) {
           System.err.println(ex.getCause());  
        }
      }
     /*------------MANAGER FACADE---------------------------------------------         
         */
          public List<Manager> getAllManagers()
      {
          return managerBll.getAllManagers();
      }
          
            public void addManager(Manager mg)
      {
        try {
            managerBll.addManager(mg);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
            
             public void removeManager(Manager mg) 
      {
        try {
            managerBll.removeManager(mg);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
             
  public List<Manager> getManagerFromGuild(Guild guild)
      {
          return managerBll.getManagerFromGuild(guild);
      }
  
  
    public void updateManager(Manager mg)
      {
        try {
            managerBll.updateManager(mg);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
    /*----------------NATIONALITY FACADE----------------------------------------------------------    
    */
     public List<Nationality> getAllNationalities()
      {
          return nationalityBll.getAllNationalities();
      }
     
     /*----TIME REGISTER FACADE-----------------------------------------     
     */
      public List<VolunteerTime> getAllVolunteerTime()
      {
          return timeRegistrationManager.getAllVolunteerTime();
      }
      
       public void addVolunteerTime(VolunteerTime vTime)
      {
          timeRegistrationManager.addVolunteerTime(vTime);

      }
       
        public void removeVolunteerTime(VolunteerTime vTime) 
      {
        try {
            timeRegistrationManager.removeVolunteerTime(vTime);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }

    public void updateVolunteerTime(VolunteerTime vTime) 
      {
        try {
            timeRegistrationManager.updateVolunteerTime(vTime);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
    /*----------VOLUNTEER FACADE--------------------------------------------    
    */
      public List<Volunteer> getAllVolunteers()
      {
          return volunteerBll.getAllVolunteers();
      }
      
       public void addVolunteer(Volunteer vtr) 
      {
        try {
            volunteerBll.addVolunteer(vtr);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
         public void removeVolunteer(Volunteer vtr) 
      {
        try {
            volunteerBll.removeVolunteer(vtr);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
           public List<Volunteer> getVolunteersFromGuild(Guild newValue)
      {
          return volunteerBll.getVolunteersFromGuild(newValue);
      }

    public void updateVolunteer(Volunteer vtr) 
      {
        try {
            volunteerBll.updateVolunteer(vtr);
        } catch (SQLException ex) {
             System.err.println(ex.getCause());
        }
      }
  }
