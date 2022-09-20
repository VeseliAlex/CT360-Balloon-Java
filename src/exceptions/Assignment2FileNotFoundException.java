package exceptions;

/**
 *Exception za Assignment
 */
abstract class Assignment2Exception extends Exception {
    public Assignment2Exception(String message) {
        super(message);
    }
}

public class Assignment2FileNotFoundException extends Assignment2Exception {
    public Assignment2FileNotFoundException(String message) {
        super(message);
    }
}




