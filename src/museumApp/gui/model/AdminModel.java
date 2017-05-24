package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Administrator;
import museumApp.bll.AdminBll;

public class AdminModel extends Model
  {

    private ObservableList<Administrator> admins;

    public AdminModel() throws IOException
      {
        adminBll = new AdminBll();
        admins = FXCollections.observableArrayList(adminBll.getAllAdmins());
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @return admins
     */
    public ObservableList<Administrator> getAdministrators()
      {
        return admins;
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param ad
     * @throws SQLException
     */
    public void addAdministrator(Administrator ad) throws SQLException
      {
        admins.add(ad); //updates gui through observable
        adminBll.addAdministrator(ad); //updates database
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param ad
     * @throws SQLException
     */
    public void removeAdministrator(Administrator ad) throws SQLException
      {
        adminBll.removeAdministrator(ad);
        admins.remove(ad);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
