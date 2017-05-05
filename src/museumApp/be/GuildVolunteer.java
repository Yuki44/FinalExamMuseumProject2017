/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

/**
 *
 * @author min
 */
public class GuildVolunteer {
    private Guild guild;
    private Volunteer volunteer;
    public GuildVolunteer(Guild guild, Volunteer volunteer){
        this.guild= guild;
        this.volunteer=volunteer;
    }

    public Guild getGuild() {
        return guild;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }
    
}
