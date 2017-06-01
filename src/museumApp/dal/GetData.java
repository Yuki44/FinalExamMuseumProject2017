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

    /**
     * This method gets a List of all guild volunteers form the database.
     *
     * @return
     * @throws SQLException
     */
    public List<GuildVolunteer> getAllGuildVolunteer() throws SQLException
      {
        List<GuildVolunteer> gv = new ArrayList<>();

        String sql = "SELECT DISTINCT * FROM employee e "
                + "JOIN guild g ON e.employee_id = g.manager_id "
                + "JOIN guild_volunteer gv ON g.guild_id= gv.guild_id "
                + "JOIN volunteer v ON gv.volunteer_id= v.volunteer_id";
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

    /**
     * This method creates a list volunteers based on the id
     *
     * @param vtrId
     * @return
     * @throws SQLException
     */
    public List<VolunteerTime> getVolunteerTimeBasedOnVtrId(int vtrId) throws SQLException
      {
        List<VolunteerTime> vTime = new ArrayList<>();

        String sql = "SELECT * FROM volunteer_time WHERE volunteer_id = ?";

        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, vtrId);
            ResultSet vTimeSet = pstmt.executeQuery();
            while (vTimeSet.next())
            {
                vTime.add(getOneVTime(vTimeSet));
            }
            return vTime;
        }
      }

    /**
     * This method creates a list volunteers and guilds based on the id
     *
     * @param vtrId
     * @param gdId
     * @return
     * @throws SQLException
     */
    public List<VolunteerTime> getVolunteerAndGuildTimeBasedOnId(int vtrId, int gdId) throws SQLException
      {
        List<VolunteerTime> vTime = new ArrayList<>();

        String sql = "SELECT * FROM volunteer_time WHERE volunteer_id = ? AND guild_id = ?";

        try (Connection con = connectionManager.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, vtrId);
            pstmt.setInt(2, gdId);
            ResultSet vTimeSet = pstmt.executeQuery();
            while (vTimeSet.next())
            {
                vTime.add(getOneVTime(vTimeSet));
            }
            return vTime;
        }
      }

    /**
     * This method creates a list nationalities from the database
     *
     * @return
     * @throws SQLException
     */
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
        VolunteerTime vTime = new VolunteerTime(date, hours, null, null);
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
        String firstName = mgResultSet.getString("e_first_name");
        String lastName = mgResultSet.getString("e_last_name");
        String email = mgResultSet.getString("e_email");
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
        String firstName = adResultSet.getString("e_first_name");
        String lastName = adResultSet.getString("e_last_name");
        String email = adResultSet.getString("e_email");
        int id = adResultSet.getInt("employee_id");
        return new Administrator(id, firstName, lastName, email, userName, password);
      }

    /**
     * This method makes the result set needed for the nationality.
     *
     * @param natResultSet
     * @return
     * @throws SQLException
     */
    private Nationality getOneNationality(ResultSet natResultSet) throws SQLException
      {

        String country = natResultSet.getString("country");
        return new Nationality(country);
      }

    /**
     * This method makes the result set needed for the Guild Volunteer.
     *
     * @param gdvtrResultSet
     * @return
     * @throws SQLException
     */
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

    /**
     * This method creates a list of managers based on the guild(s) they manage.
     *
     * @param guild
     * @return
     * @throws SQLException
     */
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

  }
