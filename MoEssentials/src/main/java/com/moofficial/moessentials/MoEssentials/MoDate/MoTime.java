package com.moofficial.moessentials.MoEssentials.MoDate;

import android.content.Context;

import com.moofficial.moessentials.MoEssentials.MoIO.MoFile;
import com.moofficial.moessentials.MoEssentials.MoIO.MoLoadable;
import com.moofficial.moessentials.MoEssentials.MoIO.MoSavable;

import java.util.HashMap;

;


public class MoTime implements MoSavable, MoLoadable {


    public static final String YEAR = "year";
    public static final String MONTH = "month";
    public static final String DAY = "day";
    public static final String HOUR = "hour";
    public static final String MINUTE = "minute";
    public static final String SECOND = "second";





    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private HashMap<String,Integer> values = new HashMap<>();

    public MoTime(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        setUpHashMap();
    }



    public MoTime(){}

    private void setUpHashMap(){
        values.put(YEAR,this.year);
        values.put(MONTH,this.month);
        values.put(DAY,this.day);
        values.put(HOUR,this.hour);
        values.put(MINUTE,this.minute);
        values.put(SECOND,this.second);
    }

    public int getYear() {
        return year;
    }

    public MoTime setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public MoTime setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public MoTime setDay(int day) {
        this.day = day;
        return this;
    }

    public int getHour() {
        return hour;
    }

    public MoTime setHour(int hour) {
        this.hour = hour;
        return this;
    }

    public int getMinute() {
        return minute;
    }

    public MoTime setMinute(int minute) {
        this.minute = minute;
        return this;
    }

    public int getSecond() {
        return second;
    }

    public MoTime setSecond(int second) {
        this.second = second;
        return this;
    }

    /**
     * returns true if this time either has
     * year or month or day
     * @return
     */
    public boolean hasYearMonthDay(){
        return this.year!=0 || this.month!=0 || this.day!=0;
    }

    /**
     * returns true if all the labels have valid values
     * @param labels
     * @return
     */
    public boolean hasValidValue(String ... labels){
        for(String l: labels){
            if(!hasValidValue(l)){
                return false;
            }
        }
        return true;
    }

    /**
     * returns true if the label
     * exist and the value of it is not zero
     * @param label
     * @return
     */
    @SuppressWarnings("ConstantConditions")
    public boolean hasValidValue(String label){
        return values.containsKey(label) && values.get(label) != 0;
    }

    /**
     * returns a the readable format of the fields
     * that are passed to this method
     * @param labels
     * @return
     */
    public String getReadable(String ... labels){
        StringBuilder sb = new StringBuilder();
        int lastIndex = labels.length-1;
        for(int i = 0;i < labels.length; i++){
            String label = labels[i];
            if(i == lastIndex){
                addIfNotZero(sb,label,true);
            }else{
                addIfNotZero(sb,label,false);
            }
        }
        return sb.toString();
    }




    private void addIfNotZero(StringBuilder sb,String label,boolean isLastOne){
        if(!values.containsKey(label)){
            return;
        }
        @SuppressWarnings("ConstantConditions")
        int value = values.get(label);
        if(value!=0){
            sb.append(value).append(" ");
            if(value == 1){
                // singular
                sb.append(label);
            }else{
                // plural
                sb.append(label).append("s");
            }
            // if this is not the last one then say 'and'
            if(!isLastOne){
                sb.append(" and ");
            }
        }
    }


    /**
     * loads a savable object into its class
     *
     * @param data
     * @param context
     */
    @Override
    public void load(String data, Context context) {
        String[] com = MoFile.loadable(data);
        this.year = Integer.parseInt(com[0]);
        this.month = Integer.parseInt(com[1]);
        this.day = Integer.parseInt(com[2]);
        this.hour = Integer.parseInt(com[3]);
        this.minute = Integer.parseInt(com[4]);
        this.second = Integer.parseInt(com[5]);
        setUpHashMap();
    }

    /**
     * @return the data that is going to be saved by the save method
     * inside the class which implements MoSavable
     */
    @Override
    public String getData() {
        return MoFile.getData(year,month,day,hour,minute,second);
    }
}
