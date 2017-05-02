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

    public User(String firstName, String lastName, String email, int id)
      {
        super(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);

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
