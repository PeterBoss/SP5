package exception;

public class QuoteNotFoundException extends Exception {

    public QuoteNotFoundException() {
    }

    public QuoteNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Quote with requested id not found";
    }

    
    
}
