package test;

import exception.QuoteNotFoundException;
import exception.QuoteNotFoundMapper;

public class Tester {

    public static void main(String[] args) throws QuoteNotFoundException {

        QuoteNotFoundException ex = new QuoteNotFoundException();
        
    QuoteNotFoundMapper mapper = new QuoteNotFoundMapper();
        System.out.println(mapper.toResponse(ex));
    
    }
    
}
