package museumApp.be;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Volunteer extends User
  {

    protected StringProperty nationality;
    protected StringProperty phoneNumber;
    protected Date registeredDate;
    protected Date birthDate;
    protected String Address;
    protected String city;
    protected String zipCode;

      {
        super(id, firstName, lastName, email);
        this.nationality = new SimpleStringProperty(nationality);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.registeredDate = registeredDate;
        this.birthDate = birthDate;
        this.city= city;
        this.zipCode= zipCode;
      }

    /** ------------------------------VOLUNTEER NATIONALITY-----------------------------------------. */
    /**
     * Get the VOLUNTEER nationality as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getNationality()
      {
        return nationality;
      }

    /**
     * Get the VOLUNTEER nationality as a string so it cannot update the view.
     *
     * @return
     */
    public String getNationalityAsString()
      {
        return nationality.get();
      }

    /** --------------------------VOLUNTEER PHONE NUMBER------------------------------------------. */
    /**
     * Get the VOLUNTEER phone number as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getPhoneNumber()
      {
        return phoneNumber;
      }

    /**
     * Get the VOLUNTEER phone number as a string so it cannot update the view.
     *
     * @return
     */
    public String getPhoneNumberAsString()
      {
        return phoneNumber.get();
      }

    /** --------------------------REGISTERED OR JOINED DATE----------------------------------------. */
    /**
     * Get the VOLUNTEER registered date as a Date type.
     *
     * @return
     */
    public Date getRegisteredDate()
      {
        return registeredDate;
      }

    /**
     * VOLUNTEER Registered date gets converted to a string and formatted for displaying.
     *
     * @return
     */
    public String getRegisteredDateAsString()
      {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String joinedDate = sdf.format(registeredDate);
        return joinedDate;
      }

    /** -------------------------------------BIRTHDATE-----------------------------------------------. */
    /**
     * Get the VOLUNTEER Birth date as a Date type.
     *
     * @return
     */
    public Date getBirthDate()
      {
        return birthDate;
      }
    /** -------------------------------------------------------------------------------------------. */
  }
