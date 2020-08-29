package com.moofficial.moessentials.MoEssentials.MoUI.MoPopupWindow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoViewUtils;

import java.util.ArrayList;
import java.util.List;


// uses our standards to build various views
public class MoPopupItemBuilder extends MoContext {

    public static final int MO_ITEM_PADDING = MoDynamicUnit.convertDpToPixels(18f);
    public static final int MO_ICON_PADDING = MoDynamicUnit.convertDpToPixels(14f);

    private final int TYPE_TEXT_BUTTON = 0;
    private final int TYPE_IMAGE_BUTTON = 1;


    private ArrayList<View> views = new ArrayList<>();
    private int textButtonPadding = MO_ITEM_PADDING;
    private int imageButtonPadding = MO_ICON_PADDING;
    private MoPopupWindow popupWindow;

    public MoPopupItemBuilder(Context c){
        super(c);
    }

    public MoPopupItemBuilder setPopupWindow(MoPopupWindow popupWindow) {
        this.popupWindow = popupWindow;
        return this;
    }

    public Context getContext() {
        return context;
    }

    public MoPopupItemBuilder setContext(Context context) {
        this.context = context;
        return this;
    }

    public ArrayList<View> getViews() {
        return views;
    }

    public MoPopupItemBuilder setViews(ArrayList<View> views) {
        this.views = views;
        return this;
    }

    public int getTextButtonPadding() {
        return textButtonPadding;
    }

    public MoPopupItemBuilder setTextButtonPadding(int textButtonPadding) {
        this.textButtonPadding = textButtonPadding;
        return this;
    }

    public int getImageButtonPadding() {
        return imageButtonPadding;
    }

    public MoPopupItemBuilder setImageButtonPadding(int imageButtonPadding) {
        this.imageButtonPadding = imageButtonPadding;
        return this;
    }

    /**
     *
     * @param title
     * @param clickListener
     * @return
     */
    public MoPopupItemBuilder buildTextButton(String title,int icon ,View.OnClickListener clickListener){
        TextView v = new TextView(context);
        v.setText(title);
        v.setCompoundDrawablesWithIntrinsicBounds(0,0,icon,0);
        finalViewBuild(v,clickListener,TYPE_TEXT_BUTTON);
        return this;
    }

    public MoPopupItemBuilder buildTextButton(String title, View.OnClickListener clickListener){
        return buildTextButton(title,0,clickListener);
    }

    // overloaded method of buildTextButton
    public MoPopupItemBuilder buildTextButton(int title, View.OnClickListener clickListener){
        return buildTextButton(getString(title),clickListener);
    }

    public MoPopupItemBuilder buildTextButton(int title,int icon ,View.OnClickListener clickListener){
        return buildTextButton(getString(title),icon,clickListener);
    }

    /**
     *
     * @param drawable
     * @param clickListener
     * @return
     */
    public MoPopupItemBuilder buildImageButton(int drawable, View.OnClickListener clickListener){
        ImageButton ib = new ImageButton(context);
        ib.setBackground(getDrawable(drawable));
        finalViewBuild(ib,clickListener,TYPE_IMAGE_BUTTON);
        return this;
    }

    /**
     *
     * @param checked
     * @param notChecked
     * @param clickListener
     * @param isChecked
     * @return
     */
    public MoPopupItemBuilder buildCheckedImageButton(int checked, int notChecked,
                                                      @NonNull View.OnClickListener clickListener,
                                                      MoPopupCondition isChecked){
        ImageButton ib = new ImageButton(context);
        ib.setBackground(isChecked.getCondition()?getDrawable(checked):getDrawable(notChecked));
        View.OnClickListener switchListener = new View.OnClickListener() {
            boolean n = isChecked.getCondition();
            @Override
            public void onClick(View view) {
                n = !n;
                ib.setBackground(n?getDrawable(checked):getDrawable(notChecked));
                clickListener.onClick(view);
            }
        };
        finalViewBuild(ib,switchListener,TYPE_IMAGE_BUTTON);
        return this;
    }


    /**
     * apply padding
     * make the view on click listener
     * and add ripple effect
     * then add it to the list of items
     * @param v
     * @param clickListener
     */
    private void finalViewBuild(View v, View.OnClickListener clickListener,int type) {
        v.setOnClickListener(view -> {
            clickListener.onClick(view);
            if(popupWindow!=null) {
                // this makes it that whenever we click on
                // an item, the pop up window closes
                popupWindow.dismiss();
            }
        });
        // applying enough padding
        applyPadding(v,type);
        // making it ripple on click
        MoViewUtils.rippleOnClick(context,v);
        this.views.add(v);
    }




    /**
     *
     * @param v
     */
    private void applyPadding(View v,int type){
        int p = 0;
        switch (type){
            case TYPE_IMAGE_BUTTON:
                p = MO_ICON_PADDING;
                break;
            case TYPE_TEXT_BUTTON:
                p = MO_ITEM_PADDING;
                break;
        }
        v.setPadding(p,p,p,p);
    }



    public List<View> build(){
        return this.views;
    }

}
