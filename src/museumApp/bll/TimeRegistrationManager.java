/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import museumApp.be.VolunteerTime;
import museumApp.dal.AddData;
import museumApp.dal.GetData;

/**
 *
 * @author Peder
 */
public class TimeRegistrationManager implements IManager<VolunteerTime>
  {

    private AddData addData;
    private GetData getData;

    public TimeRegistrationManager() throws IOException
      {
        this.addData = new AddData();
        this.getData = new GetData();
      }

    @Override
    public void Add(VolunteerTime obj)
      {
        try
        {
            System.out.println("time: " + obj.getHours());
            addData.addHours(obj);
        }
        catch (SQLException ex)
        {
            System.err.println("Unable to add hours. " + ex.getMessage());
        }
      }

    @Override
    public VolunteerTime Update(VolunteerTime obj)
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    @Override
    public List<VolunteerTime> ReadAll()
      {
        try
        {
            return getData.getAllVTime();
        }
        catch (SQLException ex)
        {
            System.err.println("Unable to get time.");
        }
        return null;
      }

    @Override
    public VolunteerTime Read(int id)
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    @Override
    public void Delete(int id)
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

  }
