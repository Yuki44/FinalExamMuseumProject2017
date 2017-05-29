package museumApp.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import museumApp.be.Employee;
import museumApp.be.Manager;

public class ManagerLoginHandler extends DatabaseManager
  {

    /**
     * constructor
     *
     * @throws java.io.IOException
     */
    public ManagerLoginHandler() throws IOException
      {
        super();
      }

    /**
     * loop all the managers'username and password in the employee table,
     * to check whether there is record matching the given username and password
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    /**
     * This method checks the username and password of the manager.
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Employee LoginChecker(String username, String password) throws SQLException
      {
        for (Manager allManager : getAllManagers())
        {
            if (allManager.getUserName().getValue().equals(username))
            {
                if (checkPasswordForManager(username, password))
                {
                    return getManagerBasedOnUsername(username);
                }
            }
        }

        return null;
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
     * Gets information about one Manager in the database.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public Manager getOneManager(ResultSet rs) throws SQLException
      {
        int id = rs.getInt("employee_id");
        String firstName = rs.getString("e_first_name");
        String lastName = rs.getString("e_last_name");
        String email = rs.getString("e_email");
        String userName = rs.getString("user_name");
        String password = rs.getString("password");
        return new Manager(id, firstName, lastName, email, userName, password);
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

    public Manager getManagerFromResults(PreparedStatement pstmt) throws SQLException
      {
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int idMgr = rs.getInt("employee_id");
        String userName = rs.getString("user_name");
        String password = rs.getString("password");
        String firstName = rs.getString("e_first_name");
        String lastName = rs.getString("e_last_name");
        String email = rs.getString("e_email");

        Manager manager = new Manager(idMgr, firstName, lastName, email, userName, password);
        return manager;
      }
  }
