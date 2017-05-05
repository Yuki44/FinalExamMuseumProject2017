package museumApp.be;

import java.sql.Date;

public class VolunteerTime extends BusinessEntity
  {

    protected Date registrationDate;
    protected int hours;

    public VolunteerTime(Date registrationDate, int hours, int id)
      {
        super(id);
        this.registrationDate = registrationDate;
        this.hours = hours;
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
