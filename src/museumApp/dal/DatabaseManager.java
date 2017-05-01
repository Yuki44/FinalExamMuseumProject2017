/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
        int id = rs.getInt("id");
        return new Volunteer(firstName, lastName, email, phoneNumber, birthDate, id);
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
        int id = rs.getInt("id");
        return new Manager(userName, password, firstName, lastName, email, phoneNumber, birthDate, id);

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
        int id = rs.getInt("id");
        return new Administrator(userName, password, firstName, lastName, email, phoneNumber, birthDate, id);
    }
}
