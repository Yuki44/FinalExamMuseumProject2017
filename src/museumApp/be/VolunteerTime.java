package museumApp.be;

import java.sql.Date;

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

    public Date getRegistrationDate()
      {
        return registrationDate;
      }

    public int getHours()
      {
        return hours;
      }

  }
