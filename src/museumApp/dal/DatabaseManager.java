/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
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
import sun.plugin.dom.DOMObjectHelper;

/**
 *
 * @author min
 */
public class DatabaseManager
{

    private final ConnectionManager connectionManager;

    /**
     * Instantiates the ConnectionManager
     *
     * @throws IOException
     */
    public DatabaseManager() throws IOException
    {
        connectionManager = new ConnectionManager();

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

        String sql = "SELECT * FROM manager";
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

        String sql = "SELECT * FROM administrator";
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
        int id = rs.getInt("volunteer_id");
        return new Volunteer(lastName, birthDate, email, birthDate, phoneNumber, firstName, lastName, email, id);

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
        int id = rs.getInt("manager_id");

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
        int id = rs.getInt("administrator_id");
        return new Administrator(userName, password, firstName, lastName, email, id);
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
    public void addVolunteer(String firstName, String lastName, Date birthDate, String phoneNumber, String email, String nationality,Date joinDate,int guildLocationId ) throws SQLException
    {
        String sql = "INSERT INTO volunteer(first_name, last_name, date_of_birth, phone_number, "
                + "email, nationality, join_date,guild_location_id) Values ('?',' ?', '?', '?',' ?','?','?','?');";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setDate(3,birthDate);
        pstmt.setString(4, phoneNumber);
        pstmt.setString(5, email);
        pstmt.setString(6, nationality);
        pstmt.setDate(7,joinDate);
        pstmt.setInt(8,guildLocationId);
        pstmt.execute();
    }

    /**
     * Makes it possible to remove a volunteer from the database by use of the
     * parameters below
     *
     * @param firstName
     * @param lastName
     * @throws SQLException
     */
    public void removeVolunteer(String firstName, String lastName) throws SQLException
    {
        String sql = "DELETE FROM volunteer WHERE first_name = (?) and last_name = (?);";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.execute();
    }

    public boolean checkPasswordForManager(String username, String password)
    {
        try (Connection con = connectionManager.getConnection())
        {
            String query1 = "SELECT * FROM manager WHERE user_name = ?";
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
            String query1 = "SELECT * FROM administrator WHERE user_name = ?";
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

    public Manager getManagerFromResults(PreparedStatement pstmt) throws SQLException
    {
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int idMgr = rs.getInt("manager_id");
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
        int idAdm = rs.getInt("administrator_id");
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
            String query = "SELECT * FROM manager WHERE user_name = ?";
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
            String query = "SELECT * FROM administrator WHERE user_name = ?";
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
}
