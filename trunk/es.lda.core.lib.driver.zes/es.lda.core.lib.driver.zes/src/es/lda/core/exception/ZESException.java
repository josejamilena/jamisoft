package es.lda.core.exception;

/**
 *
 * @author Jose Antonio
 */
public class ZESException extends DriverException {

    /**
     * Creates a new instance of <code>ZESException</code> without detail message.
     */
    public ZESException() {
    }

    /**
     * Constructs an instance of <code>ZESException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ZESException(String msg) {
        super(msg);
    }
}
