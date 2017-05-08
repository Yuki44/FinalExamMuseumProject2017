/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

/**
 *
 * @author min
 */
public abstract class AbstractFilterStrategy extends MuseumManager implements FilterStrategy  {
    String filterData;
    public AbstractFilterStrategy (String filterData){
    this.filterData = filterData;
    }

    
    
}
