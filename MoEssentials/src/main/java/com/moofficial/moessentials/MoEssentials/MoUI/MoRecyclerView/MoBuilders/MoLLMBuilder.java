package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoBuilders;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

/**
 * this is a linear layout manager builder
 * class which helps to make linear layout managers more
 * easily
 */
public class MoLLMBuilder extends MoContext {

    boolean stackFromEnd = false,reverseLayout = false;
    @RecyclerView.Orientation int orientation = RecyclerView.VERTICAL;

    public MoLLMBuilder(Context c) {
        super(c);
    }

    public boolean isStackFromEnd() {
        return stackFromEnd;
    }

    public MoLLMBuilder setStackFromEnd(boolean stackFromEnd) {
        this.stackFromEnd = stackFromEnd;
        return this;
    }

    public boolean isReverseLayout() {
        return reverseLayout;
    }

    public MoLLMBuilder setReverseLayout(boolean reverseLayout) {
        this.reverseLayout = reverseLayout;
        return this;
    }

    public int getOrientation() {
        return orientation;
    }

    public MoLLMBuilder setOrientation(int orientation) {
        this.orientation = orientation;
        return this;
    }

    public LinearLayoutManager build(){
        LinearLayoutManager l = new LinearLayoutManager(context);
        l.setOrientation(orientation);
        l.setReverseLayout(reverseLayout);
        l.setStackFromEnd(stackFromEnd);
        return l;
    }


}
