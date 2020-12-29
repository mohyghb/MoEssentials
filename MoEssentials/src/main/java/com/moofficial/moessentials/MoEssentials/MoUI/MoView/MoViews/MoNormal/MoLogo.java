package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.moofficial.moessentials.MoEssentials.MoColor.MoColor;
import com.moofficial.moessentials.MoEssentials.MoLog.MoLog;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDrawable.MoDrawableBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDrawable.MoDrawableUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoViewManager.MoViewManager;
import com.moofficial.moessentials.R;

// a class that can show a single letter inside a text view
// with background drawable or an image view that can show any image
// with a universal set dimensions that can be changed
public class MoLogo extends MoConstraint {


    private TextView innerTextView;
    private ImageView outer;
    private ImageView innerLogo;
    private Drawable savedOuter;
    private Drawable savedInner;
    private MoViewManager manager = new MoViewManager();
    private boolean selected = false;

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


    public MoLogo setText(String t) {
        this.innerTextView.setText(t);
        DrawableCompat.setTint(this.outer.getDrawable(), MoColor.colorInt(getContext(), t));
        return this;
    }

    public MoLogo setTextColor(@ColorRes int color) {
        this.innerTextView.setTextColor(ContextCompat.getColor(getContext(),color));
        return this;
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

    public MoLogo setOuter(Drawable d) {
        this.outer.setImageDrawable(d);
        this.savedOuter = d;
        return this;
    }

//    public MoLogo setInner(Bitmap b){
//        this.innerLogo.setImageBitmap(b);
//        return this;
//    }

    public MoLogo setInner(Drawable b) {
        this.innerLogo.setImageDrawable(b);
        this.savedInner = b;
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

    public MoLogo select() {
        return select(
                this.outer.getDrawable(),
                ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_check_24));
    }



    public MoLogo select(Drawable selectedDrawable, Drawable innerDrawable) {
        if (selected) {
            return this;
        }
        this.savedOuter = this.outer.getDrawable();
        this.savedInner = this.innerLogo.getDrawable();
        this.outer.setImageDrawable(selectedDrawable);
        this.innerLogo.setImageDrawable(innerDrawable);
        this.manager = new MoViewManager().saveVisibility(this.outer,this.innerLogo,this.innerTextView);
        showLogoHideText();
        this.selected = true;
        return this;
    }


    public MoLogo unSelect() {
        if (!selected) {
            return this;
        }
        setOuter(savedOuter);
        setInner(savedInner);
        this.manager.deployVisibility(this.outer, this.innerLogo, this.innerTextView);
        this.selected = false;
        return this;
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
