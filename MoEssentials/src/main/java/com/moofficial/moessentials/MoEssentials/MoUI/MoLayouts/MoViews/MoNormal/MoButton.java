package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoButton extends MoConstraint {

    CardView cardView;
    TextView title,description;
    ImageView icon;

    public MoButton(Context context) {
        super(context);
    }

    public MoButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MoButton setOnButtonClickListener(View.OnClickListener l){
        cardView.setOnClickListener(l);
        return this;
    }

    public MoButton setOnButtonLongClickListener(View.OnLongClickListener l){
        cardView.setOnLongClickListener(l);
        return this;
    }

    public MoButton setTitle(String t){
        this.title.setText(t);
        return this;
    }

    public MoButton setDescription(String t){
        this.description.setText(t);
        return this;
    }

    public int TID(){
        return title.getId();
    }

    public int CVId(){
        return cardView.getId();
    }

    public int DId(){
        return description.getId();
    }

    public MoButton hideDescription(){
        description.setVisibility(View.GONE);
        return this;
    }

    public MoButton hideIcon(){
        icon.setVisibility(View.GONE);
        return this;
    }


    public MoButton hideTitle(){
        title.setVisibility(View.GONE);
        return this;
    }

    public MoButton setIcon(int r){
        icon.setImageResource(r);
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_button;
    }

    @Override
    public void initViews() {
        cardView = findViewById(R.id.mo_button_card_view);
        title = findViewById(R.id.mo_button_title);
        description = findViewById(R.id.mo_button_description);
        icon = findViewById(R.id.mo_button_icon);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
