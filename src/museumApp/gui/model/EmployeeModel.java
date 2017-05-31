package museumApp.gui.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import museumApp.be.Employee;
import museumApp.bll.FacadeBll;

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
       facadeBll= new FacadeBll();
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
        result.addAll(facadeBll.getAllManagers());
        result.addAll(facadeBll.getAllAdmins());
        return result;
      } 
    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /** ---------------------------------------------------------------------------------------------------------------------------. */

  }
