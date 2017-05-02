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
public class Location extends BusinessEntity
  {

    protected StringProperty name;

    public Location(String name, int id)
      {
        super(id);
        this.name = new SimpleStringProperty(name);
      }

    /** ------------------------------------------------------------------------------------------- */
    /**
     * We get userNames as string property because it can update the view
     *
     * @return
     */
    public StringProperty getName()
      {
        return name;
      }

    /**
     * We get userNames as simple string, however it cannot update the view automatically
     *
     * @return
     */
    public String getNameAsString()
      {
        return name.get();
      }
    /** ------------------------------------------------------------------------------------------- */
  }
