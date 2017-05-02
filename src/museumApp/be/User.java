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

    public String getFirstNameAsString()
      {
        return firstName.get();
      }

    public StringProperty getFirstName()
      {
        return firstName;
      }

    public StringProperty getLastName()
      {
        return lastName;
      }

    public String getLastNameAsString()
      {
        return lastName.get();
      }

    public StringProperty getEmail()
      {
        return email;
      }

    public String getEmailAsString()
      {
        return email.get();
      }

  }
