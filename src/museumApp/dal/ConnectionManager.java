/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author min
 */
public class ConnectionManager {
   
    private final SQLServerDataSource ds;
    
    public ConnectionManager() throws IOException
    {
                
        ds = new SQLServerDataSource();
        ds.setServerName("EASV-DB2");
        ds.setDatabaseName("levendehistorie");
        ds.setPortNumber(1433);
        ds.setUser("CS2016B_18");
        ds.setPassword("CS2016B_18");
    }
    
    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }
}

