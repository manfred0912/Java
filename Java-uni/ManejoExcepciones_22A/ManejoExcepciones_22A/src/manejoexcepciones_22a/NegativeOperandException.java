package manejoexcepciones_22a;


public class NegativeOperandException extends RuntimeException {

    public NegativeOperandException() {
        super("Negative operand exception");
    }

    public NegativeOperandException(String message) {
        super(message);
    }
    
    
}
