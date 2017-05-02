/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import museumApp.be.Employees;

/**
 *
 * @author min
 */
public class EmployeeModel extends UserModel{
    private List<Employees> employee;

    public EmployeeModel() throws IOException {
        super();
        this.employee = new ArrayList<>();
    }
   /**
    * to get the list of employees
    * @return list of Employees
    */ 
    
    
    public List<Employees> getAllEmployees(){
       List<Employees> result = new ArrayList<>();
        result.addAll(museumManager.getAllManagers());
        result.addAll(museumManager.getAllAdmins());
        return result;
    }
}
