/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.util.List;
import museumApp.be.Volunteer;

/**
 *
 * @author min
 */
public interface Criteria {
    
   public List<Volunteer> meetCriteria(List<Volunteer> volunteer);

    
}
