package museumApp.dal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import museumApp.be.Manager;
import museumApp.be.Volunteer;

public class RemoveData extends DatabaseManager
  {

    /**
     * Constructor.
     *
     * @throws IOException
     */
    public RemoveData() throws IOException
      {
      }

    /** --------------------------------------VOLUNTEER------------------------------------------------. */
    /**
     * Makes it possible to remove a volunteer from the database by use of
     * the parameters below
     *
     * @throws SQLException
     */
    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
//        TODO
      }

    /** ---------------------------------------MANAGER----------------------------------------------------. */
    /**
     * This method deletes the record of a manager from the employee table,
     * by a given first name, last name, username and password.
     *
     * @param mg
     * @throws SQLException
     */
    public void removeManager(String fName, String lName, String uName, String password) throws SQLException
      {
        String sql = "DELETE FROM employee WHERE first_name = ? AND last_name = ? AND user_name = ? AND password = ?";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, fName);
        pstmt.setString(2, lName);
        pstmt.setString(3, uName);
        pstmt.setString(4, password);
        pstmt.execute();
      }

    public void removeGuild(String guildName) throws SQLException
      {
        String sql = "DELETE FROM guild WHERE name = ?";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, guildName);
        pstmt.execute();
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
