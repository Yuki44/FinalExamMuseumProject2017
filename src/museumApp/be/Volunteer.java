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
    protected StringProperty birthDate;
    protected StringProperty address;
    protected StringProperty city;
    protected StringProperty zipCode;
    protected StringProperty country;
    protected StringProperty comment;
    protected StringProperty photo;

    public Volunteer(int id, String firstName, String lastName, String birthDate, String phoneNumber, String email,
            String nationality, Date registeredDate, String photo, String comment,
            String address, String city, String zipCode, String country)
      {
        super(id, firstName, lastName, email);
        this.nationality = new SimpleStringProperty(nationality);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.registeredDate = registeredDate;
        this.birthDate = new SimpleStringProperty(birthDate);
        this.comment = new SimpleStringProperty(comment);
        this.address = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);
        this.zipCode = new SimpleStringProperty(zipCode);
        this.country = new SimpleStringProperty(country);
        this.photo = new SimpleStringProperty(photo);
      }

    public StringProperty getCountry()
      {
        return country;
      }

    public String getCountryAsString()
      {
        return country.get();
      }

    /** ------------------------------VOLUNTEER NATIONALITY-----------------------------------------. */
    /**
     * This method gets the VOLUNTEER nationality as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getNationality()
      {
        return nationality;
      }

    /**
     * This method gets the VOLUNTEER nationality as a string so it cannot update the view.
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
     * This method gets the VOLUNTEER phone number as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getPhoneNumber()
      {
        return phoneNumber;
      }

    /**
     * This method gets the VOLUNTEER phone number as a string so it cannot update the view.
     *
     * @return
     */
    public String getPhoneNumberAsString()
      {
        return phoneNumber.get();
      }

    /** --------------------------REGISTERED OR JOINED DATE----------------------------------------. */
    /**
     * This method gets the VOLUNTEER registered date as a Date type.
     *
     * @return
     */
    public Date getRegisteredDate()
      {
        return registeredDate;
      }

    /**
     * This method gets VOLUNTEER Registered date converted to a string and formatted for displaying.
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
     * This method gets the VOLUNTEER Birth date as a Date type.
     *
     * @return
     */
    public StringProperty getBirthDate()
      {
        return birthDate;
      }

    public String getBirthDateAString()
      {
        return birthDate.get();
      }

    /** -----------------------------ADDRESS----------------------------------------------. */
    /**
     * This method gets the VOLUNTEER address as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getAddress()
      {
        return address;
      }

    /**
     * This method gets the VOLUNTEER address as a string so it cannot update the view.
     *
     * @return
     */
    public String getAddressAsString()
      {
        return address.get();
      }

    /** -----------------------------CITY----------------------------------------------. */
    /**
     * This method gets the VOLUNTEER city as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getCity()
      {
        return city;
      }

    /**
     * This method gets the VOLUNTEER city as a string so it cannot update the view.
     *
     * @return
     */
    public String getCityAsString()
      {
        return city.get();
      }

    /** -----------------------------ZIPCODE----------------------------------------------. */
    /**
     * This method gets the VOLUNTEER zipCode as a StringProperty so it can update the view.
     *
     * @return
     */
    public StringProperty getZipCode()
      {
        return zipCode;
      }

    /**
     * This method gets the VOLUNTEER zipCode as a string so it cannot update the view.
     *
     * @return
     */
    public String getZipCodeAsString()
      {
        return zipCode.get();
      }

    /**
     * This method gets the VOLUNTEER photo as a string property so it can update the view.
     *
     * @return
     */
    public StringProperty getPhoto()
      {
        return photo;
      }

    /**
     * This method gets the VOLUNTEER photo as a string so it cannot update the view.
     *
     * @return
     */
    public String getPhotoAsString()
      {
        return photo.get();
      }

    /**
     * This method gets the VOLUNTEER comment as a string property so it can update the view.
     *
     * @return
     */
    public StringProperty getComment()
      {
        return comment;
      }

    /**
     * This method gets the VOLUNTEER comment as a string so it cannot update the view.
     *
     * @return
     */
    public String getCommentAsString()
      {
        return comment.get();
      }

  }
