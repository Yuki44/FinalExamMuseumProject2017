package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.GuildVolunteer;
import museumApp.bll.FacadeBll;

public class GuildVolunteerModel extends Model
  {

    private ObservableList<GuildVolunteer> guildVolunteer;

    public GuildVolunteerModel() throws IOException
      {
        facadeBll = new FacadeBll();
        guildVolunteer = FXCollections.observableArrayList(facadeBll.getAllGuildVolunteer());
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
        facadeBll.addGuildVolunteer(gv);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gv
     * @throws SQLException
     */
    public void removeGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        facadeBll.removeGuildVolunteer(gv);
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
        facadeBll.updateGuildVolunteer(gv);
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
