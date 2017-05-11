/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

/**
 *
 * @author Peder
 */
public class Administrator extends Employee
  {

    /**
     * We set the administrator to get these info:
     *
     * @param id
     * @param userName
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     */
    public Administrator(int id, String userName, String password, String firstName, String lastName, String email)
      {
        super(id, userName, password, firstName, lastName, email);
      }

  }
