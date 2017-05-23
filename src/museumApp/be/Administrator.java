package museumApp.be;

public class Administrator extends Employee
  {

    /**
     * We set the administrator to get these info:
     *
     * @param id
     * @param userName
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     */
    public Administrator(int id, String userName, String password, String firstName, String lastName, String email)
      {
        super(id, userName, password, firstName, lastName, email);
      }

  }
