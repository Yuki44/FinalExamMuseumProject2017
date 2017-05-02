/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Manager;
import museumApp.be.User;
import museumApp.bll.MuseumManager;

/**
 *
 * @author Peder
 */
public class UserModel extends Model
  {

    private MuseumManager museumManager;

    private ObservableList<Manager> managers;

    public UserModel() throws IOException
      {
        super();
        museumManager = new MuseumManager();
        managers = FXCollections.observableArrayList(museumManager.getAllManagers());
      }

    public ObservableList<Manager> getManagers()
      {
        return managers;
      }

    /**
     * @return an ArrayList of the different user types.
     * @throws SQLException
     */
    public List<User> getUsers() throws SQLException
      {
        List<User> result = new ArrayList<>();
        result.addAll(dataManager.getAllVolunteers());
        result.addAll(dataManager.getAllManagers());
        result.addAll(dataManager.getAllAdmins());
        return result;
      }

  }
