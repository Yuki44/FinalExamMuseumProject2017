package museumApp.be;

public class GuildVolunteer
  {

    private Guild guild;
    private Volunteer volunteer;

    /**
     * CONSTRUCTOR
     *
     * @param guild
     * @param volunteer
     */
    public GuildVolunteer(Guild guild, Volunteer volunteer)
      {
        this.guild = guild;
        this.volunteer = volunteer;
      }

    /**
     * This method gets the Guild id.
     *
     * @return
     */
    public int getGuildId()
      {
        return guild.getId();

      }

    /**
     * This method gets the Guild.
     *
     * @return
     */
    public Guild getGuild()
      {
        return guild;
      }

    /**
     * This method gets the Volunteer.
     *
     * @return
     */
    public Volunteer getVolunteer()
      {
        return volunteer;
      }

    /**
     * This method gets the Volunteer id.
     *
     * @return
     */
    public int getVolunteerId()
      {
        return volunteer.getId();

      }

  }
