package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

public class MoInputBar extends MoConstraint {


    private TextView title;
    private EditText editText;
    private MoCardWrapper cardView;


    public MoInputBar(Context context) {
        super(context);
    }

    public MoInputBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoInputBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int EDId(){
        return editText.getId();
    }

    public int CVId(){
        return cardView.getId();
    }

    public int TVId(){
        return title.getId();
    }

    public MoInputBar setTitle(String s){
        title.setText(s);
        return this;
    }

    public MoInputBar setTitle(int s){
        title.setText(s);
        return this;
    }

    public MoInputBar hideTitle(){
        title.setVisibility(View.GONE);
        return this;
    }

    public MoInputBar setHint(String h){
        this.editText.setHint(h);
        return this;
    }

    public MoInputBar setHint(int h){
        this.editText.setHint(h);
        return this;
    }

    public MoInputBar setText(String h){
        this.editText.setText(h);
        return this;
    }

    public MoInputBar setText(int h){
        this.editText.setText(h);
        return this;
    }

    /**
     * returns the text of the edit text
     * @return
     */
    public String getInputText(){
        return editText.getText().toString();
    }


    public TextView getTitle() {
        return title;
    }

    public MoInputBar setTitle(TextView title) {
        this.title = title;
        return this;
    }

    public EditText getEditText() {
        return editText;
    }

    public MoInputBar setEditText(EditText editText) {
        this.editText = editText;
        return this;
    }

    public MoCardWrapper getCardView() {
        return cardView;
    }

    public MoInputBar setCardView(MoCardWrapper cardView) {
        this.cardView = cardView;
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_input_bar;
    }

    @Override
    public void initViews() {
        editText = findViewById(R.id.input_bar_edit_text);
        cardView = new MoCardWrapper(findViewById(R.id.input_bar_card_view));
        title = findViewById(R.id.input_bar_title);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
