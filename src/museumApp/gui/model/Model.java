/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.model;

import java.io.IOException;
import museumApp.bll.MuseumManager;
import museumApp.dal.DatabaseManager;

/**
 *
 * @author Peder
 */
public abstract class Model
{

    /**
     * Creates a connection to the BLL. 
     * only connect to the BLL.
     */
    protected final MuseumManager museumManager;
   

    /**
     *
     * @throws IOException
     */
    public Model() throws IOException
    {
        museumManager = new MuseumManager();
       
    }

}
