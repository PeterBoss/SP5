package data;

public class Tester {

    public static void main(String[] args) {
        DataGenerator gen = new DataGenerator();
        
        String data = gen.getData(20, "fname, lname, street");
        System.out.println(data);
    }
    
}
