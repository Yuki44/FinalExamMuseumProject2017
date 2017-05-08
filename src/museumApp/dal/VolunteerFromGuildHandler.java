/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.sql.SQLException;
import museumApp.be.Volunteer;

/**
 *
 * @author Peder
 */
public class VolunteerFromGuildHandler
  {

    GetData DbMgr;

    public VolunteerFromGuildHandler() throws IOException
      {
        this.DbMgr = new GetData();
      }

    public Volunteer checkVolunteerInGuild(String firstname, String lastname, String guildName) throws SQLException
      {
        for (Volunteer allVolunteers : DbMgr.getAllVolunteers())
        {
            if (allVolunteers.getFirstName().getValue().equals(firstname)
                    && allVolunteers.getLastName().getValue().equals(lastname))
            {
                return DbMgr.getVolunteerBasedOnGuild(guildName);
            }
        }
        return null;
      }
  }
