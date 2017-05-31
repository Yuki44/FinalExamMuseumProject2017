package museumApp.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import museumApp.be.Administrator;
import museumApp.be.Employee;

public class AdministratorLoginHandler extends DatabaseManager
  {

    /**
     * Constructor
     *
     * @throws IOException
     */
    public AdministratorLoginHandler() throws IOException
      {
        super();
      }

    /** ----------------------------------------------------------------------------------------------------. */
    /**
     * This method is used to check the username and password of an administrator.
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Employee LoginChecker(String username, String password) throws SQLException
      {
        for (Administrator allAdmin : getAllAdmins())
        {
            if (allAdmin.getUserName().getValue().equals(username))
            {
                if (checkPasswordForAdmin(username, password))
                {
                    return getAdminBasedOnUsername(username);
                }
            }
        }
        return null;
      }

    /**
     * This method creates a list of Administrators from the database.
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
     * This method specifies collums available in the database.
     * The method is called in getAllAdmins()
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Administrator getOneAdmin(ResultSet rs) throws SQLException
      {
        String userName = rs.getString("user_name");
        String password = rs.getString("password");
        String firstName = rs.getString("e_first_name");
        String lastName = rs.getString("e_last_name");
        String email = rs.getString("e_email");
        int id = rs.getInt("employee_id");
        return new Administrator(id, firstName, lastName, email, userName, password);
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
            ResultSet rs = pstmt.executeQuery(query);
            return getOneAdmin(rs);

        }
        catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }
      }

    /** ----------------------------------------------------------------------------------------------------. */
  }
