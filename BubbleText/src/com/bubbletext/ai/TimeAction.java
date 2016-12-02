package com.bubbletext.ai;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by charles on 12/1/16.
 */
public class TimeAction {
    public static String timeInCity(String city){
        //TODO
        return null;
    }

    public static String currentTime(){
        DateFormat df = new SimpleDateFormat(" HH:mm:ss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }

    public static String currentDate(){
        DateFormat df = new SimpleDateFormat(" dd/MM/yy");
        Date dateobj = new Date();
        return df.format(dateobj);
    }
}
