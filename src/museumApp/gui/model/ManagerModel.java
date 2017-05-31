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

    private ObservableList<Manager> managers = FXCollections.observableArrayList();

    public ManagerModel() throws IOException
      {
        managerBll = new ManagerBll();
        Runnable r = () ->
        {
            setManagersIntoObservable();
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
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

    public void setManagersIntoObservable()
      {
        managers.clear();
        managers.addAll(managerBll.getAllManagers());
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
     * @param mg
     * @throws SQLException
     */
    public void updateManager(Manager mg) throws SQLException
      {
        managerBll.updateManager(mg);
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
