package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.core.graphics.drawable.DrawableCompat;

import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoButton extends MoConstraint {

    MoCardView cardView;
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

    /**
     * sets the icon color to inverse to it accounts
     * for both light and dark themes
     * @param r
     * @return this for nested calling
     */
    public MoButton setIcon(@DrawableRes int r){
        Drawable d = getDrawable(r);
        DrawableCompat.setTint(d, getColor(R.color.MoInverseColor));
        icon.setImageDrawable(d);
        return this;
    }

    public MoCardView getCardView() {
        return cardView;
    }

    public MoButton setCardView(MoCardView cardView) {
        this.cardView = cardView;
        return this;
    }

    public TextView getTitle() {
        return title;
    }

    public MoButton setTitle(TextView title) {
        this.title = title;
        return this;
    }

    public TextView getDescription() {
        return description;
    }

    public MoButton setDescription(TextView description) {
        this.description = description;
        return this;
    }

    public ImageView getIcon() {
        return icon;
    }

    public MoButton setIcon(ImageView icon) {
        this.icon = icon;
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
