package com.moofficial.moessentials.MoEssentials.MoString;

import android.widget.TextView;

import java.text.Normalizer;

public class MoString {


    public static final String EMPTY_SIGNATURE = "M";

    /**
     * how similar string b is to a
     * if they are completly different
     * we return 0
     * @param a string (bigger one)
     * @param b string (smaller one)
     * @return percentage of similarity of b to a
     */
    public static float getSimilarity(String a,String b){
        if(a.contains(b)) {
            // then b is inside a
            return ((float)b.length()/(float)a.length());
        }else{
            // a does not have any b in it
            return 0f;
        }
    }

    /**
     * how similar string b is to a
     * if they are completely different
     * we return 0
     * @param a string (bigger one)
     * @param b string (smaller one)
     * @param sameStandards whether or not we provide the
     *                      same standards for both strings like making
     *                      both of them lower case so that similarity is not
     *                      case sensitive
     * @return percentage of similarity of b to a
     */
    public static float getSimilarity(String a,String b,boolean sameStandards){
        if(sameStandards) {
            // not case sensitive
            return getSimilarity(a.toLowerCase(),b.toLowerCase());
        }else {
            return getSimilarity(a,b);
        }
    }



    /**
     * returns a [text] that is [count] long
     * and ends with [endWith]
     * @param text that want to be limited
     * @param endWith that want to end with
     * @param count number of characters included
     * @return
     */
    public static String getLimitedCount(String text,String endWith,int count){
        if(text.length() <= count){
            return text;
        }
        return text.substring(0,count) + endWith;
    }

    /**
     * normal version of a limited text ends with ...
     * to let the user know that there is more text than this
     * @param text
     * @param count
     * @return
     */
    public static String getLimitedCount(String text,int count){
        return getLimitedCount(text,"…",count);
    }

    /**
     * returns the first letter of the text
     * it is to upper case
     * and we return the first string which is applicable
     * @param texts
     * @return
     */
    public static String getSignature(String ... texts){
        for(String text: texts) {
            if(isValid(text)) {
                return (getCleanText(text).charAt(0)+"").toUpperCase();
            }
        }
        return EMPTY_SIGNATURE;
    }


    private static String getCleanText(String s) {
        String result;
        try {
            s = s.trim();
            String noHP = s;
            noHP = noHP.replaceAll("[\\s\\-\\.\\^:,]","");
            noHP = noHP.replaceAll("[^A-Za-z0-9]","");
            char isinya = noHP.charAt(0);

            if(isinya == '0')
                result = "62"+noHP.substring(1);
            else if(isinya == '+' )
                result = noHP.substring(1);
            else
                result = noHP;
        }
        catch (Exception e){
            return EMPTY_SIGNATURE;
        }
        return result == null || result.isEmpty() ? EMPTY_SIGNATURE : result;
    }

    /**
     * returns true if the text is not null and not empty
     * @param text
     * @return
     */
    public static boolean isValid(String text){
        return text!=null && !text.trim().isEmpty();
    }


    /**
     * intelligently adjusts the font
     * size of the text view based on the amount of
     * chars that the newText has, and based on the current
     * font size value of the tv
     * @param tv adjust the font of this text view
     * @param base base font size of the tv
     * @param decPerCharUnit how many sizes should we decrease each time the text exceeds charUnit
     * @param charUnit the threshold that activates the decPerCharUnit
     */
    public static void adjustFontSize(TextView tv,float base,float minSize,float decPerCharUnit,int charUnit){
        tv.setTextSize(getFontSize(tv, base,minSize, decPerCharUnit, charUnit));
    }

    /**
     * returns the font size based on the base
     * decPerCharUnit and charUnits
     * @param tv
     * @param base
     * @param decPerCharUnit
     * @param charUnit
     * @return
     */
    public static float getFontSize(TextView tv, float base, float minSize,float decPerCharUnit, int charUnit) {
        return Math.max(base - ((float)tv.getText().toString().length()/charUnit * decPerCharUnit),minSize);
    }

    /**
     *
     * @param text to repeat
     * @param n times to repeat the given text
     * @return an string that is equal to the textToRepeat * n
     */
    public static String repeat(String text, int n) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n; i++) {
            b.append(text);
        }
        return b.toString();
    }

    /**
     * finds the smaller of the two and
     * checks to see if the smaller string is
     * inside the bigger string
     * @param a an string
     * @param b an string
     * @return true or false depending on the case above
     */
    public static boolean containsSmaller(String a, String b) {
        if(a == null ||  b == null) {
            return false;
        }
        if(a.length() < b.length()) {
            return b.contains(a);
        }
        return a.contains(b);
    }

}
