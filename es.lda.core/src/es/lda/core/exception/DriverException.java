package es.lda.core.exception;

/**
 *
 * @author Jose Antonio
 */
public class DriverException extends Exception {

    /**
     * Creates a new instance of <code>DriverException</code> without detail message.
     */
    public DriverException() {
    }

    /**
     * Constructs an instance of <code>DriverException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DriverException(String msg) {
        super(msg);
    }
}
