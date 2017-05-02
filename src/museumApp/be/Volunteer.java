/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Peder
 */
public class Volunteer extends User
  {

    protected StringProperty nationality;
    protected StringProperty guildLocation;
    protected StringProperty phoneNumber;
    protected Date registeredDate;
    protected Date birthDate;

    public Volunteer(String nationality, Date registeredDate, String guildLocation, Date birthDate, String phoneNumber, String firstName, String lastName, String email, int id)
      {
        super(firstName, lastName, email, id);
        this.nationality = new SimpleStringProperty(nationality);
        this.guildLocation = new SimpleStringProperty(guildLocation);
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
    public StringProperty getGuildLocation()
      {
        return guildLocation;
      }

    public String getGuildLocationAsString()
      {
        return guildLocation.get();
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

    /** ------------------------------------------------------------------------------------------- */
    public Date getBirthDate()
      {
        return birthDate;
      }
    /** ------------------------------------------------------------------------------------------- */
  }
