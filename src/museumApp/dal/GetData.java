/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import museumApp.be.Administrator;
import museumApp.be.Guild;
import museumApp.be.Manager;
import museumApp.be.Volunteer;

/**
 *
 * @author min
 */
public class GetData extends DatabaseManager
  {

    public GetData() throws IOException {
    }

    
    /**
     * Selects the volunteers in the database, through a SELECT statement.
     *
     * @return volunteer
     * @throws SQLException
     */
    public List<Volunteer> getAllVolunteers() throws SQLException
      {
        List<Volunteer> volunteers = new ArrayList<>();

        String sql = "SELECT * FROM volunteer";
        try (Connection con = connectionManager.getConnection())
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                volunteers.add(getOneVolunteer(rs));
            }
            return volunteers;
        }
      }

    /**
     * Selects the managers in the database, through a SELECT statement.
     *
     * @return
     * @throws SQLException
     */
    public List<Manager> getAllManagers() throws SQLException
      {
        List<Manager> managers = new ArrayList<>();

        String sql = "SELECT * FROM employee WHERE employee_type_id = 1";
        try (Connection con = connectionManager.getConnection())
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                managers.add(getOneManager(rs));
            }
            return managers;
        }
      }

    /**
     * Selects the administrator in the database, through a SELECT statement.
     *
     * @return
     * @throws SQLException
     */
    public List<Administrator> getAllAdmins() throws SQLException
      {
        List<Administrator> admin = new ArrayList<>();

        String sql = "SELECT * FROM employee WHERE employee_type_id = 2";
        try (Connection con = connectionManager.getConnection())
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                admin.add(getOneAdmin(rs));
            }
            return admin;
        }
      }

    /**
     * Selects the Guild in the database, through a SELECT statement.
     *
     * @return
     * @throws SQLException
     */
    public List<Guild> getAllGuilds() throws SQLException
      {
        List<Guild> guild = new ArrayList<>();

        String sql = "SELECT * FROM guild";
        try (Connection con = connectionManager.getConnection())
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                guild.add(getOneGuild(rs));
            }
            return guild;
        }
      }

    /**
     * Gets information about one Guild in the database.
     *
     * @param rs
     * @return Guild
     * @throws SQLException
     */
    private Guild getOneGuild(ResultSet rs) throws SQLException
      {
        String guildName = rs.getString("name");
        int manager_id = rs.getInt("manager_id");
        int id = rs.getInt("guild_id");
        return new Guild(guildName, manager_id, id);
      }

    /**
     * Gets information about one volunteer in the database.
     *
     * @param rs
     * @return Volunteer
     * @throws SQLException
     */
    private Volunteer getOneVolunteer(ResultSet rs) throws SQLException
      {

        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        String phoneNumber = rs.getString("phone_number");
        Date birthDate = rs.getDate("date_of_birth");
        Date registeredDate= rs.getDate("join_date");
        String nationality= rs.getString("nationality");
        int id = rs.getInt("volunteer_id");
        return new Volunteer(id, firstName,lastName,birthDate,phoneNumber,  email, nationality,registeredDate );

      }

    /**
     * Gets information about one manager in the database.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public Manager getOneManager(ResultSet rs) throws SQLException
      {
        String userName = rs.getString("user_name");
        String password = rs.getString("password");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        int id = rs.getInt("employee_id");

        return new Manager(userName, password, firstName, lastName, email, id);

      }

    /**
     * Gets information about one administrator in the database.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Administrator getOneAdmin(ResultSet rs) throws SQLException
      {
        String userName = rs.getString("user_name");
        String password = rs.getString("password");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        int id = rs.getInt("employee_id");
        return new Administrator(userName, password, firstName, lastName, email, id);
      }

    public Manager getManagerFromResults(PreparedStatement pstmt) throws SQLException
      {
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int idMgr = rs.getInt("employee_id");
        String userName = rs.getString("user_name");
        String password = rs.getString("password");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");

        Manager manager = new Manager(userName, password, firstName, lastName, email, idMgr);
        return manager;
      }

    public Administrator getAdminFromResults(PreparedStatement pstmt) throws SQLException
      {
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int idAdm = rs.getInt("employee_id");
        String userName = rs.getString("user_name");
        String password = rs.getString("password");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");

        Administrator admin = new Administrator(userName, password, firstName, lastName, email, idAdm);
        return admin;
      }

    public Manager getManagerBasedOnUsername(String username)
      {
        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT * FROM employee WHERE employee_type_id = 1 AND user_name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);

            return getManagerFromResults(pstmt);
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }
      }

    public Administrator getAdminBasedOnUsername(String username)
      {
        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT * FROM employee WHERE employee_type_id = 2 AND user_name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);

            return getAdminFromResults(pstmt);
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }
      }
public boolean checkPasswordForManager(String username, String password)
      {
        try (Connection con = connectionManager.getConnection())
        {
            String query1 = "SELECT * FROM employee WHERE employee_type_id = 1 AND user_name = ?";
            PreparedStatement pstmt = con.prepareStatement(query1);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            return password.equals(rs.getString("password"));
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle);
            return false;
        }
      }

    public boolean checkPasswordForAdmin(String username, String password)
      {
        try (Connection con = connectionManager.getConnection())
        {
            String query1 = "SELECT * FROM employee WHERE employee_type_id = 2 AND user_name = ?";
            PreparedStatement pstmt = con.prepareStatement(query1);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            return password.equals(rs.getString("password"));
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle);
            return false;
        }
      }
 
  }
