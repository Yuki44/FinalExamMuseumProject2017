/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import museumApp.be.Guild;
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
public class FacadeBll {
    protected GetData getDbMgr;
    protected AddData addDbMgr;
    protected UpdateData updateDbMgr;
    protected RemoveData removeDbMgr;
    protected DatabaseManager DbMgr;
    protected ManagerLoginHandler managerLoginHandler;
    protected AdministratorLoginHandler adminLoginHandler;
    protected GuildBll guildBll;
    protected  AdminBll adminBll;
    protected  GuildVolunteerBll guildVolunteerBll;
    protected LoginManager loginManager;
    protected ManagerBll managerBll;
    protected NationalityBll nationalityBll;
    protected TimeRegistrationManager timeRegistrationManager;
    protected VolunteerBll volunteerBll;

    public FacadeBll() throws IOException {
        getDbMgr = new GetData();
        addDbMgr = new AddData();
        updateDbMgr = new UpdateData();
        removeDbMgr = new RemoveData();
        adminBll = new AdminBll();
        guildBll = new GuildBll();
        guildVolunteerBll = new GuildVolunteerBll();
        loginManager = new LoginManager();
        managerBll = new ManagerBll();
        nationalityBll= new NationalityBll();
        timeRegistrationManager = new TimeRegistrationManager();
        volunteerBll = new VolunteerBll();     
        
    }

    public void addGuild(Guild gd) throws SQLException {
        guildBll.addGuild(gd);
    }

    public void removeGuild(Guild gd) throws SQLException {
        guildBll.removeGuild(gd);
    }

    public void updateGuild(Guild gd) throws SQLException {
        guildBll.updateGuild(gd);
    }
    
    public List<Guild> getAllGuilds() throws SQLException{
    return guildBll.getAllGuilds();
    }
    
    
}
