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
    protected StringProperty address;
    protected StringProperty city;
    protected StringProperty zipCode;
    protected StringProperty country;

    public Volunteer(int id, String firstName, String lastName, Date birthDate, String phoneNumber, String email,
            String nationality, Date registeredDate, String comment,
            String address, String city, String zipCode, String country)
      {
        super(id, firstName, lastName, email);
        this.nationality = new SimpleStringProperty(nationality);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.registeredDate = registeredDate;
        this.birthDate = birthDate;
        this.address = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);
        this.zipCode = new SimpleStringProperty(zipCode);
        this.country = new SimpleStringProperty(country);
      }

    public StringProperty getCountry()
      {
        return country;
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

    @Override
    public String toString()
      {
        return getNationalityAsString();
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

    /** -----------------------------ADDRESS----------------------------------------------. */
    /**
     * Get the VOLUNTEER address as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getAddress()
      {
        return address;
      }

    /**
     * Get the VOLUNTEER address as a string so it cannot update the view.
     *
     * @return
     */
    public String getAddressAsString()
      {
        return address.get();
      }

    /** -----------------------------CITY----------------------------------------------. */
    /**
     * Get the VOLUNTEER city as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getCity()
      {
        return city;
      }

    /**
     * Get the VOLUNTEER city as a string so it cannot update the view.
     *
     * @return
     */
    public String getCityAsString()
      {
        return city.get();
      }

    /** -----------------------------ZIPCODE----------------------------------------------. */
    /**
     * Get the VOLUNTEER zipCode as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getZipCode()
      {
        return zipCode;
      }

    /**
     * Get the VOLUNTEER zipCode as a string so it cannot update the view.
     *
     * @return
     */
    public String getZipCodeAsString()
      {
        return zipCode.get();
      }
  }
