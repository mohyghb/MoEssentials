package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoImageButtonBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

public class MoToolBar extends MoConstraint {

    private MoCardWrapper cardView;
    private TextView title;
    private ImageButton leftButton, middleButton, rightButton;

    public MoToolBar(Context context) {
        super(context);
    }

    public MoToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // text view id
    public int TVId(){
        return title.getId();
    }

    // left button id
    public int LId(){
        return leftButton.getId();
    }

    // right button id
    public int RId(){
        return rightButton.getId();
    }

    // middle button id
    public int MId(){
        return middleButton.getId();
    }

    public int CId(){
        return cardView.getId();
    }


    public MoToolBar hideRight(){
        rightButton.setVisibility(View.GONE);
        return this;
    }

    public MoToolBar hideTitle(){
        title.setVisibility(View.GONE);
        return this;
    }

    public MoToolBar hideMiddle(){
        middleButton.setVisibility(View.GONE);
        return this;
    }

    public MoToolBar hideLeft(){
        leftButton.setVisibility(View.GONE);
        return this;
    }

    public MoToolBar onlyTitleAndLeftButtonVisible(){
        hideMiddle();
        hideRight();
        return this;
    }

    public MoCardWrapper getCardView() {
        return cardView;
    }

    public MoToolBar setCardView(MoCardWrapper cardView) {
        this.cardView = cardView;
        return this;
    }

    public TextView getTitle() {
        return title;
    }

    public MoToolBar setTitle(TextView title) {
        this.title = title;
        return this;
    }



    public MoToolBar setLeftButton(ImageButton leftButton) {
        this.leftButton = leftButton;
        return this;
    }

    public ImageButton getMiddleButton() {
        return middleButton;
    }

    public MoToolBar setMiddleButton(ImageButton middleButton) {
        this.middleButton = middleButton;
        return this;
    }



    public MoToolBar setRightButton(ImageButton rightButton) {
        this.rightButton = rightButton;
        return this;
    }

    public ImageButton getLeftButton() {
        return leftButton;
    }

    public ImageButton getRightButton() {
        return rightButton;
    }



    public MoToolBar setLeftOnClickListener(View.OnClickListener l){
        leftButton.setOnClickListener(l);
        return this;
    }

    public MoToolBar setMiddleOnClickListener(View.OnClickListener l){
        middleButton.setOnClickListener(l);
        return this;
    }

    public MoToolBar setRightOnClickListener(View.OnClickListener l){
        rightButton.setOnClickListener(l);
        return this;
    }


    public MoToolBar setLeftIcon(int res){
        new MoImageButtonBuilder(getContext()).setIcon(res).build(this.leftButton);
        return this;
    }

    public MoToolBar setMiddleIcon(int res){
        new MoImageButtonBuilder(getContext()).setIcon(res).build(this.middleButton);
        return this;
    }

    public MoToolBar setRightIcon(int res){
        new MoImageButtonBuilder(getContext()).setIcon(res).build(this.rightButton);
        return this;
    }


    @Override
    public int getLayoutId() {
        return R.layout.mo_tool_bar;
    }

    @Override
    public void initViews() {
        title = findViewById(R.id.menu_app_bar_title);
        leftButton = findViewById(R.id.menu_app_bar_back_button);
        middleButton = findViewById(R.id.menu_app_bar_search_button);
        rightButton = findViewById(R.id.menu_app_bar_more_button);
        cardView = new MoCardWrapper(findViewById(R.id.menu_app_bar_card_view));
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
