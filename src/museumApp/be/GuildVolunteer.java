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
     * We get a Guild.
     *
     * @return
     */
    public Guild getGuild()
      {
        return guild;
      }

    /**
     * We get a Volunteer.
     *
     * @return
     */
    public Volunteer getVolunteer()
      {
        return volunteer;
      }

  }
