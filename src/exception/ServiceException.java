package exception;

/**
 * Exception related to the application.
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String errorMessage) {
        super(errorMessage);
    }
}
