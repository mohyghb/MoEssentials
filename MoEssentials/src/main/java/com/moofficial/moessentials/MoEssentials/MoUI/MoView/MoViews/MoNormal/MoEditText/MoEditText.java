package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal.MoEditText;

import android.content.Context;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal.MoCardView;
import com.moofficial.moessentials.R;

import java.util.Objects;

public class MoEditText extends MoConstraint {

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

    public MoEditText clearText() {
        this.setText("");
        return this;
    }

    // clears focus and text
    public MoEditText clearFocusAndText(){
        clearFocus();
        return clearText();
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

    // EditorInfo.IME_ACTION_DONE
    public MoEditText actionDone() {
        this.textInputEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        singleLine();
        inputTypeText();
        return this;
    }

    // EditorInfo.IME_ACTION_SEARCH
    public MoEditText actionSearch(){
        this.textInputEditText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        return this;
    }

    // EditorInfo.IME_ACTION_SEND
    public MoEditText actionSend(){
        this.textInputEditText.setImeOptions(EditorInfo.IME_ACTION_SEND);
        return this;
    }

    // EditorInfo.IME_ACTION_GO
    public MoEditText actionGo(){
        this.textInputEditText.setImeOptions(EditorInfo.IME_ACTION_GO);
        return this;
    }

    /**
     * the ime option's name is called [action]
     * with id of id
     * @param action name of the ime option
     * @param id the id that will be invoked when user presses that
     * @return this
     */
    public MoEditText withAction(String action,int id){
        this.textInputEditText.setImeActionLabel(action,id);
        return this;
    }

    /**
     * makes the edit text to be single line
     * @return this for nested calling
     */
    public MoEditText singleLine() {
        textInputEditText.setMaxLines(1);
        return this;
    }

    /**
     * makes the input type of edit text be
     * just simple text
     * @return this for nested calling
     */
    public MoEditText inputTypeText() {
        textInputEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        return this;
    }


    /**
     *
     * @param l listener for editor action
     * @return this for nested calling
     */
    public MoEditText setOnEditorActionListener(TextView.OnEditorActionListener l){
        textInputEditText.setOnEditorActionListener(l);
        return this;
    }



    @Override
    public int getLayoutId() {
        return R.layout.mo_edit_text;
    }

    @Override
    public void initViews() {
        textInputEditText = findViewById(R.id.mo_edit_text_text_input);
        textInputLayout = findViewById(R.id.mo_edit_text_text_layout);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
