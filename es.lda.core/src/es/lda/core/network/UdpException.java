package es.lda.core.network;

/**
 *
 * @author Jose Antonio
 */
public class UdpException extends Exception {

    /**
     * Creates a new instance of <code>UdpException</code> without detail message.
     */
    public UdpException() {
    }

    /**
     * Constructs an instance of <code>UdpException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public UdpException(String msg) {
        super(msg);
    }
}
