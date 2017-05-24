package museumApp.dal;

import java.io.IOException;

public class DatabaseManager
  {

    protected final ConnectionManager connectionManager;

    /**
     * Constructor to get a new Connection Manager
     *
     * @throws IOException
     */
    public DatabaseManager() throws IOException
      {
        connectionManager = new ConnectionManager();
      }
    /** ---------------------------------------------------------------------------------------------------------------------------. */
    /** ---------------------------------------------------------------------------------------------------------------------------. */

    /**
     * Classes: getData - addData - updateData - removeData inherit form this class.
     */
  }
