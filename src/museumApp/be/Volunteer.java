/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Peder
 */
public class Volunteer extends User
  {

    protected StringProperty nationality;
    protected StringProperty phoneNumber;
    protected Date registeredDate;
    protected Date birthDate;

    public Volunteer(int id, String firstName, String lastName, Date birthDate, String phoneNumber, String email, String nationality, Date registeredDate)
      {
        super(id, firstName, lastName, email);
        this.nationality = new SimpleStringProperty(nationality);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.registeredDate = registeredDate;
        this.birthDate = birthDate;
      }

    /** ------------------------------------------------------------------------------------------- */
    public StringProperty getNationality()
      {
        return nationality;
      }

    public String getNationalityAsString()
      {
        return nationality.get();
      }

    /** ------------------------------------------------------------------------------------------- */
    public StringProperty getPhoneNumber()
      {
        return phoneNumber;
      }

    public String getPhoneNumberAsString()
      {
        return phoneNumber.get();
      }

    /** ------------------------------------------------------------------------------------------- */
    public Date getRegisteredDate()
      {
        return registeredDate;
      }

    public String getRegisteredDateAsString()
      {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String joinedDate = sdf.format(registeredDate);
        return joinedDate;
      }

    /** ------------------------------------------------------------------------------------------- */
    public Date getBirthDate()
      {
        return birthDate;
      }
    /** ------------------------------------------------------------------------------------------- */
  }
