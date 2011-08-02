package es.lda.core.lib.driver;

import es.lda.core.exception.DriverException;
import es.lda.core.exception.UnsupportedDriverOperation;

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

    /** 
     * Execute command:<code>cmd</code> 
     * with arguments<code>args</code> 
     * (and/or <code>argsBytes</code>) and return the result. 
     * @param cmd Command.
     * @param args Array with arguments for the Command.
     * @param argsBytes Array with byte arguments for the Command.
     * @return Return an object array, this the result list of Command.
     * @throw DriverException Error in Command.
     * @throw UnsupportedDriverOperation Unsupported Command in driver version.
     */    
    public Object[] exec(String cmd, String args[], byte[] argsBytes)
            throws DriverException, UnsupportedDriverOperation;

}
