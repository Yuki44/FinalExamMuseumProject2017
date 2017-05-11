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
    private ObservableList<Volunteer> volunteerFromGuild;
    private ObservableList<VolunteerTime> volunteerTime;

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
        vTime = new VolunteerTime(new Date(2017, 05, 10), 4, 1);
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
      }

    /** -------------------------------------------------------------------------------------------. */
    /**
     * REFACTOR.
     */
    public void addTime()
      {
        timeRegistrationManager.Add(vTime);
      }

    /** --------------------------------------------------GET METHODS------------------------------------------------------------. */
    public ObservableList<Volunteer> getVolunteerFromGuild()
      {
        return volunteerFromGuild;
      }

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

    public void removeManager(Manager mg) throws SQLException
      {
        managers.remove(mg);
        museumManager.removeManager(mg);
      }

    /** --------------------------------VOLUNTEER--------------------------------------------------. */
    public void addVolunteer(Volunteer vtr) throws SQLException
      {
        volunteers.add(vtr);
        museumManager.addVolunteer(vtr);
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

    /** -------------------------------------------------------------------------------------------. */
  }
