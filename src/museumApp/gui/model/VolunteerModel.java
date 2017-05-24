package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Guild;
import museumApp.be.Volunteer;
import museumApp.bll.VolunteerBll;

public class VolunteerModel extends Model
  {

    private ObservableList<Volunteer> volunteers;

    public VolunteerModel() throws IOException
      {
        volunteerBll = new VolunteerBll();
        volunteers = FXCollections.observableArrayList(volunteerBll.getAllVolunteers());
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

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vtr
     * @throws SQLException
     */
    public void addVolunteer(Volunteer vtr) throws SQLException
      {
        volunteers.add(vtr);
        volunteerBll.addVolunteer(vtr);

      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vtr
     * @throws SQLException
     */
    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
        volunteerBll.removeVolunteer(vtr);
        volunteers.remove(vtr);
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
        return volunteerBll.getVolunteersFromGuild(newValue);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
