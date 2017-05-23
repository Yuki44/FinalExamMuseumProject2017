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
    public int getGuildId()
      {
        return guild.getId();

      }

    public Guild getGuild()
      {
        return guild;
      }

    public Volunteer getVolunteer()
      {
        return volunteer;
      }

    /**
     * We get a Volunteer.
     *
     * @return
     */
    public int getVolunteerId()
      {
        return volunteer.getId();

      }

  }
