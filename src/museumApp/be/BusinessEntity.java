package museumApp.be;

public abstract class BusinessEntity
  {

    protected int id;

    public BusinessEntity(int id)
      {
        this.id = id;
      }

    public int getId()
      {
        return id;
      }

    public void setId(int id)
      {
        this.id = id;
      }

  }
