package com.moofficial.moessentials.MoEssentials.MoIO;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MoFile {

    private static final String NULL = "null";
    private static final String LENGTH = "length";




    /**
     *      GOD method
     *      accepts everything and dynamically produces the right output
     //     * makes it easier to use MoSavable
     //     * @param sepKey
     //     * @param params
     //     * @return
     //     */
    public static String getData(Object ... params){
        if(params==null || params.length == 0) {
            return "";
        } else{
            JSONObject jsonObject = new JSONObject();
            for(int i = 0; i < params.length; i++){
                Object o = params[i];
                try {
                    decideGetData(jsonObject, i, o);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            addLengthToJson(jsonObject, params.length);
            return jsonObject.toString();
        }
    }

    /**
     * decides what type of data needs to be added to this json object
     * @param jsonObject
     * @param i
     * @param o
     * @throws JSONException
     */
    private static void decideGetData(JSONObject jsonObject, int i, Object o) throws JSONException {
        if(o!=null){
            if(o instanceof Iterable){
                //noinspection rawtypes
                jsonObject.put(i+"",getData((Iterable) o));
            }else if(o instanceof MoSavable){
                jsonObject.put(i+"",((MoSavable)o).getData());
            }else{
                jsonObject.put(i+"",o.toString());
            }
        }else{
            jsonObject.put(i+"",NULL);
        }
    }

    private static void addLengthToJson(JSONObject jsonObject, int length) {
        // saving the length for later on
        // if the length of the json object is greater than zero
        try {
            if(jsonObject.length()>0) {
                jsonObject.put(LENGTH, length);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static String getData(MoSavable ... list){
        return getData(new ArrayList<>(Arrays.asList(list)));
    }


    /**
     * converts data of a set into json object and then into
     * an string
     * @param set
     * @return
     */
    private static String getData(Iterable<?> set){

        JSONObject jsonObject = new JSONObject();
        int i = 0;
        for(Object o: set){
            try {
                decideGetData(jsonObject,i,o);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            i++;
        }
        if(i==0){
            return "";
        }
        addLengthToJson(jsonObject,i);

        return jsonObject.toString();
    }




    /**
     * combination of iterable and objects
     * when trying to save a list and couple more objects
     * this makes it easier to get the correct data that we want
     * @param set
     * @param objects
     * @return
     */
    private static String getData(Iterable<?> set, Object ... objects){
        return getData(getData(set),getData(objects));
    }


    /**
     * returns a list of sub-data based on the data
     * that is given to us
     * @param data should be a JSON string
     * @return
     */
    public static String[] loadable(String data){
        try {
            JSONObject jsonObject = new JSONObject(data);
            // making a list of appropriate length of sub-data
            String[] subs = new String[jsonObject.getInt(LENGTH)];
            for(int i = 0; i < subs.length; i++){
                subs[i] = jsonObject.getString(i+"");
            }
            return subs;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new String[]{};
    }


    /**
     * returns true if this data can be
     * divided into smaller parts still
     * @param c data
     * @return
     */
    public static boolean isValidData(String[] c){
        return c!=null && c.length!=0;
    }




}
