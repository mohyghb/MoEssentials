package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoItemDecoration;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
public class MoOverlapDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        final int itemPosition = parent.getChildAdapterPosition(view);
        if (itemPosition == 0) {
            return;
        }
        outRect.set(0, 0, 0, -150);
        //super.getItemOffsets(outRect, view, parent, state);
    }
}
