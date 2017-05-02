package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Administrator;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.be.User;
import museumApp.be.Volunteer;
import museumApp.bll.MuseumManager;

public class UserModel extends Model
  {

    private MuseumManager museumManager;

    private ObservableList<Manager> managers;
    private ObservableList<Volunteer> volunteers;
    private ObservableList<Guild> guilds;
    private ObservableList<Administrator> admins;

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
    /**
     * PLEASE CHECK - PLEASE CHECK - PLEASE CHECK - PLEASE CHECK - PLEASE CHECK
     *
     * WHY DO WE HAVE THIS getUsers()??? Any reason??.
     *
     * @return an ArrayList of the different user types.
     * @throws SQLException
     */
    public List<User> getUsers() throws SQLException
      {
        List<User> result = new ArrayList<>();
        result.addAll(museumManager.getAllVolunteers());
        result.addAll(museumManager.getAllManagers());
        result.addAll(museumManager.getAllAdmins());
        return result;
      }

  }
