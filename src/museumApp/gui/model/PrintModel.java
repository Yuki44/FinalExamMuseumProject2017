package museumApp.gui.model;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Guild;
import museumApp.be.GuildVolunteer;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;
import museumApp.bll.FacadeBll;
import museumApp.bll.TimeRegistrationManager;
import museumApp.dal.DropboxConnection;

public class PrintModel extends Model
  {

    private ObservableList<Volunteer> volunteers;
    private ObservableList<GuildVolunteer> guildsVolunteers;
//    private ObservableList<VolunteerTime> volunteerTimeBasedOnId;

    public PrintModel() throws IOException
      {
        facadeBll = new FacadeBll();
        timeRegistrationManager = new TimeRegistrationManager();
        volunteers = FXCollections.observableArrayList(facadeBll.getAllVolunteers());
        guildsVolunteers = FXCollections.observableArrayList(facadeBll.getAllGuildVolunteer());
//        volunteerTimeBasedOnId = FXCollections.observableArrayList(timeRegistrationManager.getVolunteerTimeBasedOnVtrId(vtrId));
      }

    public ObservableList<Volunteer> getVolunteers()
      {
        return volunteers;
      }

    public ObservableList<GuildVolunteer> getGuildVolunteers()
      {
        return guildsVolunteers;
      }

    public void printAllVtrCsv() throws Exception
      {

        Runnable r = () ->
        {

            Writer writer = null;
            try
            {
                DropboxConnection dbc = new DropboxConnection();
                String fileName = "VolunteerInfo" + LocalDate.now() + "_" + System.currentTimeMillis() + ".csv";
                File file = new File(dbc.getPrintFilePath(), fileName);
                writer = new BufferedWriter(new FileWriter(file));
                String title = "Name" + "," + "Email" + "," + "Phone Number" + ","
                        + "Birthday" + "," + "Nationality" + "," + "Address"
                        + "," + "Zip Code" + "," + "City" + "," + "Joined date" + "\n";
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

                try
                {
                    writer.flush();
                    writer.close();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    public void printGuildCsv(Guild gd) throws Exception
      {
        Runnable r = () ->
        {

            Writer writer = null;
            try
            {

                DropboxConnection dbc = new DropboxConnection();
                String fileName = "GuildInfo" + LocalDate.now() + "_" + System.currentTimeMillis() + ".csv";
                File file = new File(dbc.getPrintFilePath(), fileName);
                writer = new BufferedWriter(new FileWriter(file));
                String titleGd = "Guild Name" + "," + "Guild Total Hours" + String.format("%n");
                writer.write(titleGd);

                int gdId = gd.getId();
                String titleVtrs = "Guild Volunteers" + "," + "Volunteer Hours" + String.format("%n");

                String volunteerText = "";
                int allTime = 0;
                for (GuildVolunteer gv : guildsVolunteers)
                {
                    int gvGuildId = gv.getGuildId();

                    int vtrId = gv.getVolunteer().getId();

                    List<VolunteerTime> vTimeOnId = timeRegistrationManager.getVolunteerAndGuildTimeBasedOnId(vtrId, gdId);
                    int volunteerhours = 0;
                    for (VolunteerTime volTime : vTimeOnId)
                    {
                        volunteerhours += volTime.getHours();
                    }

                    if (gvGuildId == gdId)
                    {
                        allTime += volunteerhours;
                        volunteerText += gv.getVolunteer().getFullName().get() + "," + volunteerhours + String.format("%n");
                    }

                }
                String guildText = gd.getName().get() + "," + allTime + String.format("%n") + String.format("%n");
                writer.write(guildText);
                writer.write(titleVtrs);
                writer.write(volunteerText);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {

                try
                {
                    writer.flush();
                    writer.close();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

    public void printAllSelectedVolunteerHours(Volunteer vtr) throws IOException
      {
        Runnable r = () ->
        {

            Writer writer = null;
            try
            {
                String vtrFullName = vtr.getFirstNameAsString() + vtr.getLastNameAsString();
                DropboxConnection dbc = new DropboxConnection();
                String fileName = "All" + vtrFullName + "Hours" + LocalDate.now() + "_" + System.currentTimeMillis() + ".csv";
                File file = new File(dbc.getPrintFilePath(), fileName);
                writer = new BufferedWriter(new FileWriter(file));
                int vtrId = vtr.getId();
                for (Volunteer volunteer : volunteers)
                {
                    int vtrListId = volunteer.getId();
                    String text = "Volunteer: " + volunteer.getFullName().get() + "\n" + "\n";
                    if (vtrId == vtrListId)
                    {
                        writer.write(text);
                    }
                }
                String title = "Dates" + "," + "Hours" + "\n";
                writer.write(title);
                List<VolunteerTime> vTimeOnId = timeRegistrationManager.getVolunteerTimeBasedOnVtrId(vtrId);
                for (VolunteerTime volunteerTime : vTimeOnId)
                {
                    String date = volunteerTime.getDateAsString();
                    int hours = volunteerTime.getHours();
                    String hoursThing = date + "," + hours
                            + "\n";
                    writer.write(hoursThing);
                }

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {

                try
                {
                    writer.flush();
                    writer.close();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
      }

  }
