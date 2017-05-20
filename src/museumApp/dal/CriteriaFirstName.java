/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import museumApp.be.Volunteer;

/**
 *
 * @author min
 */
public class CriteriaFirstName implements Criteria {
        @Override
    public List<Volunteer> meetCriteria(List<Volunteer> volunteer) {
        GetData getData;
            try {
                getData = new GetData();
            } catch (IOException ex) {
                Logger.getLogger(CriteriaFirstName.class.getName()).log(Level.SEVERE, null, ex);
            }
         
   //   return getData.getVolunteersByFirstName(firstName);
   return volunteer;
    }

    
}
