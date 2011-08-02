package es.lda.core.lib.driver;

import es.lda.core.exception.DriverException;
import es.lda.core.exception.UnsupportedDriverOperation;
import java.util.Map;

/**
 *
 * @author Jose Antonio
 */
public interface IDriverNext extends IDriver {

    /** 
     * Execute command:<code>cmd</code> 
     * with arguments<code>args</code> and return the result. 
     * @param cmd Command.
     * @param args Map with pair values (param. var. name, value).
     * @return Return an with pair values (return var., value).
     * @throw DriverException Error in Command.
     * @throw UnsupportedDriverOperation Unsupported Command in driver version.
     */
    public Map<String, Object> exec(String cmd, Map<String, Object> args)
            throws DriverException, UnsupportedDriverOperation;
}
