package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoMarginBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoPaddingBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoEditText.MoEditText;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

public class MoInputBar extends MoConstraint {


    private TextView title,description;
    private MoEditText editText;
    private MoCardWrapper cardView;
    private ConstraintLayout constraintLayout;
    private Button positiveButton;
    private View divider;


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

    public int DId(){
        return this.description.getId();
    }

    public int PId(){
        return this.positiveButton.getId();
    }




    public MoInputBar setTitle(String s){
        title.setText(s);
        return this;
    }

    public MoInputBar setTitle(int s){
        title.setText(s);
        return this;
    }

    public MoInputBar setDescription(String s){
        description.setText(s);
        return this;
    }

    public MoInputBar setDescription(int s){
        description.setText(s);
        return this;
    }

    public MoInputBar hideTitle(){
        title.setVisibility(View.GONE);
        return this;
    }

    public MoInputBar hideDescription(){
        description.setVisibility(View.GONE);
        return this;
    }

    public MoInputBar showDescription(){
        description.setVisibility(View.VISIBLE);
        return this;
    }

    public MoInputBar hideDivider(){
        divider.setVisibility(View.GONE);
        return this;
    }

    public MoInputBar showDivider(){
        divider.setVisibility(View.VISIBLE);
        return this;
    }

    /** this is when we need the 8dp top padding to
     *  separate the description and edit text
     *  but we don't want to show a line divider
     * @return this
     */
    public MoInputBar showDividerInvisible(){
        divider.setVisibility(View.INVISIBLE);
        return this;
    }

    public MoInputBar setHint(String h){
        this.editText.setHint(h);
        return this;
    }

    public MoInputBar setHint(int h){
        return setHint(getContext().getString(h));
    }

    public MoInputBar setText(String h){
        this.editText.setText(h);
        return this;
    }

    public MoInputBar setText(int h){
        this.editText.setText(h);
        return this;
    }

    public MoInputBar addTextWatcher(TextWatcher tw){
        this.editText.addTextChangedListener(tw);
        return this;
    }

    public MoInputBar setError(String message){
        editText.setError(message);
        return this;
    }


    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }

    public MoInputBar setConstraintLayout(ConstraintLayout constraintLayout) {
        this.constraintLayout = constraintLayout;
        return this;
    }

    public MoInputBar setEditText(MoEditText editText) {
        this.editText = editText;
        return this;
    }

    public View getDivider() {
        return divider;
    }

    public MoInputBar setDivider(View divider) {
        this.divider = divider;
        return this;
    }

    /**
     * returns the text of the edit text
     * @return
     */
    public String getInputText(){
        return this.editText.getInputText();
    }


    public TextView getTitle() {
        return title;
    }

    public MoInputBar setTitle(TextView title) {
        this.title = title;
        return this;
    }

    public MoEditText getEditText() {
        return editText;
    }

    public MoCardWrapper getCardView() {
        return cardView;
    }

    public MoInputBar setCardView(MoCardWrapper cardView) {
        this.cardView = cardView;
        return this;
    }

    public TextView getDescription() {
        return description;
    }

    public MoInputBar setDescription(TextView description) {
        this.description = description;
        return this;
    }

    public MoInputBar showPositiveButton(){
        this.positiveButton.setVisibility(View.VISIBLE);
        return this;
    }

    public MoInputBar hidePositiveButton(){
        this.positiveButton.setVisibility(View.GONE);
        return this;
    }

    public MoInputBar setPositiveButtonText(String t){
        this.positiveButton.setText(t);
        return this;
    }

    public MoInputBar setPositiveButtonText(int t){
        this.positiveButton.setText(t);
        return this;
    }

    public MoInputBar setPositiveClickListener(View.OnClickListener l){
        this.positiveButton.setOnClickListener(l);
        return this;
    }


    public Button getPositiveButton() {
        return positiveButton;
    }

    public MoInputBar setPositiveButton(Button positiveButton) {
        this.positiveButton = positiveButton;
        return this;
    }



    public MoInputBar clearText(){
        this.editText.clearText();
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
        constraintLayout = findViewById(R.id.input_bar_constraint_layout);
        description = findViewById(R.id.input_bar_description);
        positiveButton = findViewById(R.id.input_bar_positive_button);
        divider = findViewById(R.id.input_bar_divider);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }




    // special methods

    /**
     * this is the special style for when you need an input
     * bar with no title or description (you can also use MoEdit text for
     * that use case as well)
     * @param inputBar
     */
    public static void defaultDialogStyleNoTitleDescription(MoInputBar inputBar){
        // making the card view rec round
        inputBar.getCardView().makeCardRecRound();
        // making the edit text background transparent
        inputBar.getEditText().transparentTextBackground();
        // making sure there is no margin between
        inputBar.getConstraintLayout().setLayoutParams(MoMarginBuilder.
                getCardLayoutParams(0));
        new MoPaddingBuilder(16)
                .convertValuesToDp()
                .apply(inputBar);
    }





}
