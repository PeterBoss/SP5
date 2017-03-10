package test;

import entity.Person;
import facade.PersonFacade;
import javax.persistence.Persistence;
import utility.JSONConverter;

public class Tester {

    public static void main(String[] args) {
        PersonFacade pf = new PersonFacade();
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("pu"));
        
       Person p1 = new Person();
       p1.setId(1);
       p1.setfName("FirstName");
       p1.setlName("LastName");
       p1.setPhone("PhoneNumber");
       
        System.out.println(JSONConverter.getJSONFromPerson(p1));
        
    }
    
}
