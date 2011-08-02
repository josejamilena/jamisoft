package es.lda.core.lib.util;

/**
 *
 * @author Jose Antonio
 */
public class TimeStamp {

    private TimeStamp() {
    }
    
    public static String getTimeStamp() {
        java.util.Date time = new java.util.Date();
        return (new java.sql.Time(time.getTime())).toString();
    }
}
