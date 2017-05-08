/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Volunteer;
import museumApp.dal.VolunteerFromGuildHandler;

/**
 *
 * @author Peder
 */
public class VolunteerFromGuildManager
  {

    VolunteerFromGuildHandler VFGH;

    public VolunteerFromGuildManager() throws IOException
      {
        this.VFGH = new VolunteerFromGuildHandler();
      }

    public Volunteer checkVolunteerInGuild(String firstname, String lastname, String guildName) throws SQLException
      {
        if (VFGH.checkVolunteerInGuild(firstname, lastname, guildName) != null)
        {
            return checkVolunteerInGuild(firstname, lastname, guildName);
        }
        else
        {
            return null;
        }
      }
  }
