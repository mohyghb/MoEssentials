package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

public class MoTextViewBuilder extends MoViewBuilder {

    private String hint,text;
    private TextWatcher watcher;
    @DrawableRes
    private int leftIcon = 0, rightIcon = 0, bottomIcon = 0, topIcon = 0;
    private Drawable left,top,right,bottom;

    public MoTextViewBuilder(Context c) {
        super(c);
    }



    public String getHint() {
        return hint;
    }

    public MoTextViewBuilder setHint(String hint) {
        this.hint = hint;
        return this;
    }

    public String getText() {
        return text;
    }

    public MoTextViewBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public TextWatcher getWatcher() {
        return watcher;
    }

    public MoTextViewBuilder setWatcher(TextWatcher watcher) {
        this.watcher = watcher;
        return this;
    }

    public MoTextViewBuilder setLeftIcon(@DrawableRes int leftIcon) {
        this.leftIcon = leftIcon;
        return this;
    }

    public MoTextViewBuilder setRightIcon(@DrawableRes int rightIcon) {
        this.rightIcon = rightIcon;
        return this;
    }

    public MoTextViewBuilder setBottomIcon(@DrawableRes int bottomIcon) {
        this.bottomIcon = bottomIcon;
        return this;
    }

    public MoTextViewBuilder setTopIcon(@DrawableRes int topIcon) {
        this.topIcon = topIcon;
        return this;
    }

    public MoTextViewBuilder setLeftIcon(Drawable left) {
        this.left = left;
        return this;
    }

    public MoTextViewBuilder setTopIcon(Drawable top) {
        this.top = top;
        return this;
    }

    public MoTextViewBuilder setRightIcon(Drawable right) {
        this.right = right;
        return this;
    }

    public MoTextViewBuilder setBottomIcon(Drawable bottom) {
        this.bottom = bottom;
        return this;
    }

    @Override
    public MoTextViewBuilder setClickListener(View.OnClickListener clickListener) {
        super.setClickListener(clickListener);
        return this;
    }


    @Override
    public MoTextViewBuilder setLongClickListener(View.OnLongClickListener longClickListener) {
        super.setLongClickListener(longClickListener);
        return this;
    }

    @Override
    public MoTextViewBuilder setContentPadding(MoPaddingBuilder contentPadding) {
        this.contentPadding = contentPadding;
        return this;
    }

    @Override
    public MoTextViewBuilder setVisibility(int visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    public MoTextViewBuilder setMinHeight(int minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    @Override
    public MoViewBuilder setMinWidth(int minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    private boolean hasDrawableIcon() {
        return left!=null || top!=null || right!=null || bottom!=null;
    }

    private boolean hasIntIcon() {
        return leftIcon!=0 || topIcon!=0 || rightIcon!=0 || bottomIcon!=0;
    }

    @Override
    protected <T extends View> void buildItem(T v) {
        TextView t = (TextView) v;
        setIfNotNull(hint,()->t.setHint(hint));
        setIfNotNull(text,()->t.setText(text));
        setIfNotNull(watcher,()->t.addTextChangedListener(watcher));
        if(hasDrawableIcon()) {
            t.post(()-> t.setCompoundDrawablesWithIntrinsicBounds(left,top,right,bottom));

        }else if(hasIntIcon()) {
            t.post(()->t.setCompoundDrawablesWithIntrinsicBounds(leftIcon,topIcon,rightIcon,bottomIcon));
        }
    }


}
