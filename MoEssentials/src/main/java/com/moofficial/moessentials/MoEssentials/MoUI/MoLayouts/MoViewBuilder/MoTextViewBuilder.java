package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

public class MoTextViewBuilder extends MoViewBuilder {

    private String hint = "",text = "";
    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

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

    @Override
    protected <T extends View> void buildItem(T v) {
        TextView t = (TextView) v;
        t.setHint(hint);
        t.setText(text);
        t.addTextChangedListener(watcher);
    }


}
