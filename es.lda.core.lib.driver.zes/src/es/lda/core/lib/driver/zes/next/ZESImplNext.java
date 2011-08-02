package es.lda.core.lib.driver.zes.next;

import es.lda.core.exception.DriverException;
import es.lda.core.exception.UnsupportedDriverOperation;
import es.lda.core.lib.driver.IDriverNext;
import es.lda.core.lib.driver.zes.impl.ZESImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jose Antonio
 */
public class ZESImplNext extends ZESImpl implements IDriverNext{

    @Override
    public Map<String, Object> exec(String cmd, Map<String, Object> args) throws DriverException, UnsupportedDriverOperation {
        Map<String, Object> res;
        String[] args1 = (String[]) args.get("args");
        byte[] argsBytes1 = (byte[]) args.get("argsBytes");                
        res = new HashMap<String, Object>();
        Object[] result = this.exec(cmd, args1, argsBytes1);
        res.put("res", result);
        return res;
    }
    
}
