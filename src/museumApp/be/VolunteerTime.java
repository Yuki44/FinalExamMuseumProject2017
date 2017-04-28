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
public class VolunteerTime extends BusinessEntity
{

    protected int guildLocationId;
    protected Date registrationDate;
    protected int hours;

    public VolunteerTime(int guildLocationId, Date registrationDate, int hours, int id)
    {
        super(id);
        this.guildLocationId = guildLocationId;
        this.registrationDate = registrationDate;
        this.hours = hours;
    }

    public int getGuildLocationId()
    {
        return guildLocationId;
    }

    public void setGuildLocationId(int guildLocationId)
    {
        this.guildLocationId = guildLocationId;
    }

    public Date getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate)
    {
        this.registrationDate = registrationDate;
    }

    public int getHours()
    {
        return hours;
    }

    public void setHours(int hours)
    {
        this.hours = hours;
    }

}
