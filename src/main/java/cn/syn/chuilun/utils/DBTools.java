package cn.syn.chuilun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBTools {
    public static String longToDate(long timeStamp,String formatType){
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        long stamp = timeStamp;

        Date date = new Date(stamp);
        String str = formatter.format(date);
        return str;
    }

}
