package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.GuildVolunteer;
import museumApp.bll.GuildVolunteerBll;

public class GuildVolunteerModel extends Model
  {

    private ObservableList<GuildVolunteer> guildVolunteer;

    public GuildVolunteerModel() throws IOException
      {
        guildVolunteerBll = new GuildVolunteerBll();
        guildVolunteer = FXCollections.observableArrayList(guildVolunteerBll.getAllGuildVolunteer());
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @return guildVolunteer
     */
    public ObservableList<GuildVolunteer> getGuildVolunteer()
      {
        return guildVolunteer;
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gv
     * @throws SQLException
     */
    public void addGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        guildVolunteer.add(gv);
        guildVolunteerBll.addGuildVolunteer(gv);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gv
     * @throws SQLException
     */
    public void removeGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        guildVolunteerBll.removeGuildVolunteer(gv);
        guildVolunteer.remove(gv);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gv
     * @throws SQLException
     */
    public void updateGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        guildVolunteerBll.updateGuildVolunteer(gv);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
