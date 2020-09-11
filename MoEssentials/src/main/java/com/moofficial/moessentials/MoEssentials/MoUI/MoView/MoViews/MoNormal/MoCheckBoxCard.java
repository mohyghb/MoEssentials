package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoCheckBoxCard extends MoConstraint {


    private MoCardView cardView;
    private TextView title,description;
    private CheckBox checkBox;
    private ImageView icon;

    public MoCheckBoxCard(Context context) {
        super(context);
    }

    public MoCheckBoxCard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoCheckBoxCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MoCheckBoxCard setTitle(@StringRes int res){
        title.setText(res);
        return this;
    }

    public MoCheckBoxCard setTitle(String s){
        title.setText(s);
        return this;
    }

    public MoCheckBoxCard setIcon(Drawable d) {
        icon.setImageDrawable(d);
        return this;
    }

    public MoCheckBoxCard setIcon(@DrawableRes int d) {
        icon.setImageDrawable(ContextCompat.getDrawable(getContext(),d));
        return this;
    }

    public MoCheckBoxCard setDescription(@StringRes int res){
        description.setText(res);
        return this;
    }

    public MoCheckBoxCard setDescription(String s){
        description.setText(s);
        return this;
    }


    public MoCheckBoxCard setChecked(boolean b){
        this.checkBox.setChecked(b);
        return this;
    }

    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    public MoCheckBoxCard setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener l){
        this.checkBox.setOnCheckedChangeListener(l);
        return this;
    }

    public MoCardView getCardView() {
        return cardView;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDescription() {
        return description;
    }



    @Override
    public int getLayoutId() {
        return R.layout.mo_check_box_card;
    }

    @Override
    public void initViews() {
        cardView = findViewById(R.id.mo_check_box_card_card_view);
        cardView.setOnClickListener(view -> setChecked(!isChecked()));
        title = findViewById(R.id.mo_check_box_card_title);
        description = findViewById(R.id.mo_check_box_card_description);
        checkBox = findViewById(R.id.mo_check_box_card_checkBox);

        icon = findViewById(R.id.mo_check_box_card_icon);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
