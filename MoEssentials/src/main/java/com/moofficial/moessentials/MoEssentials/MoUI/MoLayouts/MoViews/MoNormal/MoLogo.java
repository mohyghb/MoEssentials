package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoDrawable.MoDrawableUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

// a class that can show a single letter inside a text view
// with background drawable or an image view that can show any image
// with a universal set dimensions that can be changed
public class MoLogo extends MoConstraint {

    private TextView tv;
    private ImageView imageView;

    public MoLogo(Context context) {
        super(context);
    }

    public MoLogo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoLogo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText(String t){
        this.tv.setText(t);
    }

    public int TVId(){
        return tv.getId();
    }

    public MoLogo filledCircle() {
        tv.setBackground(MoDrawableUtils.filledCircle(getContext()));
        return this;
    }

    public MoLogo filledRec() {
        tv.setBackground(MoDrawableUtils.filledRec(getContext()));
        return this;
    }

    public MoLogo filledRoundRec() {
        tv.setBackground(MoDrawableUtils.filledRoundRec(getContext()));
        return this;
    }

    public MoLogo setLogoDrawable(Drawable d){
        tv.setBackground(d);
        return this;
    }

    public MoLogo setLogoImage(Bitmap b){
        this.imageView.setImageBitmap(b);
        return this;
    }

    public MoLogo setLogoImage(Drawable b){
        this.imageView.setImageDrawable(b);
        return this;
    }

    public MoLogo showImage(){
        this.imageView.setVisibility(View.VISIBLE);
        return this;
    }

    public MoLogo hideText(){
        this.tv.setVisibility(View.GONE);
        return this;
    }

    public MoLogo showImageHideText(){
        showImage();
        return hideText();
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_logo;
    }

    @Override
    public void initViews() {
        tv = findViewById(R.id.mo_logo_text);
        imageView = findViewById(R.id.mo_logo_image);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
