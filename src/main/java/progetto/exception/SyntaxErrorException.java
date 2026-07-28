package progetto.exception;

public class SyntaxErrorException extends RuntimeException {
    public SyntaxErrorException(String mess) { super(mess); }
}
