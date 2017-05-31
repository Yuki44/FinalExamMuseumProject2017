/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

import javafx.beans.property.StringProperty;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peder
 */
public class EmployeeTest
  {

    public EmployeeTest()
      {
      }

    /**
     * Test of getUserName method, of class Employee.
     */
    @Test
    public void testGetUserName()
      {
        String expResultUsername = "peder";
        Employee instance = new Administrator(0, null, null, null, expResultUsername, null);
        String result = instance.getUserName().get();
        assertEquals(expResultUsername, result);
      }

    /**
     * Test of getUserNameAsString method, of class Employee.
     */
    @Test
    public void testGetUserNameAsString()
      {
        String expResultUsername = "peder";
        Employee instance = new Administrator(0, null, null, null, expResultUsername, null);
        String result = instance.getUserNameAsString();
        assertEquals(expResultUsername, result);
      }

    /**
     * Test of getPassword method, of class Employee.
     */
    @Test
    public void testGetPassword()
      {
        String expResultPassword = "1234";
        Employee instance = new Administrator(0, null, null, null, null, expResultPassword);
        String result = instance.getPassword().get();
        assertEquals(expResultPassword, result);
      }

    /**
     * Test of getPasswordAsString method, of class Employee.
     */
    @Test
    public void testGetPasswordAsString()
      {
        String expResultPassword = "1234";
        Employee instance = new Administrator(0, null, null, null, null, expResultPassword);
        String result = instance.getPasswordAsString();
        assertEquals(expResultPassword, result);
      }

    public class EmployeeImpl extends Employee
      {

        public EmployeeImpl()
          {
            super(0, "", "", "", "", "");
          }
      }

  }
