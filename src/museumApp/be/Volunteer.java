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
public class Volunteer extends User
{

    protected String nationality;
    protected Date registeredDate;
    protected String guildLocation;
    protected Date birthDate;
    protected String phoneNumber;

    public Volunteer(String nationality, Date registeredDate, String guildLocation, Date birthDate, String phoneNumber, String firstName, String lastName, String email, int id)
    {
        super(firstName, lastName, email, id);
        this.nationality = nationality;
        this.registeredDate = registeredDate;
        this.guildLocation = guildLocation;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public Date getRegisteredDate()
    {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate)
    {
        this.registeredDate = registeredDate;
    }

    public String getGuildLocation()
    {
        return guildLocation;
    }

    public void setGuildLocation(String guildLocation)
    {
        this.guildLocation = guildLocation;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

}
