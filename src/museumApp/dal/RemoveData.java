package museumApp.dal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import museumApp.be.Guild;
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
    public void removeManager(Manager manager) throws SQLException
      {
        String sql = "DELETE FROM employee WHERE employee_id = ? AND employee_type_id = 1 ";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, manager.getId());
        pstmt.execute();
      }

    public void removeGuild(Guild guild) throws SQLException
      {
        String sql = "DELETE FROM guild WHERE guild_id = ?";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, guild.getId());
        pstmt.execute();
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
