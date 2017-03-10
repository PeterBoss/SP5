package utility;

import entity.Person;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JSONConverterTest {

    private static Person testPerson = new Person();
    private static String testString = "{\"fName\":\"FirstName\",\"lName\":\"LastName\",\"phone\":\"PhoneNumber\",\"id\":1}";

    @BeforeClass
    public static void setUpBeforeAll() {
        testPerson.setId(1);
        testPerson.setfName("FirstName");
        testPerson.setlName("LastName");
        testPerson.setPhone("PhoneNumber");
    }

    @Test
    public void testGetPersonFromJson() {
        Person p = JSONConverter.getPersonFromJson(testString);

        assertEquals(p.getId(), testPerson.getId());
        assertEquals(p.getfName(), testPerson.getfName());
        assertEquals(p.getlName(), testPerson.getlName());
        assertEquals(p.getPhone(), testPerson.getPhone());

    }

    @Test
    public void testGetJSONFromPerson_Person() {

        String s = JSONConverter.getJSONFromPerson(testPerson);
        assertEquals(s, testString);

    }

    @Test
    public void testGetJSONFromPerson_List() {

        List<Person> persons = new ArrayList();
        persons.add(testPerson);
        persons.add(testPerson);

        String s = JSONConverter.getJSONFromPerson(persons);

        assertEquals(s, "[" + testString + "," + testString + "]");
    }

}
