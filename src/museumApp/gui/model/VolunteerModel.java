package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Guild;
import museumApp.be.Volunteer;
import museumApp.bll.FacadeBll;

public class VolunteerModel extends Model
  {

    private ObservableList<Volunteer> volunteers = FXCollections.observableArrayList();

    public VolunteerModel() throws IOException
      {
        facadeBll = new FacadeBll();
        Runnable r = () ->
        {
            setVolunteersIntoObservable();
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @return volunteers
     */
    public ObservableList<Volunteer> getVolunteers()
      {
        return volunteers;
      }

    public void setVolunteersIntoObservable()
      {
        volunteers.clear();
        volunteers.addAll(facadeBll.getAllVolunteers());
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vtr
     * @throws SQLException
     */
    public void addVolunteer(Volunteer vtr) throws SQLException
      {
        volunteers.add(vtr);

        Runnable r = () ->
        {
            facadeBll.addVolunteer(vtr);
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vtr
     * @throws SQLException
     */
    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
        facadeBll.removeVolunteer(vtr);
        volunteers.remove(vtr);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vtr
     * @throws SQLException
     */
    public void updateVolunteer(Volunteer vtr) throws SQLException
      {
        facadeBll.updateVolunteer(vtr);
        volunteers.add(vtr);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Comes from listGenerator() in ChooseVolunterGuildViewController
     *
     * @param newValue
     * @return
     */
    public List<Volunteer> getVolunteerFromGuild(Guild newValue)
      {
        return facadeBll.getVolunteersFromGuild(newValue);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
