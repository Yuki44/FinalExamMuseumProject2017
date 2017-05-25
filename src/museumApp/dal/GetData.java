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

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * ------------------------------getAll FROM DATABASE METHODS------------------------------------------.
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
            ResultSet vtrSet = st.executeQuery(sql);
            while (vtrSet.next())
            {
                volunteers.add(getOneVolunteer(vtrSet));
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
            ResultSet mgSet = st.executeQuery(sql);
            while (mgSet.next())
            {
                managers.add(getOneManager(mgSet));
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
            ResultSet adSet = st.executeQuery(sql);
            while (adSet.next())
            {
                admin.add(getOneAdmin(adSet));
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
            ResultSet gdSet = st.executeQuery(sql);
            while (gdSet.next())
            {
                guild.add(getOneGuild(gdSet));
            }
            return guild;
        }
      }

    public List<GuildVolunteer> getAllGuildVolunteer() throws SQLException
      {
        List<GuildVolunteer> gv = new ArrayList<>();

        String sql = "SELECT DISTINCT gv.guild_id, gv.volunteer_id, "
                + "g.name, e.employee_id, e.first_name, e.last_name, "
                + "e.email,e.user_name, e.password, v.volunteer_id, "
                + "v.first_name, v.last_name, v.date_of_birth, "
                + "v.phone_number, v.nationality, v.email, v.join_date,"
                + "v.photo, v.comment, v.address, v.city, v.zip_code, v.country "
                + "FROM guild_volunteer gv INNER JOIN volunteer v ON "
                + "gv.volunteer_id = v.volunteer_id INNER JOIN guild_volunteer ON "
                + "v.volunteer_id=gv.volunteer_id INNER JOIN guild g ON gv.guild_id = g.guild_id "
                + "INNER JOIN employee e ON g.manager_id = e.employee_id";

        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet gvSet = pstmt.executeQuery();
            while (gvSet.next())
            {
                gv.add(getOneGuildVolunteer(gvSet));
            }
            return gv;
        }
      }

    public List<VolunteerTime> getAllVolunteerTimes() throws SQLException
      {
        List<VolunteerTime> vTime = new ArrayList<>();

        String sql = "SELECT * FROM volunteer_time";
              

        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet vTimeSet = pstmt.executeQuery();
            while (vTimeSet.next())
            {
                vTime.add(getOneVTime(vTimeSet));
            }
            return vTime;
        }
      }

    public List<Nationality> getAllNationalities() throws SQLException
      {
        List<Nationality> nationalities = new ArrayList<>();

        try (Connection con = connectionManager.getConnection())
        {
            String query = "SELECT country FROM nationality;";
            Statement st = con.createStatement();
            ResultSet natSet = st.executeQuery(query);
            while (natSet.next())
            {
                nationalities.add(getOneNationality(natSet));
            }
            return nationalities;

        }

      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ---------------------------------getOne FROM DATABASE METHODS----------------------------------------------------------------------------------------. */
    /**
     * Gets information about one Guild in the database.
     *
     * @param rs
     * @return Guild
     * @throws SQLException
     */
    private Guild getOneGuild(ResultSet gdResultSet) throws SQLException
      {
        int id = gdResultSet.getInt("guild_id");
        String guildName = gdResultSet.getString("name");

        Manager manager = getOneManager(gdResultSet);
        return new Guild(id, guildName, manager);
      }

    /**
     * Gets information about one VolunteerTime in the database.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private VolunteerTime getOneVTime(ResultSet vTimeResultSet) throws SQLException
      {
        Date date = vTimeResultSet.getDate("date");
        int hours = vTimeResultSet.getInt("hours");
//        ResultSet volunteerrs = rs;
//        ResultSet guildrs = rs;
        Volunteer volunteer = getOneVolunteer(vTimeResultSet);
        Guild guild = getOneGuild(vTimeResultSet);
        VolunteerTime vTime = new VolunteerTime(date, hours, volunteer, guild);
        return vTime;
      }

    /**
     * Gets information about one Volunteer in the database.
     *
     * @param rs
     * @return Volunteer
     * @throws SQLException
     */
    private Volunteer getOneVolunteer(ResultSet vtrResultSet) throws SQLException
      {
        int id = vtrResultSet.getInt("volunteer_id");
        String firstName = vtrResultSet.getString("first_name");
        String lastName = vtrResultSet.getString("last_name");
        String email = vtrResultSet.getString("email");
        String phoneNumber = vtrResultSet.getString("phone_number");
        String birthDate = vtrResultSet.getString("date_of_birth");
        String nationality = vtrResultSet.getString("nationality");
        Date registeredDate = vtrResultSet.getDate("join_date");
        String photo = vtrResultSet.getString("photo");
        String comment = vtrResultSet.getString("comment");
        String address = vtrResultSet.getString("address");
        String city = vtrResultSet.getString("city");
        String zipCode = vtrResultSet.getString("zip_code");
        String country = vtrResultSet.getString("country");

        return new Volunteer(id, firstName, lastName, birthDate, phoneNumber, email, nationality, registeredDate, photo, comment, address, city, zipCode, country);

      }

    /**
     * Gets information about one Manager in the database.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Manager getOneManager(ResultSet mgResultSet) throws SQLException
      {
        int id = mgResultSet.getInt("employee_id");
        String firstName = mgResultSet.getString("first_name");
        String lastName = mgResultSet.getString("last_name");
        String email = mgResultSet.getString("email");
        String userName = mgResultSet.getString("user_name");
        String password = mgResultSet.getString("password");
        return new Manager(id, firstName, lastName, email, userName, password);
      }

    /**
     * Gets information about one Administrator in the database.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Administrator getOneAdmin(ResultSet adResultSet) throws SQLException
      {
        String userName = adResultSet.getString("user_name");
        String password = adResultSet.getString("password");
        String firstName = adResultSet.getString("first_name");
        String lastName = adResultSet.getString("last_name");
        String email = adResultSet.getString("email");
        int id = adResultSet.getInt("employee_id");
        return new Administrator(id, firstName, lastName, email, userName, password);
      }

    private Nationality getOneNationality(ResultSet natResultSet) throws SQLException
      {

        String country = natResultSet.getString("country");
        return new Nationality(country);
      }

    private GuildVolunteer getOneGuildVolunteer(ResultSet gdvtrResultSet) throws SQLException
      {
        Guild guild = getOneGuild(gdvtrResultSet);
        Volunteer volunteer = getOneVolunteer(gdvtrResultSet);
        return new GuildVolunteer(guild, volunteer);
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /**
     * -----------------------------------OTHER GET METHODS-----------------------------------------------.
     */
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
            String query = "SELECT * FROM employee e "
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

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ----------------------I DON'T THINK WE NEED THE FOLLOWING METHODS-------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
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

   
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */

  }
