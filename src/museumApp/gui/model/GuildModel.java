package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Guild;
import museumApp.bll.FacadeBll;

public class GuildModel extends Model
  {

    private ObservableList<Guild> guilds = FXCollections.observableArrayList();

    /**
     * Constructor
     *
     * @throws IOException
     */
    public GuildModel() throws IOException
      {
        facadeBll = new FacadeBll();
        Runnable r = () ->
        {
            setGuildsIntoObservable();
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method gets a list of guilds.
     *
     * @return guilds
     */
    public ObservableList<Guild> getGuilds()
      {
        return guilds;
      }

    /**
     * This method sets the guilds.
     */
    public void setGuildsIntoObservable()
      {
        guilds.clear();
        guilds.addAll(facadeBll.getAllGuilds());
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method calls the add guild method.
     *
     * @param gd
     * @throws SQLException
     */
    public void addGuild(Guild gd) throws SQLException
      {

        guilds.add(gd);
        Runnable r = () ->
        {

            facadeBll.addGuild(gd);

        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();

      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method calls the remove guild method.
     *
     * @param gd
     * @throws SQLException
     */
    public void removeGuild(Guild gd) throws SQLException
      {
        facadeBll.removeGuild(gd);
        guilds.remove(gd);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method calls the update guild method.
     *
     * @param gd
     * @throws SQLException
     */
    public void updateGuild(Guild gd) throws SQLException
      {
        facadeBll.updateGuild(gd);

      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
