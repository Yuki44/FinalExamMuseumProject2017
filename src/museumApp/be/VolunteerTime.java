package museumApp.be;

import java.sql.Date;

public class VolunteerTime extends BusinessEntity
  {

    protected Date date;
    protected int hours;
    private int id;

    public VolunteerTime(Date date, int hours, int id)
      {
        super(id);
        this.date = date;
        this.hours = hours;
      }

    public Date getDate()
      {
        return date;
      }

    public int getHours()
      {
        return hours;
      }

  }
