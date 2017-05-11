package museumApp.be;

public class Manager extends Employee
  {

    /**
     * We get these things from the Manager:
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
