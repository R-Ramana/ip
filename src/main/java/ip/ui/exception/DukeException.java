package ip.ui.exception;

/**
 * Exception class called when exception is caught. Returns the error message thrown (String)
 *
 * @return Error Message
 */
public class DukeException extends Exception {
    private String error;

    public DukeException(String errorMessage) {
        this.error = errorMessage;
    }

    public String getErrorMessage() {
        return error;
    }
}