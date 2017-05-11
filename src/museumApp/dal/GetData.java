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
import museumApp.be.VolunteerTime;

public class GetData extends DatabaseManager
  {

    /**
     * Constructor.
     *
     * @throws IOException
     */
    public GetData() throws IOException
      {
      }

    /** ------------------------------getAll FROM DATABASE METHODS------------------------------------------. */
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
     * Selects the VolunteerTime in the database, through a SELECT statement.
     *
     * @return
     * @throws SQLException
     */
    public List<VolunteerTime> getAllVTime() throws SQLException
      {
        List<VolunteerTime> vTime = new ArrayList<>();

        String sql = "SELECT * FROM volunteer_time";
        try (Connection con = connectionManager.getConnection())
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                vTime.add(getOneVTime(rs));
            }
            return vTime;
        }
      }

    /** ---------------------------------getOne FROM DATABASE METHODS-------------------------------------------. */
    /**
     * Gets information about one Guild in the database.
     *
     * @param rs
     * @return Guild
     * @throws SQLException
     */
    private Guild getOneGuild(ResultSet rs) throws SQLException
      {
        int id = rs.getInt("guild_id");
        String guildName = rs.getString("name");
        int manager_id = rs.getInt("manager_id");
        return new Guild(id, guildName, manager_id);
      }

    /**
     * Gets information about one VolunteerTime in the database.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private VolunteerTime getOneVTime(ResultSet rs) throws SQLException
      {
        int id = rs.getInt("guild_volunteer_id");
        Date date = rs.getDate("date");
        int hours = rs.getInt("hours");
        return new VolunteerTime(date, hours, id);
      }

    /**
     * Gets information about one Volunteer in the database.
     *
     * @param rs
     * @return Volunteer
     * @throws SQLException
     */
    private Volunteer getOneVolunteer(ResultSet rs) throws SQLException
      {
        int id = rs.getInt("volunteer_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        String phoneNumber = rs.getString("phone_number");
        Date birthDate = rs.getDate("date_of_birth");
        String nationality = rs.getString("nationality_id");
        Date registeredDate = rs.getDate("join_date");
        String comment = rs.getString("comment");

        return new Volunteer(id, firstName, lastName, birthDate, phoneNumber, email, nationality, registeredDate, comment);

      }

    /**
     * Gets information about one Manager in the database.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public Manager getOneManager(ResultSet rs) throws SQLException
      {
        int id = rs.getInt("employee_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        String userName = rs.getString("user_name");
        String password = rs.getString("password");
        return new Manager(id, firstName, lastName, email, userName, password);
      }

    /**
     * Gets information about one Administrator in the database.
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
        return new Administrator(id, firstName, lastName, email, userName, password);
      }

    /**
     * TO REFACTOR
     *
     * @param pstmt
     * @return
     * @throws SQLException
     */
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

        Manager manager = new Manager(idMgr, firstName, lastName, email, userName, password);
        return manager;
      }

    /**
     * TO REFACTOR
     *
     * @param pstmt
     * @return
     * @throws SQLException
     */
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

        Administrator admin = new Administrator(idAdm, firstName, lastName, email, userName, password);
        return admin;
      }

    /** -----------------------------------OTHER GET METHODS-----------------------------------------------. */
    /**
     *
     * @param newValue
     * @return
     * @throws SQLException
     */
    public List<Volunteer> getVolunteerBasedOnGuild(Guild newValue) throws SQLException
      {
        List<Volunteer> volunteers = new ArrayList<>();

        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT * FROM volunteer v "
                    + "INNER JOIN guild_volunteer gv ON v.volunteer_id = gv.volunteer_id "
                    + "INNER JOIN guild g ON gv.guild_id = g.guild_id "
                    + "WHERE g.guild_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, newValue.getId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                volunteers.add(getOneVolunteer(rs));
            }
            return volunteers;

        }
      }

    /**
     *
     * @param hours
     * @return
     * @throws SQLException
     */
    public List<VolunteerTime> getTimeBasedOnVolunteer(Volunteer hours) throws SQLException
      {
        List<VolunteerTime> vTime = new ArrayList<>();

        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT hours FROM volunteer_time vt "
                    + "INNER JOIN guild_volunteer gv ON vt.guild_volunteer_id = gv.guild_volunteer_id "
                    + "INNER JOIN volunteer v ON gv.volunteer_id = v.volunteer_id "
                    + "WHERE v.volunteer_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, hours.getId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                vTime.add(getOneVTime(rs));
            }
            return vTime;
        }
      }

    /**
     *
     * @param username
     * @return
     */
    public Manager getManagerBasedOnUsername(String username)
      {
        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT * FROM employee WHERE employee_type_id = 1 AND user_name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);

            return getManagerFromResults(pstmt); // REFACTOR
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }
      }

    /**
     *
     * @param username
     * @return
     */
    public Administrator getAdminBasedOnUsername(String username)
      {
        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT * FROM employee WHERE employee_type_id = 2 AND user_name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);

            return getAdminFromResults(pstmt); // REFACTOR
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }
      }

    /**
     *
     * @param username
     * @param password
     * @return
     */
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

    /**
     *
     * @param username
     * @param password
     * @return
     */
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

    /**
     *
     * @param guildName
     * @return
     */
    public int filterHoursByGuild(String guildName)
      {
        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT COUNT(hours)FROM volunteer_time vt INNER JOIN guild_volunteer gv "
                    + "ON vt.guild_volunteer_id =gv.guild_volunteer_id INNER JOIN guild g "
                    + "ON gv.guild_id =g.guild_id WHERE g.name='%'?'%";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, guildName);
            ResultSet rs = pstmt.executeQuery();
            return rs.getInt(query);
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle);
            return 0;
        }
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
