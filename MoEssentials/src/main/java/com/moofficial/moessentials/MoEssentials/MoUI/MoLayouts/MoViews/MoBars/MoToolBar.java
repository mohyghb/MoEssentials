package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.widget.TintableCompoundButton;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoImageButtonBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoCardView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

public class MoToolBar extends MoConstraint {

    private MoCardView cardView;
    private TextView title;
    private ImageButton leftButton, middleButton, rightButton,extraButton;
    private CheckBox checkBox;

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

    public int EXId(){
        return extraButton.getId();
    }

    public int CBOXId(){
        return this.checkBox.getId();
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

    public MoToolBar hideCheckBox(){
        checkBox.setVisibility(View.GONE);
        return this;
    }

    public MoToolBar hideExtraButton(){
        extraButton.setVisibility(View.GONE);
        return this;
    }


    public MoToolBar showRight(){
        rightButton.setVisibility(View.VISIBLE);
        return this;
    }

    public MoToolBar showTitle(){
        title.setVisibility(View.VISIBLE);
        return this;
    }

    public MoToolBar showMiddle(){
        middleButton.setVisibility(View.VISIBLE);
        return this;
    }

    public MoToolBar showLeft(){
        leftButton.setVisibility(View.VISIBLE);
        return this;
    }

    public MoToolBar showCheckBox(){
        checkBox.setVisibility(View.VISIBLE);
        return this;
    }

    public MoToolBar showExtraButton(){
        extraButton.setVisibility(View.VISIBLE);
        return this;
    }


    public MoToolBar onlyTitleAndLeftButtonVisible(){
        hideMiddle();
        hideRight();
        hideCheckBox();
        hideExtraButton();
        return this;
    }

    public MoCardView getCardView() {
        return cardView;
    }

    public MoToolBar setCardView(MoCardView cardView) {
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

    public ImageButton getExtraButton() {
        return extraButton;
    }

    public MoToolBar setExtraButton(ImageButton extraButton) {
        this.extraButton = extraButton;
        return this;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public MoToolBar setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
        return this;
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

    public MoToolBar setExtraOnClickListener(View.OnClickListener l){
        extraButton.setOnClickListener(l);
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

    public MoToolBar setExtraIcon(int res){
        new MoImageButtonBuilder(getContext()).setIcon(res).build(this.extraButton);
        return this;
    }



    public MoToolBar setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener l){
        this.checkBox.setOnCheckedChangeListener(l);
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
        cardView = findViewById(R.id.menu_app_bar_card_view);
        extraButton = findViewById(R.id.menu_app_bar_extra_button);
        checkBox = findViewById(R.id.menu_app_bar_checkBox);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
