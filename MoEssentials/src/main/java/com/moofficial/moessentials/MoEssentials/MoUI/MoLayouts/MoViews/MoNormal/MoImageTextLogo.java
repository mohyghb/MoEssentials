package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoDrawable.MoDrawableUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoImageTextLogo extends MoConstraint {

    private TextView tv;

    public MoImageTextLogo(Context context) {
        super(context);
    }

    public MoImageTextLogo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoImageTextLogo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText(String t){
        this.tv.setText(t);
    }

    public int TVId(){
        return tv.getId();
    }

    public MoImageTextLogo filledCircle() {
        tv.setBackground(MoDrawableUtils.filledCircle(getContext()));
        return this;
    }

    public MoImageTextLogo filledRec() {
        tv.setBackground(MoDrawableUtils.filledRec(getContext()));
        return this;
    }

    public MoImageTextLogo filledRoundRec() {
        tv.setBackground(MoDrawableUtils.filledRoundRec(getContext()));
        return this;
    }

    public MoImageTextLogo setLogoDrawable(Drawable d){
        tv.setBackground(d);
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_image_text_logo;
    }

    @Override
    public void initViews() {
        tv = findViewById(R.id.logo_text);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
