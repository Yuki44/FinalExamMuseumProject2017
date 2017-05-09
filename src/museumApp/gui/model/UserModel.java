package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Administrator;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.be.Volunteer;
import museumApp.bll.MuseumManager;

public class UserModel extends Model
  {

    private MuseumManager museumManager;

    private ObservableList<Manager> managers;
    private ObservableList<Volunteer> volunteers;
    private ObservableList<Guild> guilds;
    private ObservableList<Administrator> admins;
    private ObservableList<Volunteer> volunteerFromGuild;

    public UserModel() throws IOException
      {
        super();
        museumManager = new MuseumManager();
        /**
         * We create observable array lists for each element we want to display later
         * into the view.
         */
        managers = FXCollections.observableArrayList(museumManager.getAllManagers());
        volunteers = FXCollections.observableArrayList(museumManager.getAllVolunteers());
        guilds = FXCollections.observableArrayList(museumManager.getAllGuilds());
        admins = FXCollections.observableArrayList(museumManager.getAllAdmins());
        //  volunteerFromGuild = FXCollections.observableArrayList(museumManager.getVolunteersFromGuild());
      }

    public ObservableList<Volunteer> getVolunteerFromGuild()
      {
        return volunteerFromGuild;
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

    /** ------------------------------------------------------------------------------------------- */
//    /**
//     * PLEASE CHECK - PLEASE CHECK - PLEASE CHECK - PLEASE CHECK - PLEASE CHECK
//     *
//     * Check if this is used! if(!= true) {delete.method}
//     *
//     * @return an ArrayList of the different user types.
//     * @throws SQLException
//     */
//    public List<User> getUsers() throws SQLException
//      {
//        List<User> result = new ArrayList<>();
//        result.addAll(museumManager.getAllVolunteers());
//        result.addAll(museumManager.getAllManagers());
//        result.addAll(museumManager.getAllAdmins());
//        return result;
//      }
    /** ------------------------------------------------------------------------------------------- */
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
  }
