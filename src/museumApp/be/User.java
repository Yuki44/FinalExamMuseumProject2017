/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Peder
 */
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

    public StringProperty getFullName()
      {
        return fullName;
      }

    public String getFullNameAsString()
      {
        return fullName.get();
      }

    @Override
    public String toString()
      {
        return getFullNameAsString();
      }

    /** ------------------------------------------------------------------------------------------- */
    /**
     * We get first name as string property because it can update the view
     *
     * @return
     */
    public StringProperty getFirstName()
      {
        return firstName;
      }

    /**
     * We get the first name as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getFirstNameAsString()
      {
        return firstName.get();
      }

    /** ------------------------------------------------------------------------------------------- */
    /**
     * We get last name as string property because it can update the view
     *
     * @return
     */
    public StringProperty getLastName()
      {
        return lastName;
      }

    /**
     * We get the last name as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getLastNameAsString()
      {
        return lastName.get();
      }

    /** ------------------------------------------------------------------------------------------- */
    /**
     * We get the email as string property because it can update the view
     *
     * @return
     */
    public StringProperty getEmail()
      {
        return email;
      }

    /**
     * We get the email as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getEmailAsString()
      {
        return email.get();
      }
    /** ------------------------------------------------------------------------------------------- */
  }
