package museumApp.be;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserTest

  {

    public UserTest()
      {
      }

    /**
     * Test of getFullName method, of class User.
     */
    @Test
    public void testGetFullName()
      {
        String expResultFirstName = "Linda";
        String expResultLastName = "Braarup";
        String expResultFullName = expResultFirstName + " " + expResultLastName;
        User instance = new Volunteer(0, expResultFirstName, expResultLastName, null, null, null, null, null, null, null, null, null, null, null);
        String result = instance.getFullName().get();
        assertEquals(expResultFullName, result);
      }

    /**
     * Test of getFullNameAsString method, of class User.
     */
    @Test
    public void testGetFullNameAsString()
      {
        String expResultFirstName = "Linda";
        String expResultLastName = "Braarup";
        String expResultFullName = expResultFirstName + " " + expResultLastName;
        User instance = new Volunteer(0, expResultFirstName, expResultLastName, null, null, null, null, null, null, null, null, null, null, null);
        String result = instance.getFullNameAsString();
        assertEquals(expResultFullName, result);
      }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName()
      {
        String expResultFirstName = "Linda";
        User instance = new Volunteer(0, expResultFirstName, null, null, null, null, null, null, null, null, null, null, null, null);
        String result = instance.getFirstName().get();
        assertEquals(expResultFirstName, result);
      }

    /**
     * Test of getFirstNameAsString method, of class User.
     */
    @Test
    public void testGetFirstNameAsString()
      {
        String expResultFirstName = "Linda";
        User instance = new Volunteer(0, expResultFirstName, null, null, null, null, null, null, null, null, null, null, null, null);
        String result = instance.getFirstNameAsString();
        assertEquals(expResultFirstName, result);
      }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName()
      {
        String expResultLastName = "Linda";
        User instance = new Volunteer(0, null, expResultLastName, null, null, null, null, null, null, null, null, null, null, null);
        String result = instance.getLastName().get();
        assertEquals(expResultLastName, result);
      }

    /**
     * Test of getLastNameAsString method, of class User.
     */
    @Test
    public void testGetLastNameAsString()
      {
        String expResultLastName = "Linda";
        User instance = new Volunteer(0, null, expResultLastName, null, null, null, null, null, null, null, null, null, null, null);
        String result = instance.getLastNameAsString();
        assertEquals(expResultLastName, result);
      }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail()
      {
        String expResultEmail = "Linda@gmail.com";
        User instance = new Volunteer(0, null, null, null, null, expResultEmail, null, null, null, null, null, null, null, null);
        String result = instance.getEmail().get();
        assertEquals(expResultEmail, result);
      }

    /**
     * Test of getEmailAsString method, of class User.
     */
    @Test
    public void testGetEmailAsString()
      {
        String expResultEmail = "Linda@gmail.com";
        User instance = new Volunteer(0, null, null, null, null, expResultEmail, null, null, null, null, null, null, null, null);
        String result = instance.getEmailAsString();
        assertEquals(expResultEmail, result);
      }

    public class UserImpl extends User
      {

        public UserImpl()
          {
            super(0, "", "", "");
          }
      }
  }
