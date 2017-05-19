package museumApp.dal;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import museumApp.be.Guild;
import museumApp.be.GuildVolunteer;
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
    public void addVolunteer(String firstName, String lastName, String phoneNumber, String email) throws SQLException
      {
        {
          String sql = "INSERT INTO volunteer(first_name, last_name,  phone_number,email) VALUES (?,?,?,?);";
          PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, email);
         //  pstmt.setString(5, nationality);
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
    public void addHours(VolunteerTime vTime, GuildVolunteer gv) throws SQLException
      {
        String sql = "INSERT INTO volunteer_time (guild_id, volunteer_id, date, hours) VALUES ( ? ,?, '?', ?) ";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, gv.getGuildID());
        pstmt.setInt(2, gv.getVolunteerId());
        pstmt.setDate(3, vTime.getDate());
        pstmt.setInt(4, vTime.getHours());
        pstmt.executeUpdate();
        //TODO: add update id on vTime.
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
        String sql = "INSERT INTO guild (name, manager_id) VALUES (?,?) ";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, gd.getNameAsString());
        pstmt.setInt(2, gd.getManagerId());
        pstmt.executeUpdate();
      }

    public void addVolunteerTimeHours(Date date, int hours, Volunteer vt, Guild gd) throws SQLException {
         String sql = "INSERT INTO volunteer_time (volunteer_id, guild_id, date, hours) VALUES (?,?,?,?);";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1,vt.getId() );
        pstmt.setInt(2, gd.getId());
        pstmt.setDate(3, date);
        pstmt.setInt(4,hours);
        pstmt.execute();
        
    }
    /** ----------------------------------------------------------------------------------------------------. */
  
  }
