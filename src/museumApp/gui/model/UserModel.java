package museumApp.gui.model;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Administrator;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.be.Nationality;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;
import museumApp.bll.MuseumManager;
import museumApp.bll.TimeRegistrationManager;

public class UserModel extends Model
  {

    private MuseumManager museumManager;
    private TimeRegistrationManager timeRegistrationManager;
    private VolunteerTime vTime;

    private ObservableList<Manager> managers;
    private ObservableList<Volunteer> volunteers;
    private ObservableList<Guild> guilds;
    private ObservableList<Administrator> admins;
    private ObservableList<VolunteerTime> volunteerTime;
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
        museumManager = new MuseumManager();
        timeRegistrationManager = new TimeRegistrationManager();

        /**
         * We create observable array lists for each element we want to display later
         * into the view.
         */
        managers = FXCollections.observableArrayList(museumManager.getAllManagers());
        volunteers = FXCollections.observableArrayList(museumManager.getAllVolunteers());
        guilds = FXCollections.observableArrayList(museumManager.getAllGuilds());
        admins = FXCollections.observableArrayList(museumManager.getAllAdmins());
        volunteerTime = FXCollections.observableArrayList(museumManager.getAllVTime());
        nationalities = FXCollections.observableArrayList(museumManager.getNationality());

      }

    /** -------------------------------------------------------------------------------------------. */
    /**
     *
     */
    public void addTime()
      {
        timeRegistrationManager.Add(vTime);
      }

    public void setvTime(VolunteerTime vTime)
      {
        this.vTime = vTime;
      }

    /** --------------------------------------------------GET METHODS------------------------------------------------------------. */
    public ObservableList<VolunteerTime> getVTime()
      {
        return volunteerTime;
      }

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

    /** ------------------------------------MANAGER---------------------------------------------. */
    public void addManager(Manager mg) throws SQLException
      {
        managers.add(mg); //updates gui through observable
        museumManager.addManager(mg); //updates database
      }

    public void removeManager(Manager manager) throws SQLException
      {
        managers.remove(manager);
        museumManager.removeManager(manager);
      }

    /** --------------------------------VOLUNTEER--------------------------------------------------. */
    public void addVolunteer(String firstName, String lastName, String phoneNumber, String email, String nationality) throws SQLException
      {

        museumManager.addVolunteer(firstName, lastName, phoneNumber, email, nationality);

      }

    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
        volunteers.remove(vtr);
        museumManager.removeVolunteer(vtr);
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
        guilds.remove(guild);
        museumManager.removeGuild(guild);
      }

    /** ------------------------------------HOURS--------------------------------------------------. */
    public void addTime(Date date, int hours, Volunteer volunteer, Guild guild)
      {
        timeRegistrationManager.AddTime(date, hours, volunteer, guild);
// Create guild volunteer in db and get object
      }

    public ObservableList<Nationality> getNationalities()
      {
        return nationalities;
      }

    /** -------------------------------------------------------------------------------------------. */
  }
