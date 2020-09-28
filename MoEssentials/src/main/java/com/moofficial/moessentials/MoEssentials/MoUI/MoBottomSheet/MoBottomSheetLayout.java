package com.moofficial.moessentials.MoEssentials.MoUI.MoBottomSheet;

import android.content.Context;
import android.util.AttributeSet;

import androidx.core.widget.NestedScrollView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoEmptyLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers.MoWrapperLinearLayout;
import com.moofficial.moessentials.R;

public class MoBottomSheetLayout extends MoEmptyLayout {

    MoWrapperLinearLayout wrapperLinear;
    NestedScrollView nestedScrollView;
    MoWrapperLinearLayout wrapperTitle;
    MoWrapperLinearLayout wrapperBottomBar;

    public MoBottomSheetLayout(Context context) {
        super(context);
    }

    public MoBottomSheetLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoBottomSheetLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_bottom_sheet_layout;
    }

    @Override
    public void initViews() {
        nestedScrollView = findViewById(R.id.mo_bottom_sheet_nested_scroll_view);
        wrapperLinear = new MoWrapperLinearLayout(findViewById(R.id.mo_bottom_sheet_linear_nested));
        wrapperTitle = new MoWrapperLinearLayout(findViewById(R.id.mo_bottom_sheet_linear_title));
        wrapperBottomBar = new MoWrapperLinearLayout(findViewById(R.id.mo_bottom_sheet_linear_bottom_bar));
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
