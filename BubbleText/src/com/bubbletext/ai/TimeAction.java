package com.bubbletext.ai;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/**
 * Created by charles on 12/1/16.
 */
public class TimeAction {
    public static String timeInCity(String location) {

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        ArrayList<String> zoneList = new ArrayList<>(availableZoneIds);

        String locationFormatted = location.trim().replaceAll(" +", "_");

        String zone = "";
        for (String z : zoneList) {
            if (z.contains(locationFormatted))
                zone = z;
        }

        if (zone.isEmpty())
            return "Cette ville n'existe pas !";

        Instant now = Instant.now();
        ZoneId zoneId = ZoneId.of(zone);

        ZonedDateTime zonedDateTime = now.atZone(zoneId);

        String response = "Il est actuellement "
                + String.format("%02d:%02d", zonedDateTime.getHour(), zonedDateTime.getMinute())
                + " à " + location + ".";

        return response;
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
