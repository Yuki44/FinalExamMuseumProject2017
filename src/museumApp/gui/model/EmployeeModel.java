package museumApp.gui.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import museumApp.be.Employee;
import museumApp.bll.AdminBll;
import museumApp.bll.ManagerBll;

public class EmployeeModel extends Model
  {

    private List<Employee> employee;

    /**
     * Constructor.
     *
     * @throws IOException
     */
    public EmployeeModel() throws IOException
      {
        managerBll = new ManagerBll();
        adminBll = new AdminBll();
        employee = new ArrayList<>();
      }

    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /**
     * to get the list of employees
     *
     * @return list of Employees
     */
    public List<Employee> getAllEmployees()
      {
        List<Employee> result = new ArrayList<>();
        result.addAll(managerBll.getAllManagers());
        result.addAll(adminBll.getAllAdmins());
        return result;
      }
    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /** ---------------------------------------------------------------------------------------------------------------------------. */

  }
