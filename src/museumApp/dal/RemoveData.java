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
    public void removeManager(Manager mg) throws SQLException
      {
        String sql = "DELETE FROM employee WHERE first_name = ? AND last_name = ? AND user_name = ? AND password = ?";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, mg.getFirstNameAsString());
        pstmt.setString(2, mg.getLastNameAsString());
        pstmt.setString(3, mg.getUserNameAsString());
        pstmt.setString(4, mg.getPasswordAsString());
        pstmt.execute();
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
