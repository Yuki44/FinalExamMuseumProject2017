package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Guild;
import museumApp.bll.GuildBll;

public class GuildModel extends Model
  {

    private ObservableList<Guild> guilds;

    public GuildModel() throws IOException
      {
        guildBll = new GuildBll();
        guilds = FXCollections.observableArrayList(guildBll.getAllGuilds());
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

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gd
     * @throws SQLException
     */
    public void addGuild(Guild gd) throws SQLException
      {
        guilds.add(gd);
        guildBll.addGuild(gd);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gd
     * @throws SQLException
     */
    public void removeGuild(Guild gd) throws SQLException
      {
        guildBll.removeGuild(gd);
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
        guildBll.updateGuild(gd);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
