package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import museumApp.be.GuildVolunteer;
import museumApp.be.VolunteerTime;
import museumApp.dal.AddData;
import museumApp.dal.GetData;

public class TimeRegistrationManager implements IManager<VolunteerTime>
  {

    private AddData addData;
    private GetData getData;

    public TimeRegistrationManager() throws IOException
      {
        this.addData = new AddData();
        this.getData = new GetData();
      }

    /**
     * This method connects through the IManager to call the addHours function
     *
     * @param obj
     */
    public void Add(VolunteerTime obj, GuildVolunteer gvObj)
      {
        try
        {
            addData.addHours(obj, gvObj);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TimeRegistrationManager.class.getName()).log(Level.SEVERE, null, ex);
        }

      }

    /**
     * This method is not currently in use
     *
     * @param obj
     * @return
     */
    @Override
    public VolunteerTime Update(VolunteerTime obj)
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    /**
     * This method connects through the IManager to call the getAllVTime function.
     *
     * @return
     */
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

    /**
     * This method is not currently in use
     *
     * @param obj
     * @return
     */
    @Override
    public VolunteerTime Read(int id)
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    /**
     * This method is not currently in use
     *
     * @param obj
     * @return
     */
    @Override
    public void Delete(int id)
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    public void AddTime(VolunteerTime vTime)
      {
        try
        {
            //     getData.getVolunteerGuldIdBasedOnVolunteerIdAndGuldId(vt, gd);
//
            addData.addVolunteerTimeHours(vTime);
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
        }
      }

    @Override
    public void Add(VolunteerTime objToAdd)
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
    
    /**
     * Creates a List to fetch the Volunteer time in the database.
     *
     * @return method from GetData
     * @throws SQLException
     */
    public List<VolunteerTime> getAllVTime() throws SQLException
      {
        try
        {
            return getData.getAllVTime();
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
            throw new MuseumManagerException("Unable to fetch volunteer time.");
        }
      }

  }
