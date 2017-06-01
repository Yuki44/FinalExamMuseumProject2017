package museumApp.gui.model;

import java.io.IOException;
import museumApp.bll.AdminBll;
import museumApp.bll.FacadeBll;
import museumApp.bll.GuildBll;
import museumApp.bll.GuildVolunteerBll;
import museumApp.bll.LoginManager;
import museumApp.bll.ManagerBll;
import museumApp.bll.NationalityBll;
import museumApp.bll.TimeRegistrationManager;
import museumApp.bll.VolunteerBll;

public abstract class Model
  {

    /**
     * Creates a connection to the BLL.
     * only connect to the BLL.
     */
    protected FacadeBll facadeBll;

    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Instantiates a new MuseumManager
     *
     * @throws IOException
     */
    public Model() throws IOException
      {

      }
    /** ---------------------------------------------------------------------------------------------------------------------------. */
  }
