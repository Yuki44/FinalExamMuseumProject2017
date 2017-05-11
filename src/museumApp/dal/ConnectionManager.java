package museumApp.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionManager
  {

    private static final String CONFIG_FILE_NAME = "MuseumDatabase.cfg";
    private final SQLServerDataSource ds;

    /**
     * Constructor, get the needed info to make a connection to the database.
     *
     * @throws IOException
     */
    public ConnectionManager() throws IOException
      {
        /* We tell the constructor to look for the config file with the info needed to make a connection. */
        Properties props = new Properties();
        props.load(new FileReader(CONFIG_FILE_NAME));

        ds = new SQLServerDataSource();
        ds.setServerName(props.getProperty("SERVER"));
        ds.setDatabaseName(props.getProperty("DATABASE"));
        ds.setPortNumber(Integer.parseInt(props.getProperty("PORT")));
        ds.setUser(props.getProperty("USER"));
        ds.setPassword(props.getProperty("PASSWORD"));
      }

    /** ----------------------------------------------------------------------------------------------------. */
    /**
     * Gets the class that connects to the database.
     *
     * @return
     * @throws SQLServerException
     */
    public Connection getConnection() throws SQLServerException
      {
        return ds.getConnection();
      }
    /** ----------------------------------------------------------------------------------------------------. */
  }
