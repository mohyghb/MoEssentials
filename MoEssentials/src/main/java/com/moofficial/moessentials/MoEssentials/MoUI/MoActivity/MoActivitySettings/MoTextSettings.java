package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoActivitySettings;

import android.widget.TextView;

import com.moofficial.moessentials.MoEssentials.MoString.MoString;

public class MoTextSettings {

    // how many chars can be inside the title
    // before it gets faded and cut off
    private int charLimit;
    private float baseSize;
    private float minSize;
    private float decSizePerUnit;
    private int unit;

    public MoTextSettings(int charLimit, float baseSize, float decSizePerUnit, int unit,int minSize) {
        this.charLimit = charLimit;
        this.baseSize = baseSize;
        this.decSizePerUnit = decSizePerUnit;
        this.unit = unit;
        this.minSize = minSize;
    }

    public int getCharLimit() {
        return charLimit;
    }

    public MoTextSettings setCharLimit(int charLimit) {
        this.charLimit = charLimit;
        return this;
    }

    public float getBaseSize() {
        return baseSize;
    }

    public MoTextSettings setBaseSize(float baseSize) {
        this.baseSize = baseSize;
        return this;
    }

    public float getDecSizePerUnit() {
        return decSizePerUnit;
    }

    public MoTextSettings setDecSizePerUnit(float decSizePerUnit) {
        this.decSizePerUnit = decSizePerUnit;
        return this;
    }

    public int getUnit() {
        return unit;
    }

    public MoTextSettings setUnit(int unit) {
        this.unit = unit;
        return this;
    }


    public void adjust(TextView tv){
        adjustCharLimit(tv);
        adjustFontSize(tv);
    }

    public void adjustFontSize(TextView tv) {
        MoString.adjustFontSize(tv,baseSize,minSize,decSizePerUnit,unit);
    }

    public void adjustCharLimit(TextView tv) {
        tv.setText(MoString.getLimitedCount(tv.getText().toString(),charLimit));
    }

}
