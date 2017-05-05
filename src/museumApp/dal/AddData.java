/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import museumApp.be.Manager;

/**
 *
 * @author min
 */
public class AddData extends DatabaseManager {

    public AddData() throws IOException {
    }

     /**
     * Makes it possible to add a volunteer to the system through the database
     * by use of the parameters below
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param birthDate
     * @throws SQLException
     */
    public void addVolunteer(String firstName, String lastName, Date birthDate, String phoneNumber, String email, String nationality, Date joinDate, int guildLocationId) throws SQLException
      {
        {
            String sql = "INSERT INTO volunteer(first_name, last_name, date_of_birth, phone_number, "
                    + "email, nationality, join_date,guild_location_id) Values ('?',' ?', '?', '?',' ?','?','?','?');";
            PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setDate(3, birthDate);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, email);
            pstmt.setString(6, nationality);
            pstmt.setDate(7, joinDate);
            pstmt.setInt(8, guildLocationId);
            pstmt.execute();
        }
      }

    public void addManager(Manager mg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
