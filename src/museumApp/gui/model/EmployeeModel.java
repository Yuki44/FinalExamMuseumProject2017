package museumApp.gui.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import museumApp.be.Employee;
import museumApp.bll.MuseumManager;

public class EmployeeModel extends UserModel
  {

    private List<Employee> employee;
    private MuseumManager museumManager;

    /**
     * Constructor.
     *
     * @throws IOException
     * @throws SQLException
     */
    public EmployeeModel() throws IOException, SQLException
      {
        super();
        museumManager = new MuseumManager();
        this.employee = new ArrayList<>();
      }

    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /**
     * to get the list of employees
     *
     * @return list of Employees
     */
    public List<Employee> getAllEmployees()
      {
        List<Employee> result = new ArrayList<>();
        result.addAll(museumManager.getAllManagers());
        result.addAll(museumManager.getAllAdmins());
        return result;
      }
  }
