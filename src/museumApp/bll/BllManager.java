package museumApp.bll;

import museumApp.dal.AddData;
import museumApp.dal.AdministratorLoginHandler;
import museumApp.dal.DatabaseManager;
import museumApp.dal.GetData;
import museumApp.dal.ManagerLoginHandler;
import museumApp.dal.RemoveData;
import museumApp.dal.UpdateData;

public class BllManager
  {

    protected GetData getDbMgr;
    protected AddData addDbMgr;
    protected UpdateData updateDbMgr;
    protected RemoveData removeDbMgr;
    protected DatabaseManager DbMgr;
    protected ManagerLoginHandler managerLoginHandler;
    protected AdministratorLoginHandler adminLoginHandler;

    public BllManager()
      {

      }

  }
