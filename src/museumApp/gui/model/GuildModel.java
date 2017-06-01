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
     *
     * @return guilds
     */
    public ObservableList<Guild> getGuilds()
      {
        return guilds;
      }

    public void setGuildsIntoObservable()
      {
        guilds.clear();
        guilds.addAll(facadeBll.getAllGuilds());
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
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
     *
     * @param gd
     * @throws SQLException
     */
    public void updateGuild(Guild gd) throws SQLException
      {
        facadeBll.updateGuild(gd);
        guilds.add(gd);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
//  Runnable r = () ->
//        {
//
//        };
//        Thread t = new Thread(r);
//        t.setDaemon(true);
//        t.start();
