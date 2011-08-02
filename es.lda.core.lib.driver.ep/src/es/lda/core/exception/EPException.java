package es.lda.core.exception;

/**
 *
 * @author Jose Antonio
 */
public class EPException extends DriverException {

    /**
     * Creates a new instance of <code>EPException</code> without detail message.
     */
    public EPException() {
    }

    /**
     * Constructs an instance of <code>EPException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EPException(String msg) {
        super(msg);
    }
}
