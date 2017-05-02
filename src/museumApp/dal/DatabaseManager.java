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
import museumApp.be.Manager;
import museumApp.be.Volunteer;

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
    private Manager getOneManager(ResultSet rs) throws SQLException
    {
        String userName = rs.getString("user_name");
        String password = rs.getString("password");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        String phoneNumber = rs.getString("phone_number");
        Date birthDate = rs.getDate("date_of_birth");
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
        String phoneNumber = rs.getString("phone_number");
        Date birthDate = rs.getDate("date_of_birth");
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
    public void addVolunteer(String firstName, String lastName, String email, String phoneNumber, Date birthDate) throws SQLException
    {
        String sql = "INSERT INTO volunteer Values (?, ?, ?, ?, ?);";
        PreparedStatement pstmt = connectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, email);
        pstmt.setString(4, phoneNumber);
        pstmt.setDate(5, birthDate);
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
}
