package museumApp.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import museumApp.be.Administrator;
import museumApp.be.Guild;
import museumApp.be.GuildVolunteer;
import museumApp.be.Manager;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;

public class UpdateData extends DatabaseManager
  {

    /**
     * Constructor
     *
     * @throws IOException
     */
    public UpdateData() throws IOException
      {
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param ad
     * @throws SQLException
     */
    public void updateAdministrator(Administrator ad) throws SQLException
      {
        // TODO
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gd
     * @throws SQLException
     */
    public void updateGuild(Guild gd) throws SQLException
      {
        // TODO
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gv
     * @throws SQLException
     */
    public void updateGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        // TODO
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param mg
     * @throws SQLException
     */
    public void updateManager(Manager mg) throws SQLException
      {
        // TODO
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vTime
     * @throws SQLException
     */
    public void updateVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        // TODO
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vtr
     * @throws SQLException
     */
    public void updateVolunteer(Volunteer vtr) throws SQLException
      {
        String sql = "UPDATE volunteer SET first_name= ? last_name=? date_of_birth=? phone_number = ? "
                + "nationality =? email=? join_date=? comment=? address=? city=? zip_code=? country =?"
                + " photo=? WHERE volunteer_id = ? ";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,vtr.getFirstNameAsString());
            pstmt.setString(2, vtr.getLastNameAsString());
            pstmt.setString(3,vtr.getBirthDateAString());
            pstmt.setString(4, vtr.getPhoneNumberAsString());
            pstmt.setString(5, vtr.getNationalityAsString());
            pstmt.setString(6, vtr.getEmailAsString());
            pstmt.setDate(7,vtr.getRegisteredDate());
            pstmt.setString(8, vtr.getCommentAsString());
            pstmt.setString(9, vtr.getAddressAsString());
            pstmt.setString(10, vtr.getCityAsString());
            pstmt.setString(11, vtr.getZipCodeAsString());
            pstmt.setString(12, vtr.getCountryAsString());
            pstmt.setString(13,vtr.getPhotoAsString());
            pstmt.setInt(14, vtr.getId());
            
            pstmt.execute();
        }
      }
    /** ----------------------------------------------------------------------------------------------------. */
    /** ----------------------------------------------------------------------------------------------------. */
  }
