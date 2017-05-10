/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Peder
 */
public class Guild extends BusinessEntity
  {

    protected StringProperty name;
    protected int managerId;

    public Guild(int id, String name, int managerId)
      {
        super(id);
        this.name = new SimpleStringProperty(name);
        this.managerId = managerId;
      }

    /** ------------------------------------------------------------------------------------------- */
    /**
     * We get Name as string property because it can update the view
     *
     * @return
     */
    public StringProperty getName()
      {
        return name;
      }

    /**
     * We get Name as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getNameAsString()
      {
        return name.get();
      }

    /** ------------------------------------------------------------------------------------------- */
    /**
     * We get managerId
     *
     * @return
     */
    public int getManagerId()
      {
        return managerId;
      }

    public void setManagerId(int managerId)
      {
        this.managerId = managerId;
      }
    /** ------------------------------------------------------------------------------------------- */
  }
