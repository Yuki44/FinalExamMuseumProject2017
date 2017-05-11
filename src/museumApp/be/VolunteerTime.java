package museumApp.be;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class VolunteerTime extends BusinessEntity
  {

    protected Date date;
    protected int hours;
    private int id;

    /**
     * VolunteerTime Constructor, we get from it:
     *
     * @param date
     * @param hours
     * @param id
     */
    public VolunteerTime(Date date, int hours, int id)
      {
        super(id);
        this.date = date;
        this.hours = hours;
      }

    /** --------------------------------------------------DATE---------------------------------------------. */
    /**
     * Returns VolunteerTime date as a Date type.
     *
     * @return
     */
    public Date getDate()
      {
        return date;
      }

    /**
     * VolunterTime date gets converted to a string and formatted for displaying.
     *
     * @return
     */
    public String getDateAsString()
      {
        SimpleDateFormat getDate = new SimpleDateFormat("dd-MM-yyyy");
        String joinedDate = getDate.format(date);
        return joinedDate;
      }

    /** ---------------------------------------------------HOURS---------------------------------------------. */
    /**
     * Returns VolunteerTime hours as an integer.
     *
     * @return
     */
    public int getHours()
      {
        return hours;
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
