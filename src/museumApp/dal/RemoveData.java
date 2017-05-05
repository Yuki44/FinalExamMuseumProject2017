/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import museumApp.be.Volunteer;

/**
 *
 * @author min
 */
public class RemoveData extends DatabaseManager {

    public RemoveData() throws IOException {
    }

     /**
     * Makes it possible to remove a volunteer from the database by use of
     * the parameters below
     *
     * @param firstName
     * @param lastName
     * @throws SQLException
     */
    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
        String sql = "DELETE FROM volunteer WHERE first_name = (?) AND last_name = (?);";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, vtr.getFirstNameAsString());
        pstmt.setString(2, vtr.getLastNameAsString());
        pstmt.execute();
      }

    
}
