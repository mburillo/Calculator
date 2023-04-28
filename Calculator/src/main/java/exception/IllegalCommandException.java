package exception;

public class IllegalCommandException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalCommandException() {
        super();
    }
    
    public IllegalCommandException(String message) {
        super(message);
    }
    
    public IllegalCommandException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public IllegalCommandException(Throwable cause) {
        super(cause);
    }
}
