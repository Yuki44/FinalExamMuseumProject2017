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
     * @param firstName
     * @param lastName
     * @throws SQLException
     */
    public void removeVolunteer(Volunteer vtr) throws SQLException
      {
        String sql = "DELETE FROM volunteer WHERE first_name = ('?') AND last_name = ('?');";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, vtr.getFirstNameAsString());
        pstmt.setString(2, vtr.getLastNameAsString());
        pstmt.execute();
      }

    /** ---------------------------------------MANAGER----------------------------------------------------. */
    /**
     *
     * @param mg
     * @throws SQLException
     */
    public void removeManager(Manager mg) throws SQLException
      {
        String sql = "DELETE FROM employee WHERE first_name = ('?') AND last_name = ('?') AND employee_type_id IN (1,3);";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, mg.getFirstNameAsString());
        pstmt.setString(2, mg.getLastNameAsString());
        pstmt.execute();
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
