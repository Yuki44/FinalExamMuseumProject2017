/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

import java.io.IOException;
import museumApp.dal.GetData;

/**
 *
 * @author min
 */
public class FilterHoursByGuild extends AbstractFilterStrategy {
   protected GetData getDbMgr;

    public FilterHoursByGuild( String filterData) throws IOException {
        super(filterData);
        this.getDbMgr = new GetData();
            }

    @Override
    public int filterData(String filterData) {
         return getDbMgr.filterHoursByGuild(filterData);
    }
    
    }
    
