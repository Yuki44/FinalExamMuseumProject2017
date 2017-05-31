package museumApp.be;

public class Manager extends Employee
  {

    /**
     * The following parameters are extended by the Employee.
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param userName
     * @param password
     */
    public Manager(int id, String firstName, String lastName, String email, String userName, String password)
      {
        super(id, firstName, lastName, email, userName, password);
      }

  }
