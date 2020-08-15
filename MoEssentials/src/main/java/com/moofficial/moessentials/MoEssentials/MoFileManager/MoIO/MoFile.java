package com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO;

import android.animation.ObjectAnimator;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


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
            int totalActualSize = 0;
            for(Object o : params){
                try {
                    if(decideGetData(jsonObject, totalActualSize, o)) {
                        totalActualSize++;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if(totalActualSize == 0){
                return "";
            }
            addLengthToJson(jsonObject, totalActualSize);
            return jsonObject.toString();
        }
    }

    /**
     * decides what type of data needs to be added to this json object
     * @param jsonObject
     * @param i
     * @param o
     * @throws JSONException
     * @return true if it added something to the json file
     */
    private static boolean decideGetData(JSONObject jsonObject, int i, Object o) throws JSONException {
        if(o!=null){
            if(o instanceof Iterable){
                //noinspection rawtypes
                jsonObject.put(i+"",getData((Iterable) o));
            }else if(o instanceof MoSwitchSavable){
                // switch savable, check if it can be saved or not
                // before adding it
                MoSwitchSavable switchSavable = (MoSwitchSavable)o;
                if(switchSavable.isSavable()){
                    jsonObject.put(i+"",switchSavable.getData());
                }else{
                    return false;
                }
            }
            else if(o instanceof MoSavable){
                jsonObject.put(i+"",((MoSavable)o).getData());
            }else{
                jsonObject.put(i+"",o.toString());
            }
        }else{
            jsonObject.put(i+"",NULL);
        }
        return true;
    }

    /**
     *
     * @param jsonObject
     * @param length
     */
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

    /**
     *
     * @param list
     * @return
     */
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
        int totalActualSize = 0;
        for(Object o: set){
            try {
                if(decideGetData(jsonObject,totalActualSize,o)){
                    totalActualSize++;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if(totalActualSize==0){
            return "";
        }
        addLengthToJson(jsonObject,totalActualSize);
        return jsonObject.toString();
    }


    /**
     * A helper function designed to load
     * back classes who were stored as a list
     * @param context of the app
     * @param data the data that this list exists in
     *             (the direct data meaning that only the collection
     *             should exist inside it and nothing more)
     * @param collection collection to add all the items
     * @param listener required to make a new object and load it in
     *                 inside the developer side and add it to the collection
     * @param <T> the dynamic type extending MoLoadable
     */
    public static <T extends MoLoadable> void setData(Context context,String data,
                                                      Collection<T> collection,MoOnLoadingBackListener<T> listener){
        String[] com = loadable(data);
        for(String d:com){
            collection.add(listener.getObject(context,d));
        }
    }


    /**
     * returns a list of sub-data based on the data
     * that is given to us
     * @param data should be a JSON string
     * @return
     */
    public static String[] loadable(String data){
        if(data == null || data.isEmpty()){
            return new String[]{};
        }
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
