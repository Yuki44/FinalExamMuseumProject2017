package museumApp.dal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;

public class AddData extends DatabaseManager
  {

    /**
     * Constructor
     *
     * @throws IOException
     */
    public AddData() throws IOException
      {
      }

    /** -----------------------------------VOLUNTEER-------------------------------------------------------. */
    /**
     * Makes it possible to add a volunteer to the system through the database
     * by use of the volunteer parameters:
     *
     * @param vtr
     * @throws SQLException
     */
    public void addVolunteer(Volunteer vtr) throws SQLException
      {
        {
            String sql = "INSERT INTO volunteer(first_name, last_name, date_of_birth, phone_number, "
                    + "email, nationality, join_date,guild_location_id) Values (?,?,?,?,?,?,?);";
            PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);

            pstmt.setString(1, vtr.getFirstNameAsString());
            pstmt.setString(2, vtr.getLastNameAsString());
            pstmt.setDate(3, vtr.getBirthDate());
            pstmt.setString(4, vtr.getPhoneNumberAsString());
            pstmt.setString(5, vtr.getEmailAsString());
            pstmt.setString(6, vtr.getNationalityAsString());
            pstmt.setDate(7, vtr.getRegisteredDate());
            pstmt.execute();
        }
      }

    /** ----------------------------------------MANAGER-----------------------------------------------------. */
    /**
     * This method makes it possible to add a manager to the system.
     *
     * @param mg
     * @throws SQLException
     */
    public void addManager(Manager mg) throws SQLException
      {
        String sql = "INSERT INTO employee (first_name, last_name, email, user_name, password) "
                + "Values (?,?,?,?,?);";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, mg.getFirstNameAsString());
        pstmt.setString(2, mg.getLastNameAsString());
        pstmt.setString(3, mg.getEmailAsString());
        pstmt.setString(4, mg.getUserNameAsString());
        pstmt.setString(5, mg.getPasswordAsString());
        pstmt.executeUpdate();
      }

    /** -----------------------------------------HOURS-----------------------------------------------------. */
    /**
     * This method makes it possible to register hours to the database.
     *
     * @param vTime
     * @throws SQLException
     */
    public void addHours(VolunteerTime vTime) throws SQLException
      {
        String sql = "INSERT INTO volunteer_time (guild_volunteer_id, date, hours) VALUES ( ? , ? , ?) ";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, vTime.getId());
        pstmt.setDate(2, vTime.getDate());
        pstmt.setInt(3, vTime.getHours());
        pstmt.executeUpdate();
      }

    /** ------------------------------------------GUILD--------------------------------------------------. */
    /**
     * This method makes it possible to add a guild to the system.
     *
     * @param gd
     * @throws SQLException
     */
    public void addGuild(Guild gd) throws SQLException
      {
        String sql = "INSERT INTO guild (name, manager_id) VALUES ('?',?) ";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, gd.getNameAsString());
        pstmt.setInt(2, gd.getManagerId());
        pstmt.executeUpdate();
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
