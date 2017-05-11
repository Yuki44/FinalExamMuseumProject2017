package museumApp.bll;

public class MuseumManagerException extends RuntimeException
  {

    /**
     * It makes possible for us to see the origin of the errors by calling RuntimeException
     *
     * @param message
     */
    public MuseumManagerException(String message)
      {
        super(message);
      }

  }
