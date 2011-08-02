package es.lda.core.lib.driver;

import es.lda.core.exception.DriverException;

/**
 * Indicates that its instances are drivers.
 * @author Jose Antonio
 */
public interface IDriver {

    /** Get Device Name. */
    public String getDevice();

    /** Get Device Id. */
    public String getDeviceId();

    /** Get Device version. */
    public String getVersion();
    
    /** Execute command:<code>cmd</code> with arguments<code>args</code> (and/or <code>argsBytes</code>) and return the result. */
    public Object[] exec(String cmd, String args[], byte[] argsBytes) throws DriverException;
   
}
