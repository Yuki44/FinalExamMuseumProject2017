package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.bll.ManagerBll;

public class ManagerModel extends Model
  {

    private ObservableList<Manager> managers;

    public ManagerModel() throws IOException
      {
        managerBll = new ManagerBll();
        managers = FXCollections.observableArrayList(managerBll.getAllManagers());
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @return managers
     */
    public ObservableList<Manager> getManagers()
      {
        return managers;
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param mg
     * @throws SQLException
     */
    public void addManager(Manager mg) throws SQLException
      {
        managers.add(mg); //updates gui through observable
        managerBll.addManager(mg); //updates database
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param mg
     * @throws SQLException
     */
    public void removeManager(Manager mg) throws SQLException
      {
        managerBll.removeManager(mg);
        managers.remove(mg);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param guild
     * @return
     */
    public List<Manager> getManagerBasedOnGuild(Guild guild)
      {
        return managerBll.getManagerFromGuild(guild);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
