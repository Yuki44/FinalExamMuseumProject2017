package museumApp.be;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class VolunteerTime
  {

    protected Date date;
    protected int hours;
    private Volunteer volunteer;
    private Guild guild;
    private GuildVolunteer guildVolunteer;

    /**
     * VolunteerTime Constructor, we get from it:
     *
     * @param date
     * @param hours
     * @param id
     */
    public VolunteerTime(Date date, int hours, GuildVolunteer guildVolunteer)
      {
       this.guildVolunteer = guildVolunteer;
        this.date = date;
        this.hours = hours;
      }
     public VolunteerTime(Date date, int hours,Volunteer volunteer, Guild guild )
      {
       this.guild =guild;
       this.volunteer = volunteer;
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

    public Volunteer getVolunteer()
      {
        return volunteer;
      }

    public Guild getGuild()
      {
        return guild;
      }
    public GuildVolunteer getGuildVolunteer(){
    return guildVolunteer;
    }
    /** ----------------------------------------------------------------------------------------------------. */

  }
