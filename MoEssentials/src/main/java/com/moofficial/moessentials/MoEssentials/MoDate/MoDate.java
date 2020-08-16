package com.moofficial.moessentials.MoEssentials.MoDate;

import android.annotation.SuppressLint;
import android.content.Context;

import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoFile;
import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoLoadable;
import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoSavable;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

// a class which gives us more utils than the original Calendar
public class MoDate implements MoSavable, MoLoadable {


    private Calendar calendar;

    public MoDate(){
        this.calendar = Calendar.getInstance();
    }

    public MoDate(Calendar c){
        this.calendar = c;
    }

    public MoDate(String data,Context c){
        this();
        this.load(data,c);
    }


    public Calendar getCalendar() {
        return calendar;
    }

    /**
     * returns the date of this class as a key
     * to be used inside hash maps or sets
     * @param separator separating text between the year month and date
     *                  for example 2020,02,02 the separator is ',' in this
     *                  case
     * @return a key generated from the Calendar of this class
     *  ** NOTE: this key does not consider the HOUR or MINUTE of this
     *  calendar, so you might have problems if you want those to be considered
     *  in as well. Use generateKey method for that purpose**
     */
    public String getDateAsKey(String separator){
        return generateKey(separator,Calendar.YEAR,Calendar.MONTH,Calendar.DATE);
    }

    /**
     * generates a key for hash map purposes
     * based on the fields that are passed in
     * for example passing Calendar.YEAR,Calendar.MONTH,Calendar.HOUR with
     * separator ',' returns 2020,02,16 if the year is 2020, month is march
     * and hour is 16 (4 p.m.)
     * @param separator separator of this key
     * @param fields fields to be used in creating the key
     * @return a key based on the fields passed in
     */
    public String generateKey(String separator,int ... fields){
        StringBuilder sb = new StringBuilder();
        int len = fields.length;
        for(int i = 0; i < len; i++){
            int field = fields[i];
            sb.append(calendar.get(field));
            if(i != len-1){
                // if we are not on the last
                // field, then we want to add in the
                // separator
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    /**
     * @return calendar time in milliseconds
     * passed after 1970
     */
    public long getTimeInMillis(){
        return this.calendar.getTimeInMillis();
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @SuppressLint("DefaultLocale")
    public static String getReadableDate(Calendar calendar){
        return String.format("%d/%d/%d",calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH));
    }

    @SuppressLint("DefaultLocale")
    public String getReadableDate(){
        return String.format("%d/%d/%d",calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH));
    }


    @SuppressLint("DefaultLocale")
    public String getReadableTime(){
        int minute = this.calendar.get(Calendar.MINUTE);
        int hour  = this.calendar.get(Calendar.HOUR_OF_DAY);
        StringBuilder time = new StringBuilder();
        if(hour < 10){
            time.append(String.format("0%d:",hour));
        }else{
            time.append(String.format("%d:",hour));
        }
        if(minute < 10){
            time.append(String.format("0%d",minute));
        }else{
            time.append(String.format("%d",minute));
        }

        return time.toString();
    }


    /**
     * returns readable time of the calendar
     * @param calendar
     * @return
     */
    public static String getReadableTime(Calendar calendar){
        return new MoDate(calendar).getReadableTime();
    }


    /**
     * returns date + time
     * for example 19/07/2020 at 09:53 am
     * @param c
     * @return
     */
    public static String getReadable(Calendar c){
        return getReadableDate(c) + " at " + getReadableTime(c);
    }

    /**
     * @return [hourOfDay,minute]
     */
    public int[] getHourMinute(){
        return new int[]{calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE)};
    }


    /**
     * sets the value into the field
     * @param field
     * @param value
     */
    public void set(int field, int value){
        this.calendar.set(field,value);
    }

    /**
     * adds the value to the field
     * @param field
     * @param value
     */
    public void add(int field, int value){
        this.calendar.add(field,value);
    }

    /**
     * returns true if one of the criteria
     * of d and this are different
     * @param d
     * @param criteria
     */
    public boolean isDifferent(MoDate d,int ... criteria){
        for(int i: criteria){
            if(d.calendar.get(i) != this.calendar.get(i)){
                return true;
            }
        }
        return false;
    }


    /**
     * sets the time zone of this class
     * @param timeZone
     */
    public void setTimeZone(TimeZone timeZone){
        long time = calendar.getTimeInMillis();
        calendar = new GregorianCalendar(timeZone);
        calendar.setTimeInMillis(time);
    }

    /**
     * loads a savable object into its class
     *
     * @param data
     * @param context
     */
    @Override
    public void load(String data, Context context) {
        String[] comps = MoFile.loadable(data);
        this.calendar.set(Calendar.YEAR,Integer.parseInt(comps[0]));
        this.calendar.set(Calendar.MONTH,Integer.parseInt(comps[1]));
        this.calendar.set(Calendar.DATE,Integer.parseInt(comps[2]));
        this.calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(comps[3]));
        this.calendar.set(Calendar.MINUTE,Integer.parseInt(comps[4]));
    }

    /**
     * @return the data that is going to be saved by the save method
     * inside the class which implements MoSavable
     */
    @Override
    public String getData() {
        return MoFile.getData(this.calendar.get(Calendar.YEAR),
                this.calendar.get(Calendar.MONTH),
                this.calendar.get(Calendar.DAY_OF_MONTH),
                this.calendar.get(Calendar.HOUR_OF_DAY),
                this.calendar.get(Calendar.MINUTE));
    }







    /**
     * return the readable difference between this calendar
     * and the one that is passed as parameter (only for hour and minutes)
     * if the year, month, or day are specified, then we use the readable
     * of calendar
     * @param c
     * @return
     */
    public String getReadableDifferenceHourMinute(Calendar c){
        MoTime diff = MoTimeUtils.getDifference(this.calendar,c);
        return diff.hasValidValue(MoTime.YEAR,MoTime.MONTH,MoTime.DAY)?
                getReadable(this.calendar):diff.getReadable(MoTime.HOUR,MoTime.MINUTE);
    }


    /**
     * returns true if time of c is before c1
     * @param c
     * @param c1
     * @return
     */
    public static boolean isTimeBefore(Calendar c, Calendar c1){
        int chour = c.get(Calendar.HOUR_OF_DAY);
        int c1hour = c1.get(Calendar.HOUR_OF_DAY);
        if( chour < c1hour){
            return true;
        } else if(chour > c1hour){
            return false;
        } else {
            // hours are the same check minutes
            return c.get(Calendar.MINUTE) <= c1.get(Calendar.MINUTE);
        }

    }


    /**
     * returns the next occurring calendar
     * that is within the days list and after the timeCal
     * @param days
     * @param timeCal
     * @return
     */
    public static Calendar getNextOccurring(List<Integer> days, Calendar timeCal){
        Calendar calendar = Calendar.getInstance();
        if(isTimeBefore(timeCal, calendar) &&
                calendar.get(Calendar.DAY_OF_WEEK) == timeCal.get(Calendar.DAY_OF_WEEK)){
            /**
             * a scenario in which
             * you are on  monday
             * the alarm is for 10:30
             * currently in real life the time is 15:00
             * if you activate it, it should not be for monday, it should be for the next occuring day
             * so we increase the date by one to get what we want
             */
            calendar.add(Calendar.DATE,1);
        }
        while (!days.contains(calendar.get(Calendar.DAY_OF_WEEK))) {
            // until the next day or today does not contain
            // one of the repeating days
            // add one day to it
            calendar.add(Calendar.DATE, 1);
        }
        // then we have the current date
        // we just need to set the current time
        calendar.set(Calendar.HOUR_OF_DAY,timeCal.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,timeCal.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,0);
        if(calendar.before(Calendar.getInstance())){
            // is before do this again
            return getNextOccurring(days,calendar);
        }
        return calendar;
    }


    /**
     * we check year, month, day,hour of day, and minutes
     * to see if two objects are equal or not
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoDate moDate = (MoDate) o;
        return this.calendar.get(Calendar.YEAR) == moDate.calendar.get(Calendar.YEAR)
                && this.calendar.get(Calendar.MONTH) == moDate.calendar.get(Calendar.MONTH)
                && this.calendar.get(Calendar.DATE) == moDate.calendar.get(Calendar.DATE)
                && this.calendar.get(Calendar.HOUR_OF_DAY) == moDate.calendar.get(Calendar.HOUR_OF_DAY)
                && this.calendar.get(Calendar.MINUTE) == moDate.calendar.get(Calendar.MINUTE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.calendar.get(Calendar.YEAR),
                this.calendar.get(Calendar.MONTH),
                this.calendar.get(Calendar.DATE),
                this.calendar.get(Calendar.HOUR_OF_DAY),
                this.calendar.get(Calendar.MINUTE)
        );
    }


















}
