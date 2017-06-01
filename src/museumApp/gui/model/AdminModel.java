package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Administrator;
import museumApp.bll.FacadeBll;

public class AdminModel extends Model
  {

    private ObservableList<Administrator> admins = FXCollections.observableArrayList();

    /**
     * Constructor
     *
     * @throws IOException
     */
    public AdminModel() throws IOException
      {
        facadeBll = new FacadeBll();
        Runnable r = () ->
        {
            setAdminsIntoObservable();
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method gets a list of administrators.
     *
     * @return admins
     */
    public ObservableList<Administrator> getAdministrators()
      {
        return admins;
      }

    /**
     * This method sets a list of administrators.
     */
    public void setAdminsIntoObservable()
      {
        admins.clear();
        admins.addAll(facadeBll.getAllAdmins());
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method calls the add admin method.
     *
     * @param ad
     * @throws SQLException
     */
    public void addAdministrator(Administrator ad) throws SQLException
      {
        admins.add(ad); //updates gui through observable
        Runnable r = () ->
        {

            facadeBll.addAdministrator(ad); //updates database

        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method calls the remove admin method.
     *
     * @param ad
     * @throws SQLException
     */
    public void removeAdministrator(Administrator ad) throws SQLException
      {
        facadeBll.removeAdministrator(ad);
        admins.remove(ad);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method calls the update admin method.
     *
     * @param ad
     * @throws SQLException
     */
    public void updateAdministrator(Administrator ad) throws SQLException
      {
        facadeBll.updateAdministrator(ad);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
