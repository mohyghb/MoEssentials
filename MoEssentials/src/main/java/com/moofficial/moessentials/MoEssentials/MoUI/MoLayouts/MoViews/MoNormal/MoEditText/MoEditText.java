package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoEditText;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoCardView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

import java.util.Objects;

public class MoEditText extends MoConstraint {

    private MoCardView cardView;
    private TextInputEditText textInputEditText;
    private TextInputLayout textInputLayout;

    public MoEditText(Context context) {
        super(context);
    }

    public MoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MoCardView getCardView() {
        return cardView;
    }

    public MoEditText setCardView(MoCardView cardView) {
        this.cardView = cardView;
        return this;
    }

    public TextInputEditText getTextInputEditText() {
        return textInputEditText;
    }

    public MoEditText setTextInputEditText(TextInputEditText textInputEditText) {
        this.textInputEditText = textInputEditText;
        return this;
    }

    public TextInputLayout getTextInputLayout() {
        return textInputLayout;
    }

    public MoEditText setTextInputLayout(TextInputLayout textInputLayout) {
        this.textInputLayout = textInputLayout;
        return this;
    }

    public MoEditText setHint(@StringRes int id){
        return this.setHint(context.getString(id));

    }

    public MoEditText setHint(String h){
        this.textInputLayout.setHint(h);
        return this;
    }

    public MoEditText setText(@StringRes int id){
        return this.setText(context.getString(id));
    }

    public MoEditText setText(String h){
        this.textInputEditText.setText(h);
        return this;
    }

    public MoEditText setError(String error){
        this.textInputLayout.setErrorEnabled(true);
        this.textInputLayout.setError(error);
        return this;
    }

    public MoEditText removeError(){
        this.textInputLayout.setError(null);
        this.textInputLayout.setErrorEnabled(false);
        return this;
    }

    public MoEditText addTextChangedListener(TextWatcher w){
        this.textInputEditText.addTextChangedListener(w);
        return this;
    }


    public String getInputText(){
        return Objects.requireNonNull(this.textInputEditText.getText()).toString();
    }

    public void clearText(){
        this.setText("");
    }


    // special methods

    /**
     * makes the box background to be filled
     * @return this
     */
    public MoEditText boxBackgroundFilled(){
        this.textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_FILLED);
        return this;
    }


    /**
     * makes the box background to be outline
     * @return this
     */
    public MoEditText boxBackgroundOutline(){
        this.textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
        return this;
    }


    /**
     * makes the box background to be neither outline or filled
     * it does not show any kind of border for this
     * @return this
     */
    public MoEditText boxBackgroundNone(){
        this.textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_NONE);
        return this;
    }


    public MoEditText transparentTextBackground(){
        this.setBoxBackgroundColor(R.color.transparent);
        return this;
    }

    public MoEditText transparentCardBackground(){
        this.cardView.makeTransparent();
        return this;
    }

    /**
     * sets the box background color based on the
     * color res id that is passed
     * @param colorId
     * @return
     */
    public MoEditText setBoxBackgroundColor(@ColorRes int colorId){
        this.textInputLayout.setBoxBackgroundColor(context.getColor(colorId));
        return this;
    }

    /**
     * sets the box background color based on the
     * color integer value that is passed
     * @param color
     * @return
     */
    public MoEditText setBoxBackgroundColorFromColor(@ColorInt int color){
        this.textInputLayout.setBoxBackgroundColor(color);
        return this;
    }


    @Override
    public int getLayoutId() {
        return R.layout.mo_edit_text;
    }

    @Override
    public void initViews() {
        cardView = findViewById(R.id.mo_edit_text_card_view);
        textInputEditText = findViewById(R.id.mo_edit_text_text_input);
        textInputLayout = findViewById(R.id.mo_edit_text_text_layout);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
