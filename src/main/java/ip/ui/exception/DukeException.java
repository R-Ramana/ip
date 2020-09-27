package ip.ui.exception;

public class DukeException extends Exception {
    private String error;

    public DukeException(String errorMessage) {
        this.error = errorMessage;
    }

    public String getErrorMessage() {
        return error;
    }
}