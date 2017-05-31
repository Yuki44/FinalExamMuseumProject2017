package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.bll.FacadeBll;

public class ManagerModel extends Model
  {

    private ObservableList<Manager> managers;

    public ManagerModel() throws IOException
      {
        facadeBll = new FacadeBll();
        managers = FXCollections.observableArrayList(facadeBll.getAllManagers());
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
        facadeBll.addManager(mg); //updates database
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param mg
     * @throws SQLException
     */
    public void removeManager(Manager mg) throws SQLException
      {
        facadeBll.removeManager(mg);
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
        facadeBll.updateManager(mg);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param guild
     * @return
     */
    public List<Manager> getManagerBasedOnGuild(Guild guild)
      {
        return facadeBll.getManagerFromGuild(guild);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
