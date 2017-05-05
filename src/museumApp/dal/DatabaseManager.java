/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author min
 */
public class DatabaseManager {
     protected final ConnectionManager connectionManager;

    public DatabaseManager() throws IOException {
        connectionManager = new ConnectionManager();
    }
     
    
}
