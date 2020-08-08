package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

public class MoInputBar extends MoConstraint {


    private TextView title,description;
    private EditText editText;
    private MoCardWrapper cardView,textCardView;
    private ConstraintLayout constraintLayout;
    private Button positiveButton;


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

    public int TCVId(){
        return this.textCardView.getId();
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

    public MoInputBar addTextWatcher(TextWatcher tw){
        this.editText.addTextChangedListener(tw);
        return this;
    }

    public MoInputBar setError(String message, int drawable){
        this.editText.setError(message,getContext().getDrawable(drawable));
        return this;
    }

    public MoInputBar setError(String message){
        this.editText.setError(message);
        return this;
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }

    public MoInputBar setConstraintLayout(ConstraintLayout constraintLayout) {
        this.constraintLayout = constraintLayout;
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

    public MoCardWrapper getTextCardView() {
        return textCardView;
    }

    public MoInputBar setTextCardView(MoCardWrapper textCardView) {
        this.textCardView = textCardView;
        return this;
    }

    public MoInputBar clearText(){
        this.editText.setText("");
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
        textCardView = new MoCardWrapper(findViewById(R.id.input_bar_text_card_view));
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
