package museumApp.be;

public class GuildVolunteer extends BusinessEntity
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
        super(-1);
        this.guild = guild;
        this.volunteer = volunteer;
      }

    public GuildVolunteer(Guild guild, Volunteer volunteer, int id)
      {
        super(id);
        this.guild = guild;
        this.volunteer = volunteer;
      }

    public int getId()
      {
        return id;
      }
    

    /**
     * We get a Guild.
     *
     * @return
     */
    public Guild getGuild()
      {
        guild.getId();
        return guild;
      }

    /**
     * We get a Volunteer.
     *
     * @return
     */
    public Volunteer getVolunteer()
      {
        volunteer.getId();
        return volunteer;
      }

  }
