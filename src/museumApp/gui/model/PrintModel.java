/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.gui.model;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Volunteer;
import museumApp.bll.VolunteerBll;
import java.io.*;
import java.time.LocalDate;
import museumApp.dal.DropboxConnection;

/**
 *
 * @author Peder
 */
public class PrintModel extends Model
  {

    private ObservableList<Volunteer> volunteers;

    public PrintModel() throws IOException
      {
        volunteerBll = new VolunteerBll();
        volunteers = FXCollections.observableArrayList(volunteerBll.getAllVolunteers());
      }

    public ObservableList<Volunteer> getVolunteers()
      {
        return volunteers;
      }

    public void printAllVtrCsv() throws Exception
      {
        Writer writer = null;
        try
        {
            DropboxConnection dbc = new DropboxConnection();
            String fileName = "VolunteerInfo" + LocalDate.now() + "_" + System.currentTimeMillis() + ".csv";
            File file = new File(dbc.getPrintFilePath(), fileName);
            writer = new BufferedWriter(new FileWriter(file));
            String title = "Name" + "," + "Email" + "," + "Phone Number" + "," + "Birthday" + "," + "Nationality" + "," + "Address" + "," + "Zip Code" + "," + "City" + "," + "Joined date" + "\n";
            writer.write(title);
            for (Volunteer volunteer : volunteers)
            {

                String text = volunteer.getFullName().get()
                        + "," + volunteer.getEmail().get() + "," + volunteer.getPhoneNumber().get()
                        + "," + volunteer.getBirthDate().get() + "," + volunteer.getNationality().get()
                        + "," + volunteer.getAddress().get() + "," + volunteer.getZipCode().get()
                        + "," + volunteer.getCity().get() + "," + volunteer.getRegisteredDate() + "\n";

                writer.write(text);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {

            writer.flush();
            writer.close();
        }
      }
  }
