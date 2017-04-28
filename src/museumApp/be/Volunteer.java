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

    public Volunteer(String firstName, String lastName, String email, String phoneNumber, Date birthDate, int id)
    {
        super(firstName, lastName, email, phoneNumber, birthDate, id);
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

}
