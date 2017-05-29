package museumApp.dal;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DropboxConnection
  {

    private Properties prop = new Properties();

    public DropboxConnection() throws IOException
      {
        try
        {
            prop.load(new FileReader("MuseumDatabase.cfg"));

            // set the properties value
            prop.getProperty("DropboxVolunteer");
            prop.getProperty("DropboxNationality");
            prop.getProperty("DropboxPrint");

        }
        catch (IOException io)
        {
            io.printStackTrace();
            System.err.println(io.getCause());
        }
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    public String getVolunteerImgFilePath()
      {
        return prop.getProperty("DropboxVolunteer");
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    public String getNationalityImgFilePath()
      {
        return prop.getProperty("DropboxNationality");
      }

    public String getPrintFilePath()
      {
        return prop.getProperty("DropboxPrint");
      }

    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
    /** ------------------------------------------------------------------------------------------------------------------------------------------------------. */
  }
