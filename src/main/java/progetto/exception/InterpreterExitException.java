package progetto.exception;

public class InterpreterExitException extends RuntimeException {
    public InterpreterExitException(String message) {
        super(message);
    }
}
