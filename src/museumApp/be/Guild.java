package museumApp.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Guild extends BusinessEntity
  {

    protected StringProperty name;
    protected int managerId;

    /** ----------------------------TO DO REFACTOR BEGINNING---------------------------------------------. */
    /**
     * 1st Constructor.
     */
    public Guild(int id, String name, int managerId)
      {
        super(id);
        this.name = new SimpleStringProperty(name);
        this.managerId = managerId;
      }

    /**
     * 2nd Constructor.
     */
    public Guild(String id, String name, String managerId)
      {
        super(Integer.parseInt(id));
        this.name = new SimpleStringProperty(name);
        this.managerId = Integer.parseInt(managerId);
      }

    /** ------------------------------------TO DO REFACTOR END---------------------------------------------. */
    /** ------------------------------------GUILD NAME---------------------------------------------. */
    /**
     * We get GUILD Name as string property because it can update the view
     *
     * @return
     */
    public StringProperty getName()
      {
        return name;
      }

    /**
     * We get GUILD Name as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getNameAsString()
      {
        return name.get();
      }

    @Override
    public String toString()
      {
        return getNameAsString();
      }

    /** ----------------------------------GUILD MANAGER----------------------------------------------. */
    /**
     * We get GUILD managerId
     *
     * @return
     */
    public int getManagerId()
      {
        return managerId;
      }

    /** -------------------------------------------------------------------------------------------. */
  }
