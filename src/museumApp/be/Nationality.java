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
 * @author min
 */
public class Nationality {
    protected StringProperty country;

    public Nationality(String country) {
        this.country = new SimpleStringProperty(country);
    }

    public StringProperty getCountry() {
        return country;
    }
   
    public String getCountryAsString()
    {
        return country.get();
    }
       @Override
    public String toString()
      {
        return getCountryAsString();
      }
}
