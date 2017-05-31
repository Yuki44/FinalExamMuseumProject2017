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
         String sql = "UPDATE employee SET e_first_name=?, e_last_name=?, e_email=?, user_name=?, password=?"
                   + " WHERE employee_id=?";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ad.getFirstNameAsString());
            pstmt.setString(2, ad.getLastNameAsString());
            pstmt.setString(3,ad.getEmailAsString());
            pstmt.setString(4, ad.getUserNameAsString());
            pstmt.setString(5, ad.getPasswordAsString());
            pstmt.setInt(6, ad.getId());
           
             pstmt.execute();
      }
      }
    
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param gd
     * @throws SQLException
     */
    public void updateGuild(Guild gd) throws SQLException
       {
           String sql = "UPDATE guild SET name=? ,manager_id=? WHERE guild_id=?";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, gd.getNameAsString());
            pstmt.setInt(2, gd.getManager().getId());
            pstmt.setInt(3, gd.getId());
            
             pstmt.execute();
      }
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
         String sql = "UPDATE employee SET e_first_name=? ,e_last_name=? ,e_email=? ,user_name=? ,password=?"
                   + " WHERE employee_id=?";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mg.getFirstNameAsString());
            pstmt.setString(2, mg.getLastNameAsString());
            pstmt.setString(3,mg.getEmailAsString());
            pstmt.setString(4, mg.getUserNameAsString());
            pstmt.setString(5, mg.getPasswordAsString());
            pstmt.setInt(6, mg.getId());
           
             pstmt.execute();
      }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vTime
     * @throws SQLException
     */
    public void updateVolunteerTime(VolunteerTime vTime) throws SQLException
      {
           String sql = "UPDATE volunteer_time SET hours=? WHERE guild_id=? AND volunteer_id=? AND date=? ";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, vTime.getHours());
            pstmt.setInt(2, vTime.getGuild().getId());
            pstmt.setInt(3, vTime.getVolunteer().getId());
            pstmt.setDate(4,vTime.getDate());
            
             pstmt.execute();
      }
      }
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     *
     * @param vtr
     * @throws SQLException
     */
    public void updateVolunteer(Volunteer vtr) throws SQLException
      {
        String sql = "UPDATE volunteer SET first_name= ?, last_name=?, date_of_birth=?, phone_number = ?, "
                + "nationality =?, email=? ,join_date=?, comment=?, address=? ,city=? ,zip_code=? ,country =?,"
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
