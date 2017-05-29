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
        String sql = "DELETE FROM employee WHERE employee_id = ? AND employee_type_id = 1 ";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, mg.getId());
            pstmt.execute();
        }
      }

    public void removeGuild(Guild gd) throws SQLException
      {
        String sql = "DELETE FROM guild WHERE guild_id = ?";
        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, gd.getId());
            pstmt.execute();
        }
      }

    public void removeAdministrator(Administrator ad) throws SQLException
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    public void removeVolunteerTime(VolunteerTime vTime) throws SQLException
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    public void removeGuildVolunteer(GuildVolunteer gv) throws SQLException
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    public void removeVolunteerTime(Volunteer vtrTime)
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
