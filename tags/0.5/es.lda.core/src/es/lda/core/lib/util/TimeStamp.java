package es.lda.core.lib.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Jose Antonio
 */
public class TimeStamp {

    private TimeStamp() {
    }
    
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());

    }

    public static String getTimeStamp() {
//        java.util.Date time = new java.util.Date();
//        return (new java.sql.Time(time.getTime())).toString();
        return now();
    }
}
