package com.moofficial.moessentials.MoEssentials.MoUI.MoDrawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.R;

import static android.graphics.drawable.GradientDrawable.*;

// easily create drawables
public class MoDrawableBuilder extends MoContext{



    @IntDef(value = {RECTANGLE, OVAL, LINE, RING})
    public @interface DrawableShape {}


    @DrawableShape private int shape = RECTANGLE;
    private float[] cornerRadii = new float[8];
    private float cornerRadius = 0;
    @ColorRes private int color = R.color.colorPrimary;
    @ColorInt private int[] colors;
    private Orientation orientation = Orientation.TOP_BOTTOM;
    private int strokeWidth = 0;
    @ColorRes private int strokeColor = R.color.transparent;

    public MoDrawableBuilder(Context c) {
        super(c);
    }

    public MoDrawableBuilder shape(@DrawableShape int shape) {
        this.shape = shape;
        return this;
    }

    public MoDrawableBuilder cornerRadii(float[] cornerRadii) {
        this.cornerRadii = cornerRadii;
        return this;
    }

    public MoDrawableBuilder cornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public MoDrawableBuilder roundRadius() {
        this.cornerRadius = getDimension(R.dimen.mo_style_card_corner);
        return this;
    }

    public MoDrawableBuilder recRadius() {
        this.cornerRadius = 0;
        return this;
    }

    public MoDrawableBuilder roundRecRadius() {
        this.cornerRadius = getDimension(R.dimen.mo_style_card_corner_small);
        return this;
    }

    public MoDrawableBuilder rectangle(){
        this.shape = RECTANGLE;
        return this;
    }

    public MoDrawableBuilder oval(){
        this.shape = OVAL;
        return this;
    }

    public MoDrawableBuilder ring(){
        this.shape = RING;
        return this;
    }

    public MoDrawableBuilder line(){
        this.shape = LINE;
        return this;
    }

    public MoDrawableBuilder primaryColor(){
        this.color = R.color.colorPrimary;
        return this;
    }

    public MoDrawableBuilder primaryDarkColor(){
        this.color = R.color.colorPrimaryDark;
        return this;
    }

    public MoDrawableBuilder accentColor(){
        this.color = R.color.colorAccent;
        return this;
    }

    public MoDrawableBuilder withColor(@ColorRes int color) {
        this.color = color;
        return this;
    }

    public MoDrawableBuilder withColorsValues(@ColorInt int ... colors) {
        this.colors = colors;
        return this;
    }

    public MoDrawableBuilder withColors(@NonNull @ColorRes int ... colors) {
        this.colors = new int[colors.length];
        for(int i = 0;i < colors.length;i++){
            this.colors[i] = getColor(colors[i]);
        }
        return this;
    }


    public MoDrawableBuilder topBottom() {
        this.orientation = Orientation.TOP_BOTTOM;
        return this;
    }

    public MoDrawableBuilder bottomTop() {
        this.orientation = Orientation.BOTTOM_TOP;
        return this;
    }

    public MoDrawableBuilder BL_TR() {
        this.orientation = Orientation.BL_TR;
        return this;
    }

    public MoDrawableBuilder TR_BL() {
        this.orientation = Orientation.TR_BL;
        return this;
    }
    public MoDrawableBuilder TL_BR() {
        this.orientation = Orientation.TL_BR;
        return this;
    }

    public MoDrawableBuilder BR_TL() {
        this.orientation = Orientation.BR_TL;
        return this;
    }

    public MoDrawableBuilder leftRight() {
        this.orientation = Orientation.LEFT_RIGHT;
        return this;
    }

    public MoDrawableBuilder rightLeft() {
        this.orientation = Orientation.RIGHT_LEFT;
        return this;
    }

    public MoDrawableBuilder strokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        return this;
    }

    public MoDrawableBuilder strokeColor(@ColorRes int strokeColor) {
        this.strokeColor = strokeColor;
        return this;
    }

    public Drawable build() {
        GradientDrawable d = buildDrawable();
        buildShape(d);
        buildRadius(d);
        buildColor(d);
        buildStroke(d);
        return d;
    }

    public void buildStroke(GradientDrawable d) {
        d.setStroke(strokeWidth,getColor(strokeColor));
    }

    private GradientDrawable buildDrawable(){
        if(this.colors == null) {
            return new GradientDrawable();
        } else {
            return new GradientDrawable(orientation,colors);
        }
    }

    private void buildShape(GradientDrawable d) {
        d.setShape(this.shape);
    }

    private void buildColor( GradientDrawable d) {
        if(this.colors == null) {
            d.setColor(getColor(this.color));
        }
    }

    private void buildRadius(GradientDrawable d) {
        if(this.cornerRadius == 0){
            // they haven't changed this so
            // use the other version
            d.setCornerRadii(this.cornerRadii);
        }else{
            d.setCornerRadius(this.cornerRadius);
        }
    }


}
