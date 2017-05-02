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
public abstract class Employees extends User
  {

    protected StringProperty userName;
    protected StringProperty password;

    public Employees(String userName, String password, String firstName, String lastName, String email, int id)
      {
        super(firstName, lastName, email, id);
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
      }

    public StringProperty getUserName()
      {
        return userName;
      }

    public StringProperty getPassword()
      {
        return password;
      }

    public String getUserNameAsString()
      {
        return userName.get();
      }

    public String getPasswordAsString()
      {
        return password.get();
      }

  }
