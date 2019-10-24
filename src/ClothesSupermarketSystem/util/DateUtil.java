package ClothesSupermarketSystem.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zy
 * @date 2019-10-24 21:07
 * @reason :
 */
public class DateUtil {

    public static String toDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  df.format(date);
    }
}
