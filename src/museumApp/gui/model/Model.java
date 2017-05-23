package museumApp.gui.model;

import java.io.IOException;
import museumApp.bll.MuseumManager;
import museumApp.bll.TimeRegistrationManager;

public abstract class Model
  {

    /**
     * Creates a connection to the BLL.
     * only connect to the BLL.
     */
    protected final MuseumManager museumManager;
    protected final TimeRegistrationManager timeRegistrationManager;

    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /**
     * Instantiates a new MuseumManager
     *
     * @throws IOException
     */
    public Model() throws IOException
      {
        museumManager = new MuseumManager();
        timeRegistrationManager = new TimeRegistrationManager();

      }
    /** ---------------------------------------------------------------------------------------------------------------------------. */
  }
