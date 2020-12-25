package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

import com.moofficial.moessentials.MoEssentials.MoUI.MoDrawable.MoDrawableUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

// a class that can show a single letter inside a text view
// with background drawable or an image view that can show any image
// with a universal set dimensions that can be changed
public class MoLogo extends MoConstraint {

    private TextView innerTextView;
    private ImageView outer;
    private ImageView innerLogo;

    public MoLogo(Context context) {
        super(context);
    }

    public MoLogo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoLogo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TextView getTextView() {
        return this.innerTextView;
    }

//    public MoLogo boldText() {
//        innerTextView.setTypeface(Typeface.DEFAULT_BOLD);
//        return this;
//    }
//
//    public MoLogo normalText() {
//        innerTextView.setTypeface(Typeface.DEFAULT);
//        return this;
//    }

    public MoLogo setText(String t){
        this.innerTextView.setText(t);
        return this;
    }

    public MoLogo setTextColor(@ColorRes int color) {
        this.innerTextView.setTextColor(ContextCompat.getColor(getContext(),color));
        return this;
    }

    public int TVId(){
        return innerTextView.getId();
    }

    public MoLogo filledCircle() {
        innerTextView.setBackground(MoDrawableUtils.filledCircle(getContext()));
        return this;
    }

    public MoLogo filledRec() {
        innerTextView.setBackground(MoDrawableUtils.filledRec(getContext()));
        return this;
    }

    public MoLogo filledRoundRec() {
        innerTextView.setBackground(MoDrawableUtils.filledRoundRec(getContext()));
        return this;
    }

    public MoLogo setOuter(Drawable d){
        this.outer.setImageDrawable(d);
        return this;
    }

    public MoLogo setInner(Bitmap b){
        this.innerLogo.setImageBitmap(b);
        return this;
    }

    public MoLogo setInner(Drawable b){
        this.innerLogo.setImageDrawable(b);
        return this;
    }


    public MoLogo showLogo() {
        this.innerLogo.setVisibility(View.VISIBLE);
        return this;
    }

    public MoLogo hideLogo() {
        this.innerLogo.setVisibility(View.GONE);
        return this;
    }

    public MoLogo showText() {
        this.innerTextView.setVisibility(View.VISIBLE);
        return this;
    }

    public MoLogo hideText() {
        this.innerTextView.setVisibility(View.GONE);
        return this;
    }

    public MoLogo showLogoHideText(){
        showLogo();
        return hideText();
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_logo;
    }

    @Override
    public void initViews() {
        innerTextView = findViewById(R.id.mo_logo_text);
        outer = findViewById(R.id.mo_logo_outer_drawable);
        innerLogo = findViewById(R.id.mo_logo_image);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
