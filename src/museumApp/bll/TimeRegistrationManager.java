package museumApp.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
     * @param vTime
     * @param obj
     */
    @Override
    public void Add(VolunteerTime vTime)
      {
        try
        {
            addData.addVolunteerTimeHours(vTime);
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getCause());
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
            System.err.println(ex.getCause());
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

  }
