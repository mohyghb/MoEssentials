package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

public class MoAcceptDenyLayout extends MoConstraint {

    MoCardWrapper cardView;
    Button denyButton,acceptButton;

    public MoAcceptDenyLayout(Context context) {
        super(context);
    }

    public MoAcceptDenyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoAcceptDenyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MoCardWrapper getCardView() {
        return cardView;
    }

    public MoAcceptDenyLayout setCardView(MoCardWrapper cardView) {
        this.cardView = cardView;
        return this;
    }

    public Button getDenyButton() {
        return denyButton;
    }

    public MoAcceptDenyLayout setDenyButton(Button denyButton) {
        this.denyButton = denyButton;
        return this;
    }

    public Button getAcceptButton() {
        return acceptButton;
    }

    public MoAcceptDenyLayout setAcceptButton(Button acceptButton) {
        this.acceptButton = acceptButton;
        return this;
    }


    public MoAcceptDenyLayout setAcceptButtonText(String t){
        this.acceptButton.setText(t);
        return this;
    }

    public MoAcceptDenyLayout setAcceptButtonText(int t){
        this.acceptButton.setText(t);
        return this;
    }

    public MoAcceptDenyLayout setDenyButtonText(String t){
        this.denyButton.setText(t);
        return this;
    }

    public MoAcceptDenyLayout setDenyButtonText(int t){
        this.denyButton.setText(t);
        return this;
    }

    public MoAcceptDenyLayout setOnAcceptClickedListener(View.OnClickListener l){
        this.acceptButton.setOnClickListener(l);
        return this;
    }

    public MoAcceptDenyLayout setOnDenyClickedListener(View.OnClickListener l){
        this.denyButton.setOnClickListener(l);
        return this;
    }

    public MoAcceptDenyLayout setOnAcceptLongClickedListener(View.OnLongClickListener l){
        this.acceptButton.setOnLongClickListener(l);
        return this;
    }

    public MoAcceptDenyLayout setOnDenyLongClickedListener(View.OnLongClickListener l){
        this.denyButton.setOnLongClickListener(l);
        return this;
    }


    public MoAcceptDenyLayout hideDeny(){
        denyButton.setVisibility(View.GONE);
        return this;
    }

    public MoAcceptDenyLayout hideAccept(){
        acceptButton.setVisibility(View.GONE);
        return this;
    }

    public MoAcceptDenyLayout showDeny(){
        denyButton.setVisibility(View.VISIBLE);
        return this;
    }

    public MoAcceptDenyLayout showAccept(){
        acceptButton.setVisibility(View.VISIBLE);
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_accept_deny_button_layout;
    }

    @Override
    public void initViews() {
        cardView = new MoCardWrapper(findViewById(R.id.accept_deny_card_view));
        denyButton = findViewById(R.id.accept_deny_deny_button);
        acceptButton = findViewById(R.id.accept_deny_accept_button);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
