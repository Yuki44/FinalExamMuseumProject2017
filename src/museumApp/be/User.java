/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

import java.sql.Date;

/**
 *
 * @author Peder
 */
public abstract class User extends BusinessEntity
{

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    protected Date birthDate;

    public User(String firstName, String lastName, String email, String phoneNumber, Date birthDate, int id)
    {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

}
