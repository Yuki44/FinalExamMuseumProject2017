/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import museumApp.be.Manager;
import museumApp.be.Volunteer;

/**
 *
 * @author min
 */
public class AddData extends DatabaseManager
  {

    public AddData() throws IOException
      {
      }

    /**
     * Makes it possible to add a volunteer to the system through the database
     * by use of the parameters below
     *
     * @param vtr
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param birthDate
     * @throws SQLException
     */
    public void addVolunteer(Volunteer vtr) throws SQLException
      {
        {
            String sql = "INSERT INTO volunteer(first_name, last_name, date_of_birth, phone_number, "
                    + "email, nationality, join_date,guild_location_id) Values ('?',' ?', '?', '?',' ?','?','?');";
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

    public void addManager(Manager mg) throws SQLException
      {
        String sql = "INSERT INTO employee(first_name, last_name, email, user_name, password)"
                + "Values ('?',' ?', '?', '?',' ?');";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, mg.getFirstNameAsString());
        pstmt.setString(2, mg.getLastNameAsString());
        pstmt.setString(3, mg.getEmailAsString());
        pstmt.setString(4, mg.getUserNameAsString());
        pstmt.setString(5, mg.getPasswordAsString());
        pstmt.execute();
      }

  }
