package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.GuildVolunteer;
import museumApp.bll.FacadeBll;

public class GuildVolunteerModel extends Model
  {

    private ObservableList<GuildVolunteer> guildVolunteer = FXCollections.observableArrayList();

    /**
     * Constructor
     *
     * @throws IOException
     */
    public GuildVolunteerModel() throws IOException
      {
        facadeBll = new FacadeBll();
        Runnable r = () ->
        {
            setGuildVolunteersIntoObservable();
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method gets a list of guild volunteers.
     *
     * @return guildVolunteer
     */
    public ObservableList<GuildVolunteer> getGuildVolunteer()
      {
        return guildVolunteer;
      }

    /**
     * This method sets the list of guild volunteers
     */
    public void setGuildVolunteersIntoObservable()
      {
        guildVolunteer.clear();
        guildVolunteer.addAll(facadeBll.getAllGuildVolunteer());
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method calls the add guild volunteer method.
     *
     * @param gv
     * @throws SQLException
     */
    public void addGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        guildVolunteer.add(gv);
        Runnable r = () ->
        {

            facadeBll.addGuildVolunteer(gv);

        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();

      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method calls the remove guild volunteer method.
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
  }
