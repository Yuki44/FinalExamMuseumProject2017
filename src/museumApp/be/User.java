package museumApp.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class User extends BusinessEntity
  {

    protected StringProperty firstName;
    protected StringProperty lastName;
    protected StringProperty email;
    protected StringProperty fullName;

    public User(int id, String firstName, String lastName, String email)
      {
        super(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.fullName = new SimpleStringProperty(firstName + " " + lastName);
      }

    /** ------------------------------FULL NAMES FROM USER---------------------------------------------. */
    /**
     * This method gets the name of the user as a StringProperty and this allows for the tableView to be updated.
     *
     * @return
     */
    public StringProperty getFullName()
      {
        return fullName;
      }

    /**
     * FULL NAME OF USER AS A STRING (1 of 2 Steps).
     *
     * @return
     */
    public String getFullNameAsString()
      {
        return fullName.get();
      }

    /**
     * FULL NAME OF USER AS A STRING (Step 2 of 2).
     *
     * @return
     */
    @Override
    public String toString()
      {
        return getFullNameAsString();
      }

    /** ----------------------------ONLY USER'S FIRST NAME---------------------------------------------. */
    /**
     * This method gets the users first name as a string property because it can update the view
     *
     * @return
     */
    public StringProperty getFirstName()
      {
        return firstName;
      }

    /**
     * This method gets the users first name as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getFirstNameAsString()
      {
        return firstName.get();
      }

    /** ---------------------------ONLY USER'S LAST NAME----------------------------------------------. */
    /**
     * This method gets users last name as string property because it can update the view
     *
     * @return
     */
    public StringProperty getLastName()
      {
        return lastName;
      }

    /**
     * This method gets the users last name as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getLastNameAsString()
      {
        return lastName.get();
      }

    /** ---------------------------------------EMAIL------------------------------------------. */
    /**
     * This method gets the users email as string property because it can update the view
     *
     * @return
     */
    public StringProperty getEmail()
      {
        return email;
      }

    /**
     * This method gets the users email as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getEmailAsString()
      {
        return email.get();
      }
    /** -------------------------------------------------------------------------------------------. */
  }
