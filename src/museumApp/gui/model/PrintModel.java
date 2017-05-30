package museumApp.gui.model;

import java.io.*;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import museumApp.be.Guild;
import museumApp.be.GuildVolunteer;
import museumApp.be.Volunteer;
import museumApp.be.VolunteerTime;
import museumApp.bll.GuildVolunteerBll;
import museumApp.bll.TimeRegistrationManager;
import museumApp.bll.VolunteerBll;
import museumApp.dal.DropboxConnection;

public class PrintModel extends Model
  {

    private ObservableList<Volunteer> volunteers;
    private ObservableList<GuildVolunteer> guildsVolunteers;
    private ObservableList<VolunteerTime> volunteerTime;

    public PrintModel() throws IOException
      {
        volunteerBll = new VolunteerBll();
        guildVolunteerBll = new GuildVolunteerBll();
        timeRegistrationManager = new TimeRegistrationManager();
        volunteers = FXCollections.observableArrayList(volunteerBll.getAllVolunteers());
        guildsVolunteers = FXCollections.observableArrayList(guildVolunteerBll.getAllGuildVolunteer());
        volunteerTime = FXCollections.observableArrayList(timeRegistrationManager.getAllVolunteerTime());
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

            writer.flush();
            writer.close();
        }
      }

    public void printGuildCsv(Guild gd) throws Exception
      {
        Writer writer = null;
        try
        {
            DropboxConnection dbc = new DropboxConnection();
            String fileName = "GuildInfo" + LocalDate.now() + "_" + System.currentTimeMillis() + ".csv";
            File file = new File(dbc.getPrintFilePath(), fileName);
            writer = new BufferedWriter(new FileWriter(file));
            String titleGd = "Guild Name" + "," + "Guild Total Hours" + "\n";
            writer.write(titleGd);
            String guildName = gd.getName().get() + "\n" + "\n";
            writer.write(guildName);
            int gdId = gd.getId();
            String titleVtrs = "Guild Volunteers" + "," + "Volunteer Hours" + "\n";
            writer.write(titleVtrs);
            for (GuildVolunteer gv : guildsVolunteers)
            {

                int gvGuildId = gv.getGuildId();
                String text = gv.getVolunteer().getFullName().get() + "\n";
                if (gvGuildId == gdId)
                {
                    writer.write(text);
                }
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

    public void printAllSelectedVolunteerHours(Volunteer vtr) throws IOException
      {
        Writer writer = null;
        try
        {
            String vtrFullName = vtr.getFirstNameAsString() + vtr.getLastNameAsString();
            DropboxConnection dbc = new DropboxConnection();
            String fileName = "All" + vtrFullName + "Hours" + LocalDate.now() + "_" + System.currentTimeMillis() + ".csv";
            File file = new File(dbc.getPrintFilePath(), fileName);
            writer = new BufferedWriter(new FileWriter(file));
            String title = "Volunteer Name" + "," + "Volunteer Hours" + "\n" + "\n";
            writer.write(title);
            int vtrId = vtr.getId();
            for (Volunteer volunteer : volunteers)
            {
                int vtrListId = volunteer.getId();
                String text = volunteer.getFullName().get() + "\n";
                if (vtrId == vtrListId)
                {
                    writer.write(text);
                }
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
