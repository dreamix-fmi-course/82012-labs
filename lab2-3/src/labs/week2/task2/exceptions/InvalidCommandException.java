package labs.week2.task2.exceptions;

public class InvalidCommandException extends FileManagementException {

    public InvalidCommandException(String message) {
        super(message);
    }

}