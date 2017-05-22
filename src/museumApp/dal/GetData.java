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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import museumApp.be.Administrator;
import museumApp.be.Guild;
import museumApp.be.GuildVolunteer;
import museumApp.be.Manager;
import museumApp.be.Nationality;
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

    /**
     * ------------------------------getAll FROM DATABASE
     * METHODS------------------------------------------.
     */
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

    public List<Volunteer> getVolunteersByFirstName(String firstName) throws SQLException
      {
        List<Volunteer> volunteersByFirstName = new ArrayList<>();

        try (Connection con = connectionManager.getConnection())
        {
            String sql = "SELECT * FROM volunteer WHERE first_name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, firstName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                volunteersByFirstName.add(getOneVolunteer(rs));
            }
            return volunteersByFirstName;
        }
      }

    public List<Volunteer> getVolunteersByLastName(String lastName) throws SQLException
      {
        List<Volunteer> volunteersByLastName = new ArrayList<>();

        try (Connection con = connectionManager.getConnection())
        {
            String sql = "SELECT * FROM volunteer WHERE first_name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, lastName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                volunteersByLastName.add(getOneVolunteer(rs));
            }
            return volunteersByLastName;
        }
      }

    public List<Volunteer> getVolunteersByComment(String comment) throws SQLException
      {
        List<Volunteer> volunteersByComment = new ArrayList<>();

        try (Connection con = connectionManager.getConnection())
        {
            String sql = "SELECT * FROM volunteer WHERE comment like '%comment%'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, comment);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                volunteersByComment.add(getOneVolunteer(rs));
            }
            return volunteersByComment;
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

        String sql = "SELECT * FROM guild g INNER JOIN employee e ON g.manager_id = e.employee_id";
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

        String sql = "SELECT * FROM volunteer_time vt "
                + "INNER JOIN guild_volunteer gv ON vt.volunteer_id = gv.volunteer_id AND vt.guild_id=gv.guild_id "
                + "INNER JOIN volunteer v ON gv.volunteer_id = v.volunteer_id "
                + "INNER JOIN guild g ON g.guild_id = gv.guild_id ";

        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                vTime.add(getOneVTime(rs));
            }
            return vTime;
        }
      }

    /**
     * ---------------------------------getOne FROM DATABASE
     * METHODS-------------------------------------------.
     */
    /**
     * Gets information about one Guild in the database.
     *
     * @param rs
     * @return Guild
     * @throws SQLException
     */
    private Guild getOneGuild(ResultSet rs)
      {
        try
        {
            int id = rs.getInt("guild_id");
            String guildName = rs.getString("name");

            int manager_id = rs.getInt("manager_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String userName = rs.getString("user_name");
            String password = rs.getString("password");

            Manager manager = new Manager(manager_id, firstName, lastName, email, userName, password);
            return new Guild(id, guildName, manager);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
        Date date = rs.getDate("date");
        int hours = rs.getInt("hours");
        Volunteer volunteer = getOneVolunteer(rs);
        Guild guild = getOneGuild(rs);

        return new VolunteerTime(date, hours, volunteer, guild);
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
        String nationality = rs.getString("nationality");
        Date registeredDate = rs.getDate("join_date");
        String comment = rs.getString("comment");
        String address = rs.getString("address");
        String city = rs.getString("city");
        String zipCode = rs.getString("zip_code");
        String country = rs.getString("country");

        return new Volunteer(id, firstName, lastName, birthDate, phoneNumber, email, nationality, registeredDate, comment, address, city, zipCode, country);

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

//    private GuildVolunteer getOneGuildVolunteer(ResultSet rs) throws SQLException
//      {
//        
//      }
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

    /**
     * -----------------------------------OTHER GET
     * METHODS-----------------------------------------------.
     */
    /**
     * get all the volunteers work in the given guild name This method is used
     * to call Volunteers from the database Based the guilds they are registered
     * to.
     *
     *
     * @param newValue
     * @return volunteers
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

    public List<Manager> getManagerBasedOnGuild(Guild guild) throws SQLException
      {
        List<Manager> managers = new ArrayList<>();

        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT first_name, last_name, FROM employee e "
                    + "INNER JOIN guild g ON g.manager_id = e.employee_id, WHERE g.guild_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, guild.getId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                managers.add(getOneManager(rs));
            }
            return managers;
        }

      }

    /**
     * to refactor This method is used to tell how many hours the different
     * volunteers have registered.
     *
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
                    + "INNER JOIN guild_volunteer gv ON vt.volunteer_id = gv.volunteer_id  AND vt.guild_id=gv.guild_id"
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
     * get the manager with given username This method is used to get the
     * manager based on their username. This method is used for the login
     * function.
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
     * get the administrator with given username This method is used to get the
     * administrator based on their username of the manager. This method is used
     * in the login function.
     *
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
     * check whether the given username and password matching the record of
     * manager from the employee table in the database This method is used to
     * check if the password fits with the username. This method is used in the
     * login function.
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
     * This method is used to check if the password fits with the username of
     * the administrator. This method is used in the login function.
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
     * get the total hours from the given guild name
     *
     * @param guildName
     * @return
     */
    public int filterHoursByGuild(String guildName)
      {
        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT COUNT(hours)FROM volunteer_time vt INNER JOIN guild_volunteer gv "
                    + "ON vt.volunteer_id =gv.volunteer_id AND vt.guild_id=gv.guild_id INNER JOIN guild g "
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

    public List<Nationality> getNationality() throws SQLException
      {
        List<Nationality> nationalities = new ArrayList<>();

        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT country FROM nationality;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                nationalities.add(getOneNationality(rs));
            }
            return nationalities;

        }

      }

    private Nationality getOneNationality(ResultSet rs) throws SQLException
      {

        String country = rs.getString("country");
        return new Nationality(country);
      }

    /**
     * ----------------------------------------------------------------------------------------------------.
     */
    /**
     * get volunteerGuildId with given volunteer and guild
     *
     * @param vt
     * @param gd
     * @return
     */
    // public int getVolunteerGuldIdBasedOnVolunteerIdAndGuldId(Volunteer vt, Guild gd) throws SQLException
    // {
    //   try (Connection con = connectionManager.getConnection()) {
    //      String sql = "SELECT guild_volunteer_id FROM guild_volunteer WHERE  volunteer_id=? AND guild_id= ? ";
    //     PreparedStatement pstmt = con.prepareStatement(sql);
    //    pstmt.setInt(1, vt.getId());
    //    pstmt.setInt(2, gd.getId());
    //  pstmt.executeQuery();
    //   } catch (SQLException ex) {
    //     Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
    //  }
    //   }
  }
