package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

public class MoLoadingCard extends MoConstraint {

    MoCardView cardView;
    TextView title,description;
    ProgressBar progressBar;

    public MoLoadingCard(Context context) {
        super(context);
    }

    public MoLoadingCard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoLoadingCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MoLoadingCard showIndeterminate(){
        progressBar.setIndeterminate(true);
        return this;
    }

    public MoLoadingCard setTitle(String t){
        this.title.setText(t);
        return this;
    }

    public MoLoadingCard setTitle(int t){
        this.title.setText(t);
        return this;
    }

    public MoLoadingCard setDescription(String t){
        this.description.setText(t);
        return this;
    }

    public MoLoadingCard setDescription(int t){
        this.description.setText(t);
        return this;
    }

    public int TId(){
        return this.title.getId();
    }

    public int CVId(){
        return this.cardView.getId();
    }

    public int DId(){
        return this.description.getId();
    }

    public int PId(){
        return progressBar.getId();
    }

    public MoCardView getCardView() {
        return cardView;
    }

    public MoLoadingCard setCardView(MoCardView cardView) {
        this.cardView = cardView;
        return this;
    }

    public TextView getTitle() {
        return title;
    }

    public MoLoadingCard setTitle(TextView title) {
        this.title = title;
        return this;
    }

    public TextView getDescription() {
        return description;
    }

    public MoLoadingCard setDescription(TextView description) {
        this.description = description;
        return this;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public MoLoadingCard setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_loading_card;
    }

    @Override
    public void initViews() {
        cardView = findViewById(R.id.loading_card_card_view);
        title = findViewById(R.id.loading_card_title);
        description = findViewById(R.id.loading_card_description);
        progressBar = findViewById(R.id.loading_card_progressBar);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
