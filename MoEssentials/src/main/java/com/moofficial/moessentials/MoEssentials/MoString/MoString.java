package com.moofficial.moessentials.MoEssentials.MoString;

import android.widget.TextView;

public class MoString {

    /**
     * returns the similarity of string a to string b
     * for example if a = "abcd" and b = "abcde"
     * a is 80 percent or 0.8 similar to b
     * @param a
     * @param b
     */
    public static float getSimilarity(String a, String b){
        double biggerSize = Math.max(a.length(), b.length());
        double similarChars = 0;
        // if either is empty return 0 percent similarity
        if(a.isEmpty() || b.isEmpty()){
            return 0f;
        }else if(a.equals(b)) {
            // they are the same
            return 1f;
        }
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int min = Math.min(a.length(),b.length());
        for(int i = 0; i < min; i++){
            if(ac[i] == bc[i]){
                // this character in a is same as b
                similarChars++;
            }else{
                // we met the first char where a and b are not similar
                break;
            }
        }
        return (float)(similarChars/biggerSize);
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
        for(String text: texts){
            if(isValid(text)){
                return (text.charAt(0) + "").toUpperCase();
            }
        }
        return "";
    }

    /**
     * returns true if the text is not null and not empty
     * @param text
     * @return
     */
    public static boolean isValid(String text){
        return text!=null && !text.isEmpty();
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

}
