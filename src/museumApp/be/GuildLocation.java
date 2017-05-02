/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

/**
 *
 * @author Peder
 */
public class GuildLocation extends BusinessEntity
  {

    protected int guildId;
    protected int locationId;

    public GuildLocation(int guildId, int locationId, int id)
      {
        super(id);
        this.guildId = guildId;
        this.locationId = locationId;
      }

    /** ------------------------------------------------------------------------------------------- */
    public int getGuildId()
      {
        return guildId;
      }

    /** ------------------------------------------------------------------------------------------- */
    public int getLocationId()
      {
        return locationId;
      }
    /** ------------------------------------------------------------------------------------------- */

  }
