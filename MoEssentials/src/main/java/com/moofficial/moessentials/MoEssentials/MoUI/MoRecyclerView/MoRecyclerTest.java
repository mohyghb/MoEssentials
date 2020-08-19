package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class MoRecyclerTest extends RecyclerView {
    public MoRecyclerTest(@NonNull Context context) {
        super(context);
    }

    public MoRecyclerTest(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MoRecyclerTest(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        heightSpec = MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, heightSpec);
    }
}
