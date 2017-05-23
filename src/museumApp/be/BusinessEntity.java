package museumApp.be;

public abstract class BusinessEntity
  {

    protected final int id;

    public BusinessEntity(int id)
      {
        this.id = id;
      }

    public int getId()
      {
        return id;
      }

  }
