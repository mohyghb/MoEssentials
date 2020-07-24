package com.moofficial.moessentials.MoEssentials.MoLayouts.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;

import com.moofficial.moessentials.MoEssentials.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoToolBar extends MoConstraint {

    private TextView title;
    private ImageButton left,middle,right;

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
        return left.getId();
    }

    // right button id
    public int RId(){
        return right.getId();
    }

    // middle button id
    public int MId(){
        return middle.getId();
    }



    @Override
    protected int getLayoutId() {
        return R.layout.mo_tool_bar;
    }

    @Override
    protected void initViews() {
        title = findViewById(R.id.menu_app_bar_title);
        left = findViewById(R.id.menu_app_bar_back_button);
        middle = findViewById(R.id.menu_app_bar_search_button);
        right = findViewById(R.id.menu_app_bar_more_button);
    }
}
