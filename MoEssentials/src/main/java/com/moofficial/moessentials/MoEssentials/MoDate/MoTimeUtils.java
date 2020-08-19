package com.moofficial.moessentials.MoEssentials.MoDate;

import java.util.Calendar;

public class MoTimeUtils {



    private static final double MILLI_IN_SECOND = 1000;
    private static final double MILLI_IN_MINUTE = 60000;
    private static final double MILLI_IN_HOUR = 3.6e+6;
    private static final double MILLI_IN_DAY = 8.64e+7;
    private static final double MILLI_IN_MONTH = 2.628e+9;
    private static final double MILLI_IN_YEAR = 3.154e+10;


    /**
     * given hour,minute,and seconds in string, we return
     * the total milliseconds
     * @param hour
     * @param minute
     * @param seconds
     * @return
     */
    public static long getTimeInMilli(String hour, String minute, String seconds){
        double h = 0 ,m = 0 ,s = 0;
        if(!hour.isEmpty())
            h = Double.parseDouble(hour);
        if(!minute.isEmpty())
            m = Double.parseDouble(minute);
        if(!seconds.isEmpty())
            s = Double.parseDouble(seconds);

        long milli = 0;

        milli+= (MILLI_IN_SECOND * s);
        milli+= (MILLI_IN_MINUTE * m);
        milli+= (MILLI_IN_HOUR * h);

        return milli;
    }



    /**
     * returns a time format
     * [hour,minute,seconds,milliseconds]
     * @param milliseconds
     * @return
     */
    public static String[] convertMilli(long milliseconds){
        milliseconds = Math.abs(milliseconds);
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60))) % 60;
        int hours   = (int) ((milliseconds / (1000*60*60)));
        int millisec = (int) milliseconds % 1000;
        String h = hours < 10 ? "0"+hours: hours+"";
        String m = minutes < 10 ? "0"+minutes: minutes+"";
        String s = seconds < 10 ? "0"+seconds: seconds+"";
        String ms = millisec < 10? "00"+millisec: millisec < 100?"0"+millisec:millisec + "";

        return new String[]{h,m,s,ms};
    }


    /**
     * converts milliseconds to hr:min:sec format
     * @param milliseconds
     * @return
     */
    public static String convertToReadableFormat(long milliseconds){
        String[] parts = convertMilli(milliseconds);
        return parts[0] + ":" + parts[1] + ":" + parts[2];
    }


    /**
     * converts milliseconds to [hours,minutes,seconds,milliseconds] format
     * @param milliseconds
     * @return
     */
    @Deprecated
    public static int[] convertMilliInt(long milliseconds){
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60))) % 60;
        int hours   = (int) ((milliseconds / (1000*60*60)));
        int millisec = (int) milliseconds % 1000;
        return new int[]{hours,minutes,seconds,millisec};
    }

    /**
     * converts the milliseconds to
     * MoTime(year,month,days,hours,minutes,seconds)
     * and returns it
     * @param milliseconds
     * @return
     */
    public static MoTime convertMilliToYMDHM(long milliseconds){
        int seconds = (int) (milliseconds / MILLI_IN_SECOND) % 60 ;
        int minutes = (int) ((milliseconds / MILLI_IN_MINUTE)) % 60;
        int hours   = (int) ((milliseconds / MILLI_IN_HOUR)) % 24;
        int days = (int) ((milliseconds/MILLI_IN_DAY)) % 30;
        int month = (int) ((milliseconds/MILLI_IN_MONTH)) % 12;
        int year  = (int) ((milliseconds/MILLI_IN_YEAR));
        return new MoTime(milliseconds,year,month,days,hours,minutes,seconds);
    }


    /**
     * converts milliseconds to stop watch format minute:sec.millisecond
     * @param milliseconds
     * @return
     */
    public static String convertToStopWatchFormat(long milliseconds){
        String[] times = convertMilli(milliseconds);
        return String.format("%s:%s.%s",times[1],times[2],times[3].substring(0,2));
    }


    /**
     *
     * @param c
     * converts the hour and minutes of c to milliseconds
     */
    public static double convertToMilli(Calendar c){
        return c.get(Calendar.MINUTE) * MILLI_IN_MINUTE +
                c.get(Calendar.HOUR_OF_DAY) * MILLI_IN_HOUR;
    }


    /**
     * returns the absolute difference between c and c1
     * @param c
     * @param c1
     * @return
     */
    public static MoTime getDifference(Calendar c,Calendar c1){
        return convertMilliToYMDHM(getDifferenceInMillis(c, c1));
    }

    public static long getDifferenceInMillis(Calendar c, Calendar c1) {
        return Math.abs(c.getTimeInMillis() - c1.getTimeInMillis());
    }

    /**
     * returns the absolute difference between c and c1
     * @param c
     * @param c1
     * @return
     */
    public static MoTime getDifference(MoDate c,MoDate c1){
        return getDifference(c.getCalendar(),c1.getCalendar());
    }

    /**
     * returns the difference in milliseconds
     * for two instances of mo date
     * @param d first date
     * @param d1 second date
     * @return
     */
    public static long getDifferenceInMillis(MoDate d,MoDate d1){
        return getDifferenceInMillis(d.getCalendar() ,d1.getCalendar());
    }

    /**
     * v
     * @param limit in milliseconds
     * @param d first date
     * @param d1 second date
     * @return true if the difference between the
     *         two mo date objects is higher than the
     *         limit in long
     */
    public static boolean isDifferenceMoreThanLimit(long limit,MoDate d,MoDate d1){
        return getDifferenceInMillis(d,d1)>limit;
    }

}
