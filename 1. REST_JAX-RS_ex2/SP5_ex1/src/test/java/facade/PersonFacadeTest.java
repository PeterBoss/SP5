package facade;

import entity.Person;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class PersonFacadeTest {

    private static PersonFacade pf;

    @BeforeClass
    public static void setUpBeforeAll() {
        pf = new PersonFacade();
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("test_pu"));  // script runs, adding 5 people to in-memory db
    }

    @Test
    public void testGetPerson() {
        Person p = pf.getPerson(1);
        
        assertEquals(p.getfName(), "John");
        assertEquals(p.getlName(), "Smith");
        assertEquals(p.getPhone(), "11111111");

    }
    
    @Test
    public void testGetPersons() {
        List<Person> persons = pf.getPersons();
        
        assertEquals(persons.size(), 5);
        assertEquals(persons.get(0).getfName(), "John");
    }
    
    @Test
    public void testAddPerson() {
        Person testPerson = new Person();
        testPerson.setfName("FirstName");
        testPerson.setlName("LastName");
        testPerson.setPhone("PhoneNumber");
        
        pf.addPerson(testPerson);
        
        assertEquals(pf.getPerson(6).getfName(), "FirstName");
    }
    
    @Test
    public void testEditPerson() {
        Person p = pf.getPerson(2);
        p.setPhone("NewPhoneNumber");
        
        pf.editPerson(p);
        
        assertEquals(pf.getPerson(2).getPhone(), "NewPhoneNumber");
    }

}
