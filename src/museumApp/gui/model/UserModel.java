package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Administrator;
import museumApp.be.Guild;
import museumApp.be.GuildVolunteer;
import museumApp.be.Manager;
import museumApp.be.Nationality;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;

public class UserModel extends Model
  {

    /**
     * CAUTION: PROBLEM AHEAD.
     */
//    private VolunteerTime vTime;
//    private GuildVolunteer guildVolunteers;
    private ObservableList<GuildVolunteer> guildVolunteer;
    private ObservableList<VolunteerTime> volunteerTime;
    /**
     * END OF PROBLEM.
     */

    private ObservableList<Manager> managers;
    private ObservableList<Volunteer> volunteers;
    private ObservableList<Guild> guilds;
    private ObservableList<Administrator> admins;
    private ObservableList<Nationality> nationalities;

    /**
     * REFACTOR
     *
     * @throws IOException
     * @throws SQLException
     */
    public UserModel() throws IOException, SQLException
      {
        super();

        /**
         * We create observable array lists for each element we want to display later
         * into the view.
         */
        managers = FXCollections.observableArrayList(museumManager.getAllManagers());
        volunteers = FXCollections.observableArrayList(museumManager.getAllVolunteers());
        guilds = FXCollections.observableArrayList(museumManager.getAllGuilds());
        admins = FXCollections.observableArrayList(museumManager.getAllAdmins());
        nationalities = FXCollections.observableArrayList(museumManager.getNationality());
        /**
         * CAUTION: PROBLEM AHEAD.
         */
//        volunteerTime = FXCollections.observableArrayList(timeRegistrationManager.ReadAll());
//        guildVolunteer = FXCollections.observableArrayList(museumManager.getAllGuildVolunteer());
        /**
         * END OF PROBLEM.
         */
      }

    public ObservableList<VolunteerTime> getVolunteerTime()
      {
        return volunteerTime;
      }

    /** -------------------------------------------------------------------------------------------. */
    /**
     *
     */
//    public void setvTime(VolunteerTime vTime)
//      {
//        this.vTime = vTime;
//      }
    public void setGuildVolunteer(ObservableList<GuildVolunteer> guildVolunteer)
      {
        this.guildVolunteer = guildVolunteer;
      }

    /** --------------------------------------------------GET METHODS------------------------------------------------------------. */
//    public ObservableList<VolunteerTime> getVTime()
//      {
//        return volunteerTime;
//      }
    public ObservableList<Manager> getManagers()
      {
        return managers;
      }

    public ObservableList<Volunteer> getVolunteers()
      {
        return volunteers;
      }

    public void setVolunteers(ObservableList<Volunteer> volunteers)
      {
        this.volunteers = volunteers;
      }

    public ObservableList<Administrator> getAdministrators()
      {
        return admins;
      }

    public ObservableList<Guild> getGuilds()
      {
        return guilds;
      }

    public ObservableList<GuildVolunteer> getGuildVolunteers()
      {
        return guildVolunteer;
      }

    /** ------------------------------------MANAGER---------------------------------------------. */
    public void addManager(Manager mg) throws SQLException
      {
        managers.add(mg); //updates gui through observable
        museumManager.addManager(mg); //updates database
      }

    public void removeManager(Manager manager) throws SQLException
      {
        museumManager.removeManager(manager);
        managers.remove(manager);
      }

    /** --------------------------------VOLUNTEER--------------------------------------------------. */
    public void addVolunteer(Volunteer vtr) throws SQLException
      {
        volunteers.add(vtr);
        museumManager.addVolunteer(vtr);

      }

    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
        museumManager.removeVolunteer(vtr);
        volunteers.remove(vtr);
      }

    public List<Volunteer> getVolunteerFromGuild(Guild newValue)
      {
        return museumManager.getVolunteersFromGuild(newValue);
      }

    /** -----------------------------------GUILD----------------------------------------------. */
    public void addGuild(Guild gd) throws SQLException
      {
        guilds.add(gd);
        museumManager.addGuild(gd);
      }

    public List<Manager> getManagerBasedOnGuild(Guild guild) throws SQLException
      {
        return museumManager.getManagerFromGuild(guild);
      }

    public void removeGuild(Guild guild) throws SQLException
      {
        museumManager.removeGuild(guild);
        guilds.remove(guild);
      }

    /** ------------------------------------HOURS--------------------------------------------------. */
    /**
     *
     * @param vTime
     */
    public void addTime(VolunteerTime vTime) throws SQLException
      {
//        volunteerTime.add(vTime);
        timeRegistrationManager.Add(vTime);
      }

    /** ------------------------------------NATIONALITIES--------------------------------------------------. */
    /**
     *
     * @return
     */
    public ObservableList<Nationality> getNationalities()
      {
        return nationalities;
      }

    public void addGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
//        guildVolunteer.add(gv);
        museumManager.addGuildVolunteer(gv);
      }

    /** -------------------------------------------------------------------------------------------. */
  }
