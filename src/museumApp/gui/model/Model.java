/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.model;

import java.io.IOException;
import museumApp.dal.ConnectionManager;
import museumApp.dal.DatabaseManager;

/**
 *
 * @author min
 */
    public abstract class Model
  {

    protected final ConnectionManager ConnectionManager;
    protected final DatabaseManager DBManager;

    public Model() throws IOException
      {
        ConnectionManager = new ConnectionManager();
        DBManager = new DatabaseManager();
      }

  }
    
