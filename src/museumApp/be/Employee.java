package museumApp.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Employee extends User
  {

    protected StringProperty userName;
    protected StringProperty password;

    public Employee(int id, String firstName, String lastName, String email, String userName, String password)
      {
        super(id, firstName, lastName, email);
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
      }

    /** ------------------------------------------------------------------------------------------- */
    /**
     * We get userNames as string property because it can update the view
     *
     * @return
     */
    public StringProperty getUserName()
      {
        return userName;
      }

    /**
     * We get userNames as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getUserNameAsString()
      {
        return userName.get();
      }

    /** ------------------------------------------------------------------------------------------- */
    /**
     * We get Passwords as string property because it can update the view
     *
     * @return
     */
    public StringProperty getPassword()
      {
        return password;
      }

    /**
     * We get Passwords as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getPasswordAsString()
      {
        return password.get();
      }
    /** ------------------------------------------------------------------------------------------- */
  }
