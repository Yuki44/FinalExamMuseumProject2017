package museumApp.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import museumApp.be.Administrator;
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

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
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
            String sql = "INSERT INTO volunteer(first_name, last_name, date_of_birth,  "
                    + "phone_number,nationality,email,join_date, photo, comment, "
                    + "address, city, zip_code, country) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";

            try (Connection con = connectionManager.getConnection())
            {
                PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                pstmt.setString(1, vtr.getFirstNameAsString());
                pstmt.setString(2, vtr.getLastNameAsString());
                pstmt.setString(3, vtr.getBirthDateAString());
                pstmt.setString(4, vtr.getPhoneNumberAsString());
                pstmt.setString(5, vtr.getNationalityAsString());
                pstmt.setString(6, vtr.getEmailAsString());
                pstmt.setDate(7, vtr.getRegisteredDate());
                pstmt.setString(8, vtr.getPhotoAsString());
                pstmt.setString(9, vtr.getCommentAsString());
                pstmt.setString(10, vtr.getAddressAsString());
                pstmt.setString(11, vtr.getCityAsString());
                pstmt.setString(12, vtr.getZipCodeAsString());
                pstmt.setString(13, vtr.getCountryAsString());

                pstmt.execute();
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next())
                {
                    int id = rs.getInt(1);
                    vtr.setId(id);
                }
            }
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
        String sql = "INSERT INTO employee (e_first_name, e_last_name, e_email, user_name, password) "
                + "Values (?,?,?,?,?);";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mg.getFirstNameAsString());
            pstmt.setString(2, mg.getLastNameAsString());
            pstmt.setString(3, mg.getEmailAsString());
            pstmt.setString(4, mg.getUserNameAsString());
            pstmt.setString(5, mg.getPasswordAsString());
            pstmt.executeUpdate();
        }
      }

    /** -----------------------------------------HOURS-----------------------------------------------------. */
    /**
     * This method makes it possible to register hours to the database.
     *
     * @param vTime
     * @throws SQLException
     */
    public void addVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        String sql = "INSERT INTO volunteer_time (volunteer_id, guild_id, date, hours) VALUES (?,?,?,?);";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, vTime.getVolunteer().getId());
            pstmt.setInt(2, vTime.getGuild().getId());
            pstmt.setDate(3, vTime.getDate());
            pstmt.setInt(4, vTime.getHours());
            pstmt.execute();
        }
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
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, gd.getNameAsString());
            pstmt.setInt(2, gd.getManager().getId());
            pstmt.executeUpdate();
        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * This method makes it possible to add a guild volunteer to the system.
     *
     * @param gv
     * @throws SQLException
     */
    public void addGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        String sql = "INSERT INTO guild_volunteer (guild_id, volunteer_id) VALUES (?,?)";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, gv.getGuild().getId());
            pstmt.setInt(2, gv.getVolunteer().getId());
            pstmt.execute();
        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    public void addAdministrator(Administrator ad) throws SQLException
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    /** ----------------------------------------------------------------------------------------------------. */
  }
